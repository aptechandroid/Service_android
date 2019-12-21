package com.uits.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.uits.service.service.BackgroundSoundService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);
    }

    public void onStartMusic(View view) {
        Intent svc = new Intent(this, BackgroundSoundService.class);
        startService(svc);
    }

    public void onStopMusic(View view) {
        Intent svc = new Intent(this, BackgroundSoundService.class);
        stopService(svc);
    }
}
