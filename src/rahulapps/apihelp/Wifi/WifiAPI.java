package rahulapps.apihelp.Wifi;


import com.actionbarsherlock.app.SherlockActivity;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

import rahulapps.apihelp.R;

public class WifiAPI extends SherlockActivity implements OnCheckedChangeListener
{
	Switch swWifi;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wifi_api);
		getActionBar().setTitle("Wifi");
		swWifi = (Switch)findViewById(R.id.WIFI_SWITCH);
		
		
		
		swWifi.setOnCheckedChangeListener(this);
		
		
	}
	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) 
	{
		
		// TODO Auto-generated method stub
		if(arg0.getId()==R.id.WIFI_SWITCH)
		{
			WifiManager wifiManager = (WifiManager)this.getSystemService(WIFI_SERVICE);
			
			if (!wifiManager.isWifiEnabled())
			{
				wifiManager.setWifiEnabled(true);
				Toast.makeText(getApplicationContext(), "Wifi ON",Toast.LENGTH_SHORT).show();
			} 
			
			else if (wifiManager.isWifiEnabled()) 
			{
				wifiManager.setWifiEnabled(false);
				Toast.makeText(getApplicationContext(), "Wifi OFF",Toast.LENGTH_SHORT).show();
			}
						
		}
	}
}
