//
//  EventManagerAppIosComposeView.swift
//  iosApp
//
//  Created by Offline on 05/12/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

struct EventManagerAppIosComposeView: UIViewControllerRepresentable {
    
    func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
    
    func makeUIViewController(context: Context) -> some UIViewController {
        EventManagerAppKt.EventManagerMainViewController()
    }
}
