package at.technikumwien.birthdaynotifier;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class MainFragment extends Fragment {

    private static final String KEY_MESSAGE = "message";

    private EditText message;
    private Button sendActivity;
    private Button sendFragment;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_MESSAGE, message.getText().toString());
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        message = (EditText) getView().findViewById(R.id.message);
        sendActivity = (Button) getView().findViewById(R.id.send_Activity);
        sendFragment = (Button) getView().findViewById(R.id.send_Fragment);


        if(savedInstanceState != null) {
            message.setText(savedInstanceState.getString(KEY_MESSAGE));
        }


        sendActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MessageActivity.getIntent(getContext(), message.getText().toString()));
            }
        });


        sendFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, MessageFragment.getFragment(message.getText().toString()))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }


    /*
    sendActivity.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("MainFragment", "Send Button was clicked. Message was: " + message.getText().toString());
            Snackbar.make(sendActivity, message.getText().toString(), Snackbar.LENGTH_LONG).show();
        }
    }
    */

}
