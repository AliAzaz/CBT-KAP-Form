package edu.aku.hassannaqvi.cbt_kap_form.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static edu.aku.hassannaqvi.cbt_kap_form.contracts.FormsContract.CONTENT_AUTHORITY;
import static edu.aku.hassannaqvi.cbt_kap_form.contracts.FormsContract.FormsTable;
import static edu.aku.hassannaqvi.cbt_kap_form.contracts.FormsContract.PATH_FORMS;


public class MainContentProvider extends ContentProvider {
    //private static UriMatcher sUriMatcher = buildUriMatcher();
    public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY + "/" + PATH_FORMS);
    private static final int FORMS = 100;
    private static final int FORMS_UID = 110;
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static String TAG = MainContentProvider.class.getSimpleName();

    static {
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_FORMS, FORMS_UID);
        uriMatcher.addURI(CONTENT_AUTHORITY, PATH_FORMS + "/#", FORMS_UID);
    }

    private DatabaseHelper dbhelper;

/*    private static UriMatcher buildUriMatcher(){

        // Initalize
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

        final String authority = FormsContract.CONTENT_AUTHORITY;

        // See if matches country records
        matcher.addURI(authority, "forms", FORMS);

        // See if matches country item
        matcher.addURI(authority, "forms/#", FORMS_UID);

        return matcher;
    }*/

    @Override
    public boolean onCreate() {
        dbhelper = new DatabaseHelper(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        //final int match = sUriMatcher.match(uri);
        switch (uriMatcher.match(uri)) {
            case FORMS:
                return FormsTable.CONTENT_TYPE;
            case FORMS_UID:
                return FormsTable.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI : " + uri);
        }

    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.v(TAG, "insert(uri=" + uri + ", values=" + values.toString());

        final SQLiteDatabase db = dbhelper.getWritableDatabase();

        long id = db.insert(FormsTable.TABLE_NAME, null, values);

        switch (uriMatcher.match(uri)) {
            case FORMS:
                // Create a new record
                long recordId = db.insertOrThrow(FormsTable.TABLE_NAME, null, values);
                return FormsTable.buildCountryUri(String.valueOf(recordId));
            default:
                throw new IllegalArgumentException("Unknown URI : " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
