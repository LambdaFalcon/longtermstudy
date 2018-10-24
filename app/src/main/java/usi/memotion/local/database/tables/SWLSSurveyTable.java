package usi.memotion.local.database.tables;

import android.provider.BaseColumns;

/**
 * Created by biancastancu
 */
public class SWLSSurveyTable {
    public final static String TABLE_SWLSS_SURVEY = "SWLSSSurvey";

    public final static String _ID = BaseColumns._ID;
    public final static String TIMESTAMP = "timestamp";
    public final static String QUESTION_1 = "question1";
    public final static String QUESTION_2 = "question2";
    public final static String QUESTION_3 = "question3";
    public final static String QUESTION_4 = "question4";
    public final static String QUESTION_5 = "question5";

    public static String getCreateQuery() {
        return "CREATE TABLE " + TABLE_SWLSS_SURVEY + "("
                + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TIMESTAMP + " REAL, "
                + QUESTION_1 + " TEXT, "
                + QUESTION_2 + " TEXT, "
                + QUESTION_3 + " TEXT, "
                + QUESTION_4 + " TEXT, "
                + QUESTION_5 + " TEXT )";
    }


    public static String[] getColumns(){
        String[] columns = {_ID, TIMESTAMP, QUESTION_1, QUESTION_2, QUESTION_3, QUESTION_4, QUESTION_5};

        return columns;
    }
}
