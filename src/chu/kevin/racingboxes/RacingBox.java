package chu.kevin.racingboxes;

import android.os.Handler;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class RacingBox extends Thread{
	public final Button b;
	private Handler handler = new Handler();
	
	public RacingBox(Button b)
	{
		this.b=b;
	}
	
	@Override
	public void run()
	{
		handler.post(timedTask);
	}
	
	private Runnable timedTask = new Runnable(){

		  @Override
		  public void run() {
		   // TODO Auto-generated method stub
			LinearLayout.LayoutParams params = (LayoutParams) b.getLayoutParams();
			params.setMargins(params.leftMargin+5, 0, 0, 0); //left, top, right, bottom
			b.setLayoutParams(params);
		    handler.postDelayed(timedTask, 500);
		  }
	};
}
