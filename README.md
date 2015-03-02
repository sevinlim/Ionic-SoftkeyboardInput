Keyboard
======

The `cordova.plugins.SoftKeyboardInput` object provides functions to modify the Android's soft keyboard input mode.

    cordova plugin add https://github.com/sevinlim/ionic-plugins-softkeyboardinput.git

Methods
-------

- cordova.plugins.SoftKeyboardInput.setInputMode
  - pan
  - nothing
  - resize

Permissions
-----------

#### config.xml

		<feature name="IonicSoftKeyboardInput">
        	<param name="android-package" value="com.ionic.IonicSoftKeyboardInput" />
      	</feature>


SoftKeyboardInput.setInputMode
=================

Change the soft keyboard input method

    cordova.plugins.SoftKeyboardInput.setInputMode("pan");
    cordova.plugins.SoftKeyboardInput.setInputMode("nothing");
    cordova.plugins.SoftKeyboardInput.setInputMode("resize");

Supported Platforms
-------------------

- Android