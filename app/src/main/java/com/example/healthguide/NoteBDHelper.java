package com.example.healthguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class NoteBDHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "note";
    private static final String TABLE_NOTE = "notes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DESC = "description";
    private static final String COLUMN_DATE = "date";


    public NoteBDHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_NOTE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DESC + " TEXT,"
                + COLUMN_DATE + " TEXT )";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);

    }

    public long insertData(String description, String date) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_DESC, description);


        values.put(COLUMN_DATE, date);


        long result = db.insert(TABLE_NOTE, null, values);

        db.close();
        if (result == -1){
            Log.d("DBHelper", "Insert fail");
        } else {
            Log.d("SQL  Insert ",""+ result);
        }

        return result;
    }

    public ArrayList<Note> getAllData() {
        ArrayList<Note> shopData = new ArrayList<Note>();

        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_DESC + " , "
                + COLUMN_DATE
                + " FROM " + TABLE_NOTE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String desc = cursor.getString(1);
                String date = cursor.getString(2);
                Note obj = new Note(id,desc,date);
                shopData.add(obj);
            } while (cursor.moveToNext());
        }
//         Close connection
        cursor.close();
        db.close();

        return null;
    }

    public Cursor getAllDataForList(){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_DESC + " , "
                + COLUMN_DATE
                + " FROM " + TABLE_NOTE;
        Cursor result = db.rawQuery(selectQuery, null);
        return result;
    }
}
