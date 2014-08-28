package rahulapps.apihelp.SplashActivity;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.content.Intent;
import android.os.Bundle;

public class SplashAPI extends SherlockActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_temp);
		getSupportActionBar().setTitle("Splash");
		Thread t=new Thread()
		{
			public void run() 
			{
				// TODO Auto-generated method stub
				try 
				{
					Thread.sleep(3000);
				} 
				catch (InterruptedException ie) 
				{
					// TODO: handle exception
					ie.printStackTrace();
					
				}
				finally
				{
					Intent intent = new Intent("rahulapps.apihelp.SplashActivity.SplashMenu");
					startActivity(intent);
				}

			}
		};
		t.start();
		
	}
	
	@Override
	protected void onPause() 
	{
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	

}
