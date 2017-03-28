package com.example.birthdaynotifier;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bellacraine on 28.03.2017.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView nameView;


    public ContactViewHolder(View itemView) {
        super(itemView);

        nameView = (TextView) itemView.findViewById(R.id.name);
    }


    public void update (String name) {
        nameView.setText(name);
    }

}
