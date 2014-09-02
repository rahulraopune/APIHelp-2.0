package rahulapps.apihelp.NavigationDrawer;


import rahulapps.apihelp.R;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

public class NavigationDrawerAPI extends SherlockFragmentActivity implements OnItemClickListener 
{	
	ListView listView;
	ActionBarDrawerToggle actionBarDrawerToggle;
	DrawerLayout drawerLayout;
	ArrayAdapter<String> arrayAdapter;
	int counter = 0;
	String planets[];
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigationdrawer);
		
		listView = (ListView)findViewById(R.id.drawerListView);
		drawerLayout = (DrawerLayout)findViewById(R.id.NavigationDrawer);
		
		planets = getResources().getStringArray(R.array.temp);
		
		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,planets);
		
		listView.setAdapter(arrayAdapter);
		
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,GravityCompat.START);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		//creating object for toggling
		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.drawable.ic_drawer,R.string.drawer_open,R.string.drawer_close)
		{
			@Override
			public void onDrawerOpened(View drawerView)
			{
				// TODO Auto-generated method stub
				super.onDrawerOpened(drawerView);
				counter++;
				if(counter % 2 == 0)
				{
					listView.setBackgroundColor(Color.rgb(0, 255, 255));
				}
				if(counter % 5 == 0)
				{
					listView.setBackgroundColor(Color.rgb(100, 45, 105));
				}
				else
				{
					listView.setBackgroundColor(Color.rgb(255,178,37));
				}
			}
			
			@Override
			public void onDrawerClosed(View drawerView)
			{
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
				
			}
			
			
		};
		drawerLayout.setDrawerListener(actionBarDrawerToggle);
		
		listView.setOnItemClickListener(this);
		
		
		//for icons in corner
		
		//for functions like onclose onopen
		//drawerLayout.setDrawerListener(this);	
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		actionBarDrawerToggle.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		actionBarDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3)
	{
		// TODO Auto-generated method stub
		getSupportActionBar().setTitle(planets[position]);
		
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		if(item.getItemId() == android.R.id.home)
		{
			if(drawerLayout.isDrawerOpen(listView))
			{
				drawerLayout.closeDrawer(listView);
				getSupportActionBar().setTitle("Navigation Drawer");
			}
			else
			{
				drawerLayout.openDrawer(listView);
			}
		}
		
		return super.onOptionsItemSelected(item);
	}
}