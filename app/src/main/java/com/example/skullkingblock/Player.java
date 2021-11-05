package com.example.skullkingblock;

public class Player {
    private String name;
    private int points;
    private int call;
    private int stitches;
    private boolean riskyZero;
    private boolean wasRiskyZeroUsed;

    /**
     * Constructor of the Player class, creates new Player with default values
     */
    public Player(String name){
        this.name = name;
        this.points = 0;
        this.call = 0;
        this.stitches = 0;
        this.riskyZero = false;
        this.wasRiskyZeroUsed= false;
    }

    @Override
    public String toString(){
        return this.name;
    }

    // Setter

    /**
     * Set the name of a player
     * @param newName new Name of the Player
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Calculate the players points using his other attributes, the current round number and the
     * bonus points
     * @param round current round
     * @param bonus bonus points
     */
    public void setPoints(int round, int bonus){
        if(this.call == 0){
            int pointChange = this.riskyZero ? ((round * 10) + 50) : (round * 10);
            if(this.stitches == 0){
                this.points = this.points + pointChange;
            }
            else {
                this.points = this.points - pointChange;
            }
        }
        else{
            if(this.call == this.stitches){
                this.points = this.points + bonus + (this.stitches * 20);
            }
            else{
                int diff = Math.abs(this.call - this.stitches);
                this.points = this.points - (diff*10);
            }
        }
    }

    /**
     * sets most things back beside points, name, wasRiskyZero used. <br>
     * use at the start of a new round
     */
    public void resetPlayer(){
        this.call = 0;
        this.stitches = 0;
        if(this.riskyZero){
            wasRiskyZeroUsed = true;
        }
        this.riskyZero = false;
    }

    /**
     * Set the players call for this round
     * @param i call
     */
    public void setCall(int i){
        this.call = i;
    }

    /**
     * Set the number of stitches, a player made this round
     * @param i stitches
     */
    public void setStitches(int i){
        this.stitches = i;
    }

    /**
     * Set whether the player plays a risky Zero this round
     * @param risky risky Zero
     */
    public void setRiskyZero(boolean risky){
        this.riskyZero = risky;
    }

    /**
     * Get the points the player has
     * @return points
     */
    public int getPoints(){
        return this.points;
    }

    /**
     * Get how many stitches the player called this round
     * @return call
     */
    public int getCall(){
        return this.call;
    }
}
