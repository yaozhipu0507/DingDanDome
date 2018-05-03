package example.com.dingdandome.Utils;


/**
 * Created by lenovo on 2018/4/27.
 */

public class CommonUtils {

    public static void runOnUIThread(Runnable runable) {
        //先判断当前属于子线程还是主线程
        if (android.os.Process.myTid() == DashApplication.getMainThreadId()) {
            runable.run();
        } else {
            //子线程
            DashApplication.getAppHanler().post(runable);
        }
    }
}
