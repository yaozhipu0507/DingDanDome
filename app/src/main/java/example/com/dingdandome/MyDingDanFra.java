package example.com.dingdandome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import example.com.dingdandome.MVP.MyDingDanBean;
import example.com.dingdandome.MVP.MyJieKou;
import example.com.dingdandome.MVP.MyPersent;

/**
 * Created by lenovo on 2018/4/27.
 */

public class MyDingDanFra extends Fragment {
    private XRecyclerView dingdanXRecyclerView;
    private MyPersent myPersent;
    int page=1;
    ArrayList<MyDingDanBean.DataBean> list = new ArrayList<>();
    private MyDingDanAdapter myDingDanAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_mydingdanfra, container, false);
        dingdanXRecyclerView = view.findViewById(R.id.dingdanXRecyclerView);
        dingdanXRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL,false));

        myPersent = new MyPersent();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        String ss = MainActivity.ss;
        if(ss.equals("全部")){

        }
        getFirstDingDanContent();

        dingdanXRecyclerView.setPullRefreshEnabled(true);
        dingdanXRecyclerView.setLoadingMoreEnabled(true);
        dingdanXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        dingdanXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        dingdanXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Log.i("jiba","onRefresh====");
                getMainDingDanContent();
                dingdanXRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Log.i("jiba","onLoadMore====");
                dingdanXRecyclerView.loadMoreComplete();
            }
        });

    }

    private void getFirstDingDanContent() {
        page=1;
        myPersent.getPerContent(APIuil.getOrders(page), new MyJieKou() {
            @Override
            public void cheng(String json) {
                Gson gson = new Gson();
                MyDingDanBean myDingDanBean = gson.fromJson(json, MyDingDanBean.class);

                if(myDingDanBean.getCode().equals("0")){
                    String ss = MainActivity.ss;
                    List<MyDingDanBean.DataBean> data = myDingDanBean.getData();
                    if(ss.equals("全部")){
                        list.clear();
                        list.addAll(data);
                    }else if(ss.equals("待支付")){
                        list.clear();
                        for (MyDingDanBean.DataBean d:data) {
                            if(d.getStatus()==0){
                                list.add(d);
                            }
                        }
                    }else if(ss.equals("已支付")){
                        list.clear();
                        for (MyDingDanBean.DataBean d:data) {
                            if(d.getStatus()==1){
                                list.add(d);
                            }
                        }
                    }else if(ss.equals("已取消")){
                        list.clear();
                        for (MyDingDanBean.DataBean d:data) {
                            if(d.getStatus()==2){
                                list.add(d);
                            }
                        }
                    }
                    if(list.size()>0){
                        setDingDanAdapter();
                    }else{
                        Toast.makeText(getActivity(),"该状态下没有订单",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(),myDingDanBean.getMsg(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void shibai(String ss) {
                Toast.makeText(getActivity(),ss,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMainDingDanContent() {
        page++;
        myPersent.getPerContent(APIuil.getOrders(page), new MyJieKou() {
            @Override
            public void cheng(String json) {
                Gson gson = new Gson();
                MyDingDanBean myDingDanBean = gson.fromJson(json, MyDingDanBean.class);
                if(myDingDanBean.getCode().equals("0")){
                    String ss = MainActivity.ss;
                    List<MyDingDanBean.DataBean> data = myDingDanBean.getData();

                    if(data.size()>0){
                        if(ss.equals("全部")){
                            list.addAll(data);
                        }else if(ss.equals("待支付")){
                            for (MyDingDanBean.DataBean d:data) {
                                if(d.getStatus()==0){
                                    list.add(d);
                                }
                            }
                        }else if(ss.equals("已支付")){
                            for (MyDingDanBean.DataBean d:data) {
                                if(d.getStatus()==1){
                                    list.add(d);
                                }
                            }
                        }else if(ss.equals("已取消")){
                            for (MyDingDanBean.DataBean d:data) {
                                if(d.getStatus()==2){
                                    list.add(d);
                                }
                            }
                        }
                        if(list.size()>0){
                            setDingDanAdapter();
                        }else{
                            Toast.makeText(getActivity(),"该状态下没有订单",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        page=1;
                        Toast.makeText(getActivity(),"没有下一页啦！",Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(getActivity(),myDingDanBean.getMsg(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void shibai(String ss) {
                Toast.makeText(getActivity(),ss,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setDingDanAdapter() {
        if (myDingDanAdapter == null) {
            myDingDanAdapter = new MyDingDanAdapter(getActivity(), list);
            dingdanXRecyclerView.setAdapter(myDingDanAdapter);
        } else {
            myDingDanAdapter.notifyDataSetChanged();
        }
    }
}
