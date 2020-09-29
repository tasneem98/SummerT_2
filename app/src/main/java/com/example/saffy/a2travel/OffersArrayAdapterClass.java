package com.example.saffy.a2travel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saffy.a2travel.OfferClass;
import com.example.saffy.a2travel.R;

import java.util.ArrayList;

public class    OffersArrayAdapterClass extends ArrayAdapter<OfferClass> {
    public OffersArrayAdapterClass (@NonNull Context context, @NonNull ArrayList<OfferClass> messages) {
        super(context, 0, messages);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        OfferClass offer=getItem(position);

        View currentView=convertView;
        if(currentView==null){
            currentView= LayoutInflater.from(getContext()).inflate(R.layout.custum_item,parent,false);
        }

        ImageView imageView=currentView.findViewById(R.id.iv_ImagePlace);
        imageView.setImageResource(offer.getGet_image());

        TextView PlaceName=currentView.findViewById(R.id.tv_PlaceName);
        PlaceName.setText(offer.getGet_place_name());

        TextView Information=currentView.findViewById(R.id.tv_information);
        Information.setText(offer.getGet_information());

        return currentView;
    }
}
