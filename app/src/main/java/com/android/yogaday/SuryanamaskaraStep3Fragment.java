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
public class SuryanamaskaraStep3Fragment extends Fragment {
    View view;
    ImageView arrow,backArrow;

    public SuryanamaskaraStep3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_suryanamaskara_step3, container, false);

        arrow = (ImageView)view.findViewById(R.id.clickArrowStep3);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SS.callStepsSuryanamaskara();
                SuryanamaskaraStep4Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep4Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
                fragmentTransaction.commit();
            }
        });

        backArrow = (ImageView)view.findViewById(R.id.clickBackArrowStep3);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SS.callStepsSuryanamaskara();
                SuryanamaskaraStep2Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep2Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

}
