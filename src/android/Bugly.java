package com.pch.plugin;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import com.tencent.bugly.crashreport.CrashReport;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

/**
 * This class echoes a string called from JavaScript.
 */
public class Bugly extends CordovaPlugin {
    private final static String TAG = "Bugly";
    private Context mContext;

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (mContext == null) {
            mContext = cordova.getContext();
        }
        if (action.equals("initSDK")) {
            JSONObject obj = args.getJSONObject(0);
            String appid = obj.getString("appid");
			boolean BuglyDebug = Boolean.valueOf(obj.getString("debug")).booleanValue();
            initSDK(appid, BuglyDebug, callbackContext);
            return true;
        }
        return false;
    }

    /**
     * 初始化SDK
     * @param buglyAPPID
     */
    private void initSDK(String buglyAPPID, boolean BuglyDebug, CallbackContext callbackContext) {
        CrashReport.initCrashReport(mContext, buglyAPPID, BuglyDebug);
        JSONObject res = new JSONObject();
        try {
            res.put("resCode", 0);
            res.put("message", "初始化成功");
            callbackContext.success(res);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

