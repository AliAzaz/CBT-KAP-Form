package edu.aku.hassannaqvi.cbt_kap_form.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.cbt_kap_form.contracts.FormsContract;
import edu.aku.hassannaqvi.cbt_kap_form.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.cbt_kap_form.contracts.UsersContract;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.UsersTable.TABLE_NAME + "("
            + UsersContract.UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.UsersTable.ROW_USERNAME + " TEXT,"
            + UsersContract.UsersTable.ROW_PASSWORD + " TEXT );";
    public static final String DATABASE_NAME = "cbt_kap_form.db";
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_copy.");
    public static final String PROJECT_NAME = "CBT-KAP-FORM";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FormsTable.COLUMN_PROJECTNAME + " TEXT," +
            FormsTable.COLUMN_SURVEYTYPE + " TEXT," +
            FormsTable.COLUMN_UID + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_INTERVIEWER01 + " TEXT,"+
            FormsTable.COLUMN_INTERVIEWER02 + " TEXT,"+
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88X + " TEXT," +
            FormsTable.COLUMN_SINFO + " TEXT," +
            FormsTable.COLUMN_sA + " TEXT," +
            FormsTable.COLUMN_SC + " TEXT," +
            FormsTable.COLUMN_SD + " TEXT," +
            FormsTable.COLUMN_SG + " TEXT," +
            FormsTable.COLUMN_SH + " TEXT," +
            FormsTable.COLUMN_SI + " TEXT," +
            FormsTable.COLUMN_SJ + " TEXT," +
            FormsTable.COLUMN_SK + " TEXT," +
            FormsTable.COLUMN_SLMO + " TEXT," +
            FormsTable.COLUMN_SE + " TEXT," +
            FormsTable.COLUMN_SF + " TEXT," +
            FormsTable.COLUMN_COUNT + " TEXT," +
            FormsTable.COLUMN_ENDINGDATETIME + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDT + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_GPSELEV + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT," +
            FormsTable.COLUMN_APPVERSION + " TEXT"
            + " );";


    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + UsersContract.UsersTable.TABLE_NAME;
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;


    private final String TAG = "DatabaseHelper";


    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);
    }

    public ArrayList<UsersContract> getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<UsersContract> userList = null;
        try {
            userList = new ArrayList<UsersContract>();
            String QUERY = "SELECT * FROM " + UsersContract.UsersTable.TABLE_NAME;
            Cursor cursor = db.rawQuery(QUERY, null);
            int num = cursor.getCount();
            if (!cursor.isLast()) {
                while (cursor.moveToNext()) {
                    UsersContract user = new UsersContract();
                    user.setId(cursor.getInt(0));
                    user.setUserName(cursor.getString(1));
                    user.setPassword(cursor.getString(2));
                    userList.add(user);
                }
            }
            db.close();
        } catch (Exception e) {
        }
        return userList;
    }

    public void syncUsers(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.UsersTable.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);
                String userName = jsonObjectUser.getString("username");
                String password = jsonObjectUser.getString("password");


                ContentValues values = new ContentValues();

                values.put(UsersContract.UsersTable.ROW_USERNAME, userName);
                values.put(UsersContract.UsersTable.ROW_PASSWORD, password);
                db.insert(UsersContract.UsersTable.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
        }
    }

    public boolean Login(String username, String password) throws SQLException {

        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        String[] columns = {
                UsersContract.UsersTable._ID
        };

// Which row to update, based on the ID
        String selection = UsersContract.UsersTable.ROW_USERNAME + " = ?" + " AND " + UsersContract.UsersTable.ROW_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(UsersContract.UsersTable.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        return cursorCount > 0;
    }

    public List<FormsContract> getFormsByDSS(String dssID) {
        List<FormsContract> formList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + FormsTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                FormsContract fc = new FormsContract();
                formList.add(fc.Hydrate(c));
            } while (c.moveToNext());
        }

        // return contact list
        return formList;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECTNAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_SURVEYTYPE, fc.getSurveyType());
        values.put(FormsTable.COLUMN_UID, fc.getUID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_INTERVIEWER01, fc.getInterviewer01());
        values.put(FormsTable.COLUMN_INTERVIEWER02, fc.getInterviewer02());

        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88X, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_SINFO, fc.getsInfo());
        values.put(FormsTable.COLUMN_sA, fc.getsA());
        values.put(FormsTable.COLUMN_SC, fc.getsG());
        values.put(FormsTable.COLUMN_SD, fc.getsC());
        values.put(FormsTable.COLUMN_SG, fc.getsD());
        values.put(FormsTable.COLUMN_SH, fc.getsH());
        values.put(FormsTable.COLUMN_SI, fc.getsI());
        values.put(FormsTable.COLUMN_SJ, fc.getsJ());
        values.put(FormsTable.COLUMN_SK, fc.getsK());
        values.put(FormsTable.COLUMN_SLMO, fc.getsLMO());
        values.put(FormsTable.COLUMN_SE, fc.getsE());
        values.put(FormsTable.COLUMN_SF, fc.getsF());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.getEndingdatetime());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDT, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_GPSELEV, fc.getGpsElev());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());
        values.put(FormsTable.COLUMN_APPVERSION, fc.getAppversion());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.getUID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public Collection<FormsContract> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN_PROJECTNAME,
                FormsTable.COLUMN_SURVEYTYPE,
                FormsTable.COLUMN_ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_INTERVIEWER01,
                FormsTable.COLUMN_INTERVIEWER02,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88X,
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_sA,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
                FormsTable.COLUMN_SLMO,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_COUNT,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDT,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_GPSELEV,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APPVERSION

        };
        String whereClause = FormsTable.COLUMN_SYNCED + " is null OR " + FormsTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<FormsContract> getTodayForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                //ChildTable.COLUMN_DSSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable._ID)));
                fc.setFormDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMDATE)));
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }


    public int updatesA() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_sA, MainApp.fc.getsA());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSC() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SC, MainApp.fc.getsC());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSD() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SD, MainApp.fc.getsD());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSE() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SE, MainApp.fc.getsE());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSF() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SF, MainApp.fc.getsF());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSG() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SG, MainApp.fc.getsG());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSH() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SH, MainApp.fc.getsH());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSI() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SI, MainApp.fc.getsI());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSJ() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SJ, MainApp.fc.getsJ());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSK() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SK, MainApp.fc.getsK());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSLMO() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SLMO, MainApp.fc.getsLMO());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88X, MainApp.fc.getIstatus88x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, MainApp.fc.getEndingdatetime());


// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
}