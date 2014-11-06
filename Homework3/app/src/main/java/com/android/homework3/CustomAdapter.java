package com.android.homework3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luke on 10/30/14.
 */
public class CustomAdapter extends BaseAdapter {

    private String[] states;
    private Activity activity;
    private Context context;

    public CustomAdapter(Context context, ArrayList objects) {
        this.context = context;
        this.states = objects;
    }

    //  Define the nested class for the Holder pattern.
    static class ViewHolder {
        TextView state;
    }

    @Override
    public int getCount() {
        return states.size();
    }

    @Override
    public String getItem(int position) {
        return states.get(position);
    }

    //  Some sources state that this method is useless.
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_layout_item, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.state = (TextView) convertView.findViewById(R.id.state);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.state.setText(getItem(position));

        ((ViewHolder) convertView.getTag()).state.setText(getItem(position));

        return convertView;
    }
}
