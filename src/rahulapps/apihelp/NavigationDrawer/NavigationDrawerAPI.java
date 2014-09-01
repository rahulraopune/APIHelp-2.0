package rahulapps.apihelp.NavigationDrawer;


import rahulapps.apihelp.R;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class NavigationDrawerAPI extends SherlockFragmentActivity implements OnItemClickListener, DrawerListener 
{
	
	
	DrawerLayout drawerLayout;
	ListView listView;
	String[] planets ;
	ActionBarDrawerToggle drawerlistener;
	int counter = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigationdrawer);
		
		getSupportActionBar().setTitle("--> --> --> PULL --> -->");
		
		drawerLayout = (DrawerLayout)findViewById(R.id.NavigationDrawer);
		listView = (ListView)findViewById(R.id.drawerListView);
		planets = getResources().getStringArray(R.array.temp);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,planets);
		listView.setAdapter(adapter);
		
		drawerlistener = new ActionBarDrawerToggle(this, drawerLayout , R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher);
		
		listView.setOnItemClickListener(this);
		drawerLayout.setDrawerListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		
		listView.setItemChecked(position, true);
		int APIlevel = Build.VERSION.SDK_INT;
		Toast.makeText(this, planets[position]+" Planet Clicked \n API: "+APIlevel, Toast.LENGTH_LONG).show();
		
			getSupportActionBar().setTitle(planets[position]);
		
	}

	@Override
	public void onDrawerClosed(View arg0) {
		// TODO Auto-generated method stub
		//Toast.makeText(this,"onDrawerClosed() ", Toast.LENGTH_SHORT).show();
		
	}

	@Override
	public void onDrawerOpened(View arg0) {
		// TODO Auto-generated method stub
		counter++;
		if(counter%2==0)
		{
			listView.setBackgroundColor(Color.rgb(37,114,255));
		}
		if(counter%3==0)
		{
			listView.setBackgroundColor(Color.rgb(183,255,255));
		}
		if(counter%5==0)
		{
			listView.setBackgroundColor(Color.rgb(255,153,255));
		}
	}

	@Override
	public void onDrawerSlide(View arg0, float arg1) {
		// TODO Auto-generated method stub
		//Toast.makeText(this,"onDrawerSlide() ", Toast.LENGTH_SHORT).show();
		getSupportActionBar().setTitle("Navigation Drawer");
	}

	@Override
	public void onDrawerStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	

}



/*public class NavigationDrawerAPI extends SherlockFragmentActivity
{
	
	
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
			"Camera"};

	Context context;
	ListView lv;
	DrawerLayout drawerlLayout;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigationdrawer);
		
		lv = (ListView)findViewById(R.id.drawerListView);
		drawerlLayout = (DrawerLayout)findViewById(R.id.NavigationDrawer);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,sMenu);
		lv.setAdapter(adapter);
		
		
		
	}


}
*/