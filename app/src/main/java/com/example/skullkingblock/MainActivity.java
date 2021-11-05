package com.example.skullkingblock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.skullkingblock.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.binding.setMainActivity(this);
    }

    /**
     * Starts Activity to set the number of Players
     * @param view button that calls the method
     */
    public void openActivitySetPlayers(View view){
        Intent intent = new Intent(MainActivity.this, SetPlayersActivity.class);
        startActivity(intent);
    }
}