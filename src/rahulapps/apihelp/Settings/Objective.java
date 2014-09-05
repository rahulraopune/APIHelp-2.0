/**
 * 
 */
package rahulapps.apihelp.Settings;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import rahulapps.apihelp.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class Objective extends SherlockActivity
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
	
}