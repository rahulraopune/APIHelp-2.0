package rahulapps.apihelp.SQLite;

import rahulapps.apihelp.R;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class SQLiteOutput extends SherlockActivity
{
	TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_output);
		getSupportActionBar().setTitle("");
		RahulDatabaseAdapter r = new RahulDatabaseAdapter(this);
		String msg = r.displayData();
		tv = (TextView)findViewById(R.id.tvsqliteoutput);
		
		try
		{
			tv.setText(msg);
		}
		catch(NullPointerException npe)
		{
			tv.setText(npe.toString());
		}
		
		
	}
	
	
	
	
}
