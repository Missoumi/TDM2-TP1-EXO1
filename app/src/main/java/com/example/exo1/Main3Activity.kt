package com.example.exo1

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.exo1.SettingsActivity.Companion.PREF_NAME
import com.example.exo1.SettingsActivity.Companion.PRIVATE_MODE

class Main3Activity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val sharedPref: SharedPreferences? = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        var main3 = findViewById<ConstraintLayout>(R.id.main3)
        if (sharedPref != null) {
            val color = sharedPref.getString("color", "#FFFFFF").toString()
            main3.setBackgroundColor(Color.parseColor(color))
        }
    }
}
