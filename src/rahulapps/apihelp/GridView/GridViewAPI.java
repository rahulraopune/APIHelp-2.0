package rahulapps.apihelp.GridView;


import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GridViewAPI extends SherlockActivity implements OnItemClickListener
{

	GridView gridView;
	
	String[] sCountries={"India","America","Brazil","England","France","Germany","Netherlands","Pakistan","Saudi","Sri Lanka"};
	int[] iCountnryPics={R.drawable.india,R.drawable.america,R.drawable.brazil,R.drawable.england,R.drawable.france,R.drawable.germany,R.drawable.netherland,R.drawable.pakistan,R.drawable.saudi,R.drawable.srilanka};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gridview_layout);
		
		getSupportActionBar().setTitle("GridView");
		
		gridView = (GridView)findViewById(R.id.gridView);
		
		
		MyAdapter adapter = new MyAdapter(this,iCountnryPics,sCountries);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), sCountries[arg2],Toast.LENGTH_SHORT).show();
	}

}

class MyAdapter extends ArrayAdapter<String>
{
	String[] sCountries;
	int[] iCountnryPics;
	Context context;
	public MyAdapter(Context context,int[] iCountnryPics,String[] sCountries)
	{
		super(context,R.layout.activity_gridview_row,R.id.tvCountryName,sCountries);
		// TODO Auto-generated constructor stub
		this.context=context;
		this.iCountnryPics=iCountnryPics;
		this.sCountries=sCountries;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(SherlockActivity.LAYOUT_INFLATER_SERVICE);
		View grid = layoutInflater.inflate(R.layout.activity_gridview_row, parent, false);
		
		TextView tv = (TextView)grid.findViewById(R.id.tvCountryName);
		tv.setText(sCountries[position]);
		
		ImageView img = (ImageView)grid.findViewById(R.id.imgCountryPic);
		img.setImageResource(iCountnryPics[position]);
		
		
		return grid;
	}
	
}
