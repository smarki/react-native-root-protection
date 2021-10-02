package com.reactnativerootprotection.emulator

import android.content.Context

class EmulatorValidator(context: Context) {
  private val blackListCheckers = getBlackListedCheckers(context)

  val isEmulator: Boolean
    get() = blackListCheckers.any { it.isBlacklisted() }
}
