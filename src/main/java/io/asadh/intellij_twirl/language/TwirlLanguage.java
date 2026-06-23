package io.asadh.intellij_twirl.language;

import com.intellij.lang.Language;

public class TwirlLanguage extends Language {
  public static final TwirlLanguage INSTANCE = new TwirlLanguage();

  private TwirlLanguage() {
    super("Twirl");
  }
}
