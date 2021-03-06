# Cordova 微博插件

## 功能
- 微博SSO 登录
- 微博登出
- 微博网页分享
- 检查微博官方客户端是否安装

##安装要求
- Cordova Version >=3.5
- Cordova-Android >=4.0
- Cordova-iOS >=4.0

## 安装
1. 命令行运行 ```cordova plugin add https://github.com/giantss/cordova-plugin-weibo --variable WEIBO_APP_ID=YOUR_WEIBO_APPID``` 
2. 在你的config.xml文件中添加 ```<preference name="REDIRECTURI" value="YOUR_WEIBO_REDIRECTURI" />``` 如果你不添加这个选项，那么默认的 redirecturi 是 https://api.weibo.com/oauth2/default.html(官方建议使用默认回调地址)               
3. 命令行运行cordova build   					

#注意事项
1. 这个插件要求cordova-android 的版本 >=4.0,推荐使用 cordova  5.0.0 或更高的版本，因为从cordova 5.0 开始cordova-android 4.0 是默认使用的android版本
2.   请在cordova的deviceready事件触发以后再调用本插件!!!!!  
3. <del>在低于5.1.1的cordova版本中存在一个Bug，如果你有多个插件要修改iOS工程中的 “*-Info.plist” CFBundleURLTypes, 只有第一个安装的插件才会生效.所以安装完插件请务必在你的Xcode工程里面检查一下URLTypes。 关于这个bug的详情你可以在 [这里](https://issues.apache.org/jira/browse/CB-8007)找到</del> 建议安装使用5.1.1及以上的cordova版本 				

## 问题				
1.在不使用客户端分享进行分享的时候，网页分享会变成文字分享			

##使用方法
### 微博SSO登录
```Javascript
YCWeibo.ssoLogin(function(args){
		alert("access token is "+args.access_token);
		alert("userid is "+args.userid);
		alert("expires_time is "+ new Date(parseInt(args.expires_time)) + " TimeStamp is " +args.expires_time);
      },function(failReason){
         console.log(failReason);
});
```
### 微博登出
```Javascript
YCWeibo.logout(function(){
	console.log('logout success');
},function(failReason){
	console.log(failReason);
});
```
### 微博网页分享
```Javascript
var args = {};
args.url = "http://www.baidu.com";
args.title = "Baidu";
args.description = "This is Baidu";
args.imageUrl = "https://www.baidu.com/img/bdlogo.png";//if you don't have imageUrl,for android http://www.sinaimg.cn/blog/developer/wiki/LOGO_64x64.png will be the defualt one
args.defaultText = "";
YCWeibo.shareToWeibo(function () {
    alert("share success");
 }, function (failReason) {
    alert(failReason);
}, args);
```
### 检查微博客户端是否安装了
```Javascript
YCWeibo.checkClientInstalled(function(){
	console.log('client is installed');
},function(){
	console.log('client is not installed');
});
```
#android效果图

<div style="text-align:center"><img src="https://raw.githubusercontent.com/giantss/cordova-plugin-weibo/master/1.jpg?raw=true" alt="example" width="300px"></div>		
<div style="text-align:center"><img src="https://raw.githubusercontent.com/giantss/cordova-plugin-weibo/master/2.jpg?raw=true" alt="example" width="300px"></div>		

#ios效果图

<div style="text-align:center"><img src="https://raw.githubusercontent.com/giantss/cordova-plugin-weibo/master/3.PNG?raw=true" alt="example" width="300px"></div>		
<div style="text-align:center"><img src="https://raw.githubusercontent.com/giantss/cordova-plugin-weibo/master/4.PNG?raw=true" alt="example" width="300px"></div>	

