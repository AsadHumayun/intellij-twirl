package io.asadh.intellij_twirl.language;

import io.asadh.intellij_twirl.Config;

import javax.swing.Icon;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts.Label;
import com.intellij.openapi.util.NlsSafe;

public class TwirlFileType extends LanguageFileType {
  public static final TwirlFileType INSTANCE = new TwirlFileType();

  TwirlFileType() {
    super(TwirlLanguage.INSTANCE);
  }

  @Override
  public @NlsSafe @NotNull String getDefaultExtension() {
    return Config.FILE_EXT;
  }

  @Override
  public @Label @NotNull String getDescription() {
    return Config.DESC;
  }

  @Override
  public @Nullable Icon getIcon() {
    return TwirlIcons.FILE;
  }

  @Override
  public @NonNls @NotNull String getName() {
    return Config.LANG_NAME;
  }
}
