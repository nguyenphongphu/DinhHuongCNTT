package com.example.nhan.dinhhuongcntt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nhan.dinhhuongcntt.Calss.Danhsach;
import com.example.nhan.dinhhuongcntt.R;

import java.util.ArrayList;

public class Customdanhsach extends BaseAdapter {
    private Context context;
    private int  layout;
    private ArrayList<Danhsach> array;
    public Customdanhsach(Context context, int layout, ArrayList<Danhsach> array) {
        this.context = context;
        this.layout = layout;
        this.array = array;
    }
    @Override
    public int getCount() {
        return array.size();
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
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder=new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(layout,null);
            viewHolder.so=convertView.findViewById(R.id.item_ds_so);
            viewHolder.lam=convertView.findViewById(R.id.item_ds_kq);
            viewHolder.linearLayout=convertView.findViewById(R.id.hien_thi_ddau);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        int so=array.get(position).id;
        String lam=array.get(position).lam;
        String dau=array.get(position).dau;
        viewHolder.so.setText(String.valueOf(so));
        viewHolder.lam.setText(lam);
        if(dau=="VISIBLE"){
            viewHolder.linearLayout.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
    public  class ViewHolder {
        TextView so,lam;
        LinearLayout linearLayout;
    }
}
