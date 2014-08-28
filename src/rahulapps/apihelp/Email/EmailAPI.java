package rahulapps.apihelp.Email;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmailAPI extends SherlockActivity implements OnClickListener
{
	Button bDone;
	EditText etName,etemailID,etBody;
	String sName,sEmailID,sBody;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		
		getSupportActionBar().setTitle("Email");
		
		bDone = (Button)findViewById(R.id.BUTTON_DONE);
		etBody = (EditText)findViewById(R.id.EDITTEXT_BODY);
		etName = (EditText)findViewById(R.id.EDITTEXT_NAME);
		etemailID = (EditText)findViewById(R.id.EDITTEXT_EMAIL);
		
		bDone.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		switch(v.getId())
		{
		case R.id.BUTTON_DONE:
			
			sName = etName.getText().toString();
			sEmailID = etemailID.getText().toString();
			sBody = etBody.getText().toString();
			
			
			String body = "Hey Wassap "+sName+","+"\n"+sBody+"\n"+"Bye";
			
			
			Uri uri = Uri.fromParts("mailto","rahulraopune@gmail.com",null);
			Intent intent = new Intent(Intent.ACTION_SEND,uri);
			intent.putExtra(Intent.EXTRA_EMAIL,sEmailID);
			intent.putExtra(Intent.EXTRA_SUBJECT, "My Subject ");
			intent.putExtra(Intent.EXTRA_TEXT, body);
			intent.setType("plain/text");
			startActivity(intent);
			
			break;
		}
	}
	
	
}
