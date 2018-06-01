package edu.aku.hassannaqvi.cbt_kap_form.ui;

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
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionFghBinding;

public class SectionFGHActivity extends AppCompatActivity {
    ActivitySectionFghBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_fgh);
        bi.setCallback(this);
        this.setTitle("Section F,G and H");
        setUpActivity();
    }

    private void setUpActivity() {
        bi.ckf0199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.ckf01a.setChecked(false);
                    bi.ckf01b.setChecked(false);
                    bi.ckf0188.setChecked(false);
                    bi.ckf01a.setEnabled(false);
                    bi.ckf01b.setEnabled(false);
                    bi.ckf0188.setEnabled(false);
                } else {
                    bi.ckf01a.setEnabled(true);
                    bi.ckf01b.setEnabled(true);
                    bi.ckf0188.setEnabled(true);
                }
            }
        });
        bi.ckg0199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.ckg01a.setChecked(false);
                    bi.ckg01b.setChecked(false);
                    bi.ckg0188.setChecked(false);
                    bi.ckg01a.setEnabled(false);
                    bi.ckg01b.setEnabled(false);
                    bi.ckg0188.setEnabled(false);
                } else {
                    bi.ckg01a.setEnabled(true);
                    bi.ckg01b.setEnabled(true);
                    bi.ckg0188.setEnabled(true);
                }
            }
        });
        bi.ckh0199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.ckh01a.setChecked(false);
                    bi.ckh01b.setChecked(false);
                    bi.ckh01c.setChecked(false);
                    bi.ckh01d.setChecked(false);
                    bi.ckh01e.setChecked(false);
                    bi.ckh0188.setChecked(false);
                    bi.ckh01a.setEnabled(false);
                    bi.ckh01b.setEnabled(false);
                    bi.ckh01c.setEnabled(false);
                    bi.ckh01d.setEnabled(false);
                    bi.ckh01e.setEnabled(false);
                    bi.ckh0188.setEnabled(false);
                } else {
                    bi.ckh01a.setEnabled(true);
                    bi.ckh01b.setEnabled(true);
                    bi.ckh01c.setEnabled(true);
                    bi.ckh01d.setEnabled(true);
                    bi.ckh01e.setEnabled(true);
                    bi.ckh0188.setEnabled(true);
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


        if (!validatorClass.EmptyCheckBox(this, bi.ckf01, bi.ckf0188, bi.ckf0188x, getString(R.string.ckf01))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, bi.ckg01, bi.ckg0188, bi.ckg0188x, getString(R.string.ckg01))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, bi.ckh01, bi.ckh0188, bi.ckh0188x, getString(R.string.ckh01))) {
            return false;
        }

        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sFGH = new JSONObject();
        sFGH.put("ckf01a", bi.ckf01a.isChecked() ? "1" : "0");
        sFGH.put("ckf01b", bi.ckf01b.isChecked() ? "2" : "0");
        sFGH.put("ckf0199", bi.ckf0199.isChecked() ? "99" : "0");
        sFGH.put("ckf0188", bi.ckf0188.isChecked() ? "88" : "0");
        sFGH.put("ckf0188x", bi.ckf0188x.getText().toString());


        sFGH.put("ckg01a", bi.ckg01a.isChecked() ? "1" : "0");
        sFGH.put("ckg01b", bi.ckg01b.isChecked() ? "2" : "0");
        sFGH.put("ckg0199", bi.ckg0199.isChecked() ? "99" : "0");
        sFGH.put("ckg0188", bi.ckg0188.isChecked() ? "88" : "0");
        sFGH.put("ckg0188x", bi.ckg0188x.getText().toString());

        sFGH.put("ckh01a", bi.ckh01a.isChecked() ? "1" : "0");
        sFGH.put("ckh01b", bi.ckh01b.isChecked() ? "2" : "0");
        sFGH.put("ckh01c", bi.ckh01c.isChecked() ? "3" : "0");
        sFGH.put("ckh01d", bi.ckh01d.isChecked() ? "4" : "0");
        sFGH.put("ckh01e", bi.ckh01e.isChecked() ? "5" : "0");
        sFGH.put("ckh0199", bi.ckh0199.isChecked() ? "99" : "0");
        sFGH.put("ckh0188", bi.ckh0188.isChecked() ? "88" : "0");
        sFGH.put("ckh0188x", bi.ckh0188x.getText().toString());


        MainApp.fc.setsFGH(String.valueOf(sFGH));

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSFGH();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}
