package com.example.eduardo.a3ra_eva_14_musica;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class playmusic extends Service {
    public static  boolean bBandeMediaPlayerCreate= false;
    MediaPlayer mpPlayMusic;

    @Override
    public void onDestroy() {
        super.onDestroy();
        mpPlayMusic.stop();
        mpPlayMusic.release();
        mpPlayMusic= null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if(!mpPlayMusic.isPlaying()){//si no esta tocando la musica
            mpPlayMusic.start();//tocamo
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        bBandeMediaPlayerCreate = true;
        mpPlayMusic= MediaPlayer.create(getApplicationContext(),R.raw.acdc_back_in_black);
    }

    public playmusic() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
