package com.bawei.erlian.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.erlian.R;
import com.bawei.erlian.bean.JsonBean;
import com.bawei.erlian.net.MyGidle;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 9:35
 * @Description:
 */
public class Myadapter extends RecyclerView.Adapter<Myadapter.Holder> {
    private Context context;
    private List<JsonBean.DataBean> list;

    public Myadapter(Context context, List<JsonBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    private int type0=0;
    private int type1=1;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view=null;
          if(i==type0){
               view=View.inflate(context,R.layout.layout1,null);
          }else {
              view= LayoutInflater.from(context).inflate(R.layout.layout2,null);
          }

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        JsonBean.DataBean dataBean = list.get(i);
        holder.name.setText(dataBean.getGoods_name());
       MyGidle.LodeUrl(dataBean.getGoods_thumb(),holder.imgg);
//        Glide.with(context).load(dataBean.getGoods_thumb())
//                .into(holder.imgg);

    }

    @Override
    public int getItemViewType(int position) {
         if(position%2==0){
              return type0;
         }else {
             return type1;
         }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
           ImageView imgg;
           TextView name;
        public Holder(@NonNull View itemView) {
            super(itemView);
            imgg=itemView.findViewById(R.id.imgg);
            name=itemView.findViewById(R.id.name);
        }
    }
}
