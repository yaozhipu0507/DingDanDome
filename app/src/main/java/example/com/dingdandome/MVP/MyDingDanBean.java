package example.com.dingdandome.MVP;

import java.util.List;

/**
 * Created by lenovo on 2018/4/27.
 */

public class MyDingDanBean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-12-19T20:41:40","orderid":3590,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:13:31","orderid":3770,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:13:51","orderid":3772,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:14:13","orderid":3774,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:14:15","orderid":3775,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:14:15","orderid":3776,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:14:16","orderid":3777,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:14:16","orderid":3778,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:14:16","orderid":3779,"price":198,"status":0,"title":"订单测试标题3981","uid":3981},{"createtime":"2017-12-20T14:49:07","orderid":3858,"price":10563,"status":0,"title":"订单测试标题3981","uid":3981}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-12-19T20:41:40
         * orderid : 3590
         * price : 198.0
         * status : 0
         * title : 订单测试标题3981
         * uid : 3981
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private String title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
