package com.android.yogaday;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuryanamaskaraStep8Fragment extends Fragment {

    View view;
    ImageView arrow,backArrow;
    public SuryanamaskaraStep8Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_suryanamaskara_step8, container, false);

        arrow = (ImageView)view.findViewById(R.id.clickArrowStep8);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SS.callStepsSuryanamaskara();
                SuryanamaskaraStep9Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep9Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
                fragmentTransaction.commit();
            }
        });

        backArrow = (ImageView)view.findViewById(R.id.clickBackArrowStep8);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SS.callStepsSuryanamaskara();
                SuryanamaskaraStep7Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep7Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
