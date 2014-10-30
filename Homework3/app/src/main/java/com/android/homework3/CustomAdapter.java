package com.android.homework3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by luke on 10/30/14.
 */
public class CustomAdapter extends BaseAdapter {

    private ArrayList<String> states;
    private Activity activity;
    private Context context;

    public CustomAdapter(Context context, ArrayList objects) {
        this.context = context;
        this.states = objects;
    }

    //  Define the nested class for the Holder pattern.
    static class ViewHolder {

    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public String getItem(int position) {
        return states.get(position);
    }

    @Override
    public long getItemId(int position) {
        //  TODO: Note that this always returns 0.
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

    }
}
