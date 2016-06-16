package com.android.yogaday;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionsFragment extends Fragment {

    View view;
    EditText suggestion;
    Button submit;


    public QuestionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view = inflater.inflate(R.layout.fragment_questions, container, false);
        suggestion = (EditText)view.findViewById(R.id.questiontextview);
        submit = (Button)view.findViewById(R.id.questionSubmit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suggestion.setText("");
            }
        });

        return view;
    }

}
