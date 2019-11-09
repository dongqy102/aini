package com.bawei.erlian;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.erlian.adapter.Myadapter;
import com.bawei.erlian.bace.BaceActivity;
import com.bawei.erlian.bace.BacePresenter;
import com.bawei.erlian.bean.JsonBean;
import com.bawei.erlian.net.MyGidle;
import com.bawei.erlian.net.NetStates;
import com.bawei.erlian.presenter.PresenterMvp;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends BaceActivity {

     private  String urls="http://blog.zhaoliang5156.cn/api/shop/fulishe1.json";
    private RecyclerView rv;
    private XBanner xbanner;

    @Override
    protected void setCoDing() {

    }

    @Override
    protected void initData() {
            if(NetStates.getInstance().hasNet(this)){
                mPresenter.start(urls);
            }else {
                Toast.makeText(this, "没有网络", Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    protected void initView() {

        xbanner = findViewById(R.id.xbanner);
        rv =  findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
      rv.setLayoutManager(layoutManager);
    }

    @Override
    protected BacePresenter initPresenter() {
        return new PresenterMvp();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSccess(String json) {
        JsonBean jsonBean = new Gson().fromJson(json, JsonBean.class);
        final List<JsonBean.BannerBean> banners = jsonBean.getBanner();
        List<JsonBean.DataBean> data = jsonBean.getData();
        xbanner.setBannerData(banners);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                MyGidle.LodeUrl(banners.get(position).getImageUrl(), (ImageView) view);
//                Glide.with(MainActivity.this)
//                        .load(urls)
//                        .error(R.drawable.ic_launcher_foreground)
//                        .placeholder(R.mipmap.ic_launcher)
//                        .into((ImageView) view);
            }
        });
        rv.setAdapter(new Myadapter(this,data));

    }

    @Override
    public void onError(String error) {

    }


}
