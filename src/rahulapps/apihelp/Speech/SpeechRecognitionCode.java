package rahulapps.apihelp.Speech;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;


public class SpeechRecognitionCode extends SherlockActivity 
{
	TextView tv;
	WebView wv;
	
	String temp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.code);
		getSupportActionBar().setTitle("Speech Recognition Java");
		tv = (TextView) findViewById(R.id.TV);
		
		tv.setText("");
		
		try
		{
			InputStream is = getResources().openRawResource(R.raw.speech);
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
