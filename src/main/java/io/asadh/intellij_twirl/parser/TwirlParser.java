package io.asadh.intellij_twirl.parser;

import io.asadh.intellij_twirl.language.TwirlLanguage;
import io.asadh.intellij_twirl.lexer.TwirlLexer;
import io.asadh.intellij_twirl.psi.AstNodes;
import io.asadh.intellij_twirl.psi.TwirlPsiFile;
import io.asadh.intellij_twirl.psi.TwirlPsiParser;

import org.jetbrains.annotations.NotNull;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.ParserDefinition;

public class TwirlParser implements ParserDefinition {
  /**
   * This is where the PsiTree's elements are constructed, by matching
   * against what has been returned from `TwirlParser`. (The ASTNode tree)
   */
  @Override
  public @NotNull PsiElement createElement(ASTNode node) {
    if (node == null) throw new NullPointerException("");
    final IElementType t = node.getElementType();
    // idk what the approach for this is gonna be, previous was just:
    // when (node.elementType) {
    //     AstNodes.ScalaContent          -> {}
    //     AstNodes.HtmlContent           -> {}
    //     AstNodes.TemplateConstructor   -> {}
    //     else                           -> ASTWrapperPsiElement(node)
    // }

    if (t.toString().equals("t")) {

    }
    else {
      return new ASTWrapperPsiElement(node);
    }
    throw new UnsupportedOperationException("Unimplemented method 'createElement'");
  }

  @Override
  public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
    return new TwirlPsiFile(viewProvider);
  }

  @Override
  public @NotNull Lexer createLexer(Project project) {
    return new TwirlLexer();
  }

  @Override
  public @NotNull PsiParser createParser(Project project) {
    return new TwirlPsiParser();
  }

  /**
   * >  Returns the set of token types which are treated as comments by the PSI builder.
   *    Tokens of those types are automatically skipped by PsiBuilder. Also, To Do patterns
   *    are searched in the text of tokens of those types.
   *    For composite comment elements it should contain only the root element type
   *    (for example {@link com.intellij.psi.impl.source.tree.JavaDocElementType#DOC_COMMENT}).
   *
   * >  @return the set of comment token types.
   *
   * >  Source: `com.intellij.lang.ParserDefinition`
   *
   * As we are kind of "skipping" the lexing layer, we will have no comment
   * tokens returned from the Lexer. Therefore send back an EMPTY TokenSet.
   *
   * We will be able to get comment nodes from the Twirl AST once it's been
   * parsed.
   */
  @Override
  public @NotNull TokenSet getCommentTokens() {
    // TODO: Ponder later for an impl for these... maybe in a v2?
    return TokenSet.EMPTY;
  }

  @Override
  public @NotNull IFileElementType getFileNodeType() {
    return new IFileElementType(TwirlLanguage.INSTANCE);
  }

  @Override
  public @NotNull TokenSet getStringLiteralElements() {
    return TokenSet.EMPTY;
  }
}
