package edu.aku.hassannaqvi.cbt_kap_form.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildContract {

    private String ID = "";
    private String UID = "";
    private String chname = "0000"; // Tehsil code
    private String fname = ""; // HF
    private String study_arm = ""; // Village code
    private String mname = ""; // lhw Code
    private String childId = ""; // Index Child ID

    public ChildContract() {
    }

    public ChildContract sync(JSONObject jsonObject) throws JSONException {
        this.UID = jsonObject.getString(ChildTable.COLUMN_UID);
        this.chname = jsonObject.getString(ChildTable.COLUMN_CHILD_NAME);
        this.fname = jsonObject.getString(ChildTable.COLUMN_FATHER_NAME);
        this.mname = jsonObject.getString(ChildTable.COLUMN_MOTHER_NAME);
        this.childId = jsonObject.getString(ChildTable.COLUMN_CHILDID);
        this.study_arm = jsonObject.getString(ChildTable.COLUMN_STUDY_ARM);

        return this;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getStudy_arm() {
        return study_arm;
    }

    public void setStudy_arm(String study_arm) {
        this.study_arm = study_arm;
    }

    public ChildContract hydrate(Cursor cursor) {
        this.UID = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_UID));
        this.chname = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_CHILD_NAME));
        this.fname = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_FATHER_NAME));
        this.mname = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_MOTHER_NAME));
        this.childId = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_CHILDID));
        this.study_arm = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_STUDY_ARM));

        return this;
    }

    public static abstract class ChildTable implements BaseColumns {

        public static final String TABLE_NAME = "childCBTData";
        public static final String _URI = "enrolled.php";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_CHILD_NAME = "crb01";
        public static final String COLUMN_FATHER_NAME = "cra06";
        public static final String COLUMN_MOTHER_NAME = "cra09";
        public static final String COLUMN_CHILDID = "childid";
        public static final String COLUMN_STUDY_ARM = "cra04";

    }
}