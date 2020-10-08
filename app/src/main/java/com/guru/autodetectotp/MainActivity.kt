package com.guru.autodetectotp

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {

    var editText_otp: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText_otp = findViewById(R.id.editText_otp)
        requestPermissions()
        //BroadcastReciever setting the message read
        OTPReceiver().setEditText_otp(editText_otp)

    }
// Pop up to ask permission to allow reading of sms
    private fun requestPermissions() {
        if (ContextCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.RECEIVE_SMS)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(
                android.Manifest.permission.RECEIVE_SMS
            ), 100)
        }
    }
}