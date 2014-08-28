package rahulapps.apihelp.Menus;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivityAPI extends SherlockActivity implements OnItemClickListener
{
	ListView lv;
	ArrayAdapter<String> arrayadapter;
	
	String sMenu[]={"Option 0","Option 1","Option 2","Option 3","Option 4","Option 5","Option 6","Option 7"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_menu);
		
		getSupportActionBar().setTitle("ListView");
		
		lv=(ListView)findViewById(R.id.Common_ListView);
		
		arrayadapter = new ArrayAdapter<String>(MenuActivityAPI.this,android.R.layout.simple_list_item_1,sMenu);
		lv.setAdapter(arrayadapter);
		
		lv.setOnItemClickListener(this);
		
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) 
	{
		// TODO Auto-generated method stub
		
		
		Toast t = Toast.makeText(getApplicationContext(),String.valueOf(position)+" is Selected",Toast.LENGTH_SHORT);
				t.show();
		
		
	}

}
