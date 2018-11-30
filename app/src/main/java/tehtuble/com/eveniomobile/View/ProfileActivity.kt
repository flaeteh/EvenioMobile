package tehtuble.com.eveniomobile.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_profile.*
import tehtuble.com.eveniomobile.Adapter.ProfilePageAdapter
import tehtuble.com.eveniomobile.Model.EventsProfileData
import tehtuble.com.eveniomobile.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_profile)

        var tabLayout = findViewById<View>(R.id.tabLayout)
        var pageAdapter = ProfilePageAdapter(supportFragmentManager, 2)
        var attendedEventsFragment = pageAdapter.getAttendedEventsFragment()
        var pendingEventsFragment = pageAdapter.getPendingEventsFragment()

        viewPager.adapter = pageAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout as TabLayout?))

        img_home.setOnClickListener {
            onClickHome()
        }
    }

    fun onClickHome() {
        val intent = Intent(this@ProfileActivity, EventsHomeActivity::class.java)
        startActivity(intent)
    }
}
