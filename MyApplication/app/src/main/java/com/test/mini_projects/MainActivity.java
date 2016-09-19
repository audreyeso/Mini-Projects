package com.test.mini_projects;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Use shared preferences to figure out how to load data into your database the first time
 * you app is created. Use shared preferences to make it so the last temperature type
 * that was displayed is loaded when the app is resumed.
 * So if I had last pressed the Celsius button to be displaying the temperature in Celsius,
 * the next time I load the app it should load as Celsius.
 * <p/>
 * Use Shared Preferences to only insert data into the database 1 time
 * Use Shared Preferences to save the last chosen temperature type.
 */
public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    public static final String TEMP_TYPE = "temperature type";
    public static final String INSERTED_INTO_DATABASE_KEY = "inserted into db";
    ListView listView;
    Button fahr, cels, kelv;
    SharedPreferences sharedPreferences;
    WeatherSQLOpenHelper weatherSQLOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get an instance of weather open helper
        weatherSQLOpenHelper = WeatherSQLOpenHelper.getInstance(this);

        //inserts weather into our database
        //you need shared preferences otherwise, this will run on oncreate EVERY TIME

        sharedPreferences = getSharedPreferences(TAG, 0);
        boolean hasInserted = sharedPreferences.getBoolean(INSERTED_INTO_DATABASE_KEY, false);
        if (!hasInserted) {
            Weather weather1 = new Weather("Mon", 20, 78, 295);
            Weather weather2 = new Weather("Tues", 4, 23, 232);
            Weather weather3 = new Weather("Wednesday", 2, 42, 123);
            Weather weather4 = new Weather("Thursday", 13, 21, 245);
            Weather weather5 = new Weather("Friday", 18, 32, 231);

            weatherSQLOpenHelper.insert(weather1);
            weatherSQLOpenHelper.insert(weather2);
            weatherSQLOpenHelper.insert(weather3);
            weatherSQLOpenHelper.insert(weather4);
            weatherSQLOpenHelper.insert(weather5);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(INSERTED_INTO_DATABASE_KEY, true);
            editor.commit();
        }

        setTextViews();
        String tempType = sharedPreferences.getString(TEMP_TYPE, "nothing");
        setAdapter(tempType);
        //These Click Listeners determine which type of temperature should be shown

        fahr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setAdapter(WeatherSQLOpenHelper.COL_TEMP_FAHR);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEMP_TYPE, WeatherSQLOpenHelper.COL_TEMP_FAHR);
                editor.commit();
            }
        });

        cels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAdapter(WeatherSQLOpenHelper.COL_TEMP_CEL);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEMP_TYPE, WeatherSQLOpenHelper.COL_TEMP_CEL);
                editor.commit();
            }
        });

        kelv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAdapter(WeatherSQLOpenHelper.COL_TEMP_KELVIN);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEMP_TYPE, WeatherSQLOpenHelper.COL_TEMP_KELVIN);
                editor.commit();
            }
        });
    }

    public void setTextViews() {

        listView = (ListView) findViewById(R.id.listview);
        fahr = (Button) findViewById(R.id.fahr_button);
        cels = (Button) findViewById(R.id.celsius_button);
        kelv = (Button) findViewById(R.id.kelvin_button);
    }

    public void setAdapter(String currentColumn) {
        if(currentColumn.equals(WeatherSQLOpenHelper.COL_TEMP_CEL) ||
                currentColumn.equals(WeatherSQLOpenHelper.COL_TEMP_KELVIN) ||
                currentColumn.equals(WeatherSQLOpenHelper.COL_TEMP_FAHR)) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_expandable_list_item_2,
                    weatherSQLOpenHelper.getTemp(currentColumn),
                    new String [] {WeatherSQLOpenHelper.COL_DAY, currentColumn},
                    new int[]{android.R.id.text1, android.R.id.text2},
                    0);
            listView.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Click a Button to show tempuratures!", Toast.LENGTH_SHORT).show();
        }
    }
}
