package com.example.a4_contentresolver_broadcastreceiver.data.local;

import android.support.annotation.NonNull;

import java.util.List;

import com.example.a4_contentresolver_broadcastreceiver.data.model.Contact;

/**
 * A repository for fetching Contacts.
 */
public interface ContactRepo {

    /**
     * Finds all contacts which have a birthday set.
     *
     * @param callback The callback to be invoked on data load events
     */
    void findAllWithBirthday(@NonNull OnDataLoadCallback<List<Contact>> callback);

}
