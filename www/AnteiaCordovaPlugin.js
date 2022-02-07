var exec = require("cordova/exec");

var PLUGIN_NAME = "AnteiaCordovaPlugin";

exports.launchTermsAndConditions = function (success, error) {
  exec(success, error, PLUGIN_NAME, "launchTermsAndConditions", []);
};

exports.launchDataEntry = function (regId, success, error) {
  exec(success, error, PLUGIN_NAME, "launchDataEntry", [regId]);
};

exports.launchConfirmEmail = function (regId, success, error) {
  exec(success, error, PLUGIN_NAME, "launchConfirmEmail", [regId]);
};

exports.launchConfirmPhone = function (regId, success, error) {
  exec(success, error, PLUGIN_NAME, "launchConfirmPhone", [regId]);
};

exports.launchBiometrics = function (regId, success, error) {
  exec(success, error, PLUGIN_NAME, "launchBiometrics", [regId]);
};

exports.executeLists = function (regId, success, error) {
  exec(success, error, PLUGIN_NAME, "executeLists", [regId]);
};

exports.gerRegistration = function (regId, success, error) {
  exec(success, error, PLUGIN_NAME, "getRegistration", [regId]);
};

exports.setCredentials = function (
  userName,
  apiKey,
  projectId,
  success,
  error
) {
  exec(success, error, PLUGIN_NAME, "setCredentials", [
    userName,
    apiKey,
    projectId,
  ]);
};
