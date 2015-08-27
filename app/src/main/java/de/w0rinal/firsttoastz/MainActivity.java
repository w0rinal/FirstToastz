package de.w0rinal.firsttoastz;

import android.os.Bundle;
import android.support.annotation.NonNull; //ToDo: find out what this is 
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
    private static Button daButton;
private static String stageCounter = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (DEBUG) Log.i(TAG, "onCreate");
        whereAmI("onCreate");
countStages("a");

        daButton = (Button) findViewById(R.id.exitButton);
        daButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //Toast.makeText(getApplicationContext(), "by now this button doesn't do anything but show this toast", Toast.LENGTH_SHORT).show();

                //taken from http://stackoverflow.com/questions/6014028/closing-application-with-exit-button
//Todo: remove this empty line and indent lines correctly
whereAmI("exiting");
                finish();
                System.exit(0);

                /*
                ToDo: check http://stackoverflow.com/questions/3226495/android-exit-application-code
                ToDO: compare differences between {finish(); System.exit(int code);} and method mentioned in link above
                */

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (DEBUG) Log.i(TAG, "onStart");
        whereAmI("onStart");
countStages("b");
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (DEBUG) Log.i(TAG, "onResume");
        whereAmI("onResume");
countStages("c");
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (DEBUG) Log.i(TAG, "onPause");
        whereAmI("onPause");
countStages("d");
    }


    @Override
    protected void onStop() {
        super.onStop();
        if (DEBUG) Log.i(TAG, "onStop");
        whereAmI("onStop");
countStages("e");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        if (DEBUG) Log.i(TAG, "onRestart");
        whereAmI("onRestart");
countStages("f");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (DEBUG) Log.i(TAG, "onDestroy");
        whereAmI("onDestroy");
countStages("g");
//Toast.makeText(this, stageCounter, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (DEBUG) Log.i(TAG, "onSaveInstanceState");
        whereAmI("onSaveInstanceState");
countStages("h");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (DEBUG) Log.i(TAG, "onRestoreInstanceState");
        whereAmI("onRestoreInstanceState");
countStages("i");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
countStages("j");
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
countStages("k");
    }


    protected void whereAmI(String where) {
        Toast.makeText(getApplicationContext(), where, Toast.LENGTH_SHORT).show();
    }

protected void countStages(String stages) {
stageCounter = stageCounter + " " + stages ;
//ToDo: when using IDE check out whether this works
} 

//ToDo: ability to view stageCounter


}
