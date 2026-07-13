package io.asadh.intellij_twirl.internal.search;

import org.jetbrains.annotations.NotNull;

import play.twirl.parser.TreeNodes.*;

import java.util.List;
import java.util.Optional;

import scala.jdk.javaapi.CollectionConverters;

/**
 * The TwirlParser is written in Scala, so this is to convert the Scala result
 * into a class that contains Java types, ensuring that everything is being used
 * within the same type system for simplicity.
 */
public class JavaTemplate {
  private final Optional<Constructor> constructor;
  private final Optional<Comment>     comment;
  private final PosString             params;
  private final List<Simple>          topImports;
  private final List<Simple>          imports;
  private final List<SubTemplate>     sub;
  private final List<TemplateTree>    content;
  private final List<LocalMember>     members;

  public JavaTemplate(@NotNull Template template) {
    // TODO: Test the constructor optional here works properly in Scala conversions.
    this.constructor  = Optional.ofNullable(template.constructor().getOrElse(null));
    this.comment      = Optional.ofNullable(template.comment().getOrElse(null));
    this.params       = template.params();
    this.topImports   = CollectionConverters.asJava(template.topImports());
    this.imports      = CollectionConverters.asJava(template.imports());
    this.sub          = CollectionConverters.asJava(template.sub());
    this.content      = CollectionConverters.asJava(template.content());
    this.members      = CollectionConverters.asJava(template.members());
  }

  public Optional<Constructor> getConstructor() {
    return constructor;
  }

  public Optional<Comment> getComment() {
    return comment;
  }

  public PosString getParams() {
    return params;
  }

  public List<Simple> getTopImports() {
    return topImports;
  }

  public List<Simple> getImports() {
    return imports;
  }

  public List<SubTemplate> getSub() {
    return sub;
  }

  public List<TemplateTree> getContent() {
    return content;
  }

  public List<LocalMember> getMembers() {
    return members;
  }
}
