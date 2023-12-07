package com.yugamitech.eventmanager.presentation.qrscanner

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun QrScannerScreen(
    onQrCodeScanned: (String) -> Unit,
    modifier: Modifier
)