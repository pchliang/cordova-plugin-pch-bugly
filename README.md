# cordova-plugin-pch-bugly
### 前言：
cordova-plugin-pch-bugly插件是集成了腾讯Bugly的插件。

****
### SDK更新
2021-07-13从官网下载最新SDK
android包从原来的jar, 改为aar方便日后更新

****
### 支持平台
1. android
2. iOS
##### note：xcode版本须大于7.0

****
### 安装
##### 在线安装
    cordova plugin add cordova-plugin-pch-bugly

##### 本地安装
下载插件到本地
    cordova plugin add /your/local/path
    
****
### 使用 API
	var params = {
		appid: 'Bugly_appid',
		debug: false
	}
	cordova.plugins.bugly.initSDK(params, (res)=>{
		console.log(res)
	})