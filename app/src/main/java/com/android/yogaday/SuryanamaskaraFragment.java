package com.android.yogaday;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SuryanamaskaraFragment extends Fragment {

    View view;
    ImageView arrow;
    DetailSuryanamaskara DS;
    public SuryanamaskaraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_suryanamaskara, container, false);
        arrow = (ImageView)view.findViewById(R.id.clickArrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DS.callDetailsSuryanamaskara();
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DetailSuryanamaskara) {
            DS = (DetailSuryanamaskara) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement DetailSuryanamaskara");
        }
    }

    public interface DetailSuryanamaskara{

         void callDetailsSuryanamaskara();
    }
}
