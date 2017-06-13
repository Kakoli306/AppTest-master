package com.example.nil_akash.apptest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.nil_akash.apptest.R;
import com.example.nil_akash.apptest.modelclass.DoctorInformation;

import java.util.List;

/**
 * Created by NiL-AkAsH on 4/9/2017.
 */

public class DoctorAdapter extends BaseAdapter {

    private Context context;
    private List<DoctorInformation> list;

    public DoctorAdapter(Context context, List<DoctorInformation> list) {
        this.context = context;
        this.list = list;
    }

    private class ViewHolder{
        TextView tvDrName;
        TextView tvDetails;
        TextView tvLocation;
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
            convertView = inflater.inflate(R.layout.doctor_list_item,parent,false);
            holder = new ViewHolder();

            holder.tvDrName = (TextView) convertView.findViewById(R.id.tvName);
            holder.tvDetails = (TextView) convertView.findViewById(R.id.tvdetails);
            holder.tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvDrName.setText(list.get(position).getDoctorName().toString());
        holder.tvDetails.setText(list.get(position).getDoctorDetails().toString());
        holder.tvLocation.setText(list.get(position).getDoctorLocation().toString());

        return convertView;
    }
}
