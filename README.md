###[Hotmob](http://www.hot-mob.com/)
Mobile Advertising with Hotmob, the first and largest mobile ad network in Hong Kong, where monetizes the mobile taffic of the top ranked publishers into revenue and meanwhile connects advertisers to target audience effectively.

Visit http://www.hot-mob.com/ for more details.

### How To Get Started
---

* [Download Hotmob Android SDK](https://github.com/hotmobmobile/hotmob-android-sdk/archive/master.zip) and try out the included sample project
* Read the ["Getting Started" guide](https://github.com/hotmobmobile/hotmob-android-sdk/wiki/Getting-Started), ["Overview"](https://github.com/hotmobmobile/hotmob-android-sdk/wiki/Overview) , or [other articles on the Wiki](https://github.com/hotmobmobile/hotmob-android-sdk/wiki)
* Check out the [documentation](https://github.com/hotmobmobile/hotmob-android-sdk/wiki) for a comprehensive look at all of the APIs available in Hotmob SDK
* Read the [Hotmob SDK 4.0 Migration Guide](https://github.com/hotmobmobile/hotmob-android-sdk/wiki/HotmobSDK-4.0-Migration-Guide) for an overview of the architectural changes from 3.0 or below

### Integration 
1.) [Download the Hotmob Android SDK from Github](https://github.com/hotmobmobile/hotmob-android-sdk/archive/master.zip) or download link we provided.

2.) Drag the HotmobSDK folder into your project. (For Android Studio Project)

3.) Import HotmobSDK into Android Studio Project as a module.[You can find the Detail from Android Developer](http://developer.android.com/sdk/installing/create-project.html#ReferencingLibraryModule)

4.) Add the permission and Hotmob Activity Information to Project Manifest file.

> Add the following lines inside the <manifest> tag of the manifest:
``` xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.GET_TASKS" />
```
And add the following lines inside the <application> tag of the manifest:
```xml
<activity
     android:name="com.hotmob.sdk.core.activity.HotmobPopupActivity"
     android:configChanges="keyboardHidden|orientation|screenSize"
     android:theme="@android:style/Theme.Translucent.NoTitleBar" />
<activity
     android:name="com.hotmob.sdk.inapp.activity.HotmobBrowserActivity"
     android:configChanges="keyboardHidden|orientation|screenSize"
     android:launchMode="singleTop"
     android:theme="@android:style/Theme.Translucent.NoTitleBar" />
<activity
     android:name="com.hotmob.sdk.video.activity.HotmobVideoAdsActivity"
     android:configChanges="keyboardHidden|orientation|screenSize"
     android:screenOrientation="sensor"
     android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen" />
<activity
     android:name="com.hotmob.sdk.video.activity.HotmobVideoPlayerActivity"
     android:configChanges="keyboardHidden|orientation|screenSize"
     android:launchMode="singleTop"
     android:screenOrientation="sensor"
     android:theme="@android:style/Theme.Translucent.NoTitleBar.Fullscreen" />
```

5.) Following the HotmobAndroidSDKExampleBaseActivity.java in HotmobSDK example project to modify your base activity class.

6.) Start the HotmobSDK in first activity in your project.

``` java
HotmobManager.start(this);
HotmobManager.setDebug(true);
```
> You can try to implement following code to confirm `HotmobSDK`  is functional in your project.
``` java
// Add to `onCreate` at Launcher activity in your project
HotmobManager.getPopup(this, listener, "launch_popup", "hotmob_uat_android_image_inapp_popup", true, false);
```

### Requirements
---
| HotmobSDK Version     | Minimum Android Target         | Notes |
| --------              |---------                       |-------|
| 4.x                   | Android level 15               |   Updated to ARC structure   |
| 3.x                   | Android level 9                |   Architecture optimization    |

### Basic Usage
---

#### Popup
To create the Hotmob Popup can refercence following step.

1.) Start the HotmobManager Service
```java

//Start HotmobSDK service
HotmobManager.start(this);

//To enable debug mode on HotmobSDK
HotmobManager.setDebug(true);
```

2.) Create the HotmobManagerListener for the callback method.
```java
HotmobManagerListener listener = new HotmobManagerListener() {
     @Override
     public void didLoadBanner(View bannerView) {
         mBannerLayout.addView(bannerView);
     }
};
```

3.) Request the HotmobPopup 
```java
HotmobManager.getPopup(getActivity(), listener, identifier, adCode, true);
```
You can set any String value into identifier.
For adCode, please contact Hotmob to obtain suitable ad code.

  ---

####  Footer Banner
To create the Hotmob Banner can refercence following step.

1.) Make sure HotmobManager service is started.

2.) Create the HotmobManagerListener for the callback method.
```java
HotmobManagerListener listener = new HotmobManagerListener() {
     @Override
     public void didLoadBanner(View bannerView) {
         mBannerLayout.addView(bannerView);
     }
};
```

3.)  Request the HotmobBanner 

```java
View bottomBannerView = HotmobManager.getBanner(getActivity(), listener, HotmobManager.getScreenWidth(getActivity()), identifier, adCode);
```
You can set any String value into identifier.
For adCode, please contact Hotmob to obtain suitable ad code.

4.) Callback method didLoadBanner: will execute when the HotmobBanner ready. Add the banner into the current view as a subview.
```java
@Override
public void didLoadBanner(View bannerView) {
     mBannerLayout.addView(bannerView);
}
```

---
Other usage can refercence to wiki [Integrating Banner](https://github.com/hotmobmobile/hotmob-android-sdk/wiki/Integrating-Banner), [Integrating Popup](https://github.com/hotmobmobile/hotmob-android-sdk/wiki/Integrating-Popup).
### Contact
---
Website: [http://www.hot-mob.com](http://www.hot-mob.com/)