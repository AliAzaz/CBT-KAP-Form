package edu.aku.hassannaqvi.cbt_kap_form.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import edu.aku.hassannaqvi.cbt_kap_form.R;
import edu.aku.hassannaqvi.cbt_kap_form.contracts.ChildContract;
import edu.aku.hassannaqvi.cbt_kap_form.contracts.FormsContract;
import edu.aku.hassannaqvi.cbt_kap_form.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbt_kap_form.core.MainApp;
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

public class SectionAActivity extends AppCompatActivity {

    private static final String TAG = SectionAActivity.class.getName();
    ActivitySectionABinding bi;
    DatabaseHelper db;
    ChildContract childContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        this.setTitle("Section A");

        db = new DatabaseHelper(this);

        setupListener();

    }

    public void setupListener() {
        bi.cka01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.fldGrpcka01.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void BtnEnd() {

        if (!bi.cka01.getText().toString().isEmpty()) {
            MainApp.endActivity(this, this);
        } else {
            bi.cka01.setError("Requires Child ID!!");
        }
    }

    public void BtnCheckChild() {

        if (!bi.cka01.getText().toString().isEmpty()) {

            bi.cka01.setError(null);

            childContract = db.getFollowUpChildData(bi.cka01.getText().toString());

            if (childContract != null) {

                bi.fldGrpcka01.setVisibility(View.VISIBLE);

                bi.cka02.setText(childContract.getChname().toString());

                bi.cka03.clearCheck();
                for (int i = 0; i < bi.cka03.getChildCount(); i++) {
                    View v = bi.cka03.getChildAt(i);
                    if (v instanceof RadioButton) {
                        RadioButton rb = (RadioButton) v;
                        rb.setEnabled(false);
                    }
                }

                bi.cka03.check(childContract.getStudy_arm().equals("1") ? bi.cka03a.getId() :
                        childContract.getStudy_arm().equals("2") ? bi.cka03b.getId() :
                                childContract.getStudy_arm().equals("3") ? bi.cka03c.getId() :
                                        childContract.getStudy_arm().equals("4") ? bi.cka03d.getId() :
                                                bi.cka03e.getId()
                );


            } else {
                Toast.makeText(this, "Sorry!! Child not found.", Toast.LENGTH_SHORT).show();
            }
        } else {
            bi.cka01.setError("Requires Child ID!!");
        }
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionBActivity.class)
                        .putExtra("skipFlag", childContract.getStudy_arm().equals("1")
                                || childContract.getStudy_arm().equals("2")
                                || childContract.getStudy_arm().equals("3")));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void SaveDraft() throws JSONException {

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);

        MainApp.fc = new FormsContract();

        MainApp.fc.setdevicetagID(sharedPref.getString("tagName", null));
        MainApp.fc.setformDate((DateFormat.format("dd-MM-yyyy HH:mm", new Date())).toString());
        MainApp.fc.setuser(MainApp.userName);
        MainApp.fc.setdeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setappVersion(MainApp.versionName + "." + MainApp.versionCode);

        MainApp.fc.setchild_id(bi.cka01.getText().toString());
        MainApp.fc.setchild_name(bi.cka02.getText().toString());
        MainApp.fc.setstudy_arm(bi.cka03a.isChecked() ? "1" : bi.cka03b.isChecked() ? "2"
                : bi.cka03c.isChecked() ? "3" : bi.cka03d.isChecked() ? "4" : bi.cka03e.isChecked() ? "5" : "0");

        JSONObject sA = new JSONObject();
        sA.put("child_uid", childContract.getUID());
        sA.put("child_f_name", childContract.getFname());
        sA.put("child_m_name", childContract.getMname());

        MainApp.fc.setsA(String.valueOf(sA));

        setGPS();
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.cka01, getString(R.string.cka01))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.cka03, bi.cka03e, getString(R.string.cka03))) {
            return false;
        }

        return true;
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            MainApp.fc.setgpsLat(lat);
            MainApp.fc.setgpsLng(lang);
            MainApp.fc.setgpsAcc(acc);
            MainApp.fc.setgpsDT(date); // Timestamp is converted to date above
            MainApp.fc.setgpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    private boolean UpdateDB() {
        Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        rowId = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(rowId));

        if (rowId != null) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            MainApp.fc.set_UID(
                    (MainApp.fc.getdeviceID() + MainApp.fc.get_ID()));

            // Update UID of Last Inserted Form
            db.updateFormUID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
