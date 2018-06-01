package edu.aku.hassannaqvi.cbt_kap_form.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.cbt_kap_form.R;
import edu.aku.hassannaqvi.cbt_kap_form.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbt_kap_form.core.MainApp;
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionBBinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

public class SectionBActivity extends AppCompatActivity {

    ActivitySectionBBinding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
        bi.setCallback(this);
        this.setTitle("Section B");

        db = new DatabaseHelper(this);

    }


    private void SaveDraft() throws JSONException {

        JSONObject sB = new JSONObject();


        sB.put("ckb01", bi.ckb01a.isChecked() ? "1"
                : bi.ckb01b.isChecked() ? "2"
                : "0");


        sB.put("ckb02a", bi.ckb02aa.isChecked() ? "1"
                : bi.ckb02ab.isChecked() ? "2"
                : "0");


        sB.put("ckb02b", bi.ckb02ba.isChecked() ? "1"
                : bi.ckb02bb.isChecked() ? "2"
                : "0");


        sB.put("ckb02c", bi.ckb02ca.isChecked() ? "1"
                : bi.ckb02cb.isChecked() ? "2"
                : "0");

        sB.put("ckb02d", bi.ckb02da.isChecked() ? "1"
                : bi.ckb02db.isChecked() ? "2"
                : "0");

        sB.put("ckb02e", bi.ckb02ea.isChecked() ? "1"
                : bi.ckb02eb.isChecked() ? "2"
                : "0");

        sB.put("ckb02f", bi.ckb02fa.isChecked() ? "1"
                : bi.ckb02fb.isChecked() ? "2"
                : "0");

        sB.put("ckb02g", bi.ckb02ga.isChecked() ? "1"
                : bi.ckb02gb.isChecked() ? "2"
                : "0");

        sB.put("ckb02h", bi.ckb02ha.isChecked() ? "1"
                : bi.ckb02hb.isChecked() ? "2"
                : "0");

        sB.put("ckb02i", bi.ckb02ia.isChecked() ? "1"
                : bi.ckb02ib.isChecked() ? "2"
                : "0");

        sB.put("ckb02j", bi.ckb02ja.isChecked() ? "1"
                : bi.ckb02jb.isChecked() ? "2"
                : "0");

        sB.put("ckb0296x", bi.ckb0296x.getText().toString());


        sB.put("ckb03a", bi.ckb03a.isChecked() ? "1" : "0");
        sB.put("ckb03b", bi.ckb03b.isChecked() ? "2" : "0");
        sB.put("ckb03c", bi.ckb03c.isChecked() ? "3" : "0");
        sB.put("ckb0396", bi.ckb0396.isChecked() ? "96" : "0");

        sB.put("ckb0396x", bi.ckb0396x.getText().toString());


        sB.put("ckb04a", bi.ckb04a.isChecked() ? "1" : "0");
        sB.put("ckb04b", bi.ckb04b.isChecked() ? "2" : "0");
        sB.put("ckb04c", bi.ckb04c.isChecked() ? "3" : "0");
        sB.put("ckb04d", bi.ckb04d.isChecked() ? "4" : "0");
        sB.put("ckb0496", bi.ckb0496.isChecked() ? "96" : "0");

        sB.put("ckb0496x", bi.ckb0496x.getText().toString());


        sB.put("ckb05a", bi.ckb05a.isChecked() ? "1" : "0");
        sB.put("ckb05b", bi.ckb05b.isChecked() ? "2" : "0");
        sB.put("ckb05c", bi.ckb05c.isChecked() ? "3" : "0");
        sB.put("ckb0596", bi.ckb0596.isChecked() ? "96" : "0");

        sB.put("ckb0596x", bi.ckb0596x.getText().toString());


        sB.put("ckb06a", bi.ckb06a.isChecked() ? "1" : "0");
        sB.put("ckb06b", bi.ckb06b.isChecked() ? "2" : "0");
        sB.put("ckb06c", bi.ckb06c.isChecked() ? "3" : "0");
        sB.put("ckb06d", bi.ckb06d.isChecked() ? "4" : "0");
        sB.put("ckb0696", bi.ckb0696.isChecked() ? "96" : "0");

        sB.put("ckb0696x", bi.ckb0696x.getText().toString());


        sB.put("ckb07a", bi.ckb07a.isChecked() ? "1" : "0");
        sB.put("ckb07b", bi.ckb07b.isChecked() ? "2" : "0");
        sB.put("ckb07c", bi.ckb07c.isChecked() ? "3" : "0");
        sB.put("ckb07d", bi.ckb07d.isChecked() ? "4" : "0");
        sB.put("ckb0796", bi.ckb0796.isChecked() ? "96" : "0");
        sB.put("ckb0798", bi.ckb0798.isChecked() ? "98" : "0");

        sB.put("ckb0796x", bi.ckb0796x.getText().toString());


        sB.put("ckb08", bi.ckb08a.isChecked() ? "1"
                : bi.ckb08b.isChecked() ? "2"
                : "0");


        sB.put("ckb09", bi.ckb09a.isChecked() ? "1"
                : bi.ckb0996.isChecked() ? "96"
                : bi.ckb0998.isChecked() ? "98"
                : "0");


        sB.put("ckb0996x", bi.ckb0996x.getText().toString());


        sB.put("ckb10a", bi.ckb10a.isChecked() ? "1" : "0");
        sB.put("ckb10b", bi.ckb10b.isChecked() ? "2" : "0");
        sB.put("ckb10c", bi.ckb10c.isChecked() ? "3" : "0");
        sB.put("ckb10d", bi.ckb10d.isChecked() ? "4" : "0");
        sB.put("ckb10e", bi.ckb10e.isChecked() ? "5" : "0");
        sB.put("ckb1096", bi.ckb1096.isChecked() ? "96" : "0");
        sB.put("ckb1098", bi.ckb1098.isChecked() ? "98" : "0");


        sB.put("ckb1096x", bi.ckb1096x.getText().toString());


        sB.put("ckb11a", bi.ckb11a.isChecked() ? "1" : "0");
        sB.put("ckb11b", bi.ckb11b.isChecked() ? "2" : "0");
        sB.put("ckb11c", bi.ckb11c.isChecked() ? "3" : "0");
        sB.put("ckb11d", bi.ckb11d.isChecked() ? "4" : "0");
        sB.put("ckb11e", bi.ckb11e.isChecked() ? "5" : "0");
        sB.put("ckb11f", bi.ckb11f.isChecked() ? "6" : "0");
        sB.put("ckb1196", bi.ckb1196.isChecked() ? "96" : "0");
        sB.put("ckb1198", bi.ckb1198.isChecked() ? "98" : "0");



        sB.put("ckb1196x", bi.ckb1196x.getText().toString());


        MainApp.fc.setsB(String.valueOf(sB));

    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ckb01, bi.ckb01a, getString(R.string.ckb01))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02a, bi.ckb02aa, getString(R.string.ckb02a))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02b, bi.ckb02ba, getString(R.string.ckb02b))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02c, bi.ckb02ca, getString(R.string.ckb02c))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02d, bi.ckb02da, getString(R.string.ckb02d))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02e, bi.ckb02ea, getString(R.string.ckb02e))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02f, bi.ckb02fa, getString(R.string.ckb02f))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02g, bi.ckb02ga, getString(R.string.ckb02g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.ckb02h, bi.ckb02ha, getString(R.string.ckb02h))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02i, bi.ckb02ia, getString(R.string.ckb02i))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb02j, bi.ckb02ja, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ckb0296x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb03, bi.ckb0396, bi.ckb0396x, getString(R.string.ckb03a))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb04, bi.ckb0496, bi.ckb0496x, getString(R.string.ckb04a))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb05,  bi.ckb0596, bi.ckb0596x, getString(R.string.ckb05a))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb06,  bi.ckb0696, bi.ckb0696x, getString(R.string.ckb06a))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb07, bi.ckb0796, bi.ckb0796x, getString(R.string.ckb07a))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb08, bi.ckb08a, getString(R.string.ckb08))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb09, bi.ckb0996, bi.ckb0996x, getString(R.string.ckb09))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb10, bi.ckb1096, bi.ckb1096x, getString(R.string.ckb10a))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb11, bi.ckb1196, bi.ckb1196x, getString(R.string.ckb11a))) {
            return false;
        }

        return true;
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
    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updatesB();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}