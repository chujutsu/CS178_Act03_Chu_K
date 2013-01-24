package chu.kevin.racingboxes;

import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class RaceStarter extends Activity {

	public RacingBox rb1;
    public RacingBox rb2;
    public RacingBox rb3;
    public RacingBox rb4;
    public RacingBox rb5;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        rb1 = new RacingBox((Button)findViewById(R.id.button1));
        rb2 = new RacingBox((Button)findViewById(R.id.button2));
        rb3 = new RacingBox((Button)findViewById(R.id.button3));
        rb4 = new RacingBox((Button)findViewById(R.id.button4));
        rb5 = new RacingBox((Button)findViewById(R.id.button5));
        PowerUp pu = new PowerUp();
        
        rb1.start();
        rb2.start();
        rb3.start();
        rb4.start();
        rb5.start();
        pu.start();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /**/
    
    public class PowerUp extends Thread implements Runnable{
    	private Handler handler = new Handler();
    	public RacingBox rb;
    	private Random r = new Random();
    	@Override
    	public void run()
    	{
    		handler.post(timedTask);
    	}
    	
    	private Runnable timedTask = new Runnable(){

    		  @Override
    		  public void run() {
    			
    			int x = r.nextInt(5);
    			switch(x)
    			{
    				case 0: rb=rb1; break;
    				case 1: rb=rb2; break;
    				case 2: rb=rb3; break;
    				case 3: rb=rb4; break;
    				case 4: rb=rb5; break;
    				//default: rb=rb1;
    			}
    			
    			LinearLayout.LayoutParams params = (LayoutParams) rb.b.getLayoutParams();
    			params.setMargins(params.leftMargin+10, 0, 0, 0); //left, top, right, bottom
    			rb.b.setLayoutParams(params);
    		    handler.postDelayed(timedTask, 1000);
    		  }
    	};
    }
    /**/
}
