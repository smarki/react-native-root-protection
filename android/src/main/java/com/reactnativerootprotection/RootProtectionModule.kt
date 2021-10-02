package com.reactnativerootprotection

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.reactnativerootprotection.emulator.EmulatorValidator
import com.scottyab.rootbeer.RootBeer
import java.lang.Exception

class RootProtectionModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {
  private val rootBeer = RootBeer(reactContext)
  private val emulatorValidator = EmulatorValidator(reactContext)

  override fun getName(): String {
    return "RootProtection"
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  fun isRooted(): Boolean {
    return rootBeer.isRooted
  }

  @ReactMethod(isBlockingSynchronousMethod = true)
  fun isEmulator(): Boolean {
    return emulatorValidator.isEmulator
  }
}
