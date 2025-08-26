var exec = require('cordova/exec');

var PLUGIN_NAME = 'Bugly'

var Bugly = {
    // 初始化sdk
    initSDK: function (arg0, success, error) {
        exec(success, error, PLUGIN_NAME, 'initSDK', [arg0]);
    }
}

module.exports = Bugly;