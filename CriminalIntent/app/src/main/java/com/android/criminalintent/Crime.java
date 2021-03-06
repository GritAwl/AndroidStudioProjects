package com.android.criminalintent;

import java.util.UUID;

/**
 * Created by luke on 10/27/14.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime() {
        //  Generate unique identifier
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }
}
