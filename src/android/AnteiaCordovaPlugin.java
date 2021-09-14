package anteia.cordova.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.LOG;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import co.anteia.registrationsdk.AnteiaSDK;
import co.anteia.registrationsdk.ui.aidetection.DetectionActivity;
import co.anteia.registrationsdk.ui.confirmemail.EmailActivity;
import co.anteia.registrationsdk.ui.confirmemail.PhoneActivity;
import co.anteia.registrationsdk.ui.dataentry.DataEntryActivity;
import co.anteia.registrationsdk.ui.termsandconditions.TermsAndConditionsActivity;

/**
 * This class echoes a string called from JavaScript.
 */
public class AnteiaCordovaPlugin extends CordovaPlugin {

  private String apiKey;
  private String userName;
  private AnteiaSDK sdk = new AnteiaSDK();
  private boolean isInitialized = false;
  private int LAUNCH_TERMS_CODE = 100;
  private int LAUNCH_DATA_ENTRY = 101;
  private int LAUNCH_EMAIL_CODE = 102;
  private int LAUNCH_PHONE_CODE = 103;
  private CallbackContext call;

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    this.call = callbackContext;
    LOG.e("EXECUTE", action);
    switch (action) {
      case "setCredentials":
        String userName = args.getString(0);
        String apiKey = args.getString(1);
        String projectId = args.getString(2);
        this.setCredentials(userName, apiKey, projectId, callbackContext);
        return true;
      case "launchTermsAndConditions":
        this.launchTermsAndConditions(callbackContext);
        return true;
      case "launchDataEntry":
        String regId = args.getString(0);
        this.launchDataEntry(regId, callbackContext);
        return true;
      case "launchConfirmEmail":
        String regId2 = args.getString(0);
        this.launchEmail(regId2, callbackContext);
        return true;
      case "launchConfirmPhone":
        String regId3 = args.getString(0);
        this.launchPhone(regId3, callbackContext);
        return true;
      case "launchBiometrics":
        String regId4 = args.getString(0);
        this.launchBiometrics(regId4, callbackContext);
        return true;

    }
    return false;
  }

  private void coolMethod(String message, CallbackContext callbackContext) {
    if (message != null && message.length() > 0) {
      callbackContext.success(message);
    } else {
      callbackContext.error("Expected one non-empty string argument.");
    }
  }

  public void setCredentials(String userName, String apiKey, String projectId, CallbackContext call) {
    Log.d("ANTEIA SDK", "SetCredentialsCalled");
    if (userName == null || apiKey == null || projectId == null) {
      call.error("Empty username or api key");
      return;
    }
    this.apiKey = apiKey;
    this.userName = userName;
    sdk.setupUser(userName, apiKey);
    sdk.setupKeys(projectId);
    isInitialized = true;
    call.success();
  }

  public void launchTermsAndConditions(CallbackContext call) {
    cordova.setActivityResultCallback(this);
    if (!isInitialized) {
      call.error("ERROR: SDK Not Initialized!");
      return;
    }
    CordovaPlugin command = this;
    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(cordova.getActivity(), TermsAndConditionsActivity.class);
        cordova.startActivityForResult(command, intent, LAUNCH_TERMS_CODE);
      }
    });

  }

  public void launchDataEntry(String regId, CallbackContext call) {
    cordova.setActivityResultCallback(this);
    if (!isInitialized) {
      call.error("ERROR: SDK Not Initialized!");
      return;
    }
    if (regId == null || regId.equals("")) {
      call.error("Empty registrationId!");
      return;
    }
    CordovaPlugin command = this;
    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(cordova.getActivity(), DataEntryActivity.class);
        Bundle b = new Bundle();
        b.putString("registrationID", regId);
        intent.putExtras(b);
        cordova.startActivityForResult(command, intent, LAUNCH_DATA_ENTRY);
      }
    });
  }

  public void launchPhone(String regId, CallbackContext call) {
    cordova.setActivityResultCallback(this);
    if (!isInitialized) {
      call.error("ERROR: SDK Not Initialized!");
      return;
    }
    if (regId == null || regId.equals("")) call.error("Empty registrationId!");
    CordovaPlugin command = this;
    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(cordova.getActivity(), PhoneActivity.class);
        Bundle b = new Bundle();
        b.putString("registrationID", regId);
        intent.putExtras(b);
        cordova.startActivityForResult(command, intent, LAUNCH_DATA_ENTRY);
      }
    });
  }

  public void launchEmail(String regId, CallbackContext call) {
    cordova.setActivityResultCallback(this);
    if (!isInitialized) {
      call.error("ERROR: SDK Not Initialized!");
      return;
    }
    if (regId == null || regId.equals("")) call.error("Empty registrationId!");
    CordovaPlugin command = this;
    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(cordova.getActivity(), EmailActivity.class);
        Bundle b = new Bundle();
        b.putString("registrationID", regId);
        intent.putExtras(b);
        cordova.startActivityForResult(command, intent, LAUNCH_DATA_ENTRY);
      }
    });
  }

  public void launchBiometrics(String regId, CallbackContext call) {
    cordova.setActivityResultCallback(this);
    if (!isInitialized) {
      call.error("ERROR: SDK Not Initialized!");
      return;
    }
    if (regId == null || regId.equals("")) call.error("Empty registrationId!");
    CordovaPlugin command = this;
    cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Intent intent = new Intent(cordova.getActivity(), DetectionActivity.class);
        Bundle b = new Bundle();
        b.putString("registrationID", regId);
        intent.putExtras(b);
        cordova.startActivityForResult(command, intent, LAUNCH_DATA_ENTRY);
      }
    });
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent result) {
    if (resultCode != Activity.RESULT_OK) {
      return;
    }
    try {
      if (requestCode == LAUNCH_TERMS_CODE) {
        String resString = result.getExtras().getString("response");
        Log.d("resultado", result.toString());
        String registrationId = result.getExtras().getString("registrationId");
        Log.d("registration ID", registrationId.toString());
        JSONObject ret = new JSONObject();
        ret.put("registrationId", registrationId);
        call.success(ret);
        return;
      }
      if (requestCode == LAUNCH_DATA_ENTRY) {
        String resString = result.getExtras().getString("registration");
        Log.e("Result:::", resString);
        JSONObject jsObject = new JSONObject(resString);
        call.success(jsObject);
        return;
      }

    } catch (JSONException e) {
      call.error("Error inesperado :c");
    }
  }
}

