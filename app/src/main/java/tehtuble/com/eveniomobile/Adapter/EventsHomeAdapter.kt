package tehtuble.com.eveniomobile.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import kotlinx.android.synthetic.main.recyclerview_events.view.*
import tehtuble.com.eveniomobile.Model.EventsHomeData
import tehtuble.com.eveniomobile.R

class EventsHomeAdapter (
    private var eventsList: MutableList<EventsHomeData>) : RecyclerView.Adapter<EventsHomeAdapter.ViewHolder>()
{

    var filterEvents: MutableList<EventsHomeData>? = eventsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_events,parent, false)

        return ViewHolder(itemView)    }

    override fun getItemCount() = filterEvents?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filterEvents?.get(position) ?: EventsHomeData())
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(eventsList: EventsHomeData) = with(itemView) {
            txt_date.text = eventsList.eventDescription
            txt_time.text = eventsList.eventTime
            txt_transaction.text = eventsList.eventName
        }
    }

    //Search Filter
    fun getFilter() : Filter {
        return object: Filter() {
            override fun performFiltering(charSequence:CharSequence) : FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty())
                {
                    filterEvents = eventsList
                }
                else
                {
                    val filteredList = ArrayList<EventsHomeData>()
                    for (row in eventsList)
                    {
                        if (row.eventName.toLowerCase().contains(charString.toLowerCase()))
                        {
                            filteredList.add(row)
                        }
                    }
                    filterEvents = filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = filterEvents
                return filterResults
            }

            override fun publishResults(charSequence:CharSequence, filterResults: FilterResults) {
                filterEvents = filterResults.values as ArrayList<EventsHomeData>
                // refresh the list with filtered data
                notifyDataSetChanged()
            }
        }
    }
}