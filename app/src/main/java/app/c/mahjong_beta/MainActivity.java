package app.c.mahjong_beta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Boolean isDealer = true;
    MahjongMath MMath = new MahjongMath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final String TAG = "Calcscore";
        /* TODO 手牌を入力すると点数計算までしてくれる状態にする
         *　中目標：手牌を入力するフォーム？を作る
         *　小目標：とりあえず牌の素材を入手する
         *  BUGFIX:exportコマンドが動かない not a valid identifier
         */

//        Spinner Sfu = (Spinner)findViewById(R.id.fu);

        Button BcalcScore = findViewById(R.id.button2);
        BcalcScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner Sfan = findViewById(R.id.fan);
                Spinner Sfu = findViewById(R.id.fu);
                int fan = Integer.parseInt((String)Sfan.getSelectedItem());
                int fu = Integer.parseInt((String)Sfu.getSelectedItem());
                Log.i(TAG,"fan: "+fan+", fu: "+fu);
                TextView scoreView = findViewById(R.id.scoreView);
                TextView fanFuView = findViewById(R.id.fanFuView);
                TextView basicScoreView = findViewById(R.id.basicScoreView);

                final Switch SisDealer = findViewById(R.id.isDealer);
                SisDealer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(SisDealer.isChecked()) {isDealer = true;} else {isDealer = false;}
                    }
                });
                CalcScore calcscore = new CalcScore();
                CalcScore result = calcscore.CalclateScore(fan,fu,isDealer); //点数を計算する

                Log.i(TAG,"isDealer: " + isDealer + ", Score = " + result.score);
                scoreView.setText(String.valueOf((int)result.score+"点"));
                fanFuView.setText(result.scoreStat);
                String shareScore;
                if(isDealer) {
                    shareScore = String.valueOf(MMath.ceil100(result.basicScore*2)) + "ALL";
                }else{
                    shareScore = String.valueOf(MMath.ceil100(result.basicScore))+"-"+String.valueOf(MMath.ceil100(result.basicScore*2));
                } //HACK ここ何とかならない？点数分配の計算を何とかできれば
                basicScoreView.setText(shareScore);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
