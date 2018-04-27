package com.patateco.qc.ca.businessmoneyworld;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TabAdapter extends ArrayAdapter<String> {

    String [] names;
    int [] flags;
    Context mContext;
    Element [] listeElement;



    public TabAdapter(Context context,Element [] listeElement){

        super(context,R.layout.listitem_layout);

        this.listeElement = listeElement;

        this.mContext = context;

    }


    @Override
    public int getCount(){

        return listeElement.length;

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
            mViewHolder.mQtt = (TextView) converterView.findViewById(R.id.textView3);

            converterView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)converterView.getTag();
        }
        mViewHolder.mFlag.setImageResource(listeElement[position].getImage());
        mViewHolder.mName.setText(listeElement[position].getNom());
        mViewHolder.mQtt.setText(String.valueOf(listeElement[position].getQtt()));

        return converterView;

    }

    static class ViewHolder{

        ImageView mFlag;
        TextView mName;
        TextView mQtt;

    }

}
