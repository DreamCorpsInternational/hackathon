package org.dreamcorps.hackathon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBConn extends SQLiteOpenHelper {
	
	public static final String Table_Name = "QTable";
	public static final String Column_ID = "_ID";
	public static final String Column_Q = "Questions";
	public static final String Column_A = "Answers";
	private static final String DB_Name = "QDatabase";
	private static final int DB_Version = 1;
	
	 private static final String DATABASE_CREATE = "create table if not exists"
		      + Table_Name + "(" + Column_ID
		      + " integer primary key autoincrement, " + Column_Q
		      + " text not null,"+Column_A
		      + " text not null);";
	 


	public DBConn(Context context) {
		super(context, DB_Name, null, DB_Version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DATABASE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.w(DBConn.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		    db.execSQL("DROP TABLE IF EXISTS " + Table_Name);
		    onCreate(db);

	}

}
