package com.example.sudh.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static SharedPreferences sharedPref;

    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putInt(getString(R.string.saved_high_score_key), newHighScore);
//        editor.commit();
        TextView alarmInfo = (TextView) findViewById(R.id.alarmInfo);
        if(sharedPref.contains("HR")){
            alarmInfo.setText("Alarm set for " + sharedPref.getInt("HR", 0) + ":" + sharedPref.getInt("MN", 0));

        }

        Button setButton = (Button) findViewById(R.id.setButton);
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarmService = new Intent(getApplicationContext(),AlarmSetActivity.class);
                alarmService.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                getApplicationContext().startActivity(alarmService);
            }
        });


    }


}


