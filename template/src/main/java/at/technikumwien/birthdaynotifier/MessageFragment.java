package at.technikumwien.birthdaynotifier;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Bellacraine on 25.03.2017.
 */

public class MessageFragment extends Fragment {

    private static final String EXTRA_MESSAGE = "message";

    public static Fragment getFragment(String message) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString(EXTRA_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String message = getArguments().getString(EXTRA_MESSAGE);

        TextView textView = (TextView) getView().findViewById(R.id.message);
        textView.setText(message);
    }

}
