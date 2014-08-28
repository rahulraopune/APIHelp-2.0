package rahulapps.apihelp.Graphs;

import com.actionbarsherlock.app.SherlockActivity;


import android.os.Bundle;

public class Sine extends SherlockActivity
{
	
	SineView sine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		sine = new SineView(this);
		setContentView(sine);
	}
}
