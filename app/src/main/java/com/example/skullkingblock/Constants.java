package com.example.skullkingblock;

public class Constants {
    // intent Extra strings
    protected static final String NUMBER_OF_PLAYERS_STRING = "com.example.skullkingblock.numberOfPlayers";
    protected static final String RISKY_ZERO_STRING = "com.example.skullkingblock.riskyZero";
    protected static final String PLAYER_NAMES_LIST_STRING = "com.example.skullkingblock.playerNamesList";

    // ID of playernames edit texts in setplayers activity
    protected static final  Integer[] playerNameIDs = {R.id.playerName1, R.id.playerName2, R.id.playerName3, R.id.playerName4, R.id.playerName5, R.id.playerName6};

    // Player elements to hide players 4-6
    protected  static final Integer[] player4Elements = {R.id.nameLabelPlayer4, R.id.pointsPlayer4, R.id.riskyChipPlayer4, R.id.decrementCallPlayer4, R.id.callPlayer4, R.id.incrementCallPlayer4, R.id.decrementStitchesPlayer4, R.id.stitchesPlayer4, R.id.incrementStitchesPlayer4, R.id.bonusPointsPlayer4};
    protected  static final Integer[] player5Elements = {R.id.nameLabelPlayer5, R.id.pointsPlayer5, R.id.riskyChipPlayer5, R.id.decrementCallPlayer5, R.id.callPlayer5, R.id.incrementCallPlayer5, R.id.decrementStitchesPlayer5, R.id.stitchesPlayer5, R.id.incrementStitchesPlayer5, R.id.bonusPointsPlayer5};
    protected  static final Integer[] player6Elements = {R.id.nameLabelPlayer6, R.id.pointsPlayer6, R.id.riskyChipPlayer6, R.id.decrementCallPlayer6, R.id.callPlayer6, R.id.incrementCallPlayer6, R.id.decrementStitchesPlayer6, R.id.stitchesPlayer6, R.id.incrementStitchesPlayer6, R.id.bonusPointsPlayer6};

    // risky elements to remove in non risky game
    protected static final  Integer[] riskyElements = {R.id.riskyZeroLabel, R.id.riskyChipPlayer, R.id.riskyChipPlayer2, R.id.riskyChipPlayer3, R.id.riskyChipPlayer4, R.id.riskyChipPlayer5, R.id.riskyChipPlayer6};

    // Player Labels to set the names
    protected static final Integer[] playerLabels = {R.id.nameLabelPlayer, R.id.nameLabelPlayer2, R.id.nameLabelPlayer3, R.id.nameLabelPlayer4, R.id.nameLabelPlayer5, R.id.nameLabelPlayer6};

    // buttons to manipulate stitches and calls
    protected static final Integer[] decrementCallButtons = {R.id.decrementCallPlayer, R.id.decrementCallPlayer2, R.id.decrementCallPlayer3, R.id.decrementCallPlayer4, R.id.decrementCallPlayer5, R.id.decrementCallPlayer6};
    protected static final Integer[] incrementCallButtons = {R.id.incrementCallPlayer, R.id.incrementCallPlayer2, R.id.incrementCallPlayer3, R.id.incrementCallPlayer4, R.id.incrementCallPlayer5, R.id.incrementCallPlayer6};
    protected static final Integer[] decrementStitchesButtons = {R.id.decrementStitchesPlayer, R.id.decrementStitchesPlayer2, R.id.decrementStitchesPlayer3, R.id.decrementStitchesPlayer4, R.id.decrementStitchesPlayer5, R.id.decrementStitchesPlayer6};
    protected static final Integer[] incrementStitchesButtons = {R.id.incrementStitchesPlayer, R.id.incrementStitchesPlayer2, R.id.incrementStitchesPlayer3, R.id.incrementStitchesPlayer4, R.id.incrementStitchesPlayer5, R.id.incrementStitchesPlayer6};
    protected static final Integer[] bonusPointViews = {R.id.bonusPointsPlayer, R.id.bonusPointsPlayer2, R.id.bonusPointsPlayer3, R.id.bonusPointsPlayer4, R.id.bonusPointsPlayer5, R.id.bonusPointsPlayer6};

    // Text views that are showing the calls and stitches
    protected static final Integer[] callViews = {R.id.callPlayer, R.id.callPlayer2, R.id.callPlayer3, R.id.callPlayer4, R.id.callPlayer5, R.id.callPlayer6};
    protected static final Integer[] stitchesViews = {R.id.stitchesPlayer, R.id.stitchesPlayer2, R.id.stitchesPlayer3, R.id.stitchesPlayer4, R.id.stitchesPlayer5, R.id.stitchesPlayer6};
    protected static final Integer[] pointsViews = {R.id.pointsPlayer, R.id.pointsPlayer2, R.id.pointsPlayer3, R.id.pointsPlayer4, R.id.pointsPlayer5, R.id.pointsPlayer6};


}
