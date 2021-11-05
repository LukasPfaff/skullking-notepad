package com.example.skullkingblock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.skullkingblock.databinding.ActivityGameBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class GameActivity extends AppCompatActivity {
    ActivityGameBinding binding;

    protected static Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        this.binding.setGameActivity(this);

        // create the game
        Intent intent = getIntent();
        int playernumber = intent.getIntExtra(Constants.NUMBER_OF_PLAYERS_STRING, 3);
        boolean risky = intent.getBooleanExtra(Constants.RISKY_ZERO_STRING, false);
        ArrayList<String> playernames = intent.getStringArrayListExtra(Constants.PLAYER_NAMES_LIST_STRING);

        game = new Game(playernumber, risky);
        
        for(int i = 0; i < playernames.size(); i++){
            Player player = new Player(playernames.get(i));
            game.setPlayer(player, i);
        }

        // modify UI
        this.modifyUI();
    }

    /**
     * Remove unused elements, set action listeners, disable elements, that shouldn't be used yet
     */
    private void modifyUI(){
        this.managePlayers();
        this.pussyGame();
        this.setRoundLabel();
        this.highlightStartingPlayer();
    }

    /**
     * Set the player Name Labels and remove excess players
     */
    private void managePlayers(){
        //hide player 4-6 depending on player number
        if (game.getPlayerNumber() < 6) {
            for (int i : Constants.player6Elements) {
                View view = findViewById(i);
                view.setVisibility(View.GONE);
            }
            if (game.getPlayerNumber() < 5) {
                for (int i : Constants.player5Elements) {
                    View view = findViewById(i);
                    view.setVisibility(View.GONE);
                }
                if (game.getPlayerNumber() < 4) {
                    for (int i : Constants.player4Elements) {
                        View view = findViewById(i);
                        view.setVisibility(View.GONE);
                    }
                }
            }
        }

        // set the player names
        for(int i = 0; i < game.getPlayerNumber(); i++){
            TextView view = findViewById(Constants.playerLabels[i]);
            view.setText(game.getPlayerName(i));
        }
    }

    /**
     * remove risky Zero mechanic elements, because players are pussies
     */
    private void pussyGame(){
        if(!game.getRisky()){
            for(int i : Constants.riskyElements){
                View view = findViewById(i);
                view.setVisibility(View.GONE);
            }
        }
    }

    /**
     * Call this method by pressing a button to change a call
     * @param view the button that is pressed
     * @param increment true if the button increments the call
     */
    public void changeCall(@NonNull View view, boolean increment){
        int buttonID = view.getId();
        int player;
        int call;

        if (!increment) {
            player = Arrays.asList(Constants.decrementCallButtons).indexOf(buttonID);
            TextView callView = findViewById(Constants.callViews[player]);
            call = Integer.parseInt(callView.getText().toString());
            call--;
            callView.setText(String.valueOf(call));

            if (call == 0){
                view.setEnabled(false);
            }
            if (call == (game.getRound() -1)){
                View incBut = findViewById(Constants.incrementCallButtons[player]);
                incBut.setEnabled(true);
            }
        }
        if (increment){
            player = Arrays.asList(Constants.incrementCallButtons).indexOf(buttonID);
            TextView callView = findViewById(Constants.callViews[player]);
            call = Integer.parseInt(callView.getText().toString());
            call++;
            callView.setText(String.valueOf(call));

            if (call == game.getRound()){
                view.setEnabled(false);
            }
            if (call == 1){
                View decBut = findViewById(Constants.decrementCallButtons[player]);
                decBut.setEnabled(true);
            }
        }
    }

    /**
     * Call this method by pressing a button to change the number od stitches a player made
     * @param view the button that is pressed
     * @param increment true if the button increments the number of stitches
     */
    public void changeStitches(@NonNull View view, boolean increment){
        int buttonID = view.getId();
        int player;
        int stitches;

        if (!increment) {
            player = Arrays.asList(Constants.decrementStitchesButtons).indexOf(buttonID);
            TextView stitchesView = findViewById(Constants.stitchesViews[player]);
            stitches = Integer.parseInt(stitchesView.getText().toString());
            stitches--;
            stitchesView.setText(String.valueOf(stitches));

            if (stitches == 0){
                view.setEnabled(false);
            }
            if (stitches == (game.getRound() -1)){
                View incBut = findViewById(Constants.incrementStitchesButtons[player]);
                incBut.setEnabled(true);
            }
        }
        if (increment){
            player = Arrays.asList(Constants.incrementStitchesButtons).indexOf(buttonID);
            TextView stitchesView = findViewById(Constants.stitchesViews[player]);
            stitches = Integer.parseInt(stitchesView.getText().toString());
            stitches++;
            stitchesView.setText(String.valueOf(stitches));

            if (stitches == game.getRound()){
                view.setEnabled(false);
            }
            if (stitches == 1){
                View decBut = findViewById(Constants.decrementStitchesButtons[player]);
                decBut.setEnabled(true);
            }
        }
    }

    /**
     * Saves the calls, disables the call elements and enables the stitches elements
     */
    public void confirmCalls(){
        int players = game.getPlayerNumber();
        for(int i = 0; i < players; i++){
            // save the calls
            TextView callView = findViewById(Constants.callViews[i]);
            int call = Integer.parseInt(callView.getText().toString());
            game.setCall(call, i);

            // Disable call elements
            View view = findViewById(Constants.decrementCallButtons[i]);
            view.setEnabled(false);
            view = findViewById(Constants.incrementCallButtons[i]);
            view.setEnabled(false);

            // Enable stitches elements
            view = findViewById(Constants.incrementStitchesButtons[i]);
            view.setEnabled(true);
            view = findViewById(Constants.bonusPointViews[i]);
            view.setEnabled(true);
        }
        View view = findViewById(R.id.confirmCallsButton);
        view.setEnabled(false);
        view = findViewById(R.id.confirmStitchesButton);
        view.setEnabled(true);
    }

    /**
     * Saves the points and starts a new round. Disables stitches elements and enables call elements
     */
    public void nextRound(){
        // check, if the correct amount of stitches is given
        int stitchesSum = 0;
        for(Integer i : Constants.stitchesViews){
            TextView view = findViewById(i);
            stitchesSum += Integer.parseInt(view.getText().toString());
        }
        if (stitchesSum != game.getRound()){
            return;
        }

        // prepare going to next round
        int players = game.getPlayerNumber();
        for(int i = 0; i < players; i++){
            View view;
            // save the points
            TextView stitchesView = findViewById(Constants.stitchesViews[i]);
            int stitches = Integer.parseInt(stitchesView.getText().toString());
            EditText bonusView = findViewById(Constants.bonusPointViews[i]);
            int bonus = Integer.parseInt(bonusView.getText().toString());
            game.setPoints(stitches, bonus, i);

            // display points
            TextView tview = findViewById(Constants.pointsViews[i]);
            int points = game.getPlayerPoints(i);
            tview.setText(String.valueOf(points));

            // Disable stitches elements
            view = findViewById(Constants.decrementStitchesButtons[i]);
            view.setEnabled(false);
            view = findViewById(Constants.incrementStitchesButtons[i]);
            view.setEnabled(false);
            EditText viewb = findViewById(Constants.bonusPointViews[i]);
            viewb.setText(R.string.placeholderNumberString);
            viewb.setEnabled(false);

            // Enable call elements
            view = findViewById(Constants.incrementCallButtons[i]);
            view.setEnabled(true);

            // reset call and stitches views
            tview = findViewById(Constants.callViews[i]);
            tview.setText(getString(R.string.placeholderNumberString));
            tview = findViewById(Constants.stitchesViews[i]);
            tview.setText(getString(R.string.placeholderNumberString));
        }
        View view = findViewById(R.id.confirmStitchesButton);
        view.setEnabled(false);
        view = findViewById(R.id.confirmCallsButton);
        view.setEnabled(true);

        // end game after round 10, show scoreboard
        if (game.getRound() == 10) {
            game.nextRound();
            this.showOverview(true);
            return;
        }

        // set the game state to next round
        game.nextRound();
        this.setRoundLabel();
        this.highlightStartingPlayer();
    }

    /**
     * Set the text for the label that shows the current round
     */
    private void setRoundLabel(){
        int round = game.getRound();
        String roundString = getString(R.string.roundCounter) + " " + round;
        TextView view = findViewById(R.id.roundView);
        view.setText(roundString);
    }

    /**
     * Make the players name that is starting this round bold. <br>
     * Remove highlights from last rounds starting player
     */
    private void highlightStartingPlayer(){
        int round = game.getRound();
        int playernumber = game.getPlayerNumber();
        int startingPlayer;
        int prevPlayer;
        startingPlayer = round % playernumber;
        if(startingPlayer == 0){
            startingPlayer = playernumber -1;
        }
        else{
            startingPlayer--;
        }
        TextView view = findViewById(Constants.playerLabels[startingPlayer]);
        view.setTypeface(view.getTypeface(), Typeface.BOLD_ITALIC);
        view.setPaintFlags(view.getPaintFlags() ^ Paint.UNDERLINE_TEXT_FLAG);

        if(startingPlayer == 0) {
            prevPlayer = playernumber-1;
        }
        else{
            prevPlayer = startingPlayer - 1;
        }
        view = findViewById(Constants.playerLabels[prevPlayer]);
        view.setTypeface(null, Typeface.NORMAL);
        if (round > 1) view.setPaintFlags(view.getPaintFlags() ^ Paint.UNDERLINE_TEXT_FLAG);
    }

    /**
     *  show the scoreboard. If the last round was played, close this activity
     */
    public void showOverview(boolean lastRound){
        if (lastRound) this.finish();
        Intent intent = new Intent(this, OverviewActivity.class);
        this.startActivity(intent);
    }
}