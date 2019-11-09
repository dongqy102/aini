package com.bawei.erlian.bace;

import com.bawei.erlian.contates.Icontates;

import java.lang.ref.WeakReference;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 9:08
 * @Description:
 */
public  abstract class BacePresenter <V extends Icontates.Iview> implements  Icontates.Ipresenter {
     protected WeakReference <V> weakReference;
     //引用虚引用
    public BacePresenter() {
        initModel();
    }

    protected abstract void initModel();
     //绑定
    protected  void attch(V v){
         weakReference=new WeakReference<>(v);
    }
    //解除
    protected  void deAttch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }
    //定义view接口回调
    protected V getView(){
        return weakReference.get();
    }


}
