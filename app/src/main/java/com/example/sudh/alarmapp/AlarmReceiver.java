package com.example.sudh.alarmapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sudo-chawhan on 13/02/19.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Toast.makeText(context, "ALARM recieved broadcast!", Toast.LENGTH_SHORT);

//        context.startService(new Intent(context, AlarmActivity.class));

        Intent alarmService = new Intent(context,AlarmRingActivity.class);
        alarmService.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(alarmService);
    }
}

