package com.example.a1cmobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

var name: EditText? = null
var password: EditText? = null
var enter: Button? = null
var box: CheckBox? = null
var sharedPreference:SharedPreferences?=null

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

//
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      initview()
        var mPreferences = getSharedPreferences("PREFERENCE_NAME", AppCompatActivity.MODE_PRIVATE)

        name?.setText(mPreferences.getString("name",""))
        password?.setText(mPreferences.getString("password",""))
//////

        password?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                enter?.isEnabled=true
                if (password?.text.isNullOrEmpty()){
                    enter?.isEnabled=false
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
//                    name?.setText("Text in EditText : "+s)
            }

        })
            name?.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
                 enter?.isEnabled=true
                    if (name?.text.isNullOrEmpty()){
                        enter?.isEnabled=false
                    }
                }

                override fun beforeTextChanged(s: CharSequence, start: Int,
                                               count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence, start: Int,
                                           before: Int, count: Int) {
//                    name?.setText("Text in EditText : "+s)
                }

            })

////        }

              }


    private fun initview() {
        box = findViewById(R.id.box)
        name = findViewById(R.id.name)
        enter = findViewById(R.id.enter)
        password = findViewById(R.id.password)
    }

    fun newScreen(view: View) {
        enter?.isEnabled=false
        if (!name?.text.toString().equals("Ozodbek") ){
            Toast.makeText(this, "name is false", Toast.LENGTH_LONG).show()
        }
        if (!password?.text.toString().equals("221") ){
            Toast.makeText(this, "password is false", Toast.LENGTH_LONG).show()
        }
        if (name?.text.isNullOrEmpty()) {
            Toast.makeText(this, "name is error ", Toast.LENGTH_LONG).show()
            name?.requestFocus()
            return
        }
        if (password?.text.isNullOrEmpty()) {
            Toast.makeText(this, "password is error ", Toast.LENGTH_LONG).show()
            password?.requestFocus()
            return
        }
        if (name?.text.toString().equals("Ozodbek") && password?.text.toString().equals("221")) {

            if (box?.isChecked == true) {
                sharedPreference =
                    getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                var editor = sharedPreference?.edit()
                editor?.clear()
                editor?.putString("name", name.toString())
                editor?.putString("password", password?.text.toString())
                Toast.makeText(this, "Your name and password is saved ", Toast.LENGTH_LONG).show()
            } else {
                sharedPreference =
                    getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                var editor = sharedPreference?.edit()
                editor?.clear()
            }
//            var intent = Intent(this, MainActivity3::class.java)
//            ContextCompat.startActivity(intent)
        }
    }
//    if (password == null) {
//        Toast.makeText(this, "password is error ", Toast.LENGTH_LONG).show()}
//    if (name == firstName && password == firstPassword) {

//    }
//}
}



