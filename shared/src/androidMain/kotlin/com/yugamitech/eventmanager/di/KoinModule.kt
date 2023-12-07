package com.yugamitech.eventmanager.di

import com.yugamitech.eventmanager.presentation.qrscanner.BarcodeAnalyser
import com.yugamitech.eventmanager.presentation.qrscanner.QrImageAnalyzer
import org.koin.dsl.module

actual fun platformModule() = module {
    single<QrImageAnalyzer> { BarcodeAnalyser() }
}
