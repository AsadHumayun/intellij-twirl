package io.asadh.intellij_twirl.internal.search;

import com.intellij.lang.PsiBuilder;

import play.twirl.parser.TwirlParser;
import play.twirl.parser.TreeNodes.*;
import play.twirl.parser.TwirlParser.*;

public class Search {
  private final TwirlParser     parser = new TwirlParser(true);

  private final PsiBuilder      builder;
  private final ParsedTemplate  template;

  public Search(PsiBuilder builder) {
    this.builder  = builder;
    this.template = this.parse(builder.getOriginalText().toString());
  }

  private ParsedTemplate parse(String text) throws RuntimeException {
    final ParseResult result = this.parser.parse(text);
    if (result instanceof TwirlParser.Success) {

    } else
    if (result instanceof TwirlParser.Error) {

    }
    else {
      throw new RuntimeException(
        "An error occurred while parsing this Twirl template."
      );
    }
  }
}

//     private fun parse(source: String?): ParsedTemplate {
//         val parser = TwirlParser(true)
//         val result = parser.parse(source)

//         return when (result) {
//             is Success   ->
//                 ParsedTemplate(
//                     nodes   = result.template(),
//                     input   = result.input(),
//                     errors  = null,
//                 )

//             is Error     ->
//                 ParsedTemplate(
//                     nodes   = result.template(),
//                     input   = result.input(),
//                     errors  = result.errors().asJava(),
//                 )
//         }
//     }

//     /**
//      * Compute the template.
//      *
//      * This is the step where the Twirl AST is traversed and "translated" into
//      * the desired AST that will then be used to make the PsiTree.
//      *
//      * The nodes of this tree will consist of the elements defined in [io.asadh.intellij_twirl.psi.AstNodes]
//      */
//     fun compute(): PsiBuilder {
//         traverse()
//         return builder
//     }

//     private fun traverse() {
//         val marker = builder.mark()
//     }

//     private fun matchCommonTemplateMeta(
//         imports : List<Simple>,
//         members : List<LocalMember>,
//         sub     : List<SubTemplate>,
//         nodes   : List<TemplateTree>,
//     ) {
//         TODO()
// //        val importedStates   = imports.foldLeft(state) { (state, import_) =>
// //            emitScala(state = state, Position(import_.pos.line, import_.pos.column), import_.code)
// //        }
// //        val membersState     = members.foldLeft(importedStates) { (state, member) =>
// //            emitScala(
// //                state = state,
// //                pos = Position(
// //                    line = member.pos.line,
// //                    column = member.pos.column,
// //                ),
// //                str = member.code.code,
// //            )
// //        }
// //        val subTemplateState = sub.foldLeft(membersState) { (state, sub) =>
// //            matchTemplate(
// //                state = state,
// //                template = sub,
// //                pos = Position(
// //                    line = sub.pos.line,
// //                    column = sub.pos.column,
// //                ),
// //            )
// //        }
// //
// //        nodes.foldLeft(subTemplateState)((state, node) => matchNode(node = node, state = state))
//     }
// }
