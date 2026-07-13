package io.asadh.intellij_twirl.internal.search;

import com.intellij.psi.tree.IElementType;
import io.asadh.intellij_twirl.psi.AstNodes;

import com.intellij.lang.PsiBuilder;
import org.jetbrains.annotations.NotNull;

import scala.jdk.javaapi.CollectionConverters;

import play.twirl.parser.TwirlParser;
import play.twirl.parser.TwirlParser.*;
import play.twirl.parser.TreeNodes.*;

import java.util.List;

public class Search {
  private final TwirlParser     parser = new TwirlParser(true);

  private final PsiBuilder      builder;
  private final ParsedTemplate  template;

  public Search(@NotNull PsiBuilder builder) {
    this.builder  = builder;
    this.template = this.parse(builder.getOriginalText().toString());
  }

  private @NotNull ParsedTemplate parse(String text) {
    final ParseResult result = this.parser.parse(text);
    if (result instanceof Success successResult) {
        return new ParsedTemplate(successResult.template(), successResult.input(), null);
    }
    else {
      final TwirlParser.Error failedResult = (TwirlParser.Error) result;
      return new ParsedTemplate(
        failedResult.template(),
        failedResult.input(),
        CollectionConverters.asJava(failedResult.errors())
      );
    }
  }

  /**
   * Compute the template.
   * <p>
   * This is the step where the Twirl AST is traversed and "translated" into
   * the desired AST that will then be used to make the PsiTree.
   * <p>
   * The nodes of this tree will consist of the elements defined in [io.asadh.intellij_twirl.psi.AstNodes]
   */
  public PsiBuilder compute() {
    this.traverse();
    return this.builder;
  }

  private void traverse() {

  }

  private void matchCommonTemplateMeta(
    @NotNull  List<Simple>        imports,
    @NotNull  List<LocalMember>   members,
    @NotNull  List<SubTemplate>   subTemplates,
    @NotNull  List<TemplateTree>  nodes
  ) {
    List.of(imports, members).forEach(_ ->
      this.builder.mark().done(AstNodes.ScalaContent)
    );

    for (final TemplateTree node : nodes) {
      this.matchNode(node);
    }

    subTemplates.forEach(this::matchSubTemplate);
  }

  private void matchSubTemplate(@NotNull SubTemplate sub) {
    this.matchCommonTemplateMeta(
            CollectionConverters.asJava(sub.imports()),
            CollectionConverters.asJava(sub.members()),
            CollectionConverters.asJava(sub.sub()),
            CollectionConverters.asJava(sub.content())
    );
  }

  private void matchNode(TemplateTree node) {
    if (node instanceof Plain plain) {
      // HtmlContent - <p class="X"> ...
      this.builder.mark().done(AstNodes.HtmlContent);
    }
    else if (node instanceof Display    display) {
      // ScalaContent
      this.builder.mark().done(AstNodes.HtmlContent);
    }
    else if (node instanceof Comment    comment) {
      // ScalaContent
      this.builder.mark().done(AstNodes.ScalaContent);
    }
    else if (node instanceof ScalaExp   scalaExpr) {
      // ScalaContent
      this.builder.mark().done(AstNodes.ScalaContent);
    }
    else if (node instanceof Reassignment reAssgn) {
      // either a var/val or SubTemplate...
      if (reAssgn.ref().isRight()) { // Var
        final Var var = reAssgn.ref().right().get();
        this.builder.mark().done(AstNodes.ScalaContent);
      }
      else if (reAssgn.ref().isLeft()) { // SubTemplate
        final SubTemplate sub = reAssgn.ref().left().get();
        this.matchSubTemplate(sub);
      }
    }
  }
}
