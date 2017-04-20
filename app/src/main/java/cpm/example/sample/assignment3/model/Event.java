package cpm.example.sample.assignment3.model;

/**
 * Model class for Event
 */

public class Event {
    public Event(String mTitle, String mDate, String mPlace, int mStatus) {
        this.mDate = mDate;
        this.mTitle = mTitle;
        this.mPlace = mPlace;
        this.mStatus = mStatus;
    }

    private String mDate;

    public String getDate() {
        return mDate;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getPlace() {
        return mPlace;
    }

    public int getStatus() {
        return mStatus;
    }

    private String mTitle;
    private String mPlace;
    private int mStatus;

}
