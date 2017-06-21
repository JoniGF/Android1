package com.example.walter.reproductor;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    int posicion = 0;
    Button play ;
    MediaPlayer mMediaPlayer;
    Button pause;
    Button continuar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = (Button)findViewById(R.id.button2);
        pause = (Button)findViewById(R.id.pause);
        continuar = (Button)findViewById(R.id.continuar);
        /*de aca esta de mas*/
        /*final Button play = (Button) findViewById(R.id.button2);
        final Drawable a = getResources().getDrawable(R.drawable.play2);
        final Drawable b = getResources().getDrawable(R.drawable.pause2);
        final MediaPlayer mMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.b);
       play.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    play.setBackground(a);
                } else if (!mMediaPlayer.isPlaying()) {
                    play.setBackground(b);
                    mMediaPlayer.start();
                }
            }
        });*/
    }
    public void play(View view){
        mMediaPlayer=MediaPlayer.create(this, R.raw.a);
        mMediaPlayer.start();
        play.setVisibility(View.INVISIBLE);
        pause.setVisibility(View.VISIBLE);
        continuar.setVisibility(View.INVISIBLE);
    }

    public void stop(View view){
        continuar.setVisibility(View.INVISIBLE);
        play.setVisibility(View.VISIBLE);
        pause.setVisibility(View.INVISIBLE);
        mMediaPlayer.stop();
        posicion=0;
    }

    public void pausa(View view) {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            continuar.setVisibility(View.VISIBLE);
            play.setVisibility(View.INVISIBLE);
            pause.setVisibility(View.INVISIBLE);
            posicion = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();
        }
    }

    public void continuar(View view){
        if (mMediaPlayer != null && !mMediaPlayer.isPlaying()){
            mMediaPlayer.seekTo(posicion);
            mMediaPlayer.start();
            continuar.setVisibility(View.INVISIBLE);
            play.setVisibility(View.INVISIBLE);
            pause.setVisibility(View.VISIBLE);
        }
    }
}