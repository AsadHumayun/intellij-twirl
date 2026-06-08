package io.asadh.intellij_twirl.language

import io.asadh.intellij_twirl.Config

import com.intellij.openapi.util.IconLoader

class TwirlIcons {
  companion object {
    @JvmField
    val FILE = IconLoader.getIcon(Config.ICON_PATH, TwirlIcons::class.java)
  }
}
