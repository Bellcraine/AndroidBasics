package at.technikumwien.birthdaynotifier;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainFragment extends Fragment {

    private EditText message;
    private Button send;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        message = (EditText) getView().findViewById(R.id.message);
        send = (Button) getView().findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MessageActivity.getIntent(getContext(), message.getText().toString()));
            }
        });
    }


    /*
    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("MainFragment", "Send Button was clicked. Message was: " + message.getText().toString());
            Snackbar.make(send, message.getText().toString(), Snackbar.LENGTH_LONG).show();
        }
    }
    */


}
