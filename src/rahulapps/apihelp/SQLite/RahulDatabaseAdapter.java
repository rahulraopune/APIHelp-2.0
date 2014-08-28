package rahulapps.apihelp.SQLite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class RahulDatabaseAdapter 
{
	RahulHelper rahulHelper ;
	Context context;
	
	public RahulDatabaseAdapter(Context context) 
	{
		// TODO Auto-generated constructor stub
		this.context=context;
		rahulHelper = new RahulHelper(context);
	}
	
	public long insertData(String sUsername,String sPassword) 
	{
		SQLiteDatabase db = rahulHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(RahulHelper.NAME,sUsername);
		contentValues.put(RahulHelper.PASSWORD,sPassword);
		long id = db.insert(RahulHelper.TABLE_NAME, null, contentValues);
		return id;
	}
	
	public void displayData()
	{
		StringBuilder sb = new StringBuilder();
		SQLiteDatabase db = rahulHelper.getWritableDatabase();
		String[] columns = {RahulHelper.UID,RahulHelper.NAME,RahulHelper.PASSWORD}; 
		Cursor cursor = db.query(RahulHelper.TABLE_NAME, columns,null,null,null,null,null);
		while(cursor.moveToNext())
		{
			int cid = cursor.getInt(0);
			String cName = cursor.getString(1);
			String cPassword = cursor.getString(2);
			sb.append("_id:"+cid+" Name:"+cName+" Password:"+cPassword+"\n");
		}
		String msg = sb.toString();
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		
	}
	
	public void search(String search)
	{
		StringBuilder sb = new StringBuilder();
		SQLiteDatabase db = rahulHelper.getWritableDatabase();
		String[] columns = {RahulHelper.UID,RahulHelper.NAME,RahulHelper.PASSWORD}; 
		Cursor cursor = db.query(RahulHelper.TABLE_NAME,columns,RahulHelper.NAME+"= '"+search+"'",null,null,null,null);
		while(cursor.moveToNext())
		{
			int cid = cursor.getInt(0);
			String cName = cursor.getString(1);
			String cPassword = cursor.getString(2);
			sb.append("_id:"+cid+" Name:"+cName+" Password:"+cPassword+"\n");
		}
		String msg = sb.toString();
		Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		
	}

	class RahulHelper extends SQLiteOpenHelper
	{
		private static final String DATABASE_NAME="Rahul.db";
		private static final int DATABASE_VERSION=1;
		private static final String TABLE_NAME = "RahulTable"; 
		
		private static final String UID = "_id";
		private static final String NAME = "Name";
		private static final String PASSWORD = "Password";
		
		private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+PASSWORD+" VARCHAR(255));";
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME+";";
		
		Context context;
			
		public RahulHelper(Context context)
		{
			super(context,DATABASE_NAME,null,DATABASE_VERSION);
			// TODO Auto-generated constructor stub
			this.context=context;
			Toast t =Toast.makeText(context,"Constructor Called",Toast.LENGTH_SHORT);
			t.show();
		}

		@Override
		public void onCreate(SQLiteDatabase db)
		{
			// TODO Auto-generated method stub
			try
			{
				db.execSQL(CREATE_TABLE);
				Toast t =Toast.makeText(context,"OnCreate() Called",Toast.LENGTH_SHORT);
				t.show();
			}
			catch (SQLException sqle) 
			{
				// TODO: handle exception
				Toast t =Toast.makeText(context,"ERROR:\n"+sqle.toString(),Toast.LENGTH_SHORT);
				t.show();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2)
		{
			// TODO Auto-generated method stub
			try
			{
				db.execSQL(DROP_TABLE);
				onCreate(db);
				Toast t =Toast.makeText(context,"onUpgrade() called",Toast.LENGTH_SHORT);
				t.show();
			} 
			catch (SQLException sqle)
			{
				// TODO Auto-generated catch block
				Toast t =Toast.makeText(context,"ERROR:\n"+sqle.toString(),Toast.LENGTH_SHORT);
				t.show();
			}
			
		}

 
	}
}
