package com.uits.service.service;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.uits.service.R;

import java.io.IOException;

/**
 * BackgroundSoundService
 * <p>
 * Copyright © 2019 UITS CO.,LTD
 * Created PHUQUY on 2019-12-20.
 **/
public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player = new MediaPlayer();

    public IBinder onBind(Intent arg0) {

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            if (player.isPlaying()) {
                player.stop();
                player.release();
                player = new MediaPlayer();
            }

            AssetFileDescriptor descriptor = getAssets().openFd("EmHauPhuongAnhTienTuyen.mp3");
            player.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            descriptor.close();

            player.prepare();
            player.setVolume(1f, 1f);
            player.setLooping(true);
     /*       player.setLooping(true); // Set looping
            player.setVolume(100,100);*/
            player.start();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        playBeep();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_STICKY;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }

    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {

    }

    public void onPause() {

    }

    public void playBeep() {


    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
    }

    @Override
    public void onLowMemory() {

    }
}
