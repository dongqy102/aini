package com.bawei.erlian.model;

import com.bawei.erlian.contates.Icontates;
import com.bawei.erlian.net.NetVolley;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 9:12
 * @Description:
 */
public class ModelMvp implements Icontates.Imodel {
    @Override
    public void getIfon(String url, final Icontates.MyModelCallBack myModelCallBack) {
        NetVolley.getInstance().doGet(url, new NetVolley.MyCallBack() {
            @Override
            public void onSccess(String json) {
                 myModelCallBack.onSccess(json);
            }

            @Override
            public void onErrorSccess(String error) {
                 myModelCallBack.onErrorSccess(error);
            }
        });
    }

    @Override
    public void postIfon(String url, Icontates.MyModelCallBack myModelCallBack) {

    }
}
