package io.asadh.intellij_twirl.lexer

import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType

/**
 * The TwirlLexer.
 *
 * The presence of this class exists mostly to please the requirements of
 * developing this extension on the IntelliJ platform. A lexer is required
 * as part of the pipeline.
 *
 * This "lexer" will just consume the entire string that is sent to it in
 * one move and delegate appropriate "lexing" (tokenisation) and parsing to
 * the appropriate TwirlParser impl, supplied by Play.
 *
 * The resultant AST from parsing the input source this way will then be
 * traversed and a Psi-compatible AST will be generated during this traversal.
 * The aim is to build the new Psi tree in the same pass as traversing the AST
 * produced by TwirlParser, in the interests of performance.
 *
 * This should then help to bring accurate syntax highlighting for Twirl.
 * The hope is that errors can also be highlighted at that stage.
 *
 * The concerns around this approach are about how TwirlParser copes with
 * potentially incomplete or malformed Twirl templates. What do the error
 * nodes look like? What information do we get? Do we get enough information
 * to be able to display some sort of diagnostics for the user? This is
 * potential for future discovery and work.
 */
class TwirlLexer : LexerBase() {
  private var buffer      : CharSequence  = ""
  private var startOffset : Int           = 0
  private var endOffset   : Int           = 0
  private var pos         : Int           = 0

  override fun start(
    buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int
  ) {
    this.buffer = buffer
    this.startOffset = startOffset
    this.endOffset = endOffset
    this.pos = startOffset
  }

  override fun getState(): Int = pos

  override fun getTokenType(): IElementType? =
    if (pos <= endOffset) LexerTokenTypes.TwirlContent
    else null

  override fun getTokenStart(): Int = pos

  override fun getTokenEnd(): Int = endOffset

  override fun advance() { pos = endOffset }

  override fun getBufferSequence(): CharSequence = bufferSequence

  override fun getBufferEnd(): Int = endOffset
}
