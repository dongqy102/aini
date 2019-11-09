package com.bawei.erlian.presenter;

import android.util.Log;

import com.bawei.erlian.bace.BacePresenter;
import com.bawei.erlian.contates.Icontates;
import com.bawei.erlian.model.ModelMvp;

import javax.security.auth.login.LoginException;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 9:13
 * @Description:
 */
public class PresenterMvp extends BacePresenter {
     public ModelMvp modelMvp;

    @Override
    protected void initModel() {
         modelMvp=new ModelMvp();
    }

    @Override
    public void start(String url) {
       modelMvp.getIfon(url, new Icontates.MyModelCallBack() {
           @Override
           public void onSccess(String json) {
               getView().onSccess(json);
           }

           @Override
           public void onErrorSccess(String error) {
             getView().onError(error);
           }
       });
    }
}
