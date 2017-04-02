package com.example.birthdaynotifier;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bellacraine on 28.03.2017.
 */

public class ContactViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView nameView;


    public ContactViewHolder(View itemView) {
        super(itemView);

        cardView = (CardView) itemView.findViewById(R.id.card);
        nameView = (TextView) itemView.findViewById(R.id.name);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(cardView,
                        "Kontakt " + nameView.getText().toString() + " wurde angeklickt",
                        Snackbar.LENGTH_LONG).show();
            }
        });

    }


    public void update (String name) {
        nameView.setText(name);
    }

}
