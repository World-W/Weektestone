package com.example.wangshijie_20200224.utiuls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 王世杰
 * 20200224
 */
public class NetUtiuls {
    private static NetUtiuls netUtiuls=new NetUtiuls();
//    使用单例模式封装网络工具类
    public NetUtiuls() {
    }
//    封装网络响应接口回调，在回调中封装响应成功和响应失败的方法
    public static NetUtiuls getInstance(){
        return netUtiuls;
    }
    private Handler handler=new Handler();
    public interface ICallBack{
        void onSuceess(String json);
        void onError(String msg);
    }
//    封装网络状态判断的方法，判断有网，无网
    public boolean isNet(Context context){
        ConnectivityManager com= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = com.getActiveNetworkInfo();
        if (info!=null){
            return true;
        }
        return false;
    }
    public void getJson(final String path, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len=0;
                        byte[] by = new byte[1024];
                        StringBuilder builder = new StringBuilder();
                        while ((len=inputStream.read(by))!=-1){
                            builder.append(new String(by,0,len));
                        }
                        inputStream.close();
                        final String json = builder.toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallBack.onSuceess(json);
                            }
                        });

                    }else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                iCallBack.onError("读取失败");
                            }
                        });
                    }
                } catch (final Exception e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iCallBack.onError(e.toString());
                        }
                    });
                }
            }
        }).start();
    }
}
