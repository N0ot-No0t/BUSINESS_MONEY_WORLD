package com.patateco.qc.ca.businessmoneyworld;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyAdapter extends ArrayAdapter<String> {

     String [] names;
     int [] flags;
     Context mContext;

    public MyAdapter(Context context, String [] countryNames, int [] countryFlags){

        super(context,R.layout.listitem_layout);
        this.names = countryNames;
        this.flags = countryFlags;
        this.mContext = context;

    }

    @Override
    public int getCount(){

        return names.length;

    }

    @NonNull
    @Override
    public View getView(int position, View converterView, ViewGroup parent){

        ViewHolder mViewHolder = new ViewHolder();

        if(converterView == null) {

            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            converterView = mInflater.inflate(R.layout.listitem_layout, parent, false);
            mViewHolder.mFlag = (ImageView) converterView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) converterView.findViewById(R.id.textView2);

            converterView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)converterView.getTag();
        }
            mViewHolder.mFlag.setImageResource(flags[position]);
            mViewHolder.mName.setText(names[position]);

        return converterView;

    }

    static class ViewHolder{

        ImageView mFlag;
        TextView mName;

    }

}
