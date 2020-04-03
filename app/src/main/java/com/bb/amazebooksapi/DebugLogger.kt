package com.bb.amazebooksapi

import android.util.Log
import com.bb.amazebooksapi.Constants.ERROR_PREFIX
import com.bb.amazebooksapi.Constants.TAG

object DebugLogger {
    fun logError(throwable: Throwable) {
        Log.d(TAG, ERROR_PREFIX + throwable.localizedMessage)
    }

    fun logDebug(message: String?) {
        Log.d(TAG, message)
    }
}