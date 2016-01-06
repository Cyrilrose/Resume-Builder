package com.swiftdeal.resume.builder;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by abhishek on 31-12-2015.
 */
public class ResumeProvider extends ContentProvider {


    DbHelper mOpenHelper;
    UriMatcher sUriMatcher=buildurimatcher();
    static final int RESUME=100;
    static final int RESUME_WITH_ID=101;


    @Override
    public boolean onCreate() {
        mOpenHelper = new DbHelper(getContext());
        return true;
    }

    static UriMatcher buildurimatcher()
    {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = resumecontract.CONTENT_AUTHORITY;
        // For each type of URI you want to add, create a corresponding code.

        matcher.addURI(authority, resumecontract.PATH_RESUME, RESUME);
        matcher.addURI(authority, resumecontract.PATH_RESUME + "/*",RESUME_WITH_ID);
        return matcher;
    }
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor retCursor;
        switch (sUriMatcher.match(uri)) {
            case RESUME:
                if(mOpenHelper!=null) {
                    retCursor = mOpenHelper.getReadableDatabase().query(
                            resumecontract.Resumeentry.TABLE_NAME,
                            projection,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            sortOrder
                    );
                }
                else{ retCursor=null;}
                break;
            case RESUME_WITH_ID:
                retCursor=getResumeidcursor(uri,projection,sortOrder);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    private static final String sResumewithid=resumecontract.Resumeentry.COLUMN_ID+" = ?";

    private Cursor getResumeidcursor(Uri uri,String[] projection, String sortOrder){
        String[] selectionargs;
        selectionargs = new String[]{resumecontract.Resumeentry.getResumeidFromUri(uri)};
        String selection=sResumewithid;


        if(mOpenHelper!=null)
        {
            return mOpenHelper.getReadableDatabase().query(
                    resumecontract.Resumeentry.TABLE_NAME,
                    projection,
                    selection,
                    selectionargs,
                    null,
                    null,
                    sortOrder
            );
        }
        else
        {
            return null;
        }
    }
    @Nullable
    @Override
    public String getType(Uri uri) {
        final int match = sUriMatcher.match(uri);

        switch (match) {
            case RESUME:
                return resumecontract.Resumeentry.CONTENT_TYPE;
            case RESUME_WITH_ID:
                return resumecontract.Resumeentry.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        Uri returnUri = null;

        switch (match) {
            case RESUME: {
                long _id = db.insert(resumecontract.Resumeentry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = resumecontract.Resumeentry.buildResumeUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsDeleted;
        // this makes delete all rows return the number of rows deleted
        if ( null == selection ) selection = "1";
        switch (match) {
            case RESUME:
                rowsDeleted = db.delete(
                        resumecontract.Resumeentry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        // Because a null deletes all rows
        if (rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsUpdated;

        switch (match) {
            case RESUME:
                rowsUpdated = db.update(resumecontract.Resumeentry.TABLE_NAME, values, selection,
                        selectionArgs);
                break;
            case RESUME_WITH_ID:
                rowsUpdated=db.update(resumecontract.Resumeentry.TABLE_NAME,values,selection,selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsUpdated;
    }
    @Override
    @TargetApi(22)
    public void shutdown() {
        mOpenHelper.close();
        super.shutdown();
    }
}
