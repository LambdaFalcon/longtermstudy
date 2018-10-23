package usi.memotion.local.database.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import usi.memotion.local.database.tables.AccelerometerTable;
import usi.memotion.local.database.tables.ActivityRecognitionTable;
import usi.memotion.local.database.tables.AnxietySurveyTable;
import usi.memotion.local.database.tables.ApplicationLogsTable;
import usi.memotion.local.database.tables.BlueToothTable;
import usi.memotion.local.database.tables.FatigueSurveyTable;
import usi.memotion.local.database.tables.LectureSurveyTable;
import usi.memotion.local.database.tables.NotificationsTable;
import usi.memotion.local.database.tables.PAMTable;
import usi.memotion.local.database.tables.PSQISurveyTable;
import usi.memotion.local.database.tables.PSSSurveyTable;
import usi.memotion.local.database.tables.PersonalitySurveyTable;
import usi.memotion.local.database.tables.PhoneCallLogTable;
import usi.memotion.local.database.tables.LocationTable;
import usi.memotion.local.database.tables.PhoneLockTable;
import usi.memotion.local.database.tables.SMSTable;
import usi.memotion.local.database.tables.SWLSSurveyTable;
import usi.memotion.local.database.tables.SimpleMoodTable;
import usi.memotion.local.database.tables.SleepQualityTable;
import usi.memotion.local.database.tables.UploaderUtilityTable;
import usi.memotion.local.database.tables.UserTable;
import usi.memotion.local.database.tables.WiFiTable;

/**
 * Created by shkurtagashi on 29/12/16.
 */

public class LocalSQLiteDBHelper extends SQLiteOpenHelper {
    //db information
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "Memotion";

    private SQLiteDatabase db;


    public LocalSQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create actual data table
        db.execSQL(LocationTable.getCreateQuery());
        db.execSQL(AccelerometerTable.getCreateQuery());
        db.execSQL(PhoneCallLogTable.getCreateQuery());
        db.execSQL(SMSTable.getCreateQuery());
        db.execSQL(BlueToothTable.getCreateQuery());
        db.execSQL(PhoneLockTable.getCreateQuery());
        db.execSQL(WiFiTable.getCreateQuery());
        db.execSQL(UploaderUtilityTable.getCreateQuery());
        db.execSQL(UserTable.getCreateQuery());
        db.execSQL(SimpleMoodTable.getCreateQuery());
        db.execSQL(PAMTable.getCreateQuery());
        db.execSQL(LectureSurveyTable.getCreateQuery());
        db.execSQL(NotificationsTable.getCreateQuery());
        db.execSQL(ApplicationLogsTable.getCreateQuery());
        db.execSQL(ActivityRecognitionTable.getCreateQuery());
        db.execSQL(PersonalitySurveyTable.getCreateQuery());
        db.execSQL(SWLSSurveyTable.getCreateQuery());
        db.execSQL(PSSSurveyTable.getCreateQuery());
        db.execSQL(PSQISurveyTable.getCreateQuery());
        db.execSQL(SleepQualityTable.getCreateQuery());
        db.execSQL(FatigueSurveyTable.getCreateQuery());


        //insert init data to uploader_utility table
        insertRecords(db, UploaderUtilityTable.TABLE_UPLOADER_UTILITY, UploaderUtilityTable.getRecords());

        Log.d("DATABASE HELPER", "Db created");
    }

    /**
     * Utility function to insert the given records in the given table.
     *
     * @param db
     * @param tableName
     * @param records
     */
    private void insertRecords(SQLiteDatabase db, String tableName, List<ContentValues> records) {
        for(ContentValues record: records) {
            Log.d("DBHelper", "Inserting into table " + tableName + " record " + record.toString());
            db.insert(tableName, null, record);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DBHelper", "Upgrading db. Truncating accelerometer");
        db.execSQL("delete from "+ AccelerometerTable.TABLE_ACCELEROMETER);
        return;
    }
}
