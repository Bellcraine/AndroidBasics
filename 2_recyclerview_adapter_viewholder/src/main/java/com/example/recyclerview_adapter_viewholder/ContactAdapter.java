package com.example.recyclerview_adapter_viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bellacraine on 04.05.2017.
 */

class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<String> list = Collections.emptyList();

    public void setList (List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contact, parent, false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.update(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
