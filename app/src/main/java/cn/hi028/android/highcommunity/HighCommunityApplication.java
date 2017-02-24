package cn.hi028.android.highcommunity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.hpw.mvpframe.CoreApp;

import java.util.List;


public class HighCommunityApplication extends CoreApp{
    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;
    @Override
    public String setBaseUrl() {
        return "http://028hi.cn/api/";
    }


    //    public static LocationClient mLocationClient;
//    public BDLocationListener myListener = new MyLocationListener();
//    public static boolean isLogOut = false;
//    public static SharedPreferences share;
//    public static int SoftKeyHight = 0;
//    public static UserInfoBean mUserInfo = new UserInfoBean();
//    HighCommunityUtils mDongUtils = null;
    public static Typeface TypeFaceYaHei;

    public static HighCommunityApplication getApp() {
        return app;
    }

    static HighCommunityApplication app;
    static boolean isAliPayInStalled;
    static final String Tag = "HiApplication->";

    @Override
    public void onCreate() {
        super.onCreate();
//        JPushInterface.setDebugMode(true); // 设置开启日志,发布时请关闭日志
//        JPushInterface.init(this); // 初始化 JPush
//        /**第三个参数为SDK调试模式开关，建议在测试阶段建议设置成true，发布时设置为false。*/
//        CrashReport.initCrashReport(getApplicationContext(), "63e6f78cb5", false);
//        /**自定义的crash 处理 将crash保存在文件中通过服务器上传   运营时用 现在没用到**/
//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());
        app = this;
        //初始化屏幕宽高
        getScreenSize();
        //app强制使用简黑字体
//        TypeFaceYaHei = Typeface.createFromAsset(getAssets(), "ltjianhei.ttf");
//        try {
//            Field field = Typeface.class.getDeclaredField("SERIF");
//            field.setAccessible(true);
//            field.set(null, TypeFaceYaHei);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        Fresco.initialize(this);//初始化Fresco
//        RongIM.init(this);//初始化融云
        //初始化各种工具
//        mDongUtils = HighCommunityUtils.GetInstantiation();
//        BpiHttpClient.initCookies(this);
//        HighCommunityUtils.GetInstantiation().SetApplicationContext(this);
//        Constacts.APPVERSION = mDongUtils.getVersion(getApplicationContext());
//        mDongUtils.SetApplicationContext(getApplicationContext());
//        mDongUtils.getScreenInfo(getApplicationContext());
//        mDongUtils.initUniveralImage(getApplicationContext(),
//                new MyImageDownloader(getApplicationContext(),
//                        BpiHttpClient.mPersistentCookieStore));
//        mDongUtils.initSoundVibrator(getApplicationContext());
//        mDongUtils.initFileDir("hishequ");
//        // mDongUtils.getNetworkState(this);
//        share = getSharedPreferences("APPInformation", 0);
        //定位init
//        mLocationClient = new LocationClient(this.getApplicationContext()); //声明LocationClie
//        mLocationClient.registerLocationListener(this);//注册监听函数
//        x.Ext.init(this);//这是啥？
//        isAliPayInStalled = isAliPayInStalled();//检测是否安装支付宝
//        Log.d(Tag, "-isAliPayInStalled：" + isAliPayInStalled);
//       new UpdateUtil(getApplicationContext()).checkUpdate();
        /**配置okhttp**/
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
////                .addInterceptor(new LoggerInterceptor("TAG"))
//                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
//                .readTimeout(10000L, TimeUnit.MILLISECONDS)
//                .build();
//        OkHttpUtils.initClient(okHttpClient);

    }
    public void getScreenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }
    /**
     * 保存用户信息
     */
//    public static void SaveUser() {
//        if (mUserInfo != null) {
//            share.edit().putInt("USERID", mUserInfo.getId()).commit();
//            share.edit().putInt("VILLAGEID", mUserInfo.getV_id()).commit();
//        }
//    }

//    @Override
//    public void onReceiveLocation(BDLocation location) {
//        Constacts.location = location;
//    }

    /**
     * 判断支付宝是否安装
     *
     * @return
     */
    public static boolean isAliPayInStalled() {
        boolean isAliPayInStalled = false;
        PackageManager pm = app.getPackageManager();
        List<PackageInfo> list2 = pm.getInstalledPackages(0);
        for (PackageInfo packageInfo : list2) {
            String appName = packageInfo.applicationInfo.loadLabel(app.getPackageManager()).toString();
            String packageName = packageInfo.packageName;
            if (packageName.equals("com.eg.android.AlipayGphone")) {
                isAliPayInStalled = true;
                return isAliPayInStalled;
            }
        }
        return isAliPayInStalled;
    }

    public static int screenWidth;// 屏幕宽度
    public static int screenHeight;// 屏幕高度
    public static int densityDpi;// 屏幕密度
    public float scale;// 缩放系数
    public static float fontScale;// 文字缩放系数
    public static int bigImgWith, bigImgHeight, smallImgWith;
    public final static int SCREEN_ORIENTATION_VERTICAL = 1; // 屏幕状态：横屏
    public final static int SCREEN_ORIENTATION_HORIZONTAL = 2; // 屏幕状态：竖屏
    public static int screenOrientation = SCREEN_ORIENTATION_VERTICAL;// 当前屏幕状态，默认为竖屏

//    public static void toLoginAgain(Context context) {
//        HighCommunityApplication.isLogOut = true;
//        Intent i = new Intent(context, WelcomeAct.class);
//        i.putExtra(MenuLeftAct.ACTIVITYTAG, Constacts.MENU_LEFT_MESSAGECENTER);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        context.startActivity(i);
//
//    }

    public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }

}
