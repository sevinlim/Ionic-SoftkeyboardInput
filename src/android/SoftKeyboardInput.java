package com.ionic.softkeyboard;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.view.WindowManager;

public class SoftKeyboardInput extends CordovaPlugin {
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if ("setInputMode".equals(action)) {
			if (!args.isNull(0)) {
				final String inputMode_s = args.get(0).toString();
				
				// run on ui thread http://stackoverflow.com/questions/18406722/changing-keepscreenon-from-javascript-in-android-cordova-app
				cordova.getActivity().runOnUiThread(new Runnable() {
					public void run() {
						int inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
						if (inputMode_s.equals("pan")) {
							inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
						}
						else if (inputMode_s.equals("resize")) {
							inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
						}
						cordova.getActivity().getWindow().setSoftInputMode(inputMode_i);
						callbackContext.success(); // Thread-safe.
						
					}
				});
				return true;
			}
			else {
				callbackContext.error("No arguments found");
				return false;
			}
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }


}

