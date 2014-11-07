package com.kekwanu.androidlistviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private String TAG = "HW2::MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "::onCreate(savedInstanceState)");

        setContentView(R.layout.activity_main);

        GridView grid = (GridView)findViewById(R.id.gridView);
/*
        //get reference to ListView object
*//*
        ListView list = (ListView)findViewById(R.id.listview);
*/

        //this is a sample data. This could be in whatever form.
        String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas",
                "California", "Colorado", "Connecticut", "Delaware",
                "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
                "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana",
                "Maine", "Maryland", "Massachusetts", "Michigan",
                "Minnesota", "Mississippi", "Missouri", "Montana",
                "Nebraska", "Nevada", "New Hampshire", "New Jersey",
                "New Mexico", "New York", "North Carolina",
                "North Dakota", "Ohio", "Oklahoma", "Oregon",
                "Pennsylvania", "Rhode Island", "South Carolina",
                "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                "Virginia", "Washington", "West Virginia", "Wisconsin",
                "Wyoming"};

        //I just prefer to work with ArrayList objects. Any Array type is fine.
        ArrayList statesList = new ArrayList<String>(Arrays.asList(states));

        //Optimized adapter. See definition of the OptimizedCustomAdapter class, which extends a BaseAdapter
        //pass in a context reference. You get a reference o the context in an Activity class by simply using "this".
        OptimizedCustomAdapter adapter = new OptimizedCustomAdapter(this,statesList);

        grid.setAdapter(adapter);

        //set the adapter to the ListView object.
/*
        list.setAdapter(adapter);
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG, "::onCreateOptionsMenu(menu)");

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "::onOptionsItemSelected(item)");

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
