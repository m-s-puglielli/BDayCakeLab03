package cs301.birthdaycake;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

	private CakeView view;
	private CakeModel model;

	public CakeController(CakeView cakeView) {
		view = cakeView;
		model = view.getCakeModel();
	}

	//View.OnClickListener Implementation
	@Override
	public void onClick(View v) {
		Log.d("OnClickListener", "OnClickListener: Event Received");
		model.areCandlesLit = false;
		view.invalidate();
	}

	//CompoundButton.OnCheckedChangeListener Implementation
	@Override
	public void onCheckedChanged(CompoundButton cb, boolean isChecked) {
		Log.d("OnCheckedChangeListener", "OnCheckedChangeListener: Event Received");
		model.hasCandles = isChecked;
		model.areCandlesLit = isChecked;
		view.invalidate();
	}

	//SeekBar.OnSeekBarChangeListener Implementation
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		Log.d("OnSeekBarChangeListener", "OnSeekBarChangeListener: Event Received");
		model.amountOfCandles = progress;
		view.invalidate();
		System.out.printf("Candle Number: %d\n", model.amountOfCandles);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		;
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		;
	}

	@Override
	public boolean onTouch(View v, MotionEvent me) {
		model.cx = (int) me.getX();
		model.cy = (int) me.getY();

        model.left_touch = me.getX();
        model.right_touch = model.left_touch + 200;
        model.top_touch = me.getY();
        model.bottom_touch = model.top_touch + 300;

		view.invalidate();

		return true;
	}
}
