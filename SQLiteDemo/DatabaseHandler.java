package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        super(context, "studentDb",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table studentdetails(name TEXT primary key,contact TEXT,dob TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public boolean insertdata(String name, String contact,String dob){
        SQLiteDatabase sqldb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("dob",dob);
        long result=sqldb.insert("studentdetails",null,cv);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getdata() {

        //getWritableDatabase()...Create and/or open a database that will be used for reading and writing.
        SQLiteDatabase db=this.getWritableDatabase();

        // rawQuery(String sql,String[] selectionArgs)
        //Runs the provided SQL and returns a Cursor over the result set.
        Cursor cursor=db.rawQuery("Select * from studentdetails ",null);
        return  cursor;

    }
    public boolean updateData(String name, String contact, String dob) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);  // Update contact
        contentValues.put("dob", dob);  // Update dob

        // Update the record where the name matches
        int result = db.update("studentdetails", contentValues, "name=?", new String[]{name});
        return result > 0; // Return true if one or more rows were updated
    }

    // Delete data from the studentdetails table
    public boolean deleteData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete the record where the name matches
        int result = db.delete("studentdetails", "name=?", new String[]{name});
        return result > 0; // Return true if the record was deleted
    }
}
