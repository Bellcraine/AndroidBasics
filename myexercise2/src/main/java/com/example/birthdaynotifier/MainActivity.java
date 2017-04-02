package com.example.birthdaynotifier;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton button;
    private ContactAdapter adapter;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        button = (FloatingActionButton) findViewById(R.id.button);
        emptyView = (TextView) findViewById(R.id.empty_view);

        adapter = new ContactAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(button, "FAB wurde angeklickt", Snackbar.LENGTH_LONG).show();
                onContactsLoaded(Arrays.asList(
                        "Max Mustermann",
                        "Maria Musterfrau",
                        "Stefan Müller",
                        "Theresa Huber",
                        "Manuel Mustermann",
                        "Stefanie Musterfrau",
                        "Thomas Müller",
                        "Sarah Huber",
                        "Beinahe Unglaublich Langer Name"
                ));
            }
        });

    }


    public void onContactsLoaded(List<String> nameList) {
        if (nameList.size() > 0)
            emptyView.setVisibility(View.GONE);
        else
            emptyView.setVisibility(View.VISIBLE);

        adapter.setLists(nameList);
    }

}
