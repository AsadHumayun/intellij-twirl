package io.asadh.intellij_twirl.language

import com.intellij.openapi.fileTypes.LanguageFileType

class TwirlFileType : LanguageFileType(TwirlLanguage.INSTANCE) {
  companion object {
    @JvmField
    val INSTANCE = TwirlFileType()
  }

  override fun getName() = "Twirl"

  override fun getDescription(): String = "Twirl HTML" // future work - move to config?

  override fun getDefaultExtension(): String = "scala.html"

  override fun getIcon() = TwirlIcons.FILE
}
