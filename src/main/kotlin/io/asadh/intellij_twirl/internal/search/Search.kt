package io.asadh.intellij_twirl.internal.search

import com.intellij.lang.PsiBuilder
import org.jetbrains.plugins.scala.kotlin.util.asJava

import play.twirl.parser.TreeNodes.PosString
import play.twirl.parser.TreeNodes.Template
import play.twirl.parser.TwirlParser
import play.twirl.parser.TwirlParser.Error
import play.twirl.parser.TwirlParser.Success

class Search(
    private val builder: PsiBuilder,
) {
    /**
     * Internal representation of the result from parsing a Twirl template.
     */
    private class ParsedTemplate(
        val nodes   : Template,
        val input   : TwirlParser.Input,
        val errors  : List<PosString>? = null,
    )

    private val template: ParsedTemplate by lazy {
        parse(builder.originalText.toString())
    }

    private fun parse(source: String?): ParsedTemplate {
        val parser = TwirlParser(true)
        val result = parser.parse(source)

        return when (result) {
            is Success   ->
                ParsedTemplate(
                    nodes   = result.template(),
                    input   = result.input(),
                    errors  = null,
                )

            is Error     ->
                ParsedTemplate(
                    nodes   = result.template(),
                    input   = result.input(),
                    errors  = result.errors().asJava(),
                )
        }
    }

    /**
     * Compute the template.
     *
     * This is the step where the Twirl AST is traversed and "translated" into
     * the desired AST that will then be used to make the PsiTree.
     *
     * The nodes of this tree will consist of the elements defined in [io.asadh.intellij_twirl.psi.AstNodes]
     */
    fun compute(): PsiBuilder {
        return builder
    }

    private fun traverse() {
        TODO()
    }
}
