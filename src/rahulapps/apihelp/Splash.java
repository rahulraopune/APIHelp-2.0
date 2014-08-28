package rahulapps.apihelp;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.content.Intent;
import android.os.Bundle;

public class Splash extends SherlockActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		getActionBar().setTitle("On The Go APIHelp 2.0");
		
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
					Intent intent = new Intent("rahulapps.apihelp.MenuList");
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
