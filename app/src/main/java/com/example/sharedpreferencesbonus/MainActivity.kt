package com.example.sharedpreferencesbonus

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var et1:EditText
    lateinit var et2:EditText
    lateinit var button: Button
    lateinit var button2: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        button=findViewById(R.id.button)
        button2=findViewById(R.id.button2)
        sharedPreferences=getSharedPreferences("information", MODE_PRIVATE)
        editor=sharedPreferences.edit()


        button.setOnClickListener {
            val intent=Intent(this,MainActivity2::class.java)
            intent.putExtra("info1","${et1.text}")
            intent.putExtra("info2","${et2.text}")
            startActivity(intent)
        }

        button2.setOnClickListener {
            editor.putString("info1","${et1.text}")
            editor.putString("info2","${et2.text}")
            editor.commit()

        }

    }
}