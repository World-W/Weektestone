package com.example.wangshijie_20200224.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.wangshijie_20200224.R;
import com.example.wangshijie_20200224.adapter.MyAdapter;
import com.example.wangshijie_20200224.base.Bean;
import com.example.wangshijie_20200224.prenster.InPrenster;
import com.example.wangshijie_20200224.utiuls.NetUtiuls;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

/**
 * 王世杰
 * 20200224
 */
public class MainActivity extends AppCompatActivity implements InContent.Iview {

    private InPrenster prenster;
    private XBanner xb;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url="http://blog.zhaoliang5156.cn/api/news/news_data.json";
        prenster = new InPrenster(this);
        prenster.getBanner(url);
        xb = findViewById(R.id.xb);
        lv = findViewById(R.id.lv);
    }

    @Override
    public void onSuccess(String url) {
        boolean net = NetUtiuls.getInstance().isNet(this);
        if (net){
//            使用解析的数据完成图1列表展示
            Log.i("xxx",url);
            Gson gson = new Gson();
            Bean bean = gson.fromJson(url, Bean.class);
            final List<Bean.ResultsBean> results = bean.getResults();
            Bean.ResultsBean resultsBean = results.get(0);
            List<Bean.ResultsBean.NewsistBean> newsist = resultsBean.getNewsist();
            final List<Bean.ResultsBean.BannerBean> b = resultsBean.getBanner();
            MyAdapter adapter = new MyAdapter(this, newsist);
            lv.setAdapter(adapter);
            xb.setBannerData(b);
            xb.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    String imageurl = b.get(position).getImageurl();
                    Glide.with(MainActivity.this).load(imageurl).into((ImageView) view);

                }
            });

        }
    }

    @Override
    public void onError(String url) {

    }
}
