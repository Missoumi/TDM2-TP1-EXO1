package com.example.exo1

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch

class SettingsActivity : AppCompatActivity() {
    companion object {
        val PRIVATE_MODE = 0
        val PREF_NAME = "color_pref"
    }

    private var color = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref: SharedPreferences? = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        var constraintActivitySettings = findViewById<ConstraintLayout>(R.id.constraintActivitySettings)

        if (sharedPref != null) {
            this.color = sharedPref.getString("color", "#FFFFFF").toString()
            constraintActivitySettings.setBackgroundColor(Color.parseColor(this.color))
        }
        val button1 = findViewById<Button>(R.id.button_activity_1)
        button1.setOnClickListener{
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.button_activity_2)
        button2.setOnClickListener{
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }
        val colorButton = findViewById<Button>(R.id.choose_color)
        colorButton.setOnClickListener{
            MaterialColorPickerDialog
                .Builder(this)        				// Pass Activity Instance
                .setColorShape(ColorShape.SQAURE)   	// Default ColorShape.CIRCLE
                .setColorSwatch(ColorSwatch._300)   	// Default ColorSwatch._500
                .setDefaultColor("red") 	// Pass Default Color
                .setColorListener { color, colorHex ->
                    constraintActivitySettings.setBackgroundColor(Color.parseColor(colorHex.toString()))
                    if (sharedPref != null) {
                        var preferencesEditor = sharedPref.edit()
                        preferencesEditor.putString("color", colorHex.toString())
                        preferencesEditor.apply()
                    }
                }
                .show()
        }



    }
}
