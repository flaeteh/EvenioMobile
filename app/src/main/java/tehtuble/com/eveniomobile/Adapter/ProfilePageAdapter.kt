package tehtuble.com.eveniomobile.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import tehtuble.com.eveniomobile.View.Fragments.AttendedEventsFragment
import tehtuble.com.eveniomobile.View.Fragments.PendingEventsFragment

class ProfilePageAdapter (fm: FragmentManager?, numOfTabs: Int) : FragmentPagerAdapter(fm) {

    private var numOfTabs: Int = numOfTabs
    private var attendedEventsFragment = AttendedEventsFragment()
    private var pendingEventsFragment = PendingEventsFragment()

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> attendedEventsFragment
            1 -> pendingEventsFragment
            else -> null
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }

    fun getAttendedEventsFragment() : AttendedEventsFragment {
        return attendedEventsFragment
    }

    fun getPendingEventsFragment() : PendingEventsFragment {
        return pendingEventsFragment
    }
}