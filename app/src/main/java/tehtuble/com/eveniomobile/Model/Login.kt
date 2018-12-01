package tehtuble.com.eveniomobile.Model

import android.content.Context
import android.content.Intent
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import tehtuble.com.eveniomobile.View.EventsHomeActivity

class Login {
    internal var users = Users()
    internal var userRoleStud = "STUDENT"
    internal var userRoleProf = "PROFESSOR"
    internal var userRoleGuest = "GUEST"
    internal var emailAddressChecker: Boolean? = false


    fun allowUserToLogin(email: EditText, password: EditText, context: Context, auth: FirebaseAuth) {
        val emailAdd = email.text.toString().trim { it <= ' ' }
        val userPassword = password.text.toString().trim { it <= ' ' }

        if (emailAdd.isEmpty()) {
            Toast.makeText(context, "Please Enter your email", Toast.LENGTH_LONG).show()
            return
        }
        if (userPassword.isEmpty()) {
            Toast.makeText(context, "Please Enter you password", Toast.LENGTH_LONG).show()
            return
        }
        userLogin(emailAdd, userPassword, context, auth)
    }


    private fun userLogin(email: String, password: String, context: Context, auth: FirebaseAuth) {


        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(object : OnCompleteListener<AuthResult> {
            internal var mRef = FirebaseDatabase.getInstance().reference

            override fun onComplete(task: Task<AuthResult>) {
                if (task.isSuccessful) {
                    val uid = FirebaseAuth.getInstance().currentUser!!.uid
                    mRef.child("Users").child(FirebaseAuth.getInstance().currentUser!!.uid)
                        .addValueEventListener(object : ValueEventListener {
                            override fun onDataChange(dataSnapshot: DataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    val role = dataSnapshot.child("role").getValue(String::class.java)
                                    if (role == userRoleStud) {
                                        Toast.makeText(context, userRoleStud, Toast.LENGTH_LONG).show()
                                        sendEventsHome(context)
                                    } else if (role == userRoleProf) {
                                        Toast.makeText(context, userRoleProf, Toast.LENGTH_LONG).show()
                                        sendEventsHome(context)
                                    } else if (role == userRoleGuest) {
                                        Toast.makeText(context, userRoleGuest, Toast.LENGTH_LONG).show()
                                        sendEventsHome(context)
                                    }
                                }

                            }

                            override fun onCancelled(databaseError: DatabaseError) {

                            }
                        })


                } else {
                    Toast.makeText(context, task.exception!!.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun sendEventsHome(context: Context) {
        val intent = Intent(context, EventsHomeActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }


    private fun checkIfEmailIsVerified(context: Context, auth: FirebaseAuth) {
        val user = auth.currentUser
        emailAddressChecker = user!!.isEmailVerified

        if (emailAddressChecker!!) {
            sendEventsHome(context)
        } else {
            Toast.makeText(context, "Please Verify your account first", Toast.LENGTH_SHORT).show()
            auth.signOut()
        }
    }
}
