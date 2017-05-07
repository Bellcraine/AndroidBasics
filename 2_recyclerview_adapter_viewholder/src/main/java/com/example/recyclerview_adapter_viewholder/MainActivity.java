package com.example.recyclerview_adapter_viewholder;

import android.support.design.widget.FloatingActionButton;
import android.support.transition.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView = null;
    private TextView text = null;
    private FloatingActionButton fab = null;
    private ContactAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        text = (TextView) findViewById(R.id.text);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        adapter = new ContactAdapter();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onContactsLoaded(Arrays.asList(
                        "Thomas",
                        "Ernst",
                        "Kim",
                        "Bernie",
                        "Julius"
                        )

                );
                Toast.makeText(MainActivity.this, "FAB clicked", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void onContactsLoaded(List<String> list) {
        if(list != null) {
            text.setVisibility(View.GONE);
            adapter.setList(list);
        }
    }
}
