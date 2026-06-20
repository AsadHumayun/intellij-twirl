package io.asadh.intellij_twirl.psi;

import io.asadh.intellij_twirl.internal.search.Search;

import org.jetbrains.annotations.NotNull;

import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.PsiParser;

public class TwirlPsiParser implements PsiParser {
  /**
   * This is where we will parse the twirl template.
   *
   * Calls the internal graph traversal algorithm to
   */
  @Override
  public @NotNull ASTNode parse(@NotNull IElementType arg0, @NotNull PsiBuilder arg1) {
    // TODO Auto-generated method stub
    return null;
  }
}

// class TwirlPsiParser : PsiParserBase {
    /**
     * This is where we will parse the twirl template.
     *
     * Calls the internal graph traversal algorithm to
     */
//     override fun parse(root: IElementType, builder: PsiBuilder): ASTNode =
//         Search(builder).compute().treeBuilt
// }
