package tehtuble.com.eveniomobile.View.Fragments

import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tehtuble.com.eveniomobile.View.Adapter.ProfileAttendedRecyclerViewAdapter
import tehtuble.com.eveniomobile.Model.EventsProfileData
import tehtuble.com.eveniomobile.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class PendingEventsFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    var recyclerView : RecyclerView? = null
    var eventsList : MutableList<EventsProfileData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.recyclerview_attendedfragment, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView = view.findViewById(R.id.attendedRecyclerView) as RecyclerView
        var layoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager
        var eAdapter = ProfileAttendedRecyclerViewAdapter(eventsList!!)
        recyclerView?.adapter = eAdapter


        for(i in 1..5) {
            var eventsData = EventsProfileData("Converge", "04/07/2017", "6:00 PM", "SM North Edsa")

            eventsList.add(eventsData)
        }

    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ForumFollowingFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AttendedEventsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}