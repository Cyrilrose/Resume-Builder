package com.swiftdeal.resume.builder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by abhishek on 04-01-2016.
 */
public class updatefragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String LOG_TAG = updatefragment.class.getSimpleName();

    static String UPDATE_URI = "URI";
    Context mContext;
    Uri mUri;
    private static final int UPDATE_LOADER = 0;
    private static final String[] UPDATE_COLUMNS = {
            // In this case the id needs to be fully qualified with a table name, since
            // the content provider joins the location & weather tables in the background
            // (both have an _id column)
            // On the one hand, that's annoying.  On the other, you can search the weather table
            // using the location set by the user, which is only in the Location table.
            // So the convenience is worth it.
            resumecontract.Resumeentry.COLUMN_ID,
            resumecontract.Resumeentry.COLUMN_NAME,
            resumecontract.Resumeentry.COLUMN_COLNAME,
            resumecontract.Resumeentry.COLUMN_DOB,
            resumecontract.Resumeentry.COLUMN_FATHERNAME,
            resumecontract.Resumeentry.COLUMN_EMAIL,
            resumecontract.Resumeentry.COLUMN_ADDRESS,
            resumecontract.Resumeentry.COLUMN_MOBNO,
            resumecontract.Resumeentry.COLUMN_SEX,
            resumecontract.Resumeentry.COLUMN_MARITAL,
            resumecontract.Resumeentry.COLUMN_QUALIFICATION1,
            resumecontract.Resumeentry.COLUMN_COLLEGE1,
            resumecontract.Resumeentry.COLUMN_UNIVERSITY1,
            resumecontract.Resumeentry.COLUMN_PER1,
            resumecontract.Resumeentry.COLUMN_YEAR1,
            resumecontract.Resumeentry.COLUMN_QUALIFICATION2,
            resumecontract.Resumeentry.COLUMN_COLLEGE2,
            resumecontract.Resumeentry.COLUMN_UNIVERSITY2,
            resumecontract.Resumeentry.COLUMN_PER2,
            resumecontract.Resumeentry.COLUMN_YEAR2,
            resumecontract.Resumeentry.COLUMN_QUALIFICATION3,
            resumecontract.Resumeentry.COLUMN_COLLEGE3,
            resumecontract.Resumeentry.COLUMN_UNIVERSITY3,
            resumecontract.Resumeentry.COLUMN_PER3,
            resumecontract.Resumeentry.COLUMN_YEAR3,
            resumecontract.Resumeentry.COLUMN_QUALIFICATION4,
            resumecontract.Resumeentry.COLUMN_COLLEGE4,
            resumecontract.Resumeentry.COLUMN_UNIVERSITY4,
            resumecontract.Resumeentry.COLUMN_PER4,
            resumecontract.Resumeentry.COLUMN_YEAR4,
            resumecontract.Resumeentry.COLUMN_ACHIEVEMENTS,
            resumecontract.Resumeentry.COLUMN_HOBBIES,
            resumecontract.Resumeentry.COLUMN_PROJECT1,
            resumecontract.Resumeentry.COLUMN_PROJECT2,
            resumecontract.Resumeentry.COLUMN_PROJECT3,
            resumecontract.Resumeentry.COLUMN_PROJECT4,
            resumecontract.Resumeentry.COLUMN_INTEREST

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
    static final int COL_RESUME_QUALIFY1 = 10;
    static final int COL_RESUME_COLLEGE1 =11;
    static final int COL_RESUME_UNIVER1 = 12;
    static final int COL_RESUME_PER1 = 13;
    static final int COL_RESUME_YEAR1=14;
    static final int COL_RESUME_QUALIFY2 = 15;
    static final int COL_RESUME_COLLEGE2 =16;
    static final int COL_RESUME_UNIVER2 = 17;
    static final int COL_RESUME_PER2 = 18;
    static final int COL_RESUME_YEAR2=19;
    static final int COL_RESUME_QUALIFY3 = 20;
    static final int COL_RESUME_COLLEGE3 =21;
    static final int COL_RESUME_UNIVER3 = 22;
    static final int COL_RESUME_PER3 = 23;
    static final int COL_RESUME_YEAR3=24;
    static final int COL_RESUME_QUALIFY4 = 25;
    static final int COL_RESUME_COLLEGE4 =26;
    static final int COL_RESUME_UNIVER4 = 27;
    static final int COL_RESUME_PER4 = 28;
    static final int COL_RESUME_YEAR4=29;
    static final int COL_RESUME_ACHIEVE =30;
    static final int COL_RESUME_HOBBIES = 31;
    static final int COL_RESUME_PROJECT1 = 32;
    static final int COL_RESUME_PROJECT2 = 33;
    static final int COL_RESUME_PROJECT3 = 34;
    static final int COL_RESUME_PROJECT4 = 35;
    static final int COL_RESUME_INTEREST=36;


    protected EditText name;
    protected EditText colname;
    protected EditText dob, fathersname, mobile, address, email, sex, status;
    protected Button update;
    protected EditText qualify1,college1,uni1,per1,year1;
    protected EditText qualify2,college2,uni2,per2,year2;
    protected EditText qualify3,college3,uni3,per3,year3;
    protected EditText qualify4,college4,uni4,per4,year4;
    protected EditText achieve,hobbies,project1,project2,project3,project4,interest;





    public updatefragment(){

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mUri = arguments.getParcelable(updatefragment.UPDATE_URI);
        }
        final View rootView = inflater.inflate(com.swiftdeal.resume.builder.R.layout.update_contain, container, false);
        Button post = (Button) rootView.findViewById(com.swiftdeal.resume.builder.R.id.postgrad);
        Button graduate = (Button) rootView.findViewById(com.swiftdeal.resume.builder.R.id.graduate);
        name = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.name_e);
        colname = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.college_e);
        dob = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.dob_e);
        fathersname = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.father_e);
        mobile = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.mob_e);
        email = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.emailid_e);
        sex = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.sex_e);
        status = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.status_e);
        address = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.address_e);
        qualify1 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.qualify1_e);
        college1 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.college1_e);
        uni1 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.university1_e);
        per1 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.per1_e);
        year1 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.year1_e);
        qualify2 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.qualify2_e);
        college2 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.college2_e);
        uni2 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.university2_e);
        per2 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.per2_e);
        year2 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.year2_e);
        qualify3 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.qualify3_e);
        college3 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.college3_e);
        uni3 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.university3_e);
        per3 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.per3_e);
        year3 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.year3_e);
        qualify4 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.qualify4_e);
        college4 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.college4_e);
        uni4 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.university4_e);
        per4 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.per4_e);
        year4 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.year4_e);
        achieve = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.achievements_e);
        hobbies = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.hobbies_e);
        project1 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.project1_e);
        project2 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.project2_e);
        project3 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.project3_e);
        project4 = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.project4_e);
        interest = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.interest_e);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText gra = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.year1_e);
                gra.setText("");
                EditText pg = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.year2_e);
                pg.setText("PURSUING");
                LinearLayout l1 = (LinearLayout) rootView.findViewById(com.swiftdeal.resume.builder.R.id.grad);
                l1.setVisibility(View.VISIBLE);
            }
        });

        graduate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText gra = (EditText) rootView.findViewById(com.swiftdeal.resume.builder.R.id.year1_e);
                gra.setText("PURSUING");
                LinearLayout l1 = (LinearLayout) rootView.findViewById(com.swiftdeal.resume.builder.R.id.grad);
                l1.setVisibility(View.INVISIBLE);
            }
        });
        update=(Button) rootView.findViewById(com.swiftdeal.resume.builder.R.id.button);
        update.setText("UPDATE");
        update.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          updatevalues();
                                      }
                                  }
            );
        return rootView;
    }

    public void updatevalues()
    {
        ContentValues resume=new ContentValues();
        String names = name.getText().toString();
        String colnames = colname.getText().toString();
        String dobs = dob.getText().toString();
        String fathersnames = fathersname.getText().toString();
        String mobiles = mobile.getText().toString();
        String emails = email.getText().toString();
        String sexs = sex.getText().toString();
        String statuss = status.getText().toString();
        String addresss = address.getText().toString();

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

        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION1,qualify1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_COLLEGE1, college1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_UNIVERSITY1, uni1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PER1, per1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_YEAR1, year1_s);
        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION2,qualify2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_COLLEGE2, college2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_UNIVERSITY2, uni2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PER2, per2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_YEAR2, year2_s);
        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION3,qualify3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_COLLEGE3, college3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_UNIVERSITY3, uni3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_PER3, per3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_YEAR3, year3_s);
        resume.put(resumecontract.Resumeentry.COLUMN_QUALIFICATION4,qualify4_s);
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
        String selection=resumecontract.Resumeentry.COLUMN_ID+" = ?";
        String[] selectionargs=new String[]{resumecontract.Resumeentry.getResumeidFromUri(mUri)};
        int updated = mContext.getContentResolver().update(
                mUri,
                resume,selection,selectionargs
                );
        Toast.makeText(mContext,"UPDATED RESUME IS ON LOCAION  "+resumecontract.Resumeentry.getResumeidFromUri(mUri)+" IN HISTROY LIST",Toast.LENGTH_LONG);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(UPDATE_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);

        mContext=getActivity();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (null != mUri) {
            // Now create and return a CursorLoader that will take care of
            // creating a Cursor for the data being displayed.
            return new CursorLoader(
                    getActivity(),
                    mUri,
                    UPDATE_COLUMNS,
                    null,
                    null,
                    null
            );
        }
        return null;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            // Read weather condition ID from cursor
            int weatherId = data.getInt(COL_RESUMEID);
            // Use placeholder Image
            String names = data.getString(COL_RESUME_NAME);
            name.setText(names);
            String colnames = data.getString(COL_RESUME_COLNAME);
            colname.setText(colnames);
            String dobs = data.getString(COL_RESUME_DOB);
            dob.setText(dobs);
            String fatname = data.getString(COL_RESUME_FATHERSNAME);
            fathersname.setText(fatname);
            String emailid = data.getString(COL_RESUME_EMAIL);
            email.setText(emailid);
            String addresss = data.getString(COL_RESUME_ADDRESS);
            address.setText(addresss);
            String mob = data.getString(COL_RESUME_MOBILE);
            mobile.setText(mob);
            String sexs = data.getString(COL_RESUME_SEX);
            sex.setText(sexs);
            String marital = data.getString(COL_RESUME_MARITAL);
            status.setText(marital);
            String qualify1_s=data.getString(COL_RESUME_QUALIFY1);
            qualify1.setText(qualify1_s);
            String college1_s=data.getString(COL_RESUME_COLLEGE1);
            college1.setText(college1_s);
            String uni1_s=data.getString(COL_RESUME_UNIVER1);
            uni1.setText(uni1_s);
            String per1_s=data.getString(COL_RESUME_PER1);
            per1.setText(per1_s);
            String year1_s=data.getString(COL_RESUME_YEAR1);
            year1.setText(year1_s);
            String qualify2_s=data.getString(COL_RESUME_QUALIFY2);
            qualify2.setText(qualify2_s);
            String college2_s=data.getString(COL_RESUME_COLLEGE2);
            college2.setText(college2_s);
            String uni2_s=data.getString(COL_RESUME_UNIVER2);
            uni2.setText(uni2_s);
            String per2_s=data.getString(COL_RESUME_PER2);
            per2.setText(per2_s);
            String year2_s=data.getString(COL_RESUME_YEAR2);
            year2.setText(year2_s);
            String qualify3_s=data.getString(COL_RESUME_QUALIFY3);
            qualify3.setText(qualify3_s);
            String college3_s=data.getString(COL_RESUME_COLLEGE3);
            college3.setText(college3_s);
            String uni3_s=data.getString(COL_RESUME_UNIVER3);
            uni3.setText(uni3_s);
            String per3_s=data.getString(COL_RESUME_PER3);
            per3.setText(per3_s);
            String year3_s=data.getString(COL_RESUME_YEAR3);
            year3.setText(year3_s);
            String qualify4_s=data.getString(COL_RESUME_QUALIFY4);
            qualify4.setText(qualify4_s);
            String college4_s=data.getString(COL_RESUME_COLLEGE4);
            college4.setText(college4_s);
            String uni4_s=data.getString(COL_RESUME_UNIVER4);
            uni4.setText(uni4_s);
            String per4_s=data.getString(COL_RESUME_PER4);
            per4.setText(per4_s);
            String year4_s=data.getString(COL_RESUME_YEAR4);
            year4.setText(year4_s);
            String achieve_s=data.getString(COL_RESUME_ACHIEVE);
            achieve.setText(achieve_s);
            String hobbies_s=data.getString(COL_RESUME_HOBBIES);
            hobbies.setText(hobbies_s);
            String project1_s=data.getString(COL_RESUME_PROJECT1);
            project1.setText(project1_s);
            String project2_s=data.getString(COL_RESUME_PROJECT2);
            project2.setText(project2_s);
            String project3_s=data.getString(COL_RESUME_PROJECT3);
            project3.setText(project3_s);
            String project4_s=data.getString(COL_RESUME_PROJECT4);
            project4.setText(project4_s);
            String interest_s=data.getString(COL_RESUME_INTEREST);
            interest.setText(interest_s);

        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
