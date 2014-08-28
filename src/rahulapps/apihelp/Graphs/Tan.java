package rahulapps.apihelp.Graphs;

import com.actionbarsherlock.app.SherlockActivity;


import android.os.Bundle;

public class Tan extends SherlockActivity{
	
	TanView TanwaveView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TanwaveView = new TanView(this);
		setContentView(TanwaveView);
	}
}
