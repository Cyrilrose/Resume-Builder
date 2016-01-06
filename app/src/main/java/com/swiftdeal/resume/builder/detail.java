package com.swiftdeal.resume.builder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by abhishek on 01-01-2016.
 */
public class detail  extends AppCompatActivity {

    private final String LOG_TAG = detail.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.swiftdeal.resume.builder.R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(com.swiftdeal.resume.builder.R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putParcelable(detailfragment.DETAIL_URI, getIntent().getData());

            detailfragment fragment = new detailfragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(com.swiftdeal.resume.builder.R.id.resume_detail_container, fragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.swiftdeal.resume.builder.R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == com.swiftdeal.resume.builder.R.id.action_show) {
            Intent show = new Intent(this, Resumedisplay.class);
            startActivity(show);
        }
        //noinspection SimplifiableIfStatement
        if (id == com.swiftdeal.resume.builder.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
