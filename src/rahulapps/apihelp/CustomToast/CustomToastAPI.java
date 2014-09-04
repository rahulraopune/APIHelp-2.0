package rahulapps.apihelp.CustomToast;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToastAPI extends SherlockActivity implements OnItemClickListener
{
	

	String[] sHeadings = {"Apples","Chiku","Grapes","Kiwi","Litchi","Mango","Orange","Papaya","WaterMelon"};
	String[] sSubHeadings = {"Red","Brown","Violet","Green","Red","Yellow","Orange","Yellow","Red"};
	int[] iImgArray = {R.drawable.apples,R.drawable.chiku,R.drawable.grapes,R.drawable.kiwi,R.drawable.litchi,R.drawable.mango,R.drawable.orange,R.drawable.papaya,R.drawable.watermelon};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customtoast);
		
		getSupportActionBar().setTitle("Custom Toast");
		
		ListView lv = (ListView)findViewById(R.id.lvListView);
		
		MyAdapter adapter = new MyAdapter(this, sHeadings, sSubHeadings, iImgArray);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		//CUSTOM LIST VIEW
		LayoutInflater layoutInflaterToast = getLayoutInflater();
		
		View layoutToast = layoutInflaterToast.inflate(R.layout.activity_customtoast_toast_view,(ViewGroup) findViewById(R.id.customtoastlayout));
		
		TextView tvToast = (TextView)layoutToast.findViewById(R.id.tvToast);
		tvToast.setText("Name:"+sHeadings[position]+" Colour:"+sSubHeadings[position]);
		
		ImageView imgtoast = (ImageView)layoutToast.findViewById(R.id.imgToastPic);
		imgtoast.setImageResource(iImgArray[position]);
		
		Toast toast = new Toast(getApplicationContext());
		
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layoutToast);
        toast.show();		
		
		
		}
	}





class MyAdapter extends ArrayAdapter<String>
{
	Context context;
	
	String[] sHeadings,sSubHeadings;
	int[]  iImgArray;	
		
	public MyAdapter(Context c,String[] sHeadings,String[] sSubHeadings,int[] images)
	{
		// TODO Auto-generated constructor stub
		super(c, R.layout.activity_customlistview_row, R.id.tvHeader,sHeadings);
		this.context=c;
		this.iImgArray=images;
		this.sHeadings=sHeadings;
		this.sSubHeadings=sSubHeadings;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(SherlockActivity.LAYOUT_INFLATER_SERVICE);
		View row = layoutInflater.inflate(R.layout.activity_customtoast_row_view, parent, false);
		
		ImageView imageView = (ImageView)row.findViewById(R.id.imgFruitPic);
		TextView tvHeading=(TextView)row.findViewById(R.id.tvHeader);
		TextView tvSubHeading=(TextView)row.findViewById(R.id.tvSubHeader);
		
		
		imageView.setImageResource(iImgArray[position]);
		tvHeading.setText(sHeadings[position]);
		tvSubHeading.setText(sSubHeadings[position]);
		return row;
	}
}