package com.example.recyclerview_adapter_viewholder;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Bellacraine on 04.05.2017.
 */

class ContactViewHolder extends RecyclerView.ViewHolder {

    private CardView card = null;
    private TextView name = null;

    public ContactViewHolder(View itemView) {
        super(itemView);

        card = (CardView) itemView.findViewById(R.id.card);
        name = (TextView) itemView.findViewById(R.id.name);

       card.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Snackbar.make(card, name.getText().toString() + " clicked", Snackbar.LENGTH_LONG).show();
           }
       });
    }

    public void update(String text) {
        name.setText(text);
    }

}
