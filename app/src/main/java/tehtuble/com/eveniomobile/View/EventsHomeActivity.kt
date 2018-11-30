package tehtuble.com.eveniomobile.View

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_events_home.*
import tehtuble.com.eveniomobile.View.Adapter.EventsHomeAdapter
import tehtuble.com.eveniomobile.Model.EventsHomeData
import tehtuble.com.eveniomobile.R

class EventsHomeActivity : AppCompatActivity() {

    private var eventsList: ArrayList<EventsHomeData>? = ArrayList()
    private var recyclerView: RecyclerView? = null
    private var eAdapter: EventsHomeAdapter? = null
    private var textSearch: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events_home)

        recyclerView = findViewById(R.id.RecyclerView)
       // textSearch = findViewById(R.id.et_search)

        recyclerView?.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this@EventsHomeActivity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView?.layoutManager = layoutManager
        eAdapter = EventsHomeAdapter(eventsList!!)
        recyclerView?.adapter = eAdapter

        for(i in 1..10) {
            val eventsData = EventsHomeData()

            eventsData.eventDescription = "July $i, 2017"
            eventsData.eventTime = "$i:30 PM"
            eventsData.eventName = "Event Number #$i"

            eventsList?.add(eventsData)
        }

        img_profile.setOnClickListener {
            onClickProfile()
        }

        textSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input
                eAdapter?.getFilter()?.filter(editable.toString())
            }
        })
    }

    fun onClickProfile() {
        val intent = Intent(this@EventsHomeActivity, ProfileActivity::class.java)
        startActivity(intent)
    }
}
