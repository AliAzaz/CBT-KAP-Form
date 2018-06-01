package edu.aku.hassannaqvi.cbt_kap_form.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.cbt_kap_form.R;
import edu.aku.hassannaqvi.cbt_kap_form.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbt_kap_form.core.MainApp;
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionCBinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

public class SectionCActivity extends AppCompatActivity {
ActivitySectionCBinding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_section_c);
        bi.setCallback(this);
        this.setTitle("Section C and D");

setUpActivity();
    }

    private void setUpActivity() {
        bi.ckc0799.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    bi.ckc07a.setChecked(false);
                    bi.ckc07b.setChecked(false);
                    bi.ckc07c.setChecked(false);
                    bi.ckc07d.setChecked(false);
                    bi.ckc0788.setChecked(false);
                    bi.ckc07a.setEnabled(false);
                    bi.ckc07b.setEnabled(false);
                    bi.ckc07c.setEnabled(false);
                    bi.ckc07d.setEnabled(false);
                    bi.ckc0788.setEnabled(false);
                }else {
                    bi.ckc07a.setEnabled(true);
                    bi.ckc07b.setEnabled(true);
                    bi.ckc07c.setEnabled(true);
                    bi.ckc07d.setEnabled(true);
                    bi.ckc0788.setEnabled(true);
                }
            }
        });
        bi.ckd0199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.ckd01a.setChecked(false);
                    bi.ckd01b.setChecked(false);
                    bi.ckd01c.setChecked(false);
                    bi.ckd01d.setChecked(false);
                    bi.ckd0188.setChecked(false);
                    bi.ckd01a.setEnabled(false);
                    bi.ckd01b.setEnabled(false);
                    bi.ckd01c.setEnabled(false);
                    bi.ckd01d.setEnabled(false);
                    bi.ckd0188.setEnabled(false);
                }else {
                    bi.ckd01a.setEnabled(true);
                    bi.ckd01b.setEnabled(true);
                    bi.ckd01c.setEnabled(true);
                    bi.ckd01d.setEnabled(true);
                    bi.ckd0188.setEnabled(true);
                }
            }
        });
    }


    public void BtnEnd() {
        MainApp.endActivity(this, this);
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

                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {
        if (!validatorClass.EmptyRadioButton(this, bi.ckc01, bi.ckc01c,bi.ckc01cx, getString(R.string.ckc01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ckc02, bi.ckc02c,bi.ckc02cx, getString(R.string.ckc02))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ckc03, bi.ckc03c,bi.ckc03cx, getString(R.string.ckc03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ckc04, bi.ckc04c,bi.ckc04cx, getString(R.string.ckc04))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ckc05, bi.ckc05c,bi.ckc05cx, getString(R.string.ckc05))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ckc06, bi.ckc06c,bi.ckc06cx, getString(R.string.ckc06))) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, bi.ckc07, bi.ckc0788,bi.ckc0788x, getString(R.string.ckc07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.ckc08, bi.ckc08c,bi.ckc08cx, getString(R.string.ckc08))) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, bi.ckd01, bi.ckd0188,bi.ckd0188x, getString(R.string.ckd01))) {
            return false;
        }

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sC = new JSONObject();
        sC.put("ckc01", bi.ckc01a.isChecked() ? "1"
                : bi.ckc01b.isChecked() ? "2"
                : bi.ckc01c.isChecked() ? "3"
                : "0");
        sC.put("ckc01cx", bi.ckc01cx.getText().toString());
        
        sC.put("ckc02", bi.ckc02a.isChecked() ? "1"
                : bi.ckc02b.isChecked() ? "2"
                : bi.ckc02c.isChecked() ? "3"
                : "0");
        sC.put("ckc02cx", bi.ckc02cx.getText().toString());
        
        sC.put("ckc03", bi.ckc03a.isChecked() ? "1"
                : bi.ckc03b.isChecked() ? "2"
                : bi.ckc03c.isChecked() ? "3"
                : "0");
        sC.put("ckc03cx", bi.ckc03cx.getText().toString());
        sC.put("ckc04", bi.ckc04a.isChecked() ? "1"
                : bi.ckc04b.isChecked() ? "2"
                : bi.ckc04c.isChecked() ? "3"
                : "0");
        sC.put("ckc04cx", bi.ckc04cx.getText().toString());
        sC.put("ckc05", bi.ckc05a.isChecked() ? "1"
                : bi.ckc05b.isChecked() ? "2"
                : bi.ckc05c.isChecked() ? "3"
                : "0");
        sC.put("ckc05cx", bi.ckc05cx.getText().toString());

        sC.put("ckc06", bi.ckc06a.isChecked() ? "1"
                : bi.ckc06b.isChecked() ? "2"
                : bi.ckc06c.isChecked() ? "3"
                : "0");
        sC.put("ckc06cx", bi.ckc06cx.getText().toString());


        sC.put("ckc07a", bi.ckc07a.isChecked() ? "1" : "0");
        sC.put("ckc07b", bi.ckc07b.isChecked() ? "2" : "0");
        sC.put("ckc07c", bi.ckc07c.isChecked() ? "3" : "0");
        sC.put("ckc07d", bi.ckc07d.isChecked() ? "4" : "0");
        sC.put("ckc0799", bi.ckc0799.isChecked() ? "99" : "0");
        sC.put("ckc0788", bi.ckc0788.isChecked() ? "88" : "0");
        sC.put("ckc0788x", bi.ckc0788x.getText().toString());

        sC.put("ckc08", bi.ckc08a.isChecked() ? "1"
                : bi.ckc08b.isChecked() ? "2"
                : bi.ckc08c.isChecked() ? "3"
                : "0");
        sC.put("ckc08cx", bi.ckc08cx.getText().toString());


        sC.put("ckd01a", bi.ckd01a.isChecked() ? "1" : "0");
        sC.put("ckd01b", bi.ckd01b.isChecked() ? "2" : "0");
        sC.put("ckd01c", bi.ckd01c.isChecked() ? "3" : "0");
        sC.put("ckd01d", bi.ckd01d.isChecked() ? "4" : "0");
        sC.put("ckd0199", bi.ckd0199.isChecked() ? "99" : "0");
        sC.put("ckd0188", bi.ckd0188.isChecked() ? "88" : "0");
        sC.put("ckd0188x", bi.ckd0188x.getText().toString());

        MainApp.fc.setsCD(String.valueOf(sC));

    }
    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

       int updcount = db.updatesCD();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
