package com.example.skullkingblock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OverviewActivity extends AppCompatActivity {

    private Game game;
    private int playernumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        this.game = GameActivity.game;
        playernumber = this.game.getPlayerNumber();

        this.removeUnusedColumns();
        this.setNames();
        this.setPoints();
    }

    /**
     * remove the unused columns from the table
     */
    private void removeUnusedColumns(){
        TextView view;
        if (playernumber < 6){
            for ( Integer i : Constants.player6OV){
                view = findViewById(i);
                view.setVisibility(View.GONE);
            }
            if (playernumber < 5){
                for ( Integer i : Constants.player5OV){
                    view = findViewById(i);
                    view.setVisibility(View.GONE);
                }
                if (playernumber < 4){
                    for ( Integer i : Constants.player4OV){
                        view = findViewById(i);
                        view.setVisibility(View.GONE);
                    }
                }
            }
        }
    }

    /**
     * set the names of the players at the top of the table
     */
    private void setNames(){
        for (int i = 0; i < this.game.getPlayers().length; i++){
            TextView view = findViewById(Constants.tableHeader[i]);
            view.setText(this.game.getPlayers()[i].toString());
        }
    }

    /**
     * fill the table with points
     */
    private void setPoints(){
        for(int i = 0; i < this.game.getRound(); i++){
            Integer[] row = Constants.rows[i];
            for(int j = 0; j < this.game.getPlayerNumber(); j++){
                TextView view = findViewById(row[j]);
                view.setText(this.game.getPointTable()[j][i]);
            }
        }
    }
}