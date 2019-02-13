package com.example.sudh.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAlarm(getApplicationContext());
    }
    private void setAlarm(Context context){
        // set a repeating alarm
        int alarmHr = 19;
        int alarmMn = 48;
        Intent alarmIntent = new Intent(context, AlarmActivity.class);
        PendingIntent sender = PendingIntent.getActivity(context, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        /////
        // get a Calendar object with current time
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.set(Calendar.HOUR_OF_DAY, alarmHr);
//        calendar.set(Calendar.MINUTE, alarmMn);

        AlarmManager am = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);

        am.cancel(sender); // cancel others.

        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000,
                10*1000, sender);

//        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()+100,
//                AlarmManager.INTERVAL_DAY, sender);
    }

}

class alarmBroadcast extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent){

        Log.d("12341235", "onReceive: broadcast recieved");

        context.startService(new Intent(context, AlarmActivity.class));

        Intent alarmService = new Intent(context,AlarmActivity.class);

        context.sendBroadcast(alarmService);
    }
}
