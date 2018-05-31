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
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionCBinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

public class SectionEActivity extends AppCompatActivity {
    ActivitySectionEBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e);
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

        if (!validatorClass.EmptyRadioButton(this, bi.cke07, bi.cke0788, bi.cke0788x, getString(R.string.cke07))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.cke08, bi.cke0888, bi.cke0888x, getString(R.string.cke08))) {
            return false;
        }
        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sD = new JSONObject();

        sD.put("wrd03", bi.wrd03a.isChecked() ? "1"
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
