package io.asadh.intellij_twirl.language

import com.intellij.lang.Language

class TwirlLanguage : Language("Twirl") {
  companion object {
    @JvmField
    val INSTANCE = TwirlLanguage()
  }

  fun getName() = "Twirl"
}
