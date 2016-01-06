package com.swiftdeal.resume.builder;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by abhishek on 30-12-2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="resumebuild";
    private static final int DATABASE_VERSION = 6;

    public DbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
                        final String table = "create table "+resumecontract.Resumeentry.TABLE_NAME+
                        "("+resumecontract.Resumeentry.COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        resumecontract.Resumeentry.COLUMN_NAME+" TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_COLNAME +" TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_DOB + " DATE NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_FATHERNAME + " TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_EMAIL + " TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_ADDRESS + " TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_MOBNO + " BIGINT(20) NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_SEX + " TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_MARITAL + " TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_QUALIFICATION1 + " TEXT NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_COLLEGE1 + " TEXT NOT NULL, " +
                        resumecontract.Resumeentry.COLUMN_UNIVERSITY1 + " TEXT NOT NULL, " +
                        resumecontract.Resumeentry.COLUMN_PER1 + " REAL NOT NULL, "+
                        resumecontract.Resumeentry.COLUMN_YEAR1 +" INTEGER NOT NULL, " +
                                resumecontract.Resumeentry.COLUMN_QUALIFICATION2 + " TEXT, "+
                                resumecontract.Resumeentry.COLUMN_COLLEGE2 + " TEXT, " +
                                resumecontract.Resumeentry.COLUMN_UNIVERSITY2 + " TEXT, " +
                                resumecontract.Resumeentry.COLUMN_PER2 + " REAL, "+
                                resumecontract.Resumeentry.COLUMN_YEAR2 +" INTEGER, " +
                                resumecontract.Resumeentry.COLUMN_QUALIFICATION3 + " TEXT NOT NULL, "+
                                resumecontract.Resumeentry.COLUMN_COLLEGE3 + " TEXT NOT NULL, " +
                                resumecontract.Resumeentry.COLUMN_UNIVERSITY3 + " TEXT NOT NULL, " +
                                resumecontract.Resumeentry.COLUMN_PER3+ " REAL NOT NULL, "+
                                resumecontract.Resumeentry.COLUMN_YEAR3 +" INTEGER NOT NULL, " +
                                resumecontract.Resumeentry.COLUMN_QUALIFICATION4 + " TEXT NOT NULL, "+
                                resumecontract.Resumeentry.COLUMN_COLLEGE4 + " TEXT NOT NULL, " +
                                resumecontract.Resumeentry.COLUMN_UNIVERSITY4 + " TEXT NOT NULL, " +
                                resumecontract.Resumeentry.COLUMN_PER4 + " REAL NOT NULL, "+
                                resumecontract.Resumeentry.COLUMN_YEAR4 +" INTEGER NOT NULL, "+
                                resumecontract.Resumeentry.COLUMN_ACHIEVEMENTS +" TEXT, " +
                                resumecontract.Resumeentry.COLUMN_HOBBIES + " TEXT, "+
                                resumecontract.Resumeentry.COLUMN_PROJECT1 + " TEXT, "+
                                resumecontract.Resumeentry.COLUMN_PROJECT2 + " TEXT, " +
                                resumecontract.Resumeentry.COLUMN_PROJECT3 + " TEXT, "+
                                resumecontract.Resumeentry.COLUMN_PROJECT4 + " TEXT, " +
                                resumecontract.Resumeentry.COLUMN_INTEREST + " TEXT);";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + resumecontract.Resumeentry.TABLE_NAME);
        onCreate(db);
    }
}
