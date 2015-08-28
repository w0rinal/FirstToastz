package de.w0rinal.firsttoastz;

import android.os.Bundle;
import android.support.annotation.NonNull; //ToDo: find out what this does
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "w0rinalsMessage";
    private static final boolean DEBUG = false;
    private static String stageCounter = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (DEBUG) Log.i(TAG, "onCreate");
        whereAmI("onCreate");
        countStages("1");

        Button exit = (Button) findViewById(R.id.exitButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //Toast.makeText(getApplicationContext(), "by now this button doesn't do anything but show this toast", Toast.LENGTH_SHORT).show();

                //taken from http://stackoverflow.com/questions/6014028/closing-application-with-exit-button
                finish();
                System.exit(0);

                /*
                ToDo: check http://stackoverflow.com/questions/3226495/android-exit-application-code
                ToDO: compare differences between {finish(); System.exit(int code);} and method mentioned in link above
                */

            }
        });
        exit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                whereAmI("leaving");
                //ToDo: fill
                return false;
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        if (DEBUG) Log.i(TAG, "onStart");
        whereAmI("onStart");
        countStages("2");
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (DEBUG) Log.i(TAG, "onResume");
        whereAmI("onResume");
        countStages("3");
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (DEBUG) Log.i(TAG, "onPause");
        whereAmI("onPause");
        countStages("4");
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (DEBUG) Log.i(TAG, "onStop");
        whereAmI("onStop");
        countStages("5");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        if (DEBUG) Log.i(TAG, "onRestart");
        whereAmI("onRestart");
        countStages("6");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (DEBUG) Log.i(TAG, "onDestroy");
        whereAmI("onDestroy");
        countStages("7");
        Toast.makeText(this, stageCounter, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (DEBUG) Log.i(TAG, "onSaveInstanceState");
        whereAmI("onSaveInstanceState");
        countStages("8");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (DEBUG) Log.i(TAG, "onRestoreInstanceState");
        whereAmI("onRestoreInstanceState");
        countStages("9");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        countStages("10");
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        countStages("11");

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

@Override
public void onBackPressed() {
whereAmI("onBackPressed");
countStages("12");
super.onBackPressed();
} 

@Override
public void finish() {
whereAmI("finish");
countStages("13");
super.finish();
} 

//ToDo: check if number are accepted as strings, indent correctly


    protected void whereAmI(String where) {
        Toast.makeText(getApplicationContext(), where, Toast.LENGTH_SHORT).show();
    }

    protected void countStages(String stages) {
        stageCounter = stageCounter + " " + stages;
    }

    //ToDo: ability to view stageCounter


}
