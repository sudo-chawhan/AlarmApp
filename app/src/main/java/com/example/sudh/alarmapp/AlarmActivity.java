package com.example.sudh.alarmapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by sudo-chawhan on 11/02/19.
 */

public class AlarmActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_alarm);
        Toast.makeText(this, "alarm ringing", Toast.LENGTH_LONG);
    }
}
