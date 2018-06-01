package edu.aku.hassannaqvi.cbt_kap_form.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.cbt_kap_form.R;
import edu.aku.hassannaqvi.cbt_kap_form.core.DatabaseHelper;
import edu.aku.hassannaqvi.cbt_kap_form.core.MainApp;
import edu.aku.hassannaqvi.cbt_kap_form.databinding.ActivitySectionBBinding;
import edu.aku.hassannaqvi.cbt_kap_form.validation.validatorClass;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

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

        setUpActivity();

    }

    private void setUpActivity() {
        bi.ckb01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.ckb01a) {
                    bi.fldGrpckb01.setVisibility(GONE);
                    bi.ckb02a.clearCheck();
                    bi.ckb02b.clearCheck();
                    bi.ckb02c.clearCheck();
                    bi.ckb02d.clearCheck();
                    bi.ckb02e.clearCheck();
                    bi.ckb02f.clearCheck();
                    bi.ckb02g.clearCheck();
                    bi.ckb02h.clearCheck();
                    bi.ckb02i.clearCheck();
                    bi.ckb02j.clearCheck();
                }else {
                    bi.fldGrpckb01.setVisibility(VISIBLE);
                }
            }
        });
        bi.ckb0799.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.ckb07a.setChecked(false);
                    bi.ckb07b.setChecked(false);
                    bi.ckb07c.setChecked(false);
                    bi.ckb07d.setChecked(false);
                    bi.ckb0788.setChecked(false);

                    bi.ckb07a.setEnabled(false);
                    bi.ckb07b.setEnabled(false);
                    bi.ckb07c.setEnabled(false);
                    bi.ckb07d.setEnabled(false);
                    bi.ckb0788.setEnabled(false);

                }else {
                    bi.ckb07a.setEnabled(true);
                    bi.ckb07b.setEnabled(true);
                    bi.ckb07c.setEnabled(true);
                    bi.ckb07d.setEnabled(true);
                    bi.ckb0788.setEnabled(true);
                }
            }
        });
        bi.ckb1099.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.ckb10a.setChecked(false);
                    bi.ckb10b.setChecked(false);
                    bi.ckb10c.setChecked(false);
                    bi.ckb10d.setChecked(false);
                    bi.ckb10e.setChecked(false);
                    bi.ckb1088.setChecked(false);

                    bi.ckb10a.setEnabled(false);
                    bi.ckb10b.setEnabled(false);
                    bi.ckb10c.setEnabled(false);
                    bi.ckb10d.setEnabled(false);
                    bi.ckb10e.setEnabled(false);
                    bi.ckb1088.setEnabled(false);


                }else {
                    bi.ckb10a.setEnabled(true);
                    bi.ckb10b.setEnabled(true);
                    bi.ckb10c.setEnabled(true);
                    bi.ckb10d.setEnabled(true);
                    bi.ckb10e.setEnabled(true);
                    bi.ckb1088.setEnabled(true);
                }
            }
        });
        bi.ckb1199.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.ckb11a.setChecked(false);
                    bi.ckb11b.setChecked(false);
                    bi.ckb11c.setChecked(false);
                    bi.ckb11d.setChecked(false);
                    bi.ckb11e.setChecked(false);
                    bi.ckb11f.setChecked(false);
                    bi.ckb1188.setChecked(false);

                    bi.ckb11a.setEnabled(false);
                    bi.ckb11b.setEnabled(false);
                    bi.ckb11c.setEnabled(false);
                    bi.ckb11d.setEnabled(false);
                    bi.ckb11e.setEnabled(false);
                    bi.ckb11f.setEnabled(false);
                    bi.ckb1188.setEnabled(false);
                }else {
                    bi.ckb11a.setEnabled(true);
                    bi.ckb11b.setEnabled(true);
                    bi.ckb11c.setEnabled(true);
                    bi.ckb11d.setEnabled(true);
                    bi.ckb11e.setEnabled(true);
                    bi.ckb11f.setEnabled(true);
                    bi.ckb1188.setEnabled(true);
                }
            }
        });

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

        sB.put("ckb0288x", bi.ckb0288x.getText().toString());


        sB.put("ckb03a", bi.ckb03a.isChecked() ? "1" : "0");
        sB.put("ckb03b", bi.ckb03b.isChecked() ? "2" : "0");
        sB.put("ckb03c", bi.ckb03c.isChecked() ? "3" : "0");
        sB.put("ckb0388", bi.ckb0388.isChecked() ? "88" : "0");

        sB.put("ckb0388x", bi.ckb0388x.getText().toString());


        sB.put("ckb04a", bi.ckb04a.isChecked() ? "1" : "0");
        sB.put("ckb04b", bi.ckb04b.isChecked() ? "2" : "0");
        sB.put("ckb04c", bi.ckb04c.isChecked() ? "3" : "0");
        sB.put("ckb04d", bi.ckb04d.isChecked() ? "4" : "0");
        sB.put("ckb0488", bi.ckb0488.isChecked() ? "88" : "0");

        sB.put("ckb0488x", bi.ckb0488x.getText().toString());


        sB.put("ckb05a", bi.ckb05a.isChecked() ? "1" : "0");
        sB.put("ckb05b", bi.ckb05b.isChecked() ? "2" : "0");
        sB.put("ckb05c", bi.ckb05c.isChecked() ? "3" : "0");
        sB.put("ckb0588", bi.ckb0588.isChecked() ? "88" : "0");

        sB.put("ckb0588x", bi.ckb0588x.getText().toString());


        sB.put("ckb06a", bi.ckb06a.isChecked() ? "1" : "0");
        sB.put("ckb06b", bi.ckb06b.isChecked() ? "2" : "0");
        sB.put("ckb06c", bi.ckb06c.isChecked() ? "3" : "0");
        sB.put("ckb06d", bi.ckb06d.isChecked() ? "4" : "0");
        sB.put("ckb0688", bi.ckb0688.isChecked() ? "88" : "0");

        sB.put("ckb0688x", bi.ckb0688x.getText().toString());


        sB.put("ckb07a", bi.ckb07a.isChecked() ? "1" : "0");
        sB.put("ckb07b", bi.ckb07b.isChecked() ? "2" : "0");
        sB.put("ckb07c", bi.ckb07c.isChecked() ? "3" : "0");
        sB.put("ckb07d", bi.ckb07d.isChecked() ? "4" : "0");
        sB.put("ckb0788", bi.ckb0788.isChecked() ? "88" : "0");
        sB.put("ckb0799", bi.ckb0799.isChecked() ? "99" : "0");

        sB.put("ckb0788x", bi.ckb0788x.getText().toString());


        sB.put("ckb08", bi.ckb08a.isChecked() ? "1"
                : bi.ckb0899.isChecked() ? "99"
                : bi.ckb0888.isChecked() ? "88"
                : "0");
        sB.put("ckb0888x", bi.ckb0888x.getText().toString());


        sB.put("ckb09", bi.ckb09a.isChecked() ? "1"
                : bi.ckb0988.isChecked() ? "88"
                : bi.ckb0999.isChecked() ? "99"
                : "0");


        sB.put("ckb0988x", bi.ckb0988x.getText().toString());


        sB.put("ckb10a", bi.ckb10a.isChecked() ? "1" : "0");
        sB.put("ckb10b", bi.ckb10b.isChecked() ? "2" : "0");
        sB.put("ckb10c", bi.ckb10c.isChecked() ? "3" : "0");
        sB.put("ckb10d", bi.ckb10d.isChecked() ? "4" : "0");
        sB.put("ckb10e", bi.ckb10e.isChecked() ? "5" : "0");
        sB.put("ckb1088", bi.ckb1088.isChecked() ? "88" : "0");
        sB.put("ckb1099", bi.ckb1099.isChecked() ? "99" : "0");


        sB.put("ckb1088x", bi.ckb1088x.getText().toString());


        sB.put("ckb11a", bi.ckb11a.isChecked() ? "1" : "0");
        sB.put("ckb11b", bi.ckb11b.isChecked() ? "2" : "0");
        sB.put("ckb11c", bi.ckb11c.isChecked() ? "3" : "0");
        sB.put("ckb11d", bi.ckb11d.isChecked() ? "4" : "0");
        sB.put("ckb11e", bi.ckb11e.isChecked() ? "5" : "0");
        sB.put("ckb11f", bi.ckb11f.isChecked() ? "6" : "0");
        sB.put("ckb1188", bi.ckb1188.isChecked() ? "88" : "0");
        sB.put("ckb1199", bi.ckb1199.isChecked() ? "99" : "0");



        sB.put("ckb1188x", bi.ckb1188x.getText().toString());


        MainApp.fc.setsB(String.valueOf(sB));

    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ckb01, bi.ckb01a, getString(R.string.ckb01))) {
            return false;
        }
        if (bi.ckb01a.isChecked()) {


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


        if (!validatorClass.EmptyTextBox(this, bi.ckb0288x, getString(R.string.other))) {
            return false;
        }
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb03, bi.ckb0388, bi.ckb0388x, getString(R.string.ckb03))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb04, bi.ckb0488, bi.ckb0488x, getString(R.string.ckb04))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb05,  bi.ckb0588, bi.ckb0588x, getString(R.string.ckb05))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb06,  bi.ckb0688, bi.ckb0688x, getString(R.string.ckb06))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb07, bi.ckb0788, bi.ckb0788x, getString(R.string.ckb07))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb08, bi.ckb0888,bi.ckb0888x, getString(R.string.ckb08))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ckb09, bi.ckb0988, bi.ckb0988x, getString(R.string.ckb09))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb10, bi.ckb1088, bi.ckb1088x, getString(R.string.ckb10))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.fldGrpckb11, bi.ckb1188, bi.ckb1188x, getString(R.string.ckb11))) {
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