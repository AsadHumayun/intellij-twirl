package io.asadh.intellij_twirl.psi

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import io.asadh.intellij_twirl.internal.search.Search
import com.intellij.lang.PsiParser as PsiParserBase

class TwirlPsiParser : PsiParserBase {
    /**
     * This is where we will parse the twirl template.
     *
     * Calls the internal graph traversal algorithm to
     */
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode =
        Search(builder).compute().treeBuilt
}
