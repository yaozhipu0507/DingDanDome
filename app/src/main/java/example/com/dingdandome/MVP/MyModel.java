package example.com.dingdandome.MVP;

import java.io.IOException;

import example.com.dingdandome.Utils.CommonUtils;
import example.com.dingdandome.Utils.OkHttp3Util;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by lenovo on 2018/4/27.
 */

public class MyModel {
    public void getModContent(String url, final MyJieKou myJieKou){
        OkHttp3Util.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                CommonUtils.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        myJieKou.shibai("请求失败！");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String json = response.body().string();
                CommonUtils.runOnUIThread(new Runnable() {
                    @Override
                    public void run() {
                        myJieKou.cheng(json);
                    }
                });

            }
        });
    }
}
