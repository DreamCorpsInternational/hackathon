package org.dreamcorps.hackathon;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBDAO {
@SuppressWarnings("unused")
private SQLiteDatabase database;
private SQLiteOpenHelper dbHelper;
private Question Q = new Question();
private String[] allColumns = { DBConn.Column_ID,
	      DBConn.Column_A,DBConn.Column_Q};
private int QID = 1;


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
	//use rs.moveToNext() to check if reached the last one yet;
	String selection  = "_ID="+QID;
	Cursor rs = database.query(DBConn.Table_Name,allColumns,selection,null,null,null,null,null);
	Q.setQ(rs.getString(2));	
	Q.setA(rs.getString(3));
	//Q.setOptions();
	QID +=1;
	rs.close();
	return Q;
}

public boolean checkAnswer(){
	
	return false;
}



}
