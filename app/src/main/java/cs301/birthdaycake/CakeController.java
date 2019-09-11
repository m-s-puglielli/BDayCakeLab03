package cs301.birthdaycake;

import android.util.Log;
import android.view.View;

public class CakeController implements View.OnClickListener {

	private CakeView view;
	private CakeModel model;

	public CakeController(CakeView cakeView) {
		view = cakeView;
		model = view.getCakeModel();
	}

	public void onClick(View v) {
		Log.d("CakeController", "Click Received");
		model.areCandlesLit = false;
		view.invalidate();
	}
}
