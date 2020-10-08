package com.guru.autodetectotp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Telephony
import android.widget.EditText
import androidx.annotation.RequiresApi

class OTPReceiver : BroadcastReceiver() {
    fun setEditText_otp(editText: EditText?) {
        editText_otp = editText
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    //get data of the message after : can be text or number
    override fun onReceive(context: Context, intent: Intent) {
        val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        //get data of the message after : can be text or number
        for (smsMessage in smsMessages) {
            val message_body = smsMessage.messageBody

            val getOTP = message_body.split(":".toRegex()).toTypedArray()[1]
            editText_otp!!.setText(getOTP)
        }
    }

    companion object {
        private var editText_otp: EditText? = null
    }
}