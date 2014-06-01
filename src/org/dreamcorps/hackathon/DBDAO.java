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
	      DBConn.Column_A,DBConn.Column_Q,"option1","option2","option3","option4"};
private int QID = 1;


public DBDAO(Context context){
	dbHelper = new DBConn(context);
}
//encounters problem here
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
	Q.setA(rs.getInt(3));
	String[] Options = {rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
	Q.setOptions(Options);
	QID +=1;
	rs.close();
	return Q;
}

public void addSampleQuestions(){
	Cursor rs = database.query(DBConn.Table_Name,allColumns,null,null,null,null,null,null);
	//only add sample questions when the table is empty
	if (rs.moveToFirst()==false){
		//add sample questions here
		//database.insert(table, nullColumnHack, values);
		//database.insert();
		
	}
	
	
	
	
}


}
