/**
 * 
 */
package rahulapps.apihelp.Settings;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import rahulapps.apihelp.R;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;

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
}
