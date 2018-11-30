package tehtuble.com.eveniomobile.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import tehtuble.com.eveniomobile.R

class LoginActivity : AppCompatActivity() {

    var btnLogin: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)

        var et_email: EditText? = null
        var et_password: EditText? = null
        btnLogin = findViewById(R.id.btn_login)

        showRegister()
        showHome()
    }

    private fun showRegister() {
        var txtRegister = findViewById<Button>(R.id.txt_register2)
        txtRegister.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showHome() {
        btnLogin?.setOnClickListener() {
            val intent = Intent(this, EventsHomeActivity::class.java)
            startActivity(intent)
        }
    }
}
