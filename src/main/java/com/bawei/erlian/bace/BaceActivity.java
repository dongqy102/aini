package com.bawei.erlian.bace;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.erlian.contates.Icontates;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 9:20
 * @Description:
 */
public abstract class BaceActivity <P extends BacePresenter> extends AppCompatActivity implements Icontates.Iview {
     public   P  mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(provideLayoutId()!=0){
            setContentView(provideLayoutId());
            mPresenter=initPresenter();
            if (mPresenter != null) {
                mPresenter.attch(this);
            }
            initView();
            initData();
             setCoDing();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.deAttch();
            mPresenter=null;
        }
    }

    protected abstract void setCoDing();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();


    protected abstract int provideLayoutId();


}
