package edu.aku.hassannaqvi.cbt_kap_form.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class ChildContract {

    private String ID = "";
    private String UID = "";
    private String hhDT = ""; // Date
    private String tehsil = "0000"; // Tehsil code
    private String hFacility = ""; // HF
    private String uccode = ""; // uc code
    private String villagename = ""; // Village code
    private String lhwCode = ""; // lhw Code
    private String houseHold = ""; // HH no.
    private String childId = ""; // Index Child ID

    public ChildContract() {
    }

    public ChildContract sync(JSONObject jsonObject) throws JSONException {
        this.ID = jsonObject.getString(ChildTable.COLUMN_ID);
        this.UID = jsonObject.getString(ChildTable.COLUMN_UID);
        this.hhDT = jsonObject.getString(ChildTable.COLUMN_HHDT);
        this.tehsil = jsonObject.getString(ChildTable.COLUMN_TEHSIL);
        this.hFacility = jsonObject.getString(ChildTable.COLUMN_HFACILITY);
        this.lhwCode = jsonObject.getString(ChildTable.COLUMN_LHWCODE);
        this.houseHold = jsonObject.getString(ChildTable.COLUMN_HOUSEHOLD);
        this.childId = jsonObject.getString(ChildTable.COLUMN_CHILDID);
        this.uccode = jsonObject.getString(ChildTable.COLUMN_UCCODE);
        this.villagename = jsonObject.getString(ChildTable.COLUMN_VILLAGENAME);

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

    public String getHhDT() {
        return hhDT;
    }

    public void setHhDT(String hhDT) {
        this.hhDT = hhDT;
    }

    public String getTehsil() {
        return tehsil;
    }

    public void setTehsil(String tehsil) {
        this.tehsil = tehsil;
    }

    public String gethFacility() {
        return hFacility;
    }

    public void sethFacility(String hFacility) {
        this.hFacility = hFacility;
    }

    public String getLhwCode() {
        return lhwCode;
    }

    public void setLhwCode(String lhwCode) {
        this.lhwCode = lhwCode;
    }

    public String getHouseHold() {
        return houseHold;
    }

    public void setHouseHold(String houseHold) {
        this.houseHold = houseHold;
    }

    public String getChildId() {
        return childId;
    }

    public void setChildId(String childId) {
        this.childId = childId;
    }

    public String getUccode() {
        return uccode;
    }

    public void setUccode(String uccode) {
        this.uccode = uccode;
    }

    public String getVillagename() {
        return villagename;
    }

    public void setVillagename(String villagename) {
        this.villagename = villagename;
    }

    public ChildContract hydrate(Cursor cursor) {
        this.ID = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_ID));
        this.UID = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_UID));
        this.hhDT = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_HHDT));
        this.tehsil = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_TEHSIL));
        this.hFacility = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_HFACILITY));
        this.lhwCode = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_LHWCODE));
        this.houseHold = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_HOUSEHOLD));
        this.childId = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_CHILDID));
        this.uccode = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_UCCODE));
        this.villagename = cursor.getString(cursor.getColumnIndex(ChildTable.COLUMN_VILLAGENAME));

        return this;
    }

    public static abstract class ChildTable implements BaseColumns {

        public static final String TABLE_NAME = "childCBTData";
        public static final String _URI = "cbtdata.php";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_HHDT = "hhdt";
        public static final String COLUMN_TEHSIL = "tehsil";
        public static final String COLUMN_HFACILITY = "hfacility";
        public static final String COLUMN_LHWCODE = "lhwcode";
        public static final String COLUMN_HOUSEHOLD = "household";
        public static final String COLUMN_CHILDID = "childid";
        public static final String COLUMN_UCCODE = "uccode";
        public static final String COLUMN_VILLAGENAME = "villagename";

    }
}