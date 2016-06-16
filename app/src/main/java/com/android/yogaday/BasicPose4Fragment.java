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
public class BasicPose4Fragment extends Fragment {

    ImageView arrow,backArrow;
    View view;
    public BasicPose4Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_basic_pose4, container, false);

        arrow = (ImageView)view.findViewById(R.id.clickArrowpose4);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose5Fragment basicPose5Fragment = new BasicPose5Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose5Fragment);
                fragmentTransaction.commit();
            }
        });
        backArrow = (ImageView)view.findViewById(R.id.clickBackArrowpose4);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose3Fragment basicPose3Fragment = new BasicPose3Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose3Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
