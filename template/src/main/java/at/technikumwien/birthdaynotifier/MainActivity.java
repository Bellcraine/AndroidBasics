package at.technikumwien.birthdaynotifier;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText message = (EditText) findViewById(R.id.message);
        final Button send = (Button) findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "Send Button was clicked. Message was: " + message.getText().toString());
                Snackbar.make(send, message.getText().toString(), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
