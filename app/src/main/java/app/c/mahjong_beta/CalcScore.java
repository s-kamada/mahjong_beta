package app.c.mahjong_beta;

/**
 * Created by s.kamada on 2018/07/06.
 *
 */

class CalcScore{
    double score;
    int basicScore;
    String scoreStat;

    CalcScore CalclateScore(int fan,int fu,boolean IsDealer) {
        CalcScore calc = new CalcScore();
        MahjongMath MMath = new MahjongMath();

        int multiplier;
        if(IsDealer){ multiplier = 6; } else { multiplier = 4; }

        switch (fan) {
            case 1: case 2: case 3: case 4:
                calc.basicScore = fu * (int)Math.pow(2,fan + 2); //基本点＝符*2^(半数+2)
//                calc.score = multiplier * calc.basicScore;
                calc.score = MMath.ceil100(multiplier * calc.basicScore); //和了点＝基本点*4(子) or 基本点*6(親)
                calc.scoreStat = String.valueOf(fan)+"飜"+String.valueOf(fu)+"符";

                if (calc.basicScore > Score.BASIC_SCORE_MANGAN) { //満貫(3-70以上 or 4-40以上)
                    calc.score = multiplier * Score.BASIC_SCORE_MANGAN;
                    calc.basicScore = Score.BASIC_SCORE_MANGAN;
                    calc.scoreStat = Score.STR_MANGAN + "(" + String.valueOf(fan)+"飜"+String.valueOf(fu)+"符)";
                }
                break;
            case 5: //5飜　満貫
                calc.score = multiplier * Score.BASIC_SCORE_MANGAN;
                calc.basicScore = Score.BASIC_SCORE_MANGAN;
                calc.scoreStat = Score.STR_MANGAN + "(" + String.valueOf(fan)+"飜"+String.valueOf(fu)+"符)";
                break;
            case 6: case 7: //6,7飜　跳満
                calc.score = multiplier * Score.BASIC_SCORE_HANEMAN;
                calc.basicScore = Score.BASIC_SCORE_HANEMAN;
                calc.scoreStat = Score.STR_HANEMAN + "(" + String.valueOf(fan)+"飜"+String.valueOf(fu)+"符)";
                break;
            case 8: case 9: case 10:
                calc.score = multiplier * Score.BASIC_SCORE_BAIMAN;
                calc.basicScore = Score.BASIC_SCORE_BAIMAN;
                calc.scoreStat = Score.STR_BAIMAN + "(" + String.valueOf(fan)+"飜"+String.valueOf(fu)+"符)";
                break;
            case 11: case 12:
                calc.score = multiplier * Score.BASIC_SCORE_SANBAIMAN;
                calc.basicScore = Score.BASIC_SCORE_SANBAIMAN;
                calc.scoreStat = Score.STR_SANBAIMAN + "(" + String.valueOf(fan)+"飜"+String.valueOf(fu)+"符)";
                break;
            default:
                calc.score = multiplier * Score.BASIC_SCORE_YAKUMAN;
                calc.basicScore = Score.BASIC_SCORE_YAKUMAN;
                calc.scoreStat = Score.STR_YAKUMAN + "(" + String.valueOf(fan)+"飜"+String.valueOf(fu)+"符)";
                break;
        }
        return calc;
    }

}
