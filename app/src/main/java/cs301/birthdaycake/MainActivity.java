package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView view = findViewById(R.id.cakeview);
        CakeController controller = new CakeController(view);

        Button blowOut = findViewById(R.id.blowOut);
        blowOut.setOnClickListener(controller);

        Switch candles = findViewById(R.id.candles);
        candles.setOnCheckedChangeListener(controller);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(controller);

        view.setOnTouchListener(controller);
    }
    public void goodbye(View button){
        System.out.println("Goodbye");
    }
}
