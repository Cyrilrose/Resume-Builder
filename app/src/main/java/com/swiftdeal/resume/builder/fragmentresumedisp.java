package com.swiftdeal.resume.builder;

import android.database.Cursor;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * Created by abhishek on 01-01-2016.
 */
public class fragmentresumedisp extends android.support.v4.app.Fragment implements LoaderManager.LoaderCallbacks<Cursor>
{
    private static final int FORECAST_LOADER = 0;
    private static final String[] FORECAST_COLUMNS = {
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
    static final int COL_RESUME_QUALIFY1=10;

    ResumeAdapter resumeadapter;
    private ListView listview;
    private int mPosition = ListView.INVALID_POSITION;

    private static final String SELECTED_KEY = "selected_position";

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String sortOrder = resumecontract.Resumeentry.COLUMN_ID + " ASC";
        Uri normalUri=resumecontract.Resumeentry.CONTENT_URI;
        return new CursorLoader(getActivity(),
                normalUri,
                FORECAST_COLUMNS,
                null,
                null,
                sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        resumeadapter.swapCursor(data);
        if (mPosition != ListView.INVALID_POSITION) {
            // If we don't need to restart the loader, and there's a desired position to restore
            // to, do so now.
            listview.smoothScrollToPosition(mPosition);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        resumeadapter.swapCursor(null);
    }
    public fragmentresumedisp() {
    }

    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onItemSelected(Uri dateUri);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(com.swiftdeal.resume.builder.R.menu.menu_main, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (true) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        resumeadapter = new ResumeAdapter(getActivity(), null, 0);

        View rootView = inflater.inflate(com.swiftdeal.resume.builder.R.layout.displayfragment, container, false);
        listview = (ListView) rootView.findViewById(com.swiftdeal.resume.builder.R.id.listview_resume);
        listview.setAdapter(resumeadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Cursor cursor = (Cursor) adapterView.getItemAtPosition(position);
                if (cursor != null) {
                    ((Callback) getActivity())
                            .onItemSelected(resumecontract.Resumeentry.buildResumeUriWithid(cursor.getLong(COL_RESUMEID))
                            );
                }
                mPosition = position;
            }

        });
        if (savedInstanceState != null && savedInstanceState.containsKey(SELECTED_KEY)) {
            mPosition = savedInstanceState.getInt(SELECTED_KEY);
        }

        return (rootView);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (mPosition != ListView.INVALID_POSITION) {
            outState.putInt(SELECTED_KEY, mPosition);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(FORECAST_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }
}
