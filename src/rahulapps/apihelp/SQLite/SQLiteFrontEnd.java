package rahulapps.apihelp.SQLite;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;
import rahulapps.apihelp.SQLite.RahulDatabaseAdapter.RahulHelper;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLiteFrontEnd extends SherlockActivity implements OnClickListener
{
	EditText etUsername,etPassword,etSearch;
	RahulHelper rahulHelper;
	Button bShowDetails,bAddUser,bSearch;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        
        getSupportActionBar().setTitle("SQLite Front-End");
        
        etPassword = (EditText)findViewById(R.id.etPassword);
        etUsername = (EditText)findViewById(R.id.etUserName);
        etSearch = (EditText)findViewById(R.id.etSearch);
        
        bShowDetails = (Button)findViewById(R.id.bShowDetails);
        bAddUser = (Button)findViewById(R.id.bInsert);		
        bSearch = (Button)findViewById(R.id.bSearch);
        
        bShowDetails.setOnClickListener(this);
        bAddUser.setOnClickListener(this);
        bSearch.setOnClickListener(this);
        
    }
    
    public void addUser()
    {
    	String user = etUsername.getText().toString();  
    	String password = etPassword.getText().toString();
    	
    	RahulDatabaseAdapter adapter = new RahulDatabaseAdapter(this);
    	long id = adapter.insertData(user, password);
    	
    	if(id<0)
    	{
    		Toast.makeText(this,"ROW NOT INSERTED",Toast.LENGTH_LONG).show();
    	}
    	else
    	{
    		Toast.makeText(this,"ROW INSERTED",Toast.LENGTH_LONG).show();
    	}
     
    }
    
    public void showresults()
    {
    	RahulDatabaseAdapter adapter = new RahulDatabaseAdapter(this);
    	adapter.displayData();
    }
    
    public void searchresults()
    {
    	String search = etSearch.getText().toString();
    	RahulDatabaseAdapter adapter = new RahulDatabaseAdapter(this);
    	adapter.search(search);
    }
    
    @Override
    public void onClick(View arg0) {
    	// TODO Auto-generated method stub
    	switch (arg0.getId()) 
    	{
		case R.id.bInsert:addUser();break;
		case R.id.bShowDetails:showresults();break;
		case R.id.bSearch:searchresults();break;
		
		}
    	
    }
}
