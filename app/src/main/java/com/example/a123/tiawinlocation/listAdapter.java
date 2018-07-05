package com.example.a123.tiawinlocation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.a123.tiawinlocation.Class.location;

import java.util.List;

public class listAdapter extends BaseAdapter {


    private LocationListActivity context;
    private List<location> mlist;

    public listAdapter(LocationListActivity c, List<location> list) {
        this.context = c;
        this.mlist = list;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyTag myTag = null;
        if (convertView == null) {
            myTag = new MyTag();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, null);
            myTag.list_text1 = (TextView) convertView.findViewById(R.id.list_text1);
            myTag.list_text2 = (TextView) convertView.findViewById(R.id.list_text2);
            convertView.setTag(myTag);
        } else {
            myTag = (MyTag) convertView.getTag();
        }

        myTag.list_text1.setText(mlist.get(position).getLat());
        myTag.list_text2.setText(mlist.get(position).getLot());

        return convertView;
    }

    private class MyTag {
        TextView list_text1;
        TextView list_text2;
    }

}
