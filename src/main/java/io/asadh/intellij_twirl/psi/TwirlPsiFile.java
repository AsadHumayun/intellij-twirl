package io.asadh.intellij_twirl.psi;

import io.asadh.intellij_twirl.language.TwirlFileType;
import io.asadh.intellij_twirl.language.TwirlLanguage;

import org.jetbrains.annotations.NotNull;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public class TwirlPsiFile extends PsiFileBase {
  TwirlPsiFile(FileViewProvider viewProvider) {
    super(viewProvider, TwirlLanguage.INSTANCE);
  }

  @Override
  public @NotNull FileType getFileType() {
    return TwirlFileType.INSTANCE;
  }
}
