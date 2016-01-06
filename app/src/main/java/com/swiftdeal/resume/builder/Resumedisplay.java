package com.swiftdeal.resume.builder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

/**
 * Created by abhishek on 01-01-2016.
 */
public class Resumedisplay extends AppCompatActivity implements fragmentresumedisp.Callback {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    Context mContext;
    private static final String DETAILFRAGMENT_TAG = "DFTAG";
    /*public Resumedisplay(Context context)
    {
        mContext=context;
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.swiftdeal.resume.builder.R.layout.display_main);
        Toolbar toolbar = (Toolbar) findViewById(com.swiftdeal.resume.builder.R.id.toolbar);
       setSupportActionBar(toolbar);
        mContext=getBaseContext();
       /* long resumeid;
        ContentValues swiftdeal.resume=new ContentValues();

        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_NAME, "abhi");
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_COLNAME, "jss");
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_DOB,14/8/1996);
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_FATHERNAME,"singhania");
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_EMAIL,"abhisinghania14@gmail.com");
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_MOBNO, 964315);
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_SEX, "male");
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_MARITAL, "unmarried");
        swiftdeal.resume.put(resumecontract.Resumeentry.COLUMN_ADDRESS, "200-Shcjdfgegtg");

        Uri insertedUri = mContext.getContentResolver().insert(
                resumecontract.Resumeentry.CONTENT_URI,
                swiftdeal.resume
        );
        resumeid = ContentUris.parseId(insertedUri);*/
        //fragmentresumedisp forecastFragment =  new fragmentresumedisp();
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment_resume, forecastFragment).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.swiftdeal.resume.builder.R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        // update the location in our second pane using the fragment manager

    }
    @Override
    public void onItemSelected(Uri contentUri) {
        Intent intent = new Intent(this, detail.class)
                .setData(contentUri);
        startActivity(intent);
    }

}
