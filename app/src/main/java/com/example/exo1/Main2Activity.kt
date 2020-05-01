package com.example.exo1

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class Main2Activity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val sharedPref: SharedPreferences? = getSharedPreferences(
            SettingsActivity.PREF_NAME,
            SettingsActivity.PRIVATE_MODE
        )
        var main2 = findViewById<ConstraintLayout>(R.id.main2)
        if (sharedPref != null) {
            var color = sharedPref.getString("color", "#FFFFFF").toString()
            main2.setBackgroundColor(Color.parseColor(color))
        }
    }
}
