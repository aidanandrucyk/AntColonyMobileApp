package com.e.antcolony;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    Switch musicSwitch;
    Switch soundEffectSwitch;
    Button howToPlayButton;
    Button credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Music Switch
        musicSwitch = (Switch) findViewById(R.id.musicSwitch);
        musicSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getBaseContext(), "Music On", Toast.LENGTH_SHORT).show();
                    MusicService.mPlayer.setVolume(.1f, .1f);
                    musicSwitch.setChecked(true);
                } else {
                    Toast.makeText(getBaseContext(), "Music Off", Toast.LENGTH_SHORT).show();
                    MusicService.mPlayer.setVolume(0f, 0f);
                    musicSwitch.setChecked(false);
                }
            }
        });

        // Sound Effect Switch
        soundEffectSwitch = (Switch) findViewById(R.id.soundEffectSwitch);
        soundEffectSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getBaseContext(), "Sound Effect On", Toast.LENGTH_SHORT).show();
                    MainActivity.WORKsound.setVolume(1f, 1f);
                    MainActivity.GROWsound.setVolume(1f, 1f);
                    MainActivity.LIFTsound.setVolume(1f, 1f);
                    MainActivity.BITEsound.setVolume(1f, 1f);
                    musicSwitch.setChecked(true);
                } else {
                    Toast.makeText(getBaseContext(), "Sound Effect Off", Toast.LENGTH_SHORT).show();
                    MainActivity.WORKsound.setVolume(0f, 0f);
                    MainActivity.GROWsound.setVolume(0f, 0f);
                    MainActivity.LIFTsound.setVolume(0f, 0f);
                    MainActivity.BITEsound.setVolume(0f, 0f);
                    musicSwitch.setChecked(false);
                }
            }
        });

        // How To Play Button
        howToPlayButton = (Button) findViewById(R.id.howToPlayButton);
        howToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHowToPlay();
            }
        });

        // Credits Button
        credits = findViewById(R.id.creditsButton);
        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCredits();
            }
        });

        Intent intent = getIntent();

        // Back Button
        Button okay = findViewById(R.id.okaySetting);
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void openHowToPlay() {
        Intent intent = new Intent(this, HowToPlay.class);
        startActivity(intent);
    }

    public void openCredits() {
        Intent intent = new Intent(this, Credits.class);
        startActivity(intent);
    }
}