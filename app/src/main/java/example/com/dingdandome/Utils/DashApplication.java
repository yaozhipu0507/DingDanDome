package example.com.dingdandome.Utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by lenovo on 2018/4/27.
 */

public class DashApplication extends Application{
    private static Context context;
    private static Handler handler;
    private static int mainId;
    public static boolean isLoginSuccess;//是否已经登录的状态


    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        //初始化handler
        handler = new Handler();

    }

    /**
     * 得到全局的handler
     * @return
     */
    public static Handler getAppHanler() {
        return handler;
    }

    /**
     * 获取主线程id
     * @return
     */
    public static int getMainThreadId() {
        return mainId;
    }
}
