package io.asadh.intellij_twirl.parser

import io.asadh.intellij_twirl.lexer.TwirlLexer
import io.asadh.intellij_twirl.language.TwirlLanguage
import io.asadh.intellij_twirl.psi.TwirlPsiParser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition as ParserDefinitionBase
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.impl.source.PsiFileImpl
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import io.asadh.intellij_twirl.psi.TwirlPsiFile

class Parser : ParserDefinitionBase {
    override fun createLexer(project: Project?): Lexer = TwirlLexer()

    override fun createParser(project: Project?): PsiParser = TwirlPsiParser()

    override fun getFileNodeType(): IFileElementType =
        IFileElementType(TwirlLanguage.INSTANCE)

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
    override fun getCommentTokens(): TokenSet = TokenSet.EMPTY

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement {
        TODO("Not yet implemented")
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile = TwirlPsiFile(viewProvider)
}
