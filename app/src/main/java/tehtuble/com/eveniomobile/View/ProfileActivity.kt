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
