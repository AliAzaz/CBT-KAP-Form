package edu.aku.hassannaqvi.cbt_kap_form.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.cbt_kap_form.R;
import edu.aku.hassannaqvi.cbt_kap_form.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbt_kap_form.core.MainApp;
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionEBinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

public class SectionEActivity extends AppCompatActivity {
    ActivitySectionEBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e);
        bi.setCallback(this);
        this.setTitle("Section E");
        setUpActivity();

    }

    private void setUpActivity() {
        bi.cke0199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cke01a.setChecked(false);
                    bi.cke01b.setChecked(false);
                    bi.cke01c.setChecked(false);
                    bi.cke01d.setChecked(false);
                    bi.cke0188.setChecked(false);

                    bi.cke01a.setEnabled(false);
                    bi.cke01b.setEnabled(false);
                    bi.cke01c.setEnabled(false);
                    bi.cke01d.setEnabled(false);
                    bi.cke0188.setEnabled(false);
                } else {
                    bi.cke01a.setEnabled(true);
                    bi.cke01b.setEnabled(true);
                    bi.cke01c.setEnabled(true);
                    bi.cke01d.setEnabled(true);
                    bi.cke0188.setEnabled(true);
                }
            }
        });
        bi.cke0299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cke02a.setChecked(false);
                    bi.cke02b.setChecked(false);
                    bi.cke02c.setChecked(false);
                    bi.cke0288.setChecked(false);


                    bi.cke02a.setEnabled(false);
                    bi.cke02b.setEnabled(false);
                    bi.cke02c.setEnabled(false);
                    bi.cke0288.setEnabled(false);

                } else {
                    bi.cke02a.setEnabled(true);
                    bi.cke02b.setEnabled(true);
                    bi.cke02c.setEnabled(true);
                    bi.cke0288.setEnabled(true);
                }
            }
        });
        bi.cke0599.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cke05a.setChecked(false);
                    bi.cke05b.setChecked(false);
                    bi.cke0588.setChecked(false);

                    bi.cke05a.setEnabled(false);
                    bi.cke05b.setEnabled(false);
                    bi.cke0588.setEnabled(false);


                } else {
                    bi.cke05a.setEnabled(true);
                    bi.cke05b.setEnabled(true);
                    bi.cke0588.setEnabled(true);
                }
            }
        });
        bi.cke0699.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.cke06a.setChecked(false);
                    bi.cke06b.setChecked(false);
                    bi.cke06c.setChecked(false);
                    bi.cke06d.setChecked(false);
                    bi.cke0688.setChecked(false);


                    bi.cke06a.setEnabled(false);
                    bi.cke06b.setEnabled(false);
                    bi.cke06c.setEnabled(false);
                    bi.cke06d.setEnabled(false);
                    bi.cke0688.setEnabled(false);
                } else {
                    bi.cke06a.setEnabled(true);
                    bi.cke06b.setEnabled(true);
                    bi.cke06c.setEnabled(true);
                    bi.cke06d.setEnabled(true);
                    bi.cke0688.setEnabled(true);
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

                startActivity(new Intent(this, SectionFGHActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {


        if (!validatorClass.EmptyCheckBox(this, bi.cke01, bi.cke0188, bi.cke0188x, getString(R.string.cke01))) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, bi.cke02, bi.cke0288, bi.cke0288x, getString(R.string.cke02))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.cke03, bi.cke0388, bi.cke0388x, getString(R.string.cke03))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cke04, bi.cke0488, bi.cke0488x, getString(R.string.cke04))) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, bi.cke05, bi.cke0588, bi.cke0588x, getString(R.string.cke05))) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, bi.cke06, bi.cke0688, bi.cke0688x, getString(R.string.cke06))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.cke07, bi.cke07c, bi.cke07cx, getString(R.string.cke07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cke08, bi.cke08c, bi.cke08cx, getString(R.string.cke08))) {
            return false;
        }
        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sE = new JSONObject();
        sE.put("cke01a", bi.cke01a.isChecked() ? "1" : "0");
        sE.put("cke01b", bi.cke01b.isChecked() ? "2" : "0");
        sE.put("cke01c", bi.cke01c.isChecked() ? "3" : "0");
        sE.put("cke01d", bi.cke01d.isChecked() ? "4" : "0");
        sE.put("cke0199", bi.cke0199.isChecked() ? "99" : "0");
        sE.put("cke0188", bi.cke0188.isChecked() ? "88" : "0");
        sE.put("cke0188x", bi.cke0188x.getText().toString());

        sE.put("cke02a", bi.cke02a.isChecked() ? "1" : "0");
        sE.put("cke02b", bi.cke02b.isChecked() ? "2" : "0");
        sE.put("cke02c", bi.cke02c.isChecked() ? "3" : "0");
        sE.put("cke0299", bi.cke0299.isChecked() ? "99" : "0");
        sE.put("cke0288", bi.cke0288.isChecked() ? "88" : "0");
        sE.put("cke0288x", bi.cke0288x.getText().toString());


        sE.put("cke03", bi.cke03a.isChecked() ? "1"
                : bi.cke03b.isChecked() ? "2"
                : bi.cke0399.isChecked() ? "99"
                : bi.cke0388.isChecked() ? "88"
                : "0");

        sE.put("cke0388x", bi.cke0388x.getText().toString());

        sE.put("cke04", bi.cke04a.isChecked() ? "1"
                : bi.cke0499.isChecked() ? "99"
                : bi.cke0488.isChecked() ? "88"
                : "0");

        sE.put("cke0488x", bi.cke0488x.getText().toString());

        sE.put("cke05a", bi.cke05a.isChecked() ? "1" : "0");
        sE.put("cke05b", bi.cke05b.isChecked() ? "2" : "0");
        sE.put("cke0599", bi.cke0599.isChecked() ? "99" : "0");
        sE.put("cke0588", bi.cke0588.isChecked() ? "88" : "0");
        sE.put("cke0588x", bi.cke0588x.getText().toString());

        sE.put("cke06a", bi.cke06a.isChecked() ? "1" : "0");
        sE.put("cke06b", bi.cke06b.isChecked() ? "2" : "0");
        sE.put("cke06c", bi.cke06c.isChecked() ? "3" : "0");
        sE.put("cke06d", bi.cke06d.isChecked() ? "4" : "0");
        sE.put("cke0699", bi.cke0699.isChecked() ? "99" : "0");
        sE.put("cke0688", bi.cke0688.isChecked() ? "88" : "0");
        sE.put("cke0688x", bi.cke0688x.getText().toString());

        sE.put("cke07", bi.cke07a.isChecked() ? "1"
                : bi.cke07b.isChecked() ? "2"
                : bi.cke07c.isChecked() ? "3"
                : "0");
        sE.put("cke07cx", bi.cke07cx.getText().toString());

        sE.put("cke08", bi.cke08a.isChecked() ? "1"
                : bi.cke08b.isChecked() ? "2"
                : bi.cke08c.isChecked() ? "3"
                : "0");

        sE.put("cke08cx", bi.cke08cx.getText().toString());

        MainApp.fc.setsE(String.valueOf(sE));

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesE();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}
