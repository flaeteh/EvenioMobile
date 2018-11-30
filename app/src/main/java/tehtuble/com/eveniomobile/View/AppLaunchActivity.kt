package tehtuble.com.eveniomobile.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import tehtuble.com.eveniomobile.R

class AppLaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_app_launch)

        showLogin()
        showRegister()
    }

    private fun showRegister() {
        var btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showLogin() {
        var btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
