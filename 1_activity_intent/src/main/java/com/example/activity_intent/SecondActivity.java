package com.example.activity_intent;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String MESSAGE_KEY = "123";

    private TextView messageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        messageText = (TextView) findViewById(R.id.messageText);

        String message = getIntent().getStringExtra(MESSAGE_KEY);
        messageText.setText(message);

        messageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(messageText, "Message received", Snackbar.LENGTH_LONG).show();
            }
        });
    }


    public static Intent getIntent(Context context, String message) {
        Intent i = new Intent(context, SecondActivity.class);
        i.putExtra(MESSAGE_KEY, message);
        return i;
    }

}
