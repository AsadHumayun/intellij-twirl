package io.asadh.intellij_twirl.internal.search;

import java.util.ArrayList;

import play.twirl.parser.TreeNodes.*;
import play.twirl.parser.TwirlParser.Input;

/**
 * Convenient representation of a parsed Twirl template
 */
public class ParsedTemplate {
  private final JavaTemplate template;
  private final Input input;
  private final ArrayList<PosString> errors;

  public ParsedTemplate(Template template, Input input, ArrayList<PosString> errors) {
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

  public ArrayList<PosString> getErrors() {
    return errors;
  }
}
