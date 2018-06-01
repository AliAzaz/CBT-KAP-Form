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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

import edu.aku.hassannaqvi.cbt_kap_form.R;
import edu.aku.hassannaqvi.cbt_kap_form.contracts.FormsContract;
import edu.aku.hassannaqvi.cbt_kap_form.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbt_kap_form.core.MainApp;
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

public class SectionAActivity extends AppCompatActivity {

    private static final String TAG = SectionAActivity.class.getName();
    ActivitySectionABinding bi;
    DatabaseHelper db;

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
        MainApp.endActivity(this, this);
    }

    public void BtnCheckChild() {

        if (formValidation()) {

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

                startActivity(new Intent(this, SectionBActivity.class));

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

        JSONObject sA = new JSONObject();

        MainApp.fc.setsA(String.valueOf(sA));

        setGPS();
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.cka01, getString(R.string.cka01))) {
            return false;
        }
        return true;
    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);

//        String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String dt = GPSPref.getString("Time", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            MainApp.fc.setgpsLat(GPSPref.getString("Latitude", "0"));
            MainApp.fc.setgpsLng(GPSPref.getString("Longitude", "0"));
            MainApp.fc.setgpsAcc(GPSPref.getString("Accuracy", "0"));
            MainApp.fc.setgpsDT(date); // Timestamp is converted to date above

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
//            db.updateFormsUID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
