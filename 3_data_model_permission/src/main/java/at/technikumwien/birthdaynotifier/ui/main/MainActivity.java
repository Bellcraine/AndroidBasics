package at.technikumwien.birthdaynotifier.ui.main;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.jar.Manifest;

import at.technikumwien.birthdaynotifier.R;
import at.technikumwien.birthdaynotifier.ui.main.model.data.Contact;
import at.technikumwien.birthdaynotifier.ui.main.ui.main.recyclerview.ContactAdapter;
import at.technikumwien.birthdaynotifier.ui.main.util.Utils;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_PERMISSION_READ_CONTACTS = 123;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private TextView emptyText;

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view and find our views
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        emptyText = (TextView) findViewById(R.id.no_contacts);

        // Create an adapter for the RecyclerView
        adapter = new ContactAdapter();

        // If the recycler view does not change in size, this
        // enables some optimizations
        recyclerView.setHasFixedSize(true);
        // Set a LinearLayoutManager, which lays the items out one after another
        // (like a LinearLayout)
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Set our contacts adapter on the RecyclerView
        recyclerView.setAdapter(adapter);

        // Show a snackbar when the floating action button is clicked
        // and add some data to show
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkContactsPermission();
            }
        });
    }



    private void checkContactsPermission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            onContactsPermissionGranted();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.READ_CONTACTS}, REQUEST_CODE_PERMISSION_READ_CONTACTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE_PERMISSION_READ_CONTACTS) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onContactsPermissionGranted();
            } else {
                onContactsPermissionDenied();
            }
        }
    }

    private void onContactsPermissionGranted () {
        Snackbar.make(recyclerView, "Permission granted!", Snackbar.LENGTH_LONG ).show();
        onContactsLoaded(Arrays.asList(
                Contact.create(0, "Max Mustermann", Utils.parseDate("2010-01-13")),
                Contact.create(1, "Maria Musterfrau", Utils.parseDate("2010-01-14")),
                Contact.create(2, "Stefan Müller", new Date()),
                Contact.create(3,  "Manuel Mustermann", Utils.parseDate("2010-01-23")),
                Contact.create(4, "Stefanie Musterfrau", Utils.parseDate("2010-01-14"))
        ));
    }

    private void onContactsPermissionDenied () {
        Snackbar.make(recyclerView, "Permission denied!", Snackbar.LENGTH_LONG )
                .setAction("Retry", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkContactsPermission();
            }
        })
                .show();

    }

    // Is called, when contacts are loaded. Here we set the visibility
    // of the empty list info text and update the data in our adapter
    private void onContactsLoaded(List<Contact> contactList) {
        emptyText.setVisibility(contactList.isEmpty() ? View.VISIBLE : View.GONE);
        adapter.setContactList(contactList);
    }
}
