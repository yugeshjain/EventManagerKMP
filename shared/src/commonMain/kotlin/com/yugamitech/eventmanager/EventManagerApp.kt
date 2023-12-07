package com.yugamitech.eventmanager

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yugamitech.eventmanager.presentation.qrscanner.QrScannerScreen

@Composable
fun EventManagerApp() {

    var scannedCode by remember { mutableStateOf("") }
    Box(
        modifier = Modifier.padding(bottom = 28.dp).fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        QrScannerScreen(
            onQrCodeScanned = {
                scannedCode = it
            },
            modifier = Modifier
        )

        Text(text = "Scanned Code = $scannedCode", color = Color.White)
    }
}
