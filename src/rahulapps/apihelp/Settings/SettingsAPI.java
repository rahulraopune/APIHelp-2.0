package rahulapps.apihelp.Settings;

import rahulapps.apihelp.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsAPI extends Activity implements OnItemSelectedListener 
{
	Spinner spinner;
	
	String theme[]={"1) Holo Light","2)Holo Dark"};
	
	ArrayAdapter<String> arrayadapter;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_settings);
		
		arrayadapter = new ArrayAdapter<String>(SettingsAPI.this, android.R.layout.simple_spinner_dropdown_item, theme);
		
		spinner = (Spinner)findViewById(R.id.spinner_theme);
		spinner.setAdapter(arrayadapter);
		spinner.setOnItemSelectedListener(this);
		
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,long arg3) 
	{
		// TODO Auto-generated method stub
		switch(arg2)
		{
		
		case 0:setTheme(android.R.style.Theme_Translucent);break;
		case 1:setTheme(android.R.style.Theme_Black);break;
		}
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
	