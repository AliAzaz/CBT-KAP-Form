package edu.aku.hassannaqvi.cbt_kap_form.contracts;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private String projectName = "CBT-KAP Form";
    private String _ID = "";
    private String _UID = "";
    private String formDate = "";
    private String user = "";
    private String child_id = "";
    private String child_name = "";
    private String study_arm = "";
    private String sA = "";
    private String sB = "";
    private String sCD = "";
    private String sE = "";
    private String sFGH = "";
    private String istatus = "";
    private String istatus88x = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String synced = "";
    private String synced_date = "";
    private String appVersion = "";
    private String endingdatetime = "";


    public static final String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.kmc.contracts.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_FORMS = "forms";

    public static final Uri URI_TABLE = Uri.parse(BASE_CONTENT_URI.toString() + "/" + PATH_FORMS);

    public static final String[] TOP_LEVEL_PATHS = {PATH_FORMS};

    public FormsContract() {
    }


    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this.projectName= jsonObject.getString(FormsTable.COLUMN_PROJECTNAME);
        this._ID = jsonObject.getString(FormsTable.COLUMN__ID );
        this._UID = jsonObject.getString(FormsTable.COLUMN__UID );
        this.formDate= jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.user= jsonObject.getString(FormsTable.COLUMN_USER);
        this.child_id= jsonObject.getString(FormsTable.COLUMN_CHILD_ID);
        this.child_name= jsonObject.getString(FormsTable.COLUMN_CHILD_NAME);
        this.study_arm= jsonObject.getString(FormsTable.COLUMN_STUDY_ARM);
        this.sA= jsonObject.getString(FormsTable.COLUMN_SA);
        this.sB= jsonObject.getString(FormsTable.COLUMN_SB);
        this.sCD= jsonObject.getString(FormsTable.COLUMN_SCD);
        this.sE= jsonObject.getString(FormsTable.COLUMN_SE);
        this.sFGH= jsonObject.getString(FormsTable.COLUMN_SFGH);
        this.istatus= jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x= jsonObject.getString(FormsTable.COLUMN_ISTATUS88X);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID );
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID );
        this.gpsLat= jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng= jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT= jsonObject.getString(FormsTable.COLUMN_GPSDT);
        this.gpsAcc= jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.gpsElev= jsonObject.getString(FormsTable.COLUMN_GPSELEV);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED );
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE );
        this.appVersion= jsonObject.getString(FormsTable.COLUMN_APPVERSION);
        this.endingdatetime= jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);


        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this.projectName = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_PROJECTNAME));
        this._ID  = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN__ID ));
        this._UID  = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN__UID ));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));
        this.child_id = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_CHILD_ID));
        this.child_name = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_CHILD_NAME));
        this.study_arm = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_STUDY_ARM));
        this.sA = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA));
        this.sB = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB));
        this.sCD = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SCD));
        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.sFGH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SFGH));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88X));
        this.deviceID  = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID ));
        this.devicetagID  = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID ));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDT));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.gpsElev = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSELEV));
        this.synced  = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED ));
        this.synced_date  = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE ));
        this.appVersion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));


        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(FormsTable.COLUMN__ID , this._ID  == null ? JSONObject.NULL : this._ID );
        json.put(FormsTable.COLUMN__UID , this._UID  == null ? JSONObject.NULL : this._UID );
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FormsTable.COLUMN_CHILD_ID, this.child_id == null ? JSONObject.NULL : this.child_id);
        json.put(FormsTable.COLUMN_CHILD_NAME, this.child_name == null ? JSONObject.NULL : this.child_name);
        json.put(FormsTable.COLUMN_STUDY_ARM, this.study_arm == null ? JSONObject.NULL : this.study_arm);
        if (!this.sA.equals("")) {
            json.put(FormsTable.COLUMN_SA, this.sA.equals("") ? JSONObject.NULL : new JSONObject(this.sA));
        }
        if (!this.sB.equals("")) {
            json.put(FormsTable.COLUMN_SB, this.sB.equals("") ? JSONObject.NULL : new JSONObject(this.sB));
        }
        if (!this.sCD.equals("")) {
            json.put(FormsTable.COLUMN_SCD, this.sCD.equals("")? JSONObject.NULL : new JSONObject(this.sCD));
        }
        if (!this.sE.equals("")) {
            json.put(FormsTable.COLUMN_SE, this.sE.equals("") ? JSONObject.NULL : new JSONObject(this.sE));
        }
        if (!this.sFGH.equals("")) {
            json.put(FormsTable.COLUMN_SFGH, this.sFGH.equals("") ? JSONObject.NULL : new JSONObject(this.sFGH));
        }
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88X, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_DEVICEID , this.deviceID  == null ? JSONObject.NULL : this.deviceID );
        json.put(FormsTable.COLUMN_DEVICETAGID , this.devicetagID  == null ? JSONObject.NULL : this.devicetagID );
        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDT, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_GPSELEV, this.gpsElev == null ? JSONObject.NULL : this.gpsElev);
        json.put(FormsTable.COLUMN_SYNCED , this.synced  == null ? JSONObject.NULL : this.synced );
        json.put(FormsTable.COLUMN_SYNCED_DATE , this.synced_date  == null ? JSONObject.NULL : this.synced_date );
        json.put(FormsTable.COLUMN_APPVERSION, this.appVersion == null ? JSONObject.NULL : this.appVersion);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);

        return json;
    }

    public String getprojectName() {
        return projectName;
    }

    public void setprojectName(String projectName) {
        this.projectName = projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String getformDate() {
        return formDate;
    }

    public void setformDate(String formDate) {
        this.formDate = formDate;
    }

    public String getuser() {
        return user;
    }

    public void setuser(String user) {
        this.user = user;
    }

    public String getchild_id() {
        return child_id;
    }

    public void setchild_id(String child_id) {
        this.child_id = child_id;
    }

    public String getchild_name() {
        return child_name;
    }

    public void setchild_name(String child_name) {
        this.child_name = child_name;
    }

    public String getstudy_arm() {
        return study_arm;
    }

    public void setstudy_arm(String study_arm) {
        this.study_arm = study_arm;
    }

    public String getistatus() {
        return istatus;
    }

    public void setistatus(String istatus) {
        this.istatus = istatus;
    }

    public String getistatus88x() {
        return istatus88x;
    }

    public void setistatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }

    public String getsCD() {
        return sCD;
    }

    public void setsCD(String sCD) {
        this.sCD = sCD;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsFGH() {
        return sFGH;
    }

    public void setsFGH(String sFGH) {
        this.sFGH = sFGH;
    }

    public String getdeviceID() {
        return deviceID;
    }

    public void setdeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getdevicetagID() {
        return devicetagID;
    }

    public void setdevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getgpsLat() {
        return gpsLat;
    }

    public void setgpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getgpsLng() {
        return gpsLng;
    }

    public void setgpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getgpsDT() {
        return gpsDT;
    }

    public void setgpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getgpsAcc() {
        return gpsAcc;
    }

    public void setgpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getgpsElev() {
        return gpsElev;
    }

    public void setgpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
    }

    public String getsynced() {
        return synced;
    }

    public void setsynced(String synced) {
        this.synced = synced;
    }

    public String getsynced_date() {
        return synced_date;
    }

    public void setsynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getappVersion() {
        return appVersion;
    }

    public void setappVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getendingdatetime() {
        return endingdatetime;
    }

    public void setendingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

    public static String getcontentAuthority() {
        return CONTENT_AUTHORITY;
    }

    public static Uri getbaseContentUri() {
        return BASE_CONTENT_URI;
    }

    public static String getpathForms() {
        return PATH_FORMS;
    }

    public static Uri geturiTable() {
        return URI_TABLE;
    }

    public static String[] gettopLevelPaths() {
        return TOP_LEVEL_PATHS;
    }

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN__ID  = "_id";
        public static final String COLUMN__UID  = "_uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_CHILD_ID = "child_id";
        public static final String COLUMN_CHILD_NAME = "child_name";
        public static final String COLUMN_STUDY_ARM = "study_arm";
        public static final String COLUMN_SA = "sa";
        public static final String COLUMN_SB = "sb";
        public static final String COLUMN_SCD = "scd";
        public static final String COLUMN_SE = "se";
        public static final String COLUMN_SFGH = "sfgh";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88X = "istatus88x";
        public static final String COLUMN_DEVICEID  = "deviceid";
        public static final String COLUMN_DEVICETAGID  = "devicetagid";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDT = "gpsdt";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_GPSELEV = "gpselev";
        public static final String COLUMN_SYNCED  = "synced";
        public static final String COLUMN_SYNCED_DATE  = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";


        public static String _URL = "formspw.php";

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_FORMS).build();

        // Accessing content directory and item
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + ".forms";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".forms";

        public static Uri buildCountryUri(String uid) {
            return CONTENT_URI.buildUpon().appendEncodedPath(uid).build();
        }

        public static String getCountryId(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }
}