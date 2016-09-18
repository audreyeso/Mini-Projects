package com.test.mini_projects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by audreyeso on 9/18/16.
 */
public class WeatherSQLOpenHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 100;
    public static final String DATABASE_NAME = "WEATHER_DB";
    public static final String TABLE_NAME = "Weather";

    public static final String COL_ID = "_id";
    public static final String COL_TEMP_CEL = "Celsius";
    public static final String COL_TEMP_FAHR = "Fahrenheit";
    public static final String COL_TEMP_KELVIN = "Kelvin";
    public static final String COL_DAY = "Date";

    public static final String SQL_CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "( " +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_TEMP_CEL + " INTEGER, " +
            COL_TEMP_FAHR + " INTEGER, " +
            COL_TEMP_KELVIN + " INTEGER, " +
            COL_DAY + " TEXT)";

    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public static WeatherSQLOpenHelper instance;

    public static WeatherSQLOpenHelper getInstance (Context context) {
        if(instance ==null) {
            instance = new WeatherSQLOpenHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DROP_TABLE);
        this.onCreate(sqLiteDatabase);
    }

    public WeatherSQLOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //insert into database
    public void insert(Weather weather) {
        ContentValues values = new ContentValues();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        values.put(COL_DAY, weather.getDay());
        values.put(COL_TEMP_CEL, weather.getCelcius());
        values.put(COL_TEMP_FAHR, weather.getFahrenheit());
        values.put(COL_TEMP_KELVIN, weather.getKelvin());
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();
    }

    //takes in a column name and gets the temp

    public Cursor getTemp(String wantedTemp){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String[] projection = {COL_ID, COL_DAY, wantedTemp};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
}
