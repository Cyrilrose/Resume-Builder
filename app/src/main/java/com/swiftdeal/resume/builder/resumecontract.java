package com.swiftdeal.resume.builder;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by abhishek on 30-12-2015.
 */
public class resumecontract {
    public static final String CONTENT_AUTHORITY = "com.example.abhishek.resumebuilder";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_RESUME = "swiftdeal.resume";
    public static final class Resumeentry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_RESUME).build();
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESUME;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_RESUME;

        public static final String TABLE_NAME = "swiftdeal.resume";
        public static final String COLUMN_ID= "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_COLNAME = "college_name";
        public static final String COLUMN_DOB= "dob";
        public static final String COLUMN_FATHERNAME= "father_name";
        public static final String COLUMN_EMAIL = "email_id";
        public static final String COLUMN_ADDRESS = "address";
        public static final String COLUMN_MOBNO= "mobile_no";
        public static final String COLUMN_SEX= "sex";
        public static final String COLUMN_MARITAL= "marital_status";
        public static final String COLUMN_QUALIFICATION1 = "qualification1";
        public static final String COLUMN_COLLEGE1= "college1";
        public static final String COLUMN_UNIVERSITY1= "university1";
        public static final String COLUMN_PER1= "per1";
        public static final String COLUMN_YEAR1= "year1";
        public static final String COLUMN_QUALIFICATION2 = "qualification2";
        public static final String COLUMN_COLLEGE2= "college2";
        public static final String COLUMN_UNIVERSITY2= "university2";
        public static final String COLUMN_PER2= "per2";
        public static final String COLUMN_YEAR2= "year2";
        public static final String COLUMN_QUALIFICATION3= "qualification3";
        public static final String COLUMN_COLLEGE3= "college3";
        public static final String COLUMN_UNIVERSITY3= "university3";
        public static final String COLUMN_PER3= "per3";
        public static final String COLUMN_YEAR3= "year3";
        public static final String COLUMN_QUALIFICATION4 = "qualification4";
        public static final String COLUMN_COLLEGE4= "college4";
        public static final String COLUMN_UNIVERSITY4= "university4";
        public static final String COLUMN_PER4= "per4";
        public static final String COLUMN_YEAR4= "year4";
        public static final String COLUMN_ACHIEVEMENTS="achievement";
        public static final String COLUMN_HOBBIES="hobbies";
        public static final String COLUMN_PROJECT1="project1";
        public static final String COLUMN_PROJECT2="project2";
        public static final String COLUMN_PROJECT3="project3";
        public static final String COLUMN_PROJECT4="project4";
        public static final String COLUMN_INTEREST="interest";

        public static Uri buildResumeUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
        public static Uri buildResumeUriWithid(long id) {
            return CONTENT_URI.buildUpon().appendPath(Long.toString(id)).build();

        }
        public static String getResumeidFromUri(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }
}
