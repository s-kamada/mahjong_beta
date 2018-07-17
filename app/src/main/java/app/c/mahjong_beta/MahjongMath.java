package app.c.mahjong_beta;

/**
 * Created by s.kamada on 2018/07/18.
 */

public class MahjongMath {

    public int ceil100(int value){ //10の位で四捨五入する
        double bval;
        bval = (double)value/100;
        bval = Math.ceil(bval);
        bval *= 100;
        return (int)bval;
    }

}
