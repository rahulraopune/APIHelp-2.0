package rahulapps.apihelp.Settings;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.os.Bundle;

public class AboutAPI extends SherlockActivity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		getSupportActionBar().setTitle("About Developer");
		
	}
}
