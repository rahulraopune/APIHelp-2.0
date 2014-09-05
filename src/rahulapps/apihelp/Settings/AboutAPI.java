package rahulapps.apihelp.Settings;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class AboutAPI extends SherlockActivity implements OnNavigationListener 
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		getSupportActionBar().setTitle("About Developer");
		
		Context context = getSupportActionBar().getThemedContext();
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.options, R.layout.sherlock_spinner_item);
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(adapter, this);
		
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId)
	{
		// TODO Auto-generated method stub
		switch (itemPosition)
		{
		case 0:break;
		case 1:
			finish();
			Intent intentAbout = new Intent("rahulapps.apihelp.Settings.AboutAPI");
			startActivity(intentAbout);
			break;
			
		case 2:
			finish();
			Intent intentObjective = new Intent("rahulapps.apihelp.Settings.Objective");
			startActivity(intentObjective);
			break;
			
		case 3:
			finish();
			Intent intentComment = new Intent("rahulapps.apihelp.Settings.CommentAPI");
			startActivity(intentComment);
			break;
			
		case 4:
			finish();
			Uri url = Uri.parse("https://github.com/rahulraopune/APIHelp-2.0");
			Intent repositoryintent = new Intent(Intent.ACTION_VIEW,url);
			startActivity(repositoryintent);
			break;
			
		case 5:
			finish();
			
			break;
		}

		return false;
	}
}
