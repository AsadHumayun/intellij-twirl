package io.asadh.intellij_twirl.internal.search;

import com.intellij.lang.PsiBuilder;

import org.jetbrains.annotations.NotNull;

import scala.jdk.javaapi.CollectionConverters;

import play.twirl.parser.TwirlParser;
import play.twirl.parser.TwirlParser.*;

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
   *
   * This is the step where the Twirl AST is traversed and "translated" into
   * the desired AST that will then be used to make the PsiTree.
   *
   * The nodes of this tree will consist of the elements defined in [io.asadh.intellij_twirl.psi.AstNodes]
   */
  public PsiBuilder compute() {
    this.traverse();
    return this.builder;
  }

  private void traverse() {

  }
}

//     private fun matchCommonTemplateMeta(
//         imports : List<Simple>,
//         members : List<LocalMember>,
//         sub     : List<SubTemplate>,
//         nodes   : List<TemplateTree>,
//     ) {
//         TODO()
// //        val importedStates   = imports.foldLeft(state) { (state, import_) =>
// //            emitScala(state = state, Position(import_.pos.line, import_.pos.column), import_.code)
// //        }
// //        val membersState     = members.foldLeft(importedStates) { (state, member) =>
// //            emitScala(
// //                state = state,
// //                pos = Position(
// //                    line = member.pos.line,
// //                    column = member.pos.column,
// //                ),
// //                str = member.code.code,
// //            )
// //        }
// //        val subTemplateState = sub.foldLeft(membersState) { (state, sub) =>
// //            matchTemplate(
// //                state = state,
// //                template = sub,
// //                pos = Position(
// //                    line = sub.pos.line,
// //                    column = sub.pos.column,
// //                ),
// //            )
// //        }
// //
// //        nodes.foldLeft(subTemplateState)((state, node) => matchNode(node = node, state = state))
//     }
// }
