package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class preferenceshelper(context: Context) {

    private val PREF_NAME = "sharedPreferenceKotlin"
    private val sharedpref : SharedPreferences
    val editor : SharedPreferences.Editor

    init {
        sharedpref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedpref.edit()
    }

    fun put(key : String, value :  String) {
        editor.putString(key, value)
            .apply()
    }
    fun getString(key : String) : String? {
        return sharedpref.getString(key, null)
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String) : Boolean {
        return sharedpref.getBoolean(key, false)
    }

    fun clear() {
        editor.clear()
            .apply()
    }
}