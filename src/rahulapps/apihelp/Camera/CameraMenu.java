package rahulapps.apihelp.Camera;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import rahulapps.apihelp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CameraMenu extends SherlockActivity implements OnItemClickListener
{
	ListView lv;
	ArrayAdapter<String> arrayadapter;
	
	String sMenu[]={"Camera API","Camera Code"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_menu);
		
		getSupportActionBar().setTitle("Camera");
		
		lv=(ListView)findViewById(R.id.Common_ListView);
		
		arrayadapter = new ArrayAdapter<String>(CameraMenu.this,android.R.layout.simple_list_item_1,sMenu);
		lv.setAdapter(arrayadapter);
		
		lv.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) 
	{
		// TODO Auto-generated method stub
		switch(position)
		{
		case 0:ActivityStarter("rahulapps.apihelp.Camera.CameraAPI");break;
		case 1:ActivityStarter("rahulapps.apihelp.Camera.CameraCode");break;
		
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
