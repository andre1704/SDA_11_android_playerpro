package com.sdacademy.slowinski.andrzej.playerpro;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private SeekBar seekBarVolume;
    private ImageView playButton;
    private ImageView pauseButton;
    private ImageView restartButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = (ImageView) findViewById(R.id.play);
        pauseButton = (ImageView) findViewById(R.id.pause);
        restartButton = (ImageView) findViewById(R.id.restart);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBarVolume = (SeekBar) findViewById(R.id.voludeSeekBar);

        mediaPlayer = MediaPlayer.create(this, R.raw.bensound_dubstep);
        seekBar.setMax(100);

        pauseButton.setVisibility(View.INVISIBLE);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                float progress = seekBar.getProgress();
                int maxValue = 100;
                float currentProgress = progress / maxValue;
                int durationMillis = mediaPlayer.getDuration();
                mediaPlayer.seekTo((int) (durationMillis * currentProgress));
            }
        });
    }



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.play:
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    pauseButton.setVisibility(View.VISIBLE);
                    playButton.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.pause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playButton.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.restart:
                mediaPlayer.seekTo(0);
                break;
        }


    }
}
