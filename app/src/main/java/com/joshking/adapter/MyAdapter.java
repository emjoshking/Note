package com.joshking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.joshking.data.Data;
import com.joshking.note.R;


import java.util.ArrayList;

/**
 * Created by Joshking on 2017/6/3.
 */

public class MyAdapter extends BaseAdapter{

    LayoutInflater inflater;
    ArrayList<Data> array;

    public MyAdapter(LayoutInflater inf,ArrayList<Data> arry){
        this.inflater = inf;
        this.array = arry;
    }

    public int getCount() {
        return array.size();
    }

    public Object getItem(int position) {
        return array.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=inflater.inflate(R.layout.adapter_listview, null);//注意导包，别导系统包
            vh.tv1=(TextView) convertView.findViewById(R.id.textView1);
            vh.tv2=(TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(vh);
        }
        vh=(ViewHolder) convertView.getTag();
        vh.tv1.setText(array.get(position).getTitle());
        vh.tv2.setText(array.get(position).getTimes());
        return convertView;
    }

    class ViewHolder{
        TextView tv1,tv2;
    }
}
