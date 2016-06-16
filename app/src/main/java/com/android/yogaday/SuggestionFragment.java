package com.android.yogaday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SuggestionFragment extends Fragment {

    View view;
    EditText suggestion;
    Button submit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_suggestion, container, false);
        suggestion = (EditText)view.findViewById(R.id.suggestiontextview);
        submit = (Button)view.findViewById(R.id.suggestionSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suggestion.setText("");
            }
        });

        return view;
    }


}
