package example.com.dingdandome;

/**
 * Created by lenovo on 2018/4/27.
 */

public class APIuil {
    //创建订单
    public static String createOrder(String price){
        String createdan="https://www.zhaoapi.cn/product/updateOrder?uid=3470&price="+price+"&source=android";
        return createdan;
    }

    //查看订单
    //http://120.27.23.105/product/getOrders?uid=71
    public static String getOrders(int page){
        String url="https://www.zhaoapi.cn/product/getOrders?uid=3981&page="+page+"&source=android";
        return url;
    }
}
