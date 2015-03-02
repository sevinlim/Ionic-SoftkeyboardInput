
var argscheck = require('cordova/argscheck'),
    utils = require('cordova/utils'),
    exec = require('cordova/exec');

var SoftKeyboardInput = function() {
};

SoftKeyboardInput.setInputMode = function(mode) {
	console.log("Executing soft keyboard input");
    exec(null, null, "SoftKeyboardInput", "setInputMode", [mode]);
};

module.exports = SoftKeyboardInput;



