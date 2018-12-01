package tehtuble.com.eveniomobile.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import tehtuble.com.eveniomobile.Model.Login
import tehtuble.com.eveniomobile.R

class LoginActivity : AppCompatActivity() {
    internal var login = Login()
    var btnLogin: Button? = null
    var et_email: EditText? = null
    var et_password: EditText? = null

    var auth: FirebaseAuth? = null
    internal var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)
        user = FirebaseAuth.getInstance().currentUser
        et_email = findViewById(R.id.user_name)
        et_password = findViewById(R.id.user_pass)
        btnLogin = findViewById(R.id.btn_login)
        user = FirebaseAuth.getInstance().currentUser
        auth = FirebaseAuth.getInstance()

        if (user != null) {
            // User is signed in
            val i = Intent(this@LoginActivity, EventsHomeActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        } else {
            // User is signed out

        }


        showRegister()
        //showHome()
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

    fun option(v: View) {
        if (v.id == R.id.btn_login) {
            et_email?.let {
                et_password?.let { it1 ->
                    auth?.let { it2 ->
                        login.allowUserToLogin(
                            it, it1, this@LoginActivity,
                            it2
                        )
                    }
                }
            }
        }
    }
}
