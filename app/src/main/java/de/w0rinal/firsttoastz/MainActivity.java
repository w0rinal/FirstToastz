package de.w0rinal.firsttoastz;

import android.os.Bundle;
import android.support.annotation.NonNull; //ToDo: still find out what this is. why keeps android studio deleting this?
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "FirstToastzMessage";
    private static final boolean DEBUGLOG = false;
    private static final boolean DEBUGTOAST = true;
    private static final boolean COUNT = true;
    private static String stageCounter = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doStuff("onCreate", "1");

        Button exiter = (Button) findViewById(R.id.exitButton);
        exiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                doStuff("onClick", "2");
                finish();
                System.exit(0);
            }
        });
        exiter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View arg0) {
                doStuff("onLongClick", "3");
                Intent returnHome = new Intent(Intent.ACTION_MAIN);
                returnHome.addCategory(Intent.CATEGORY_HOME);
                returnHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(returnHome);
                return true;
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        doStuff("onStart", "4");
    }

    @Override
    protected void onResume() {
        super.onResume();
        doStuff("onResume", "5");
    }

    @Override
    protected void onPause() {
        super.onPause();
        doStuff("onPause", "6");
    }

    @Override
    protected void onStop() {
        super.onStop();
        doStuff("onStop", "7");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        doStuff("onRestart", "8");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        doStuff("onDestroy", "9");
        if (COUNT) Toast.makeText(this, stageCounter, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        doStuff("onSaveInstanceState", "10");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        doStuff("onRestoreInstanceState", "11");
    }

    @Override
    public void onBackPressed() {
        doStuff("onBackPressed", "12");
        super.onBackPressed();
    }

    @Override
    public void finish() {
        doStuff("finish", "13");
        super.finish();
    }

    protected void doStuff(String where, String stages) {
        if (DEBUGLOG) Log.i(TAG, where);
        if (DEBUGTOAST) Toast.makeText(getApplicationContext(), where, Toast.LENGTH_SHORT).show();
        if (COUNT) {
            stageCounter = stageCounter + " " + stages;

            //ToDo: ability to view stageCounter
            TextView stageLister = (TextView) findViewById(R.id.passedStages);
            stageLister.setText(stageCounter);
        }
    }

}
