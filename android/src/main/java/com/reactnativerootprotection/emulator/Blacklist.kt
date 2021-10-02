package com.reactnativerootprotection.emulator

import android.content.Context
import android.os.Build

abstract class BlacklistedChecker(context: Context) {
  abstract fun isBlacklisted(): Boolean
}

class BlacklistedGoogleEmulatorChecker(context: Context) : BlacklistedChecker(context) {
  override fun isBlacklisted(): Boolean {
    return (Build.FINGERPRINT.startsWith("google/sdk_gphone_")
      && Build.FINGERPRINT.endsWith(":user/release-keys")
      && Build.MANUFACTURER == "Google" && Build.PRODUCT.startsWith("sdk_gphone_") && Build.BRAND == "google"
      && Build.MODEL.startsWith("sdk_gphone_"))
  }
}

class BlacklistedModelChecker(context: Context) : BlacklistedChecker(context) {
  override fun isBlacklisted(): Boolean {
    return Build.MODEL.contains("google_sdk")
      || Build.MODEL.contains("Emulator")
      || Build.MODEL.contains("Android SDK built for x86")
  }
}

class BlacklistedFingerprintChecker(context: Context) : BlacklistedChecker(context) {
  override fun isBlacklisted(): Boolean {
    return Build.FINGERPRINT.startsWith("generic")
      || Build.FINGERPRINT.startsWith("unknown")
      || Build.FINGERPRINT.contains("vbox")
  }
}

class BlacklistedManufacturerChecker(context: Context) : BlacklistedChecker(context) {
  override fun isBlacklisted(): Boolean {
    return Build.MANUFACTURER.contains("Genymotion") || Build.MANUFACTURER.contains("Genymobile")
  }
}

class BlacklistedHostChecker(context: Context) : BlacklistedChecker(context) {
  override fun isBlacklisted(): Boolean {
    return Build.HOST == "Build2" //MSI App Player
  }
}

class BlacklistedCheckerBrandChecker(context: Context) : BlacklistedChecker(context) {
  override fun isBlacklisted(): Boolean {
    return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) // Some Manufacturers
  }
}

class BlacklistedProductChecker(context: Context) : BlacklistedChecker(context) {
  override fun isBlacklisted(): Boolean {
    return Build.PRODUCT == "google_sdk" || Build.PRODUCT == "vbox86p"
  }
}

fun getBlackListedCheckers(context: Context): List<BlacklistedChecker> {
  return listOf(
    BlacklistedGoogleEmulatorChecker(context),
    BlacklistedModelChecker(context),
    BlacklistedFingerprintChecker(context),
    BlacklistedManufacturerChecker(context),
    BlacklistedHostChecker(context),
    BlacklistedCheckerBrandChecker(context),
    BlacklistedProductChecker(context)
  )
}
