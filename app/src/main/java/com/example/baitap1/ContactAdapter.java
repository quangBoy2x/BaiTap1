package com.example.baitap1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends BaseAdapter {
    Context context;
    ArrayList<Contact> contacts;

    public ContactAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.line_data, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Contact contactCurrent = (Contact) getItem(position);
        if(contactCurrent.getStatus() == 1){
            viewHolder.Status.setChecked(true);
        }
        else{
            viewHolder.Status.setChecked(false);
        }
        // lúc nào bấm check box set lại status là int
        viewHolder.Status.setOnClickListener(v -> {
            if(viewHolder.Status.isChecked()){
                contactCurrent.setStatus(1);
                Log.d("ckc1", contactCurrent.toString());

            }else{
                contactCurrent.setStatus(0);
                Log.d("ckc", contactCurrent.toString());

            }
        });

        viewHolder.Name.setText(contactCurrent.getName());
        viewHolder.PhoneNum.setText(contactCurrent.getPhoneNum());
        return convertView;
    }

    //class viewHolder tránh giảm giật
    private class ViewHolder{
        CheckBox Status;
        TextView Name;
        TextView PhoneNum;

        public ViewHolder(View view){
            Status = (CheckBox) view.findViewById(R.id.ckcSelect);
            Name = (TextView) view.findViewById(R.id.tvName);
            PhoneNum = (TextView) view.findViewById(R.id.tvNum);

        }
    }


}

