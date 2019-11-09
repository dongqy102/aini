package com.bawei.erlian.contates;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 9:04
 * @Description:
 */
public interface Icontates {
     interface MyModelCallBack{
         void  onSccess(String json);
         void  onErrorSccess(String error);
     }

     interface Imodel{
         void getIfon(String url,MyModelCallBack myModelCallBack);
         void postIfon(String url,MyModelCallBack myModelCallBack);
     }
     interface Iview{
         void  onSccess(String json);
         void  onError(String error);
     }
     interface Ipresenter{
         void start(String url);
     }



}
