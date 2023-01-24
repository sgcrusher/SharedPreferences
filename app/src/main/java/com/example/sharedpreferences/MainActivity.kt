package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref : preferenceshelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = preferenceshelper(this)

        btnlogin.setOnClickListener{
            if (et_nama.text.isNotEmpty() && et_nama.text.isNotEmpty()){
                sharedPref.put(Constant.PREF_USERNAME, et_nama.text.toString() )
                sharedPref.put(Constant.PREF_PASSWORD, et_password.text.toString() )
                sharedPref.put(Constant.PREF_IS_LOGIN, true)
                Toast.makeText(applicationContext, "Berhasil Login", Toast.LENGTH_SHORT).show()
                moveIntent()
            }
        }



    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, UserActivity::class.java))
        finish()
    }
}