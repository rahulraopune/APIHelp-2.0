package rahulapps.apihelp.Notifications;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificationAPI extends SherlockActivity implements OnClickListener
{
	Button bNotification;
	NotificationManager nm;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notification);
		
		getSupportActionBar().setTitle("Notifications");
		
		bNotification = (Button)findViewById(R.id.BUTTON_NOTIFICATION);
		bNotification.setOnClickListener(this);
		
		nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		
	}
	@Override
	public void onClick(View v) 
	{
		long longarray[] = {1000,1000,1000,1000,1000,1000};
		// TODO Auto-generated method stub
		switch (v.getId()) 
		{
		case R.id.BUTTON_NOTIFICATION:
			
			Intent intent = new Intent(this,NotificationAPI.class);
			PendingIntent pi = PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
			
			NotificationCompat.Builder nb = new NotificationCompat.Builder(getApplicationContext());
			nb.setContentTitle("HI GUYS!..");
			nb.setContentText(".....AND YO BABES.................");
			nb.setTicker("Wasaap Gangstas.....");
			nb.setSmallIcon(R.drawable.android_splash);
			nb.setVibrate(longarray);
			nb.setContentIntent(pi);
			nb.setAutoCancel(true);
			nm.notify(1111,nb.build());
			break;

		}
	}
}
