package tehtuble.com.eveniomobile.Model

open class EventsProfileData {

    //sample data only for display purposes

    var eventName: String
    var eventDate: String
    var eventTime: String
    var eventLocation: String


    constructor(
        eventName: String,
        eventDate: String,
        eventTime: String,
        eventLocation: String
    ) {
        this.eventName = eventName
        this.eventDate = eventDate
        this.eventTime = eventTime
        this.eventLocation = eventLocation
    }

    fun setEventname (eventName: String) {
        this.eventName = eventName
    }

    fun getEventname() : String {
        return eventName
    }

    fun setEventdate (eventDate: String) {
        this.eventDate = eventDate
    }

    fun getEventdate() : String {
        return eventDate
    }

    fun setEventtime (eventTime: String) {
        this.eventTime = eventTime
    }

    fun getEventtime() : String {
        return eventTime
    }

    fun setEventlocation (eventLocation: String) {
        this.eventLocation = eventLocation
    }

    fun getEventlocation() : String {
        return  eventLocation
    }
}