package com.swiftdeal.resume.builder;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public  class MainActivity extends AppCompatActivity {

    Uri muri = null;
    Context mContext;
    ContentValues resume;
    RadioGroup post;
    Button nxtpg;
    static final String DETAIL_URI = "URI";
    private static final int DETAIL_LOADER = 0;
   /* private static final String[] DETAIL_COLUMNS = {
            // In this case the id needs to be fully qualified with a table name, since
            // the content provider joins the location & weather tables in the background
            // (both have an _id column)
            // On the one hand, that's annoying.  On the other, you can search the weather table
            // using the location set by the user, which is only in the Location table.
            // So the convenience is worth it.
            resumecontract.Resumeentry.TABLE_NAME + "." + resumecontract.Resumeentry._ID,
            resumecontract.Resumeentry.COLUMN_NAME,
            resumecontract.Resumeentry.COLUMN_COLNAME,
            resumecontract.Resumeentry.COLUMN_DOB,
            resumecontract.Resumeentry.COLUMN_FATHERNAME,
            resumecontract.Resumeentry.COLUMN_EMAIL,
            resumecontract.Resumeentry.COLUMN_ADDRESS,
            resumecontract.Resumeentry.COLUMN_MOBNO,
            resumecontract.Resumeentry.COLUMN_SEX,
            resumecontract.Resumeentry.COLUMN_MARITAL
    };

    static final int COL_RESUMEID = 0;
    static final int COL_RESUME_NAME = 1;
    static final int COL_RESUME_COLNAME = 2;
    static final int COL_RESUME_DOB = 3;
    static final int COL_RESUME_FATHERSNAME = 4;
    static final int COL_RESUME_EMAIL = 5;
    static final int COL_RESUME_ADDRESS = 6;
    static final int COL_RESUME_MOBILE = 7;
    static final int COL_RESUME_SEX = 8;
    static final int COL_RESUME_MARITAL=9;


   /* public MainActivity(Context context) {
        mContext = context;
    }*/

    public void add() {
        final EditText name;
        final EditText colname;
        final EditText dob, fathersname, mobile, address, email, sex, status;

        resume = new ContentValues();
        name = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.name_e);
        colname = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.college_e);
        dob = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.dob_e);
        fathersname = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.father_e);
        mobile = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.mob_e);
        email = (EditText) findViewById(R.id.emailid_e);
        sex = (EditText) findViewById(R.id.sex_e);
        status = (EditText) findViewById(R.id.status_e);
        address = (EditText) findViewById(R.id.address_e);

        String names = name.getText().toString();
        String colnames = colname.getText().toString();
        String dobs = dob.getText().toString();
        String fathersnames = fathersname.getText().toString();
        String mobiles = mobile.getText().toString();
        String emails = email.getText().toString();
        String sexs = sex.getText().toString();
        String statuss = status.getText().toString();
        String addresss = address.getText().toString();
        final EditText qualify1, college1, uni1, per1, year1;
        qualify1 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.qualify1_e);
        college1 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.college1_e);
        uni1 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.university1_e);
        per1 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.per1_e);
        year1 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.year1_e);
        final EditText qualify2, college2, uni2, per2, year2;
        qualify2 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.qualify2_e);
        college2 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.college2_e);
        uni2 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.university2_e);
        per2 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.per2_e);
        year2 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.year2_e);
        final EditText qualify3, college3, uni3, per3, year3;
        qualify3 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.qualify3_e);
        college3 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.college3_e);
        uni3 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.university3_e);
        per3 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.per3_e);
        year3 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.year3_e);
        final EditText qualify4, college4, uni4, per4, year4;
        qualify4 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.qualify4_e);
        college4 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.college4_e);
        uni4 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.university4_e);
        per4 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.per4_e);
        year4 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.year4_e);
        final EditText achieve,hobbies,project1,project2,project3,project4,interest;
        achieve = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.achievements_e);
        hobbies= (EditText) findViewById(com.swiftdeal.resume.builder.R.id.hobbies_e);
        project1 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.project1_e);
        project2 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.project2_e);
        project3 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.project3_e);
        project4 = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.project4_e);
        interest = (EditText) findViewById(com.swiftdeal.resume.builder.R.id.interest_e);

        String qualify1_s = qualify1.getText().toString();
        String college1_s = college1.getText().toString();
        String uni1_s = uni1.getText().toString();
        String per1_s = per1.getText().toString();
        String year1_s = year1.getText().toString();
        String qualify2_s = qualify2.getText().toString();
        String college2_s = college2.getText().toString();
        String uni2_s = uni2.getText().toString();
        String per2_s = per2.getText().toString();
        String year2_s = year2.getText().toString();
        String qualify3_s = qualify3.getText().toString();
        String college3_s = college3.getText().toString();
        String uni3_s = uni3.getText().toString();
        String per3_s = per3.getText().toString();
        String year3_s = year3.getText().toString();
        String qualify4_s = qualify4.getText().toString();
        String college4_s = college4.getText().toString();
        String uni4_s = uni4.getText().toString();
        String per4_s = per4.getText().toString();
        String year4_s = year4.getText().toString();
        String achieve_s = achieve.getText().toString();
        String hobbies_s = hobbies.getText().toString();
        String project1_s = project1.getText().toString();
        String project2_s = project2.getText().toString();
        String project3_s = project3.getText().toString();
        String project4_s = project4.getText().toString();
        String interest_s = interest.getText().toString();




        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION1, qualify1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_COLLEGE1, college1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_UNIVERSITY1, uni1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PER1, per1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_YEAR1, year1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION2, qualify2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_COLLEGE2, college2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_UNIVERSITY2, uni2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PER2, per2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_YEAR2, year2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION3, qualify3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_COLLEGE3, college3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_UNIVERSITY3, uni3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PER3, per3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_YEAR3, year3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION4, qualify4_s);
        resume.put(resumecontract.Resumeentry.COLUMN_COLLEGE4, college4_s);
        resume.put(resumecontract.Resumeentry.COLUMN_UNIVERSITY4, uni4_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PER4, per4_s);
        resume.put(resumecontract.Resumeentry.COLUMN_YEAR4, year4_s);
        resume.put(resumecontract.Resumeentry.COLUMN_ACHIEVEMENTS, achieve_s);
        resume.put(resumecontract.Resumeentry.COLUMN_HOBBIES, hobbies_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PROJECT1, project1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PROJECT2, project2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PROJECT3, project3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PROJECT4, project4_s);
        resume.put(resumecontract.Resumeentry.COLUMN_INTEREST, interest_s);

        resume.put(resumecontract.Resumeentry.COLUMN_NAME, names);
        resume.put(resumecontract.Resumeentry.COLUMN_COLNAME, colnames);
        resume.put(resumecontract.Resumeentry.COLUMN_DOB, dobs);
        resume.put(resumecontract.Resumeentry.COLUMN_FATHERNAME, fathersnames);
        resume.put(resumecontract.Resumeentry.COLUMN_EMAIL, emails);
        resume.put(resumecontract.Resumeentry.COLUMN_MOBNO, mobiles);
        resume.put(resumecontract.Resumeentry.COLUMN_SEX, sexs);
        resume.put(resumecontract.Resumeentry.COLUMN_MARITAL, statuss);
        resume.put(resumecontract.Resumeentry.COLUMN_ADDRESS, addresss);
        Uri insertedUri = mContext.getContentResolver().insert(
                resumecontract.Resumeentry.CONTENT_URI,
                resume
        );
        long resumeid;
        resumeid = ContentUris.parseId(insertedUri);

        Toast.makeText(mContext, "YOUR RESUME IS SUCCESSFULLY INSERTED with ITEM LOCATION ON HISTROY IS " + resumeid, Toast.LENGTH_LONG);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.swiftdeal.resume.builder.R.layout.activity_main);
        mContext = getBaseContext();
        // getLoaderManager().initLoader(DETAIL_LOADER, null, (android.app.LoaderManager.LoaderCallbacks<Cursor>) this);
        Toolbar toolbar = (Toolbar) findViewById(com.swiftdeal.resume.builder.R.id.toolbar);
        setSupportActionBar(toolbar);


        muri = getIntent().getData();
        FloatingActionButton fab = (FloatingActionButton) findViewById(com.swiftdeal.resume.builder.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                add();
            }
        });
        Button next = (Button) findViewById(com.swiftdeal.resume.builder.R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });


        Button post = (Button) findViewById(com.swiftdeal.resume.builder.R.id.pg);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText gra=(EditText)findViewById(com.swiftdeal.resume.builder.R.id.year1_e);
                gra.setText("");
                EditText pg=(EditText)findViewById(com.swiftdeal.resume.builder.R.id.year2_e);
                pg.setText("PURSUING");
                LinearLayout l1 = (LinearLayout) findViewById(com.swiftdeal.resume.builder.R.id.grad);
                l1.setVisibility(View.VISIBLE);
            }
        });
        Button graduate = (Button) findViewById(com.swiftdeal.resume.builder.R.id.graduation);
        graduate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText gra=(EditText)findViewById(com.swiftdeal.resume.builder.R.id.year1_e);
                gra.setText("PURSUING");
                LinearLayout l1 = (LinearLayout) findViewById(com.swiftdeal.resume.builder.R.id.grad);
                l1.setVisibility(View.INVISIBLE);
            }
        });
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

