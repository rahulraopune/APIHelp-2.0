/**
 * 
 */
package rahulapps.apihelp.Settings;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import rahulapps.apihelp.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Watson.OnOptionsItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.OnNavigationListener;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.internal.view.menu.MenuView.ItemView;
import com.actionbarsherlock.view.MenuItem;

public class Objective extends SherlockActivity implements OnNavigationListener
{
	
	TextView tv;
	String temp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_objective);
		tv = (TextView)findViewById(R.id.TV);
		
		
		Context context = getSupportActionBar().getThemedContext();
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.options, R.layout.sherlock_spinner_item);
		getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(adapter, this);
        
		tv.setText("");
		try
		{
			InputStream is = getResources().openRawResource(R.raw.mymessage);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			while ((temp=br.readLine())!=null) 
			{
				tv.append(temp+"\n");
			}
		}
		catch(Exception e)
		{
			Toast t  = Toast.makeText(getApplicationContext(), e.getMessage().toUpperCase(),Toast.LENGTH_LONG);
			t.show();
		}
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch(item.getItemId())
		{
		
		case R.id.ABOUT:
			Intent intentAbout = new Intent("rahulapps.apihelp.Settings.AboutAPI");
			startActivity(intentAbout);
			break;
			
		case R.id.OBJECTIVE:
			Intent intentObjective = new Intent("rahulapps.apihelp.Settings.Objective");
			startActivity(intentObjective);
			break;
			
		case R.id.COMMENT:
			Intent intentComment = new Intent("rahulapps.apihelp.Settings.CommentAPI");
			startActivity(intentComment);
			break;
			
		case R.id.EXIT:
			finish();
			break;
		}
		return false;
	
		
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