package com.example.birthdaynotifier;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by Bellacraine on 28.03.2017.
 */

class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<String> nameList = Collections.emptyList();

    public void setLists(List<String> nameList) {
        this.nameList = nameList;
        notifyDataSetChanged();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.update(nameList.get(position));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
