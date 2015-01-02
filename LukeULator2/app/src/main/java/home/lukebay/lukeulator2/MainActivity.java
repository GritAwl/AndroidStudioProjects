package home.lukebay.lukeulator2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.editText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void seven(View v) {
        textView.setText("7", TextView.BufferType.EDITABLE);
    }

    public void eight(View v) {
        textView.setText("8", TextView.BufferType.EDITABLE);
    }

    public void nine(View v) {
        textView.setText("9", TextView.BufferType.EDITABLE);
    }

    public void clearEntry(View v) {
        textView.setText("?", TextView.BufferType.EDITABLE);
    }

    public void allClear(View v) {
        textView.setText("0", TextView.BufferType.EDITABLE);
    }

    public void four(View v) {
        textView.setText("4", TextView.BufferType.EDITABLE);
    }

    public void five(View v) {
        textView.setText("5", TextView.BufferType.EDITABLE);
    }

    public void six(View v) {
        textView.setText("6", TextView.BufferType.EDITABLE);
    }

    public void mult(View v) {
        textView.setText("X", TextView.BufferType.EDITABLE);
    }

    public void div(View v) {
        textView.setText("/", TextView.BufferType.EDITABLE);
    }

    public void one(View v) {
        textView.setText("1", TextView.BufferType.EDITABLE);
    }

    public void two(View v) {
        textView.setText("2", TextView.BufferType.EDITABLE);
    }

    public void three(View v) {
        textView.setText("3", TextView.BufferType.EDITABLE);
    }

    public void add(View v) {
        textView.setText("+", TextView.BufferType.EDITABLE);
    }

    public void sub(View v) {
        textView.setText("-", TextView.BufferType.EDITABLE);
    }

    public void zero(View v) {
        textView.setText("0", TextView.BufferType.EDITABLE);
    }

    public void Lparen(View v) {
        textView.setText("(", TextView.BufferType.EDITABLE);
    }

    public void Rparen(View v) {
        textView.setText(")", TextView.BufferType.EDITABLE);
    }

    public void pow(View v) {
        textView.setText("^", TextView.BufferType.EDITABLE);
    }

    public void equals(View v) {
        textView.setText("=", TextView.BufferType.EDITABLE);
    }
}
