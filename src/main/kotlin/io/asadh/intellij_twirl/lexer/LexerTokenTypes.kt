package io.asadh.intellij_twirl.lexer

import com.intellij.psi.tree.IElementType
import io.asadh.intellij_twirl.language.TwirlLanguage

/**
 * The token types emitted by the Lexer.
 *
 * Only one source is emitted as the entire file is consumed as one token.
 */
object LexerTokenTypes {
  /**
   * Lexer marks entire file as TwirlContent and then sends off to TwirlParser.
   */
  val TwirlContent = IElementType("TwirlContent", TwirlLanguage.INSTANCE)
}
