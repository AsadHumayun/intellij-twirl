package io.asadh.intellij_twirl.lexer;

import io.asadh.intellij_twirl.language.TwirlLanguage;

import com.intellij.psi.tree.IElementType;

/**
 * The token types emitted by the Lexer.
 *
 * Only one source is emitted as the entire file is consumed as one token.
 */
public class LexerTokenTypes {
  /**
   * Lexer marks entire file as TwirlContent and then sends off to TwirlParser.
   */
  public static IElementType TwirlContent = new IElementType("TwirlContent", TwirlLanguage.INSTANCE);
}
