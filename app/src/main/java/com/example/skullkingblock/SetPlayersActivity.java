package com.example.skullkingblock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableInt;

import com.example.skullkingblock.databinding.ActivitySetPlayerBinding;

import java.util.ArrayList;

public class SetPlayersActivity extends AppCompatActivity {
    ActivitySetPlayerBinding binding;

    public final ObservableInt numberOfPlayers = new ObservableInt();
    private final ArrayList<String> playerNames = new ArrayList<>();
    public boolean riskyZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_set_player);

        this.numberOfPlayers.set(4);
        this.riskyZero = false;
        this.binding.setSetPlayerActivity(this);
    }

    public void sendResults(){
        Intent intent = new Intent(this, GameActivity.class);

        for(int i = 0; i < this.numberOfPlayers.get(); i++){
            playerNames.add(((TextView) findViewById(Constants.playerNameIDs[i])).getText().toString());
        }

        CheckBox view = findViewById(R.id.riskyZeroCheck);
        this.riskyZero = view.isChecked();

        intent.putExtra(Constants.NUMBER_OF_PLAYERS_STRING, this.numberOfPlayers.get());
        intent.putExtra(Constants.RISKY_ZERO_STRING, this.riskyZero);
        intent.putStringArrayListExtra(Constants.PLAYER_NAMES_LIST_STRING, this.playerNames);

        finish();
        this.startActivity(intent);
    }

    /**
     * This method changes the playernumber and handles button en- and disabling upon pressing
     * increment and decrement button
     * @param view The button, that is pressed
     */
    public void changePlayerNumber(View view){
        if (view.getId() == R.id.incrementPlayerNumberButton){
            View decrement = findViewById(R.id.decrementPlayerNumberButton);

            this.numberOfPlayers.set(this.numberOfPlayers.get()+1);
            this.visibilityHandler();

            if (this.numberOfPlayers.get() >= 6){
                view.setEnabled(false);
            }
            if (this.numberOfPlayers.get() > 3){
                decrement.setEnabled(true);
            }
        }
        if (view.getId()== R.id.decrementPlayerNumberButton){
            View increment = findViewById(R.id.incrementPlayerNumberButton);

            this.visibilityHandler();
            this.numberOfPlayers.set(this.numberOfPlayers.get()-1);

            if (this.numberOfPlayers.get() <= 3){
                view.setEnabled(false);
            }
            if (this.numberOfPlayers.get() < 6){
                increment.setEnabled(true);
            }
        }
    }

    /**
     * handles the visibility of the playername text views when changing the playernumber. <br>
     * Note: <br>
     * call after incrementing playernumber <br>
     * call before decrementing playernumber <br>
     */
    private void visibilityHandler(){
        EditText name;
        name = findViewById(Constants.playerNameIDs[this.numberOfPlayers.get()-1]);
        if(name.getVisibility() == View.VISIBLE){
            name.setVisibility(View.INVISIBLE);
        }
        else{
            name.setVisibility(View.VISIBLE);
        }
    }
}