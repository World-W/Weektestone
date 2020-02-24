package com.example.wangshijie_20200224.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wangshijie_20200224.R;
import com.example.wangshijie_20200224.base.Bean;

import java.util.List;

/**
 * 王世杰
 * 20200224
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultsBean.NewsistBean> list;
    public MyAdapter(Context context, List<Bean.ResultsBean.NewsistBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.item, null);
            holder=new ViewHolder();
            holder.iv=convertView.findViewById(R.id.iv);
            holder.t1=convertView.findViewById(R.id.t1);
            holder.t2=convertView.findViewById(R.id.t2);
            holder.t3=convertView.findViewById(R.id.t3);
            holder.t4=convertView.findViewById(R.id.t4);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Bean.ResultsBean.NewsistBean bean = list.get(position);
        String image = bean.getImage();
        Glide.with(context).load(image).into(holder.iv);
        String title = bean.getTitle();
        holder.t1.setText(title);
        String content = bean.getContent();
        holder.t2.setText(content);
        String author = bean.getAuthor();
        holder.t3.setText(author);
        String time = bean.getTime();
        holder.t4.setText(time);
        return convertView;
    }
//    iv.	（复习）优化列表
    public class ViewHolder{
        ImageView iv;
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
    }
}
