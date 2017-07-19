package model.imask;

/**
 * Created by HUZY_KAMZ on 2/12/2017.
 */

public class EventsModel {
    private String EventName;
    private String MaximumScore;
    private String eventID;


    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getMaximumScore() {
        return MaximumScore;
    }

    public void setMaximumScore(String maximumScore) {
        MaximumScore = maximumScore;
    }
}
