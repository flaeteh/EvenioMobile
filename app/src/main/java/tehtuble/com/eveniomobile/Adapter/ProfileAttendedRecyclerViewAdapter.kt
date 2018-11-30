package tehtuble.com.eveniomobile.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_attended_profile.view.*
import tehtuble.com.eveniomobile.Model.EventsProfileData
import tehtuble.com.eveniomobile.R

class ProfileAttendedRecyclerViewAdapter (eventsList: MutableList<EventsProfileData>) : RecyclerView.Adapter<ProfileAttendedRecyclerViewAdapter.ViewHolder>() {

    private var context: Context? = null
    var filterEvents: MutableList<EventsProfileData> = eventsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attended_profile, parent, false)
        context = itemView.context

        return ViewHolder(itemView)
    }

    override fun getItemCount() = filterEvents.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filterEvents.get(position))
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(events: EventsProfileData) = with(itemView) {
            txt_event?.text = events.eventName
            txt_date?.text = events.eventDate
            txt_time?.text = events.eventTime
            txt_location?.text = events.eventLocation
        }
    }
}