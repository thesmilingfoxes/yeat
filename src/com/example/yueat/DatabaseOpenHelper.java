//package com.example.yueat;
//
//import android.content.Context;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.os.Message;
//
//public class DatabaseOpenHelper extends SQLiteOpenHelper {
//private static final String DATABASE_NAME = "mydatabase";
//    private static final String TABLE_NAME = "MYTABLE";
//    private static final int DATABASE_VERSION = 1;
//    private static final String NAME = "Name";
//    private static final String UID = "_id";
//    private static final String CREATE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PPRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
//    private Context context;
//    private static final String UPGRADE = "DROP_TABLE" + TABLE_NAME+ "IF EXISTS";
//    private static final
//    
//public DatabaseOpenHelper (Context context){
//super(context, DATABASE_NAME,null,DATABASE_VERSION);
//    this.context = context;
//}
//    
//    public void onCreate(SQLiteDatabase db) {
//        try {
//            db.execSQL(CREATE);
//        }catch(SQLException e){
//        	
//            Message.message(context, "" + e);
//        }
//
//    }
//
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//    try {
//        db.execSQL(UPGRADE);
//        onCreate(db);
//    }
//    catch(SQLException e){
//        Message.message(context, "" + e);
//    }
//    }
//}