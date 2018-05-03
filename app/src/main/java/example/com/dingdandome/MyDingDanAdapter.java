package example.com.dingdandome;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import example.com.dingdandome.MVP.MyDingDanBean;

/**
 * Created by lenovo on 2018/4/27.
 */

public class MyDingDanAdapter extends RecyclerView.Adapter<MyDingDanAdapter.ViewHolder> {
    Context context;
    ArrayList<MyDingDanBean.DataBean> list;
    public MyDingDanAdapter(Context context, ArrayList<MyDingDanBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_dingdanbuju, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final MyDingDanBean.DataBean dataBean = list.get(position);
        holder.dingdanTitle.setText(dataBean.getTitle());
        if(dataBean.getStatus()==0){
            holder.dingdanStute.setText("待支付");
            holder.dingdanAnNiu.setText("取消订单");
        }else if(dataBean.getStatus()==1){
            holder.dingdanStute.setText("已支付");
            holder.dingdanAnNiu.setText("查看订单");
        }else if(dataBean.getStatus()==2){
            holder.dingdanStute.setText("已取消");
            holder.dingdanAnNiu.setText("查看订单");
        }
        holder.dingdanPrice.setText("价格："+dataBean.getPrice());
        holder.dingdanTime.setText(dataBean.getCreatetime());

        holder.dingdanAnNiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dataBean.getStatus()!=2){
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setTitle("确认取消订单吗？");
                    builder.setNegativeButton("取消",null);
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dataBean.setStatus(2);
                            holder.dingdanStute.setTextColor(Color.BLACK);
                            notifyDataSetChanged();
                        }
                    }).show();
                }else{
                    Toast.makeText(context,"订单已更改！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView dingdanTitle;
        public TextView dingdanStute;
        public TextView dingdanPrice;
        public TextView dingdanTime;
        public Button dingdanAnNiu;

        public ViewHolder(View itemView) {
            super(itemView);
            dingdanTitle = itemView.findViewById(R.id.dingdanTitle);
            dingdanStute = itemView.findViewById(R.id.dingdanStute);
            dingdanPrice = itemView.findViewById(R.id.dingdanPrice);
            dingdanTime = itemView.findViewById(R.id.dingdanTime);
            dingdanAnNiu = itemView.findViewById(R.id.dingdanAnNiu);
        }
    }
}