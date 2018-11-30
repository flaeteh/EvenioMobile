package tehtuble.com.eveniomobile.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import tehtuble.com.eveniomobile.R

class RegisterActivity : AppCompatActivity() {

    var userName: EditText? = null
    var userEmail: EditText? = null
    var userIDNum: EditText? = null
    var userPassword: EditText? = null
    var imgStudent: ImageView? = null
    var imgProfessor: ImageView? = null
    var imgGuest: ImageView? = null
    var txtStudent: TextView? = null
    var txtProfessor: TextView? = null
    var txtGuest: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_register)

        imgStudent = findViewById(R.id.img_student)
        imgProfessor = findViewById(R.id.img_professor)
        imgGuest = findViewById(R.id.img_guest)
        txtStudent = findViewById(R.id.txt_student)
        txtProfessor = findViewById(R.id.txt_professor)
        txtGuest = findViewById(R.id.txt_guest)

        onClickStudent()
        onClickProfessor()
        onClickGuest()
        showLogin()
    }

    private fun showLogin() {
        var txtLogin = findViewById<Button>(R.id.txt_login)
        txtLogin.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }


    fun onClickStudent() {
        imgStudent!!.setOnClickListener {
            imgStudent?.setImageResource(R.drawable.studenticonred)
            txtStudent?.setTextColor(ContextCompat.getColor(this@RegisterActivity,
                R.color.colorPrimary
            ))
            imgProfessor?.setImageResource(R.drawable.teachericon)
            imgGuest?.setImageResource(R.drawable.guesticon)
            txtProfessor?.setTextColor(ContextCompat.getColor(this@RegisterActivity,
                R.color.White
            ))
            txtGuest?.setTextColor(ContextCompat.getColor(this@RegisterActivity,
                R.color.White
            ))
        }
    }

    fun onClickProfessor() {
        imgProfessor!!.setOnClickListener{
        imgProfessor?.setImageResource(R.drawable.teachericonred)
        txtProfessor?.setTextColor(ContextCompat.getColor(this@RegisterActivity,
            R.color.colorPrimary
        ))
        imgStudent?.setImageResource(R.drawable.studenticonwhite)
        imgGuest?.setImageResource(R.drawable.guesticon)
        txtStudent?.setTextColor(ContextCompat.getColor(this@RegisterActivity, R.color.White))
        txtGuest?.setTextColor(ContextCompat.getColor(this@RegisterActivity, R.color.White))
        }
    }

    fun onClickGuest() {
        imgGuest!!.setOnClickListener {
            imgGuest?.setImageResource(R.drawable.guesticonred)
            txtGuest?.setTextColor(ContextCompat.getColor(this@RegisterActivity,
                R.color.colorPrimary
            ))
            imgStudent?.setImageResource(R.drawable.studenticonwhite)
            imgProfessor?.setImageResource(R.drawable.teachericon)
            txtStudent?.setTextColor(ContextCompat.getColor(this@RegisterActivity,
                R.color.White
            ))
            txtProfessor?.setTextColor(ContextCompat.getColor(this@RegisterActivity,
                R.color.White
            ))
        }
    }
}
