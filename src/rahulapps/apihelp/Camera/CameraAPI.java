package rahulapps.apihelp.Camera;

import java.io.IOException;

import com.actionbarsherlock.app.SherlockActivity;

import rahulapps.apihelp.R;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CameraAPI extends SherlockActivity implements OnClickListener
{
	ImageView iv;
	Button bClick,bSetAsWallpaper;
	
	final static int iCameraData = 0;
	
	final static int TAKE_PICTURE = 1;
	
	Bitmap bmp;
	
	Uri capaturedImageUri=null;
	
	Intent intent ;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		getSupportActionBar().setTitle("Camera");
		
		iv = (ImageView)findViewById(R.id.IMAGEVIEW_CAMERA);
		bClick = (Button)findViewById(R.id.BUTTON_PHOTO_CLICK);
		bSetAsWallpaper = (Button)findViewById(R.id.BUTTON_SET_AS_WALLPAPER);
		
		
		bClick.setOnClickListener(this);
		bSetAsWallpaper.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) 
	{
		// TODO Auto-generated method stub
		if(v.getId()==R.id.BUTTON_PHOTO_CLICK)
		{
		    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent, iCameraData);
			
		}
		if(v.getId()==R.id.BUTTON_SET_AS_WALLPAPER)
		{
			try 
			{
				WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
				
				Point size = new Point();
				getWindowManager().getDefaultDisplay().getSize(size);
				wallpaperManager.suggestDesiredDimensions(size.x,size.y);
				
				wallpaperManager.setBitmap(bmp);
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		
		if(resultCode == RESULT_OK)
		{
			if(resultCode == RESULT_OK){
				Bundle extras = data.getExtras();
				bmp = (Bitmap) extras.get("data");
		
				iv.setImageBitmap(bmp);
			}
		}
	}
	
}