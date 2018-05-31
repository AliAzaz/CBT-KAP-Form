package edu.aku.hassannaqvi.cbt_kap_form.ui;

import android.app.Activity;
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
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionCBinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

public class SectionCActivity extends AppCompatActivity {
ActivitySectionCBinding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_section_c);
        bi.setCallback(this);

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

        JSONObject sD = new JSONObject();
        sD.put("ckc01", bi.wrd03a.isChecked() ? "1"
                : bi.wrd03b.isChecked() ? "2"
                : bi.wrd0399.isChecked() ? "99"
                : "0");

        sD.put("wrd04a", bi.wrd04a.isChecked() ? "1" : "0");
        sD.put("wrd04b", bi.wrd04b.isChecked() ? "2" : "0");
        sD.put("wrd04c", bi.wrd04c.isChecked() ? "3" : "0");
        sD.put("wrd04d", bi.wrd04d.isChecked() ? "4" : "0");
        sD.put("wrd04e", bi.wrd04e.isChecked() ? "5" : "0");
        sD.put("wrd04f", bi.wrd04f.isChecked() ? "6" : "0");
        sD.put("wrd04g", bi.wrd04g.isChecked() ? "7" : "0");
        sD.put("wrd04h", bi.wrd04h.isChecked() ? "8" : "0");
        sD.put("wrd04g", bi.wrd0488.isChecked() ? "88" : "0");

        sD.put("wrd0488x", bi.wrd0488x.getText().toString());


        MainApp.fc.setsD(String.valueOf(sD));

    }
    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSD();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}
