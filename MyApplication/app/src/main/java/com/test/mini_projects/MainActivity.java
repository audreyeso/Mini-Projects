package com.test.mini_projects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
Use shared preferences to figure out how to load data into your database the first time
 you app is created. Use shared preferences to make it so the last temperature type
 that was displayed is loaded when the app is resumed.
 So if I had last pressed the Celsius button to be displaying the temperature in Celsius,
 the next time I load the app it should load as Celsius.

 Use Shared Preferences to only insert data into the database 1 time
 Use Shared Preferences to save the last chosen temperature type.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
