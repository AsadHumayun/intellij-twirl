package io.asadh.intellij_twirl.lexer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.tree.IElementType;

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
public class TwirlLexer extends LexerBase {
  private CharSequence    buffer        = "";
  private Integer         startOffset   = 0;
  private Integer         endOffset     = 0;
  private Integer         pos           = 0;

  @Override
  public void advance() {
    this.pos = this.endOffset;
  }

  @Override
  public int getBufferEnd() {
    return this.endOffset;
  }

  @Override
  public @NotNull CharSequence getBufferSequence() {
    return this.buffer;
  }

  @Override
  public int getState() {
    return this.pos;
  }

  @Override
  public int getTokenEnd() {
    return this.endOffset;
  }

  @Override
  public int getTokenStart() {
    return this.pos;
  }

  @Override
  public @Nullable IElementType getTokenType() {
    if (pos <= endOffset)
      return LexerTokenTypes.TwirlContent;
    else
      return null;
  }

  @Override
  public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
    this.buffer       = buffer;
    this.startOffset  = startOffset;
    this.endOffset    = endOffset;
    this.pos          = startOffset;
  }
}
