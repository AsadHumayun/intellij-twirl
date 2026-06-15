package io.asadh.intellij_twirl.psi

import com.intellij.lang.html.HTMLLanguage
import com.intellij.psi.tree.IElementType
import io.asadh.intellij_twirl.language.TwirlLanguage
import org.jetbrains.plugins.scala.ScalaLanguage

/**
 * PsiTokenTypes for the Twirl language.
 *
 * These will be used to construct the Psi representation of the Twirl AST.
 */
object AstNodes {
    val ScalaContent = IElementType("ScalaContent", ScalaLanguage.INSTANCE)

    val HtmlContent = IElementType("HtmlContent", HTMLLanguage.INSTANCE)

    /**
     * TODO:
     * Need a custom token type for this as Scala may error or cause incorrect
     * highlighting to be applied. Future work - how can we apply colouring to
     * this? Maybe wrap this in a class constructor and send this off to a
     * Scala somehow and extract colours from there?
     */
    val TemplateConstructor = IElementType("TemplateConstructor", TwirlLanguage.INSTANCE)
}
