package com.example.appcaixa.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import com.example.appcaixa.R
import com.example.appcaixa.register.view.RegisterActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    //private lateinit var btnnewuser: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       /* btnnewuser = findViewById(R.id.btn_new_user)

        btnnewuser.setOnClickListener{
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }*/

        val editTextEmail = findViewById<TextInputEditText>(R.id.et_login_email)
        val editTextPassword = findViewById<TextInputEditText>(R.id.login_edit_password)

        editTextEmail.addTextChangedListener(watcher)
        editTextPassword.addTextChangedListener(watcher)

        val buttonEnter = findViewById<LoadingButton>(R.id.login_btn_enter)
        buttonEnter.setOnClickListener {
            buttonEnter.showProgress(true)

            findViewById<TextInputLayout>(R.id.ip_edit_email).error = "Usuário inválido"

            findViewById<TextInputLayout>(R.id.ip_edit_password).error = "Senha incorreta"

            Handler(Looper.getMainLooper()).postDelayed({
                buttonEnter.showProgress(false)
            },2000)
        }

    }

    private val watcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            findViewById<LoadingButton>(R.id.login_btn_enter).isEnabled = s.toString().isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {

        }

    }

}