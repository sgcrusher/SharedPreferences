package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user.*


class UserActivity : AppCompatActivity() {

    lateinit var sharedPref : preferenceshelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        sharedPref = preferenceshelper(this)

        textView2.text = sharedPref.getString(Constant.PREF_USERNAME)

        btnlogOUT.setOnClickListener{
            sharedPref.clear()
            Toast.makeText(applicationContext, "Berhasil Log out", Toast.LENGTH_SHORT).show()
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}