package com.example.nil_akash.apptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.modelclass.ImageConverter;
import com.example.nil_akash.apptest.modelclass.MedicineInformation;

import java.util.List;

/**
 * Created by NiL-AkAsH on 4/10/2017.
 */

public class MedicineAdapter extends BaseAdapter {

    private Context context;
    private List<MedicineInformation> list;

    public MedicineAdapter(Context context, List<MedicineInformation> list) {
        this.context = context;
        this.list = list;
    }

    private class ViewHolder{
        ImageView ivImage;
        TextView tvDate;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.medicine_item,parent,false);
            holder = new ViewHolder();

            holder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //holder.ivImage.setImageResource(list.get(position).getPrecsiptionImage());
        holder.tvDate.setText(list.get(position).getPrecsiptionDate().toString());
        holder.ivImage.setImageBitmap(ImageConverter.getImage(list.get(position).getPrecsiptionImage()));
        return convertView;
    }
}
