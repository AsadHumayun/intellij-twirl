package io.asadh.intellij_twirl.internal.search;

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

  public JavaTemplate(Template template) {
    // TODO: Test the constructor optional here works properly in Scala conversions.
    this.constructor  = Optional.ofNullable(template.constructor().getOrElse(null));
    this.comment      = Optional.ofNullable(template.comment().getOrElse(null));
    this.params       = template.params();
    this.topImports   = CollectionConverters.asJava(template.topImports());
    this.imports      = CollectionConverters.asJava(template.imports());
    this.sub          = CollectionConverters.asJava(template.sub());
    this.content      = CollectionConverters.asJava(template.content());
  }
}
