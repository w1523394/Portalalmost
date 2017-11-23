package com.example.buscis_c2_l11.myapplication;

import android.content.res.Configuration; // import resource config
import android.content.res.Resources; // import resources
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.DisplayMetrics; // import display metrics
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.Locale;


public class displayMessageActivity extends AppCompatActivity{

    private static final String TAG = "CalendarActivity";
    private CalendarView calendarView;
    private Toast toast;
    private RadioButton radio1_id;
    private RadioButton radio2_id;
    private Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        radio1_id = (RadioButton) findViewById(R.id.radio1_Id);
        radio2_id = (RadioButton) findViewById(R.id.radio2_Id);

        radio1_id.setOnClickListener(first_radio_listener);
        radio2_id.setOnClickListener(second_radio_listener);
        calendarView.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Toast.makeText(getApplicationContext(), "" + dayOfMonth, 0).show();// TODO Auto-generated method stub}
            }});}

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    OnClickListener first_radio_listener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            // enter convert to english string
            setLocale("en");
        }
    };
    OnClickListener second_radio_listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            // enter convert to spanish string
            setLocale("es");
        }
    };

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, displayMessageActivity.class);
        startActivity(refresh);
    }
    public boolean onOptionsItemSelected(MenuItem item) {

        //respond to menu item selection
        switch (item.getItemId()) {
            case R.id.aboutId:
                startActivity(new Intent(this, AboutActivity.class));
                return true;
            case R.id.appId:
                startActivity(new Intent(this, appActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
