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
public class SuryanamaskaraStep4Fragment extends Fragment {

    View view;
    ImageView arrow,backArrow;

    public SuryanamaskaraStep4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_suryanamaskara_step4, container, false);
        arrow = (ImageView)view.findViewById(R.id.clickArrowStep4);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SS.callStepsSuryanamaskara();
                SuryanamaskaraStep5Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep5Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
                fragmentTransaction.commit();
            }
        });

        backArrow = (ImageView)view.findViewById(R.id.clickBackArrowStep4);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SS.callStepsSuryanamaskara();
                SuryanamaskaraStep3Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep3Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
