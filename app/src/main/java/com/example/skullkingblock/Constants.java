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

    protected static final  Integer[] player4OV = {R.id.ovNameLabelPlayer4, R.id.round1Player4, R.id.round2Player4, R.id.round3Player4, R.id.round4Player4, R.id.round5Player4, R.id.round6Player4, R.id.round7Player4, R.id.round8Player4, R.id.round9Player4, R.id.round10Player4};
    protected static final  Integer[] player5OV = {R.id.ovNameLabelPlayer5, R.id.round1Player5, R.id.round2Player5, R.id.round3Player5, R.id.round4Player5, R.id.round5Player5, R.id.round6Player5, R.id.round7Player5, R.id.round8Player5, R.id.round9Player5, R.id.round10Player5};
    protected static final  Integer[] player6OV = {R.id.ovNameLabelPlayer6, R.id.round1Player6, R.id.round2Player6, R.id.round3Player6, R.id.round4Player6, R.id.round5Player6, R.id.round6Player6, R.id.round7Player6, R.id.round8Player6, R.id.round9Player6, R.id.round10Player6};

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

    // Rows of the overview
    protected static final Integer[] tableHeader = {R.id.ovNameLabelPlayer, R.id.ovNameLabelPlayer2, R.id.ovNameLabelPlayer3, R.id.ovNameLabelPlayer4, R.id.ovNameLabelPlayer5, R.id.ovNameLabelPlayer6};
    protected static final Integer[] round1 = {R.id.round1Player, R.id.round1Player2, R.id.round1Player3, R.id.round1Player4, R.id.round1Player5, R.id.round1Player6};
    protected static final Integer[] round2 = {R.id.round2Player, R.id.round2Player2, R.id.round2Player3, R.id.round2Player4, R.id.round2Player5, R.id.round2Player6};
    protected static final Integer[] round3 = {R.id.round3Player, R.id.round3Player2, R.id.round3Player3, R.id.round3Player4, R.id.round3Player5, R.id.round3Player6};
    protected static final Integer[] round4 = {R.id.round4Player, R.id.round4Player2, R.id.round4Player3, R.id.round4Player4, R.id.round4Player5, R.id.round4Player6};
    protected static final Integer[] round5 = {R.id.round5Player, R.id.round5Player2, R.id.round5Player3, R.id.round5Player4, R.id.round5Player5, R.id.round5Player6};
    protected static final Integer[] round6 = {R.id.round6Player, R.id.round6Player2, R.id.round6Player3, R.id.round6Player4, R.id.round6Player5, R.id.round6Player6};
    protected static final Integer[] round7 = {R.id.round7Player, R.id.round7Player2, R.id.round7Player3, R.id.round7Player4, R.id.round7Player5, R.id.round7Player6};
    protected static final Integer[] round8 = {R.id.round8Player, R.id.round8Player2, R.id.round8Player3, R.id.round8Player4, R.id.round8Player5, R.id.round8Player6};
    protected static final Integer[] round9 = {R.id.round9Player, R.id.round9Player2, R.id.round9Player3, R.id.round9Player4, R.id.round9Player5, R.id.round9Player6};
    protected static final Integer[] round10 = {R.id.round10Player, R.id.round10Player2, R.id.round10Player3, R.id.round10Player4, R.id.round10Player5, R.id.round10Player6};

    protected static final Integer[][] rows = {round1, round2, round3, round4, round5, round6, round7, round8, round9, round10};
}
