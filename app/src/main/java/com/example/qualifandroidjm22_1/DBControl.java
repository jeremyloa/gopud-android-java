package com.example.qualifandroidjm22_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBControl extends SQLiteOpenHelper {

    public DBControl(Context context) {
        super(context, "UserData", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE UserData (id INTEGER PRIMARY KEY, uname TEXT, mail TEXT, phone TEXT, pass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS UserData");
        onCreate(sqLiteDatabase);
    }

    public void insert(UserData userData) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("uname", userData.getUname());
        val.put("mail", userData.getMail());
        val.put("phone", userData.getPhone());
        val.put("pass", userData.getPhone());
        db.insert("UserData", null, val);
        db.close();
    }

    public UserData readID(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor curr = db.query("UserData", new String[] {"id", "uname", "mail", "phone", "pass"}, "id=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (curr!=null) curr.moveToFirst();

        UserData data = new UserData(Integer.parseInt(curr.getString(0)), curr.getString(1), curr.getString(2), curr.getString(3), curr.getString(4));
        return data;
    }

    public UserData login(String uname, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
//        Log.println(Log.INFO, "DEBUG", "DB SIZE = " + db.getMaximumSize());
        Cursor curr = db.query("UserData", new String[] {"id", "uname", "mail", "phone", "pass"}, "uname=?",
                new String[] {uname}, null, null, null, null);
        Log.println(Log.INFO, "DEBUG", "CURR GET COUNT = " + curr.getCount());
        if (curr!=null  && curr.moveToFirst() && curr.getCount()>0) {
            Log.println(Log.INFO, "DEBUG", "CURR IS NOT NULL");
            UserData temp = new UserData(Integer.parseInt(curr.getString(0)), curr.getString(1), curr.getString(2), curr.getString(3), curr.getString(4));
//                curr.moveToFirst();
            if (pass.equals(temp.pass)) return temp;
            else Log.println(Log.INFO, "DEBUG", "PASS WRONG");
        } else Log.println(Log.INFO, "DEBUG", "CURR IS NULL");

//        if (db.getMaximumSize()>0) {
//
//        }
        return null;
    }

    public boolean unameExists(String uname) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor curr = db.query("UserData", new String[] {"id", "uname", "mail", "phone", "pass"}, "uname=?",
                new String[] {uname}, null, null, null, null);
        if (curr!=null && curr.moveToFirst() && curr.getCount()>0) return true;
        return false;
    }
}
