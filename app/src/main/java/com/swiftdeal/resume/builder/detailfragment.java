package com.swiftdeal.resume.builder;

import android.content.Intent;
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

import android.widget.TextView;

/**
 * Created by abhishek on 01-01-2016.
 */
public class detailfragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String LOG_TAG = detailfragment.class.getSimpleName();

    static String DETAIL_URI = "URI";
    Uri mUri;
    private static final int DETAIL_LOADER = 0;
    private static final String[] DETAIL_COLUMNS = {
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
    protected TextView nameView;
    protected TextView ColnameView;
    protected TextView dobView;
    protected TextView fatnameView;
    protected TextView emailView;
    protected TextView addressView;
    protected TextView mobView;
    protected TextView sexView;
    protected TextView statusView;
    protected TextView qualify1,college1,uni1,per1,year1;
    protected TextView qualify2,college2,uni2,per2,year2;
    protected TextView qualify3,college3,uni3,per3,year3;
    protected TextView qualify4,college4,uni4,per4,year4;
    protected TextView achieve,hobbies,project1,project2,project3,project4,interest;

    public detailfragment(){

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
    {
        Bundle arguments = getArguments();
        if (arguments != null) {
            mUri = arguments.getParcelable(detailfragment.DETAIL_URI);
        }
        View rootView = inflater.inflate(com.swiftdeal.resume.builder.R.layout.content_detail, container, false);
        nameView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_name_textview);
        ColnameView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_colname_textview);
        dobView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_dob_textview);
        fatnameView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_fathersname_textview);
        emailView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_email_textview);
        addressView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_address_textview);
        mobView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_mob_textview);
        sexView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_sex_textview);
        statusView = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_status_textview);
        qualify1 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_qualify1_textview);
        college1 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_college1_textview);
        uni1 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_univ1_textview);
        per1 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_per1_textview);
        year1 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_year1_textview);
        qualify2 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_qualify2_textview);
        college2 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_college2_textview);
        uni2 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_univ2_textview);
        per2 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_per2_textview);
        year2 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_year2_textview);
        qualify3 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_qualify3_textview);
        college3 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_college3_textview);
        uni3 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_univ3_textview);
        per3 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_per3_textview);
        year3 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_year3_textview);
        qualify4 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_qualify4_textview);
        college4 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_college4_textview);
        uni4 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_univ4_textview);
        per4 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_per4_textview);
        year4 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_year4_textview);
        achieve = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_achieve_textview);
        hobbies = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_hobbies_textview);
        project1 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_project1_textview);
        project2 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_project2_textview);
        project3 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_project3_textview);
        project4 = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_project4_textview);
        interest = (TextView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.detail_interest_textview);
        Button update=(Button) rootView.findViewById(R.id.buttonupdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main=new Intent(getActivity(),update.class).setData(mUri);
                startActivity(main);
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(DETAIL_LOADER,null,this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        if (null != mUri) {
            // Now create and return a CursorLoader that will take care of
            // creating a Cursor for the data being displayed.
            return new CursorLoader(
                    getActivity(),
                    mUri,
                    DETAIL_COLUMNS,
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
            String name=data.getString(COL_RESUME_NAME);
            nameView.setText(name);
            String colname=data.getString(COL_RESUME_COLNAME);
            ColnameView.setText(colname);
            String dob=data.getString(COL_RESUME_DOB);
            dobView.setText(dob);
            String fatname=data.getString(COL_RESUME_FATHERSNAME);
            fatnameView.setText(fatname);
            String email=data.getString(COL_RESUME_EMAIL);
            emailView.setText(email);
            String address=data.getString(COL_RESUME_ADDRESS);
            addressView.setText(address);
            String mob=data.getString(COL_RESUME_MOBILE);
            mobView.setText(mob);
            String sex=data.getString(COL_RESUME_SEX);
            sexView.setText(sex);
            String status=data.getString(COL_RESUME_MARITAL);
            statusView.setText(status);
            String qualify1_s=data.getString(COL_RESUME_QUALIFY1);
            qualify1.setText(qualify1_s);
            String college1_s=data.getString(COL_RESUME_COLLEGE1);
            college1.setText(college1_s);
            String univer1_s=data.getString(COL_RESUME_UNIVER1);
            uni1.setText(univer1_s);
            String per1_s=data.getString(COL_RESUME_PER1);
            per1.setText(per1_s);
            String year1_s=data.getString(COL_RESUME_YEAR1);
            year1.setText(year1_s);
            String qualify2_s=data.getString(COL_RESUME_QUALIFY2);
            qualify2.setText(qualify2_s);
            String college2_s=data.getString(COL_RESUME_COLLEGE2);
            college2.setText(college2_s);
            String univer2_s=data.getString(COL_RESUME_UNIVER2);
            uni2.setText(univer2_s);
            String per2_s=data.getString(COL_RESUME_PER2);
            per2.setText(per2_s);
            String year2_s=data.getString(COL_RESUME_YEAR2);
            year2.setText(year2_s);
            String qualify3_s=data.getString(COL_RESUME_QUALIFY3);
            qualify3.setText(qualify3_s);
            String college3_s=data.getString(COL_RESUME_COLLEGE3);
            college3.setText(college3_s);
            String univer3_s=data.getString(COL_RESUME_UNIVER3);
            uni3.setText(univer3_s);
            String per3_s=data.getString(COL_RESUME_PER3);
            per3.setText(per3_s);
            String year3_s=data.getString(COL_RESUME_YEAR3);
            year3.setText(year3_s);
            String qualify4_s=data.getString(COL_RESUME_QUALIFY4);
            qualify4.setText(qualify4_s);
            String college4_s=data.getString(COL_RESUME_COLLEGE4);
            college4.setText(college4_s);
            String univer4_s=data.getString(COL_RESUME_UNIVER4);
            uni4.setText(univer4_s);
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
