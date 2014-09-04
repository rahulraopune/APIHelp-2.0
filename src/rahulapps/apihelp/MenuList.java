package rahulapps.apihelp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;


public class MenuList extends SherlockActivity implements OnItemClickListener
{
	ListView lv;
	ArrayAdapter<String> arrayadapter;
	
	
	
	String sMenu[]={"Bluetooth",
					"Wifi",
					"Sensor",
					"Splash Activity",
					"List Activity",
					"Speech Recognition",
					"Drawing Graphs",
					"Notifications",
					"File IO",
					"Email",
					"Camera",
					"SQLite Database Management",
					"Navigation Drawer",
					"Custom ListView",
					"Grid View",
					"Custom Toast Message",
					"ManiFest.XML"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_menu);
		
		lv=(ListView)findViewById(R.id.Common_ListView);
		
		arrayadapter = new ArrayAdapter<String>(MenuList.this,android.R.layout.simple_list_item_1,sMenu);
		lv.setAdapter(arrayadapter);
		
		getSupportActionBar().setTitle("APIHelp 2.0");
		
		
		
		lv.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) 
	{
		// TODO Auto-generated method stub
		switch(position)
		{
		case 0:ActivityStarter("rahulapps.apihelp.Bluetooth.BluetoothMenu");break;
		case 1:ActivityStarter("rahulapps.apihelp.Wifi.WifiMenu");break;
		case 2:ActivityStarter("rahulapps.apihelp.Sensor.SensorMenu");break;
		case 3:ActivityStarter("rahulapps.apihelp.SplashActivity.SplashMenu");break;
		case 4:ActivityStarter("rahulapps.apihelp.Menus.MenuActivityMenu");break;
		case 5:ActivityStarter("rahulapps.apihelp.Speech.SpeechRecognitionMenu");break;
		case 6:ActivityStarter("rahulapps.apihelp.Graphs.GraphMenu");break;
		case 7:ActivityStarter("rahulapps.apihelp.Notifications.NotificationMenu");break;
		case 8:ActivityStarter("rahulapps.apihelp.FileIO.FileIOMenu");break;
		case 9:ActivityStarter("rahulapps.apihelp.Email.EmailMenu");break;
		case 10:ActivityStarter("rahulapps.apihelp.Camera.CameraMenu");break;
		case 11:ActivityStarter("rahulapps.apihelp.SQLite.SQLiteMenu");break;
		case 12:ActivityStarter("rahulapps.apihelp.NavigationDrawer.NavigationDrawerMenu");break;
		case 13:ActivityStarter("rahulapps.apihelp.CustomListView.CustomListViewMenu");break;
		case 14:ActivityStarter("rahulapps.apihelp.GridView.GridViewMenu");break;
		case 15:ActivityStarter("rahulapps.apihelp.CustomToast.CustomToastMenu");break;
		case 16:ActivityStarter("rahulapps.apihelp.Manifest.ManifestCode");break;
		}
	}
	
	public void ActivityStarter(String sActivity)
	{
		Intent intent = new Intent(sActivity);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater menuInflater = getSupportMenuInflater();
		menuInflater.inflate( R.menu.common_menu, menu);
		return true;
	}
	
	@Override
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
