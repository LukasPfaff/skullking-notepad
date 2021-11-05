package com.example.skullkingblock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class OverviewActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        this.game = GameActivity.game;
    }
}