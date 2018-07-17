package app.c.mahjong_beta;

/**
 * Created by s.kamada on 2018/07/06
 */

class Score {
    private Score(){}
    static final int MANGAN = 8000;
    static final int HANEMAN = 12000;
    static final int BAIMAN = 16000;
    static final int SANBAIMAN = 24000;
    static final int YAKUMAN = 32000;
    static final int DOUBLE_YAKUMAN = 64000;

    static final int BASIC_SCORE_MANGAN = 2000;
    static final int BASIC_SCORE_HANEMAN = 3000;
    static final int BASIC_SCORE_BAIMAN = 4000;
    static final int BASIC_SCORE_SANBAIMAN = 6000;
    static final int BASIC_SCORE_YAKUMAN = 8000;
    static final int BASIC_SCORE_DOUBLE_YAKUMAN = 16000;

//    static final int OYAMAN = 12000;
//    static final int OYAPPANE = 18000;
//    static final int OYABAI = 24000;
//    static final int OYASANBAI = 36000;
//    static final int OYAYAKU = 48000;
//    static final int OYADOUBLE_YAKUMAN = 96000;

    static final String STR_MANGAN = "満貫";
    static final String STR_HANEMAN = "跳満";
    static final String STR_BAIMAN = "倍満";
    static final String STR_SANBAIMAN = "三倍満";
    static final String STR_YAKUMAN = "役満";
    static final String STR_DOUBLE = "ダブル役満";
}
