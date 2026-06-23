package io.asadh.intellij_twirl.internal.search;

import java.util.List;

import play.twirl.parser.TreeNodes.*;
import play.twirl.parser.TwirlParser.Input;

/**
 * Convenient representation of a parsed Twirl template
 */
public class ParsedTemplate {
  private final JavaTemplate template;
  private final Input input;
  private final List<PosString> errors;

  public ParsedTemplate(Template template, Input input, List<PosString> errors) {
    this.template = new JavaTemplate(template);
    this.input    = input;
    this.errors   = errors;
  }

  public JavaTemplate getTemplate() {
    return template;
  }

  public Input getInput() {
    return input;
  }

  public List<PosString> getErrors() {
    return errors;
  }
}
