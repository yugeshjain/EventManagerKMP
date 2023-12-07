package com.yugamitech.eventmanager.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

var koinApplication: KoinApplication? = null

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication {
    return koinApplication ?: run {
        startKoin {
            appDeclaration()
            modules(platformModule())
        }.also {
            koinApplication = it
        }
    }
}

expect fun platformModule(): Module
