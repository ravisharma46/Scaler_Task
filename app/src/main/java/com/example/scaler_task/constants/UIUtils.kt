package com.example.scaler_task.constants

import android.content.Context

object UIUtils {
    fun isNetworkAvailable(context: Context?): Boolean {
        return NetworkUtils.isConnected(context!!)
    }
}