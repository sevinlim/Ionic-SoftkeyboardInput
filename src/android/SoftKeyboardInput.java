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
    	System.out.println("Running exec func");
        if ("setInputMode".equals(action)) {
			if (!args.isNull(0)) {
				final String inputMode_s = args.get(0).toString();
				
// 				cordova.getActivity().runOnUiThread(new Runnable() {
// 					public void run() {
// 						int inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
// 						if (inputMode_s.equals("pan")) {
// 							inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
// 							System.out.println("Set soft keyboard input mode pan");
// 						}
// 						else if (inputMode_s.equals("resize")) {
// 							inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
// 							System.out.println("Set soft keyboard input mode resize");
// 						}
// 						cordova.getActivity().getWindow().setSoftInputMode(inputMode_i);
// 						callbackContext.success(); // Thread-safe.
// 						
// 					}
// 				});

				
				cordova.getThreadPool().execute(new Runnable() {
					public void run() {
						int inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
						if (inputMode_s.equals("pan")) {
							inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
							System.out.println("Set soft keyboard input mode pan");
						}
						else if (inputMode_s.equals("resize")) {
							inputMode_i = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
							System.out.println("Set soft keyboard input mode resize");
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

