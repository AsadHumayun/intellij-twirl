package io.asadh.intellij_twirl.psi

import io.asadh.intellij_twirl.language.TwirlFileType
import io.asadh.intellij_twirl.language.TwirlLanguage

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class TwirlPsiFile(fileViewProvider: FileViewProvider)
        : PsiFileBase(fileViewProvider, TwirlLanguage.INSTANCE) {
    override fun getFileType(): FileType = TwirlFileType.INSTANCE
}
