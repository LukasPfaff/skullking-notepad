package com.example.skullkingblock;

public class Game {
    private final Player[] players;
    private int round;
    private final String[][] pointTable;
    private final boolean riskyZero;

    public Game(int playerNumber, boolean risky) {
        this.players = new Player[playerNumber];
        this.round = 1;
        this.pointTable = new String[playerNumber][10];
        this.riskyZero = risky;
    }

    /**
     * Set a player at the given index in the players array
     *
     * @param player a player
     * @param index  his position
     */
    public void setPlayer(Player player, int index) {
        this.players[index] = player;
    }

    /**
     * Get the number of players in the game
     * @return number of players
     */
    public int getPlayerNumber(){
        return players.length;
    }

    /**
     * return the name of the player at a given position of the table
     * @param i position
     * @return player name
     */
    public String getPlayerName(int i){
        return players[i].toString();
    }

    public int getPlayerPoints(int i){
        return players[i].getPoints();
    }

    /**
     * Return whether the game has the risky Zero mechanic enabled
     * @return if false players are pussys
     */
    public boolean getRisky(){
        return this.riskyZero;
    }

    /**
     * Return the current round of the game
     * @return current round
     */
    public int getRound(){
        return this.round;
    }

    public void setCall(int call, int playerIndex){
        players[playerIndex].setCall(call);
    }

    public void setPoints(int stitches, int bonus, int playerIndex){
        players[playerIndex].setStitches(stitches);
        players[playerIndex].setPoints(this.round, bonus);
    }

    /**
     * Increase the round counter and reset the players calls/stitches. <br>
     * Fill the Scoreboard.
     */
    public void nextRound(){
        for(Player player : players){
            int i = 0;
            pointTable[i][this.round-1] = player.getCall() + "|" + player.getPoints();
            player.resetPlayer();
            i++;
        }
        this.round++;
    }
}
