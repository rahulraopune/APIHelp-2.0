package rahulapps.apihelp.CustomListView;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;
import android.os.Bundle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class CustomListViewAPI extends SherlockActivity
{

	String[] sHeadings = {"Apples","Chiku","Grapes","Kiwi","Litchi","Mango","Orange","Papaya","WaterMelon"};
	String[] sSubHeadings = {"Red","Brown","Violet","Green","Red","Yellow","Orange","Yellow","Red"};
	int[] iImgArray = {R.drawable.apples,R.drawable.chiku,R.drawable.grapes,R.drawable.kiwi,R.drawable.litchi,R.drawable.mango,R.drawable.orange,R.drawable.papaya,R.drawable.watermelon};
   
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customlistview);
        
        getSupportActionBar().setTitle("Custom ListView");
        
        ListView lv = (ListView)findViewById(R.id.lvListView);
        
        CustomAdapter adapter = new CustomAdapter(this, sHeadings, sSubHeadings, iImgArray);
        lv.setAdapter(adapter);
        
    }
    
}

class CustomAdapter extends ArrayAdapter<String>
{
	Context context;
	String[] sHeadings,sSubHeadings;
	int[] iImgArray;
	
	public CustomAdapter(Context context,String[] sHeading,String[] sSubHeading,int[] iImageArray)
	{
		// TODO Auto-generated constructor stub
		super(context,R.layout.activity_customlistview_row,R.id.tvHeading,sHeading);
		this.context=context;
		this.iImgArray=iImageArray;
		this.sHeadings=sHeading;
		this.sSubHeadings=sSubHeading;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		
		LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(SherlockActivity.LAYOUT_INFLATER_SERVICE);
		View row = layoutInflater.inflate(R.layout.activity_customlistview_row, parent, false);
		
		TextView tvHeading = (TextView)row.findViewById(R.id.tvHeading);
		TextView tvSubHeading = (TextView)row.findViewById(R.id.tvSubHeading);
		ImageView imgView = (ImageView)row.findViewById(R.id.imgPicFruit);
		
		tvHeading.setText(sHeadings[position]);
		tvSubHeading.setText(sSubHeadings[position]);
		imgView.setImageResource(iImgArray[position]);
		return row;
	}
}