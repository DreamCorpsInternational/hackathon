package org.dreamcorps.hackathon;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBDAO {
private SQLiteDatabase database;
private SQLiteOpenHelper dbHelper;
public DBDAO(Context context){
	dbHelper = new DBConn(context);
}
public void open() throws SQLException {
    database = dbHelper.getWritableDatabase();
  }

public void close() {
    dbHelper.close();
  }

public Question getQuestion(){
	Question Q = new Question();
	
	
	
	return Q;
}

}
