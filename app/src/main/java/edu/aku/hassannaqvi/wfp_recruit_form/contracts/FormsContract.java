package edu.aku.hassannaqvi.wfp_recruit_form.contracts;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private String projectName = "WFP-Phisin Recruitment Form";
    private String surveyType = "BL";
    private String _ID = "";
    private String _UID = "";
    private String formDate = ""; // Date
    private String interviewer01 = ""; // Interviewer 01
    private String interviewer02 = ""; // Interviewer 02
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String sInfo = "";    // Info Section
    private String sA = "";
    private String sC = "";
    private String sD = "";
    private String sE = "";
    private String sF = "";
    private String sG = "";
    private String sH = "";
    private String sI = "";
    private String sJ = "";
    private String sK = "";
    private String sLMO = "";

    private String count = "";
    private String endingdatetime = "";
    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion;

    public static final String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.kmc.contracts.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_FORMS = "forms";

    public static final Uri URI_TABLE = Uri.parse(BASE_CONTENT_URI.toString() + "/" + PATH_FORMS);

    public static final String[] TOP_LEVEL_PATHS = {PATH_FORMS};

    public FormsContract() {
    }


    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this.projectName = jsonObject.getString(FormsTable.COLUMN_PROJECTNAME);
        this.surveyType = jsonObject.getString(FormsTable.COLUMN_SURVEYTYPE);
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.formDate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.interviewer01= jsonObject.getString(FormsTable.COLUMN_INTERVIEWER01);
        this.interviewer02= jsonObject.getString(FormsTable.COLUMN_INTERVIEWER02);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS88X);
        this.sInfo = jsonObject.getString(FormsTable.COLUMN_SINFO);
        this.sA = jsonObject.getString(FormsTable.COLUMN_sA);
        this.sC = jsonObject.getString(FormsTable.COLUMN_SC);
        this.sD = jsonObject.getString(FormsTable.COLUMN_SD);
        this.sG = jsonObject.getString(FormsTable.COLUMN_SG);
        this.sH = jsonObject.getString(FormsTable.COLUMN_SH);
        this.sI = jsonObject.getString(FormsTable.COLUMN_SI);
        this.sJ = jsonObject.getString(FormsTable.COLUMN_SJ);
        this.sK = jsonObject.getString(FormsTable.COLUMN_SK);
        this.sLMO = jsonObject.getString(FormsTable.COLUMN_SLMO);
        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.sF = jsonObject.getString(FormsTable.COLUMN_SF);
        this.count = jsonObject.getString(FormsTable.COLUMN_COUNT);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDT);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.gpsElev = jsonObject.getString(FormsTable.COLUMN_GPSELEV);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_APPVERSION);


        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this.projectName = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_PROJECTNAME));
        this.surveyType = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SURVEYTYPE));
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.interviewer01 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_INTERVIEWER01));
        this.interviewer02 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_INTERVIEWER02));

        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88X));
        this.sInfo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SINFO));
        this.sA = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_sA));

        this.sD = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD));
        this.sG = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SG));
        this.sC = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SC));

        this.sH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SH));
        this.sI = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SI));
        this.sJ = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SJ));
        this.sK = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SK));
        this.sLMO = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SLMO));
        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SF));
        this.count = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_COUNT));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDT));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.gpsElev = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSELEV));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));


        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(FormsTable.COLUMN_SURVEYTYPE, this.surveyType == null ? JSONObject.NULL : this.surveyType);
        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_INTERVIEWER01, this.interviewer01 == null ? JSONObject.NULL : this.interviewer01);
        json.put(FormsTable.COLUMN_INTERVIEWER02, this.interviewer02 == null ? JSONObject.NULL : this.interviewer02);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88X, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_COUNT, this.count == null ? JSONObject.NULL : this.count);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);

        if (!this.sInfo.equals("")) {
            json.put(FormsTable.COLUMN_SINFO, this.sInfo.equals("") ? JSONObject.NULL : new JSONObject(this.sInfo));
        }
        if (!this.sA.equals("")) {
            json.put(FormsTable.COLUMN_sA, this.sA.equals("") ? JSONObject.NULL : new JSONObject(this.sA));
        }
        if (!this.sC.equals("")) {
            json.put(FormsTable.COLUMN_SD, this.sC.equals("") ? JSONObject.NULL : new JSONObject(this.sC));
        }
        if (!this.sD.equals("")) {
            json.put(FormsTable.COLUMN_SG, this.sD.equals("") ? JSONObject.NULL : new JSONObject(this.sD));
        }
        if (!this.sE.equals("")) {
            json.put(FormsTable.COLUMN_SE, this.sE.equals("") ? JSONObject.NULL : new JSONObject(this.sE));
        }
        if (!this.sF.equals("")) {
            json.put(FormsTable.COLUMN_SF, this.sF.equals("") ? JSONObject.NULL : new JSONObject(this.sF));
        }
        if (!this.sG.equals("")) {
            json.put(FormsTable.COLUMN_SG, this.sG.equals("") ? JSONObject.NULL : new JSONObject(this.sG));
        }
        if (!this.sH.equals("")) {
            json.put(FormsTable.COLUMN_SH, this.sH.equals("") ? JSONObject.NULL : new JSONObject(this.sH));
        }
        if (!this.sI.equals("")) {
            json.put(FormsTable.COLUMN_SI, this.sI.equals("") ? JSONObject.NULL : new JSONObject(this.sI));
        }
        if (!this.sJ.equals("")) {
            json.put(FormsTable.COLUMN_SJ, this.sJ.equals("") ? JSONObject.NULL : new JSONObject(this.sJ));
        }
        if (!this.sK.equals("")) {
            json.put(FormsTable.COLUMN_SK, this.sK == null ? JSONObject.NULL : new JSONObject(this.sK));
        }
        if (!this.sLMO.equals("")) {
            json.put(FormsTable.COLUMN_SLMO, this.sLMO == null ? JSONObject.NULL : new JSONObject(this.sLMO));
        }
        if (!this.count.equals("")) {

            json.put(FormsTable.COLUMN_COUNT, this.count.equals("") ? JSONObject.NULL : new JSONObject(this.count));
        }

        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDT, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_GPSELEV, this.gpsElev == null ? JSONObject.NULL : this.gpsElev);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        return json;
    }

    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

    public String getInterviewer01() {
        return interviewer01;
    }

    public void setInterviewer01(String interviewer01) {
        this.interviewer01 = interviewer01;
    }

    public String getInterviewer02() {
        return interviewer02;
    }

    public void setInterviewer02(String interviewer02) {
        this.interviewer02 = interviewer02;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return _UID;
    }

    public void setUID(String _UID) {
        this._UID = _UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }


    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }


    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }


    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }

    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }

    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }

    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }

    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }

    public String getsI() {
        return sI;
    }

    public void setsI(String sI) {
        this.sI = sI;
    }

    public String getsJ() {
        return sJ;
    }

    public void setsJ(String sJ) {
        this.sJ = sJ;
    }

    public String getsK() {
        return sK;
    }

    public void setsK(String sK) {
        this.sK = sK;
    }

    public String getsLMO() {
        return sLMO;
    }

    public void setsLMO(String sLMO) {
        this.sLMO = sLMO;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }

    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }

    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN_SURVEYTYPE = "surveytype";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_INTERVIEWER01 = "interviewer01";
        public static final String COLUMN_INTERVIEWER02 = "interviewer02";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88X = "istatus88x";
        public static final String COLUMN_SINFO = "sinfo";
        public static final String COLUMN_sA = "sA";
        public static final String COLUMN_SC = "sc";
        public static final String COLUMN_SD = "sd";
        public static final String COLUMN_SE = "se";
        public static final String COLUMN_SF = "sf";
        public static final String COLUMN_SG = "sg";
        public static final String COLUMN_SH = "sh";
        public static final String COLUMN_SI = "si";
        public static final String COLUMN_SJ = "sj";
        public static final String COLUMN_SK = "sk";
        public static final String COLUMN_SLMO = "slmo";
        public static final String COLUMN_COUNT = "count";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDT = "gpsdt";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_GPSELEV = "gpselev";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";

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