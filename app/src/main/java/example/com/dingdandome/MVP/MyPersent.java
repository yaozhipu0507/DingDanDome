package example.com.dingdandome.MVP;

/**
 * Created by lenovo on 2018/4/27.
 */

public class MyPersent {
    private final MyModel myModel;

    public MyPersent() {
        myModel = new MyModel();
    }

    public void getPerContent(String url, final MyJieKou myJieKou){
        myModel.getModContent(url, new MyJieKou() {
            @Override
            public void cheng(String json) {
                myJieKou.cheng(json);
            }

            @Override
            public void shibai(String ss) {
                myJieKou.shibai(ss);
            }
        });
    }
}
