package com.example.wangshijie_20200224.activity;
/**
 * 王世杰
 * 20200224
 */
public interface InContent {
//    项目采用MVP架构，分包明确
//    使用契约统一管理MVP接口
    interface Iview{
        void onSuccess(String url);
        void onError(String url);
    }
    interface Iprenster{
        void getBanner(String url);
    }
    interface Imoudle{
        void getBanner(String url, Iback iback);
        interface Iback{
            void onSuccess(String url);
            void onError(String url);
        }
    }
}
