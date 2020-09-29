package com.example.saffy.a2travel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapterClass {

    public final static String TABLE_COL_NAME = "trvl_name";
    public final static String TABLE_COL_NATIONALITY = "trvl_nationality";
    public final static String TABLE_COL_SSN = "trvl_ssn";
    public final static String TABLE_COL_MAIL = "trvl_mail";
    public final static String TABLE_COL_PHONE = "trvl_phone";
    public final static String TABLE_COL_DATE = "trvl_date";
    public final static String TABLE_COL_ORDEROFROOM = "trvl_orderOroom";
    public final static String TABLE_COL_NUMOFPERSON = "trvl_numOperson";
    public final static String TABLE_COL_VISAORCASH = "trvl_visaORcash";
    public final static String TABLE_COL_VISANUM = "trvl_visaNum";

    private final static String TAG = "DBAdapterClass";
    private final static String DATABASE_NAME = "APPData";
    private final static String DATABASE_TABLE_NAME = "Traveller";
    private final static int DATABASE_VERSION = 1;
    private final static String DATABASE_CREATE = "CREATE TABLE Traveller (" +
            "    trvl_name        TEXT    NOT NULL," +
            "    trvl_nationality TEXT    NOT NULL," +
            "    trvl_ssn         INTEGER PRIMARY KEY," +
            "    trvl_mail        TEXT    NOT NULL," +
            "    trvl_phone       TEXT," +
            "    trvl_date        TEXT    ," +
            "    trvl_orderOroom  TEXT    NOT NULL," +
            "    trvl_numOperson  INTEGER," +
            "    trvl_visaORcash  TEXT    NOT NULL," +
            "    trvl_visaNum     INTEGER )";

    private final Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public DBAdapterClass(Context ctx) {
        this.context = ctx;
        databaseHelper = new DatabaseHelper(context);
    }

    //---opens the database---
    public DBAdapterClass open() throws SQLException {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close() {
        databaseHelper.close();
    }

    //Insert into database when visa is checked
    public long insertTraveller(String name, String nationality, int ssn, String mail, String phone, String date,
                                String orderOroom, int numOperson, String visaORcash, int visaNum) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(TABLE_COL_NAME, name);
        contentValues.put(TABLE_COL_NATIONALITY, nationality);
        contentValues.put(TABLE_COL_SSN, ssn);
        contentValues.put(TABLE_COL_MAIL, mail);
        contentValues.put(TABLE_COL_PHONE, phone);
        contentValues.put(TABLE_COL_DATE, date);
        contentValues.put(TABLE_COL_ORDEROFROOM, orderOroom);
        contentValues.put(TABLE_COL_NUMOFPERSON, numOperson);
        contentValues.put(TABLE_COL_VISAORCASH, visaORcash);
        contentValues.put(TABLE_COL_VISANUM, visaNum);

        return sqLiteDatabase.insert(DATABASE_TABLE_NAME, null, contentValues);
    }

    //Search for radioButtonChecked by ssn from database
    public Cursor getRadioButtonChecked(String ssn) throws SQLException {
        Cursor cursor = sqLiteDatabase.query(true, DATABASE_TABLE_NAME, new String[]{TABLE_COL_VISAORCASH}, TABLE_COL_SSN + "=" + ssn,
                null, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    //Delete from database by ssn
    public boolean deleteTraveller(int ssn) {
        return sqLiteDatabase.delete(DATABASE_TABLE_NAME, TABLE_COL_SSN + "=" + ssn, null) > 0;
    }

    public Cursor getAllData(int ssn)throws SQLException{
        Cursor cursor=sqLiteDatabase.query(true,DATABASE_TABLE_NAME,new String[]{TABLE_COL_NAME, TABLE_COL_NATIONALITY,TABLE_COL_SSN, TABLE_COL_MAIL,
                        TABLE_COL_PHONE, TABLE_COL_DATE, TABLE_COL_ORDEROFROOM, TABLE_COL_NUMOFPERSON, TABLE_COL_VISAORCASH, TABLE_COL_VISANUM},
                TABLE_COL_SSN+"="+ssn,
                null,null,null,null,null);
        //if(cursor!=null)
          //  cursor.moveToFirst();
        return cursor;
    }
    //Update data into database if it was visa
    public boolean updateTraveller(String name, String nationality, int ssn, String mail, String phone, String date,
                                   String orderOroom, int numOperson, String visaORcash, int visaNum) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(TABLE_COL_NAME, name);
        contentValues.put(TABLE_COL_NATIONALITY, nationality);
        contentValues.put(TABLE_COL_MAIL, mail);
        contentValues.put(TABLE_COL_PHONE, phone);
        contentValues.put(TABLE_COL_DATE, date);
        contentValues.put(TABLE_COL_ORDEROFROOM, orderOroom);
        contentValues.put(TABLE_COL_NUMOFPERSON, numOperson);
        contentValues.put(TABLE_COL_VISAORCASH, visaORcash);
        contentValues.put(TABLE_COL_VISANUM, visaNum);

        return sqLiteDatabase.update(DATABASE_TABLE_NAME, contentValues, TABLE_COL_SSN + "=" + ssn, null) > 0;
    }

    //Update data into database if it was cash
    public boolean updateTraveller(String name, String nationality, int ssn, String mail, String phone, String date,
                                   String orderOroom, int numOperson, String visaORcash) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(TABLE_COL_NAME, name);
        contentValues.put(TABLE_COL_NATIONALITY, nationality);
        contentValues.put(TABLE_COL_MAIL, mail);
        contentValues.put(TABLE_COL_PHONE, phone);
        contentValues.put(TABLE_COL_DATE, date);
        contentValues.put(TABLE_COL_ORDEROFROOM, orderOroom);
        contentValues.put(TABLE_COL_NUMOFPERSON, numOperson);
        contentValues.put(TABLE_COL_VISAORCASH, visaORcash);

        return sqLiteDatabase.update(DATABASE_TABLE_NAME, contentValues, TABLE_COL_SSN + "=" + ssn, null) > 0;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS Traveller");
            onCreate(db);
        }
    }
}
