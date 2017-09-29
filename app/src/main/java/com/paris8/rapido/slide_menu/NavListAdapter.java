package com.paris8.rapido.slide_menu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rapido on 13/11/2016.
 */

public class NavListAdapter extends ArrayAdapter<NavItem> {

    Context context;
    int resLayout;
    List<NavItem> listNavItem;

    public NavListAdapter (Context context, int resLayout, List<NavItem> listNavItem)
    {
        super(context, resLayout, listNavItem);

        this.context = context;
        this.resLayout = resLayout;
        this.listNavItem = listNavItem;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = View.inflate(context, resLayout, null);

        TextView tvTitle = (TextView) v.findViewById(R.id.title);
        TextView tvSubTitle = (TextView) v.findViewById(R.id.subtitle);
        ImageView navIcon = (ImageView) v.findViewById(R.id.nav_icon);

        NavItem navItem = listNavItem.get(position);
        tvTitle.setText(navItem.getTitle());
        tvSubTitle.setText(navItem.getSubTitle());
        navIcon.setImageResource(navItem.getResIcon());

        return v;
    }
}
