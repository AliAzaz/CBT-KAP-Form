package edu.aku.hassannaqvi.cbt_kap_form.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import org.json.JSONArray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.cbt_kap_form.R;
import edu.aku.hassannaqvi.cbt_kap_form.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbt_kap_form.core.MainApp;
import edu.aku.hassannaqvi.cbt_kap_form.get.GetAllData;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements LoaderCallbacks<Cursor> {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "test1234:test1234", "testS12345:testS12345", "bar@example.com:world"
    };
    // District Spinner
    public ArrayList<String> lables;
    public ArrayList<String> values;
    public Map<String, String> valuesnlabels;
    // UI references.
    @BindView(R.id.login_progress)
    ProgressBar mProgressView;
    @BindView(R.id.login_form)
    ScrollView mLoginFormView;
    @BindView(R.id.email)
    EditText mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.email2)
    EditText mEmailView2;
    @BindView(R.id.password2)
    EditText mPasswordView2;

    @BindView(R.id.txtinstalldate)
    TextView txtinstalldate;
    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;
    @BindView(R.id.spUC)
    Spinner spUC;

    @BindView(R.id.syncData)
    Button syncData;

    @BindView(R.id.testing)
    TextView testing;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    String DirectoryName;

    private UserLoginTask mAuthTask = null;
    private StringBuffer jsonString_output;
    private JSONArray json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        MainApp.loginMem = new String[3];
        MainApp.loginMem[0] = "...";    //default value

        try {
            long installedOn = this
                    .getPackageManager()
                    .getPackageInfo("edu.aku.hassannaqvi.wfp_recruit_form", 0)
                    .lastUpdateTime;
            Integer versionCode = this
                    .getPackageManager()
                    .getPackageInfo("edu.aku.hassannaqvi.wfp_recruit_form", 0)
                    .versionCode;
            String versionName = this
                    .getPackageManager()
                    .getPackageInfo("edu.aku.hassannaqvi.wfp_recruit_form", 0)
                    .versionName;
            txtinstalldate.setText("Ver. " + versionName + "." + String.valueOf(versionCode) + " \r\n( Last Updated: " + new SimpleDateFormat("dd MMM. yyyy").format(new Date(installedOn)) + " )");

            MainApp.versionCode = versionCode;
            MainApp.versionName = versionName;


        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // Set up the login form.
        mEmailView = findViewById(R.id.email);
        populateAutoComplete();


        mPasswordView = findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    MainApp.loginMem[1] = mEmailView.getText().toString();


                    return true;

                }
                return false;
            }
        });

        mEmailView2 = findViewById(R.id.email2);
        populateAutoComplete();
        mPasswordView2 = findViewById(R.id.password2);
        mPasswordView2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    MainApp.loginMem[2] = mEmailView2.getText().toString();
                    return true;
                }
                return false;
            }
        });

        Target viewTarget = new ViewTarget(R.id.syncData, this);

        new ShowcaseView.Builder(this)
                .setTarget(viewTarget)
                .setStyle(R.style.CustomShowcaseTheme)
                .setContentText("\n\nPlease Sync Data before login...")
                .singleShot(42)
                .build();

        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        // District Spinner
        // Populate from District Table
       /* ArrayList<UCContract> ucList = new ArrayList<UCContract>();
        ucList = db.getAllUC();*/


//        DB backup

        dbBackup();

//        Testing visibility
        if (Integer.valueOf(MainApp.versionName.split("\\.")[0]) > 0) {
            testing.setVisibility(View.GONE);
        } else {
            testing.setVisibility(View.VISIBLE);
        }
    }


    public void dbBackup() {

        sharedPref = getSharedPreferences("cbt_kap_form", MODE_PRIVATE);
        editor = sharedPref.edit();

        if (sharedPref.getBoolean("flag", false)) {

            String dt = sharedPref.getString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()).toString());

            if (dt != new SimpleDateFormat("dd-MM-yy").format(new Date()).toString()) {
                editor.putString("dt", new SimpleDateFormat("dd-MM-yy").format(new Date()).toString());

                editor.commit();
            }

            File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "DMU-CBT-KAP");
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdirs();
            }
            if (success) {

                DirectoryName = folder.getPath() + File.separator + sharedPref.getString("dt", "");
                folder = new File(DirectoryName);
                if (!folder.exists()) {
                    success = folder.mkdirs();
                }
                if (success) {

                    try {
                        File dbFile = new File(this.getDatabasePath(DatabaseHelper.DATABASE_NAME).getPath());
                        FileInputStream fis = new FileInputStream(dbFile);

                        String outFileName = DirectoryName + File.separator +
                                DatabaseHelper.DB_NAME;

                        // Open the empty db as the output stream
                        OutputStream output = new FileOutputStream(outFileName);

                        // Transfer bytes from the inputfile to the outputfile
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            output.write(buffer, 0, length);
                        }
                        // Close the streams
                        output.flush();
                        output.close();
                        fis.close();
                    } catch (IOException e) {
                        Log.e("dbBackup:", e.getMessage());
                    }

                }

            } else {
                Toast.makeText(this, "Not create folder", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @OnClick(R.id.syncData)
    void onSyncDataClick() {
        //TODO implement

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new syncData(this).execute();


        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    private void populateAutoComplete() {
        getLoaderManager().initLoader(0, null, this);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        mEmailView2.setError(null);
        mPasswordView2.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        String email2 = mEmailView2.getText().toString();
        String password2 = mPasswordView2.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        if (!TextUtils.isEmpty(password2) && !isPasswordValid(password2)) {
            mPasswordView2.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView2;
            cancel = true;
        }

        if (TextUtils.isEmpty(email2)) {
            mEmailView2.setError(getString(R.string.error_field_required));
            focusView = mEmailView2;
            cancel = true;
        } /*else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }*/

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } /*else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }*/


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password, email2, password2);
            mAuthTask.execute((Void) null);


        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }


    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 7;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    @OnClick(edu.aku.hassannaqvi.cbt_kap_form.R.id.showPassword)
    void onShowPasswordClick() {
        //TODO implement
        if (mPasswordView.getTransformationMethod() == null) {
            mPasswordView.setTransformationMethod(new PasswordTransformationMethod());
            mPasswordView.setCompoundDrawablesWithIntrinsicBounds(edu.aku.hassannaqvi.cbt_kap_form.R.drawable.ic_lock_black_24dp, 0, 0, 0);
        } else {
            mPasswordView.setTransformationMethod(null);
            mPasswordView.setCompoundDrawablesWithIntrinsicBounds(edu.aku.hassannaqvi.cbt_kap_form.R.drawable.ic_lock_open_black_24dp, 0, 0, 0);
        }
    }

    @OnClick(R.id.showPassword2)
    void onShowPasswordClick2() {
        //TODO implement
        if (mPasswordView2.getTransformationMethod() == null) {
            mPasswordView2.setTransformationMethod(new PasswordTransformationMethod());
            mPasswordView2.setCompoundDrawablesWithIntrinsicBounds(edu.aku.hassannaqvi.cbt_kap_form.R.drawable.ic_lock_black_24dp, 0, 0, 0);
        } else {
            mPasswordView2.setTransformationMethod(null);
            mPasswordView2.setCompoundDrawablesWithIntrinsicBounds(edu.aku.hassannaqvi.cbt_kap_form.R.drawable.ic_lock_open_black_24dp, 0, 0, 0);
        }
    }

    public void gotoMain(View v) {

        finish();

        Intent im = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(im);
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        private final String mEmail2;
        private final String mPassword2;

        UserLoginTask(String email, String password, String email2, String password2) {
            mEmail = email;
            mPassword = password;

            mEmail2 = email2;
            mPassword2 = password2;
        }


        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                DatabaseHelper db = new DatabaseHelper(LoginActivity.this);
                if ((mEmail.equals("dmu@aku") && mPassword.equals("aku?dmu")) || db.Login(mEmail, mPassword) ||
                        (mEmail.equals("test1234") && mPassword.equals("test1234"))
                        || (mEmail.equals("test12345") && mPassword.equals("test12345"))) {
                    MainApp.userName = mEmail;

                    if ((mEmail2.equals("dmu@aku") && mPassword2.equals("aku?dmu")) || db.Login(mEmail2, mPassword2) ||
                            (mEmail2.equals("test1234") && mPassword2.equals("test1234")) || (mEmail2.equals("test12345") && mPassword2.equals("test12345"))) {
                        if (!mEmail.equals(mEmail2)) {

                            MainApp.userName2 = mEmail2;
                            MainApp.admin = mEmail2.contains("@");

                            finish();

                            Intent iLogin = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(iLogin);
                        } else {
                            mEmailView2.setError("Same username..");
                            mEmailView2.requestFocus();
                        }

                    } else {
                        mPasswordView2.setError(getString(R.string.error_incorrect_password));
                        mPasswordView2.requestFocus();
                        Toast.makeText(LoginActivity.this, mEmail2 + " " + mPassword2, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    mPasswordView.requestFocus();
                    Toast.makeText(LoginActivity.this, mEmail + " " + mPassword, Toast.LENGTH_SHORT).show();
                }
            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        LoginActivity.this);
                alertDialogBuilder
                        .setMessage("GPS is disabled in your device. Enable it?")
                        .setCancelable(false)
                        .setPositiveButton("Enable GPS",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        Intent callGPSSettingIntent = new Intent(
                                                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                        startActivity(callGPSSettingIntent);
                                    }
                                });
                alertDialogBuilder.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }

        }


        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }


    public class syncData extends AsyncTask<String, String, String> {

        private Context mContext;

        public syncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                 /*   Toast.makeText(LoginActivity.this, "Sync User", Toast.LENGTH_LONG).show();
                    new GetUsers(mContext).execute();
                    Toast.makeText(LoginActivity.this, "Sync Tehsil's", Toast.LENGTH_LONG).show();
                    new GetTehsil(mContext).execute();
                    Toast.makeText(LoginActivity.this, "Sync UC's", Toast.LENGTH_LONG).show();
                    new GetUCs(mContext).execute();
                    Toast.makeText(LoginActivity.this, "Sync Villages", Toast.LENGTH_LONG).show();
                    new GetVillages(mContext).execute();
                    Toast.makeText(LoginActivity.this, "Sync NGOs", Toast.LENGTH_LONG).show();
                    new GetSources(mContext).execute();
                    Toast.makeText(LoginActivity.this, "Sync LHWs", Toast.LENGTH_LONG).show();
                    new GetLHWs(mContext).execute();
*/

                    Toast.makeText(LoginActivity.this, "Sync Enum Blocks", Toast.LENGTH_LONG).show();
                    // new GetAllData(mContext, "EnumBlock").execute();
                    Toast.makeText(LoginActivity.this, "Sync Users", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "User").execute();
                    Toast.makeText(LoginActivity.this, "Sync UC's", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "UCs").execute();
                    Toast.makeText(LoginActivity.this, "Sync Villages", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "Villages").execute();
                    Toast.makeText(LoginActivity.this, "Sync LHWs", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "LHW").execute();
                    Toast.makeText(LoginActivity.this, "Sync Tehsil", Toast.LENGTH_LONG).show();
                    new GetAllData(mContext, "Tehsil").execute();
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    editor.putBoolean("flag", true);
                    editor.commit();

                    dbBackup();

                }
            }, 1200);
        }
    }


}

