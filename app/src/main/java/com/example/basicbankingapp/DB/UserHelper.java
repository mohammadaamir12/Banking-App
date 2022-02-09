package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(7860,'Aamir', 'aamir@gmail.com','7584','6879456745', 2550)");
        db.execSQL("insert into " + TABLE_NAME + " values(5862,'Salman', 'salman@gmail.com','1258','5748574346', 5500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7895,'Muskan', 'muskan@gmail.com','8896','7689456734', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1258,'Simran', 'simran@gmail.com','7752','3434346789', 58000)");
        db.execSQL("insert into " + TABLE_NAME + " values(7410,'Alvi', 'alvi@gmail.com','3669','7668876559', 57500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8529,'Piyal', 'piyal@gmail.com','9985','4466578965', 7650)");
        db.execSQL("insert into " + TABLE_NAME + " values(3698,'Raj', 'raj@gmail.com','1207','4557656445', 45300)");
        db.execSQL("insert into " + TABLE_NAME + " values(7853,'Komal', 'komal@gmail.com','4522','5768493065', 23500)");
        db.execSQL("insert into " + TABLE_NAME + " values(4562,'Roshan', 'roshan@gmail.com','6582','5674321567', 16500)");
        db.execSQL("insert into " + TABLE_NAME + " values(2365,'Manik', 'manik@gmail.com','5450','8574879456', 6900)");
        db.execSQL("insert into " + TABLE_NAME + " values(7854,'Falud', 'falud@gmail.com','2656','9475728905', 9700)");
        db.execSQL("insert into " + TABLE_NAME + " values(3621,'Hemant', 'hemant@gmail.com','1203','6878436807', 9000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1122,'Ram', 'ram@gmail.com','5566','9784561001', 7000)");
        db.execSQL("insert into " + TABLE_NAME + " values(9512,'Faruk', 'faruk@gmail.com','2236','5867557668', 5400)");
        db.execSQL("insert into " + TABLE_NAME + " values(7530,'Sanu', 'sanu@gmail.com','6692','1234567890', 10500)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}