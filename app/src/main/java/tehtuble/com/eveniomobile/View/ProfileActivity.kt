package tehtuble.com.eveniomobile.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_profile.*
import tehtuble.com.eveniomobile.View.Adapter.ProfilePageAdapter
import tehtuble.com.eveniomobile.R
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import tehtuble.com.eveniomobile.Model.UserProfile


class ProfileActivity : AppCompatActivity() {
    private var profileReference: DatabaseReference? = null
    private var auth: FirebaseAuth? = null
    private var currentUserId: String? = null
    var userName: TextView? = null
    var email: TextView? = null
    var studNum: TextView? = null
    internal var userProfile = UserProfile()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_profile)
        userName = findViewById(R.id.name)
        email = findViewById(R.id.email)
        studNum = findViewById(R.id.studNum)
        var tabLayout = findViewById<View>(R.id.tabLayout)
        var pageAdapter = ProfilePageAdapter(supportFragmentManager, 2)
        var attendedEventsFragment = pageAdapter.getAttendedEventsFragment()
        var pendingEventsFragment = pageAdapter.getPendingEventsFragment()
        auth = FirebaseAuth.getInstance()
        currentUserId = auth!!.currentUser!!.uid

        profileReference = FirebaseDatabase.getInstance().getReference().child("Users").child(currentUserId!!)

        userProfile.getUserProfile(profileReference, userName, email, studNum)


        viewPager.adapter = pageAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout as TabLayout?))

        img_home.setOnClickListener {
            onClickHome()
        }

        tabLayout?.setTabTextColors(resources.getColor(R.color.lightGray), resources.getColor(R.color.White))
        for (i in 0 until tabLayout?.tabCount!!) {
            val tab = (tabLayout?.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(20, 0, 20, 0)
            tab.requestLayout()
        }


    }

    fun onClickHome() {
        val intent = Intent(this@ProfileActivity, EventsHomeActivity::class.java)
        startActivity(intent)
    }
}
