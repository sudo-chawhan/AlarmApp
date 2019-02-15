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
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putInt(getString(R.string.saved_high_score_key), newHighScore);
//        editor.commit();
        final TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "alarm set for " + timePicker.getHour() + ":"+ timePicker.getMinute(), Toast.LENGTH_LONG);
                setAlarm(getApplicationContext(), timePicker.getHour(), timePicker.getMinute());
            }
        });

    }
    private void setAlarm(Context context, int alarmHr, int alarmMn){
        // set a repeating alarm
        int seconds = 1;
//        int alarmHr = 17;
//        int alarmMn = 51;
//        Log.d(TAG, "setAlarm: entered");
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        /////
        // get a Calendar object with current time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, alarmHr);
        calendar.set(Calendar.MINUTE, alarmMn);
//        ((AlarmManager) getSystemService(ALARM_SERVICE)).set(
//                AlarmManager.RTC, calendar.getTimeInMillis(), sender);
//        Toast.makeText(MainActivity.this, "Timer set to " + seconds + " seconds.",
//                Toast.LENGTH_SHORT).show();
        AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
//
        am.cancel(sender); // cancel others.
//
//        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000,
//                10*1000, sender);

        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, sender);
    }

}


