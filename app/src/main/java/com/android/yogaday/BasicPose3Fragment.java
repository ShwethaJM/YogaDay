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
public class BasicPose3Fragment extends Fragment {

    ImageView arrow,backArrow;
    View view;
    public BasicPose3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_basic_pose3, container, false);
        arrow = (ImageView)view.findViewById(R.id.clickArrowpose3);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose4Fragment basicPose4Fragment = new BasicPose4Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose4Fragment);
                fragmentTransaction.commit();
            }
        });
        backArrow = (ImageView)view.findViewById(R.id.clickBackArrowpose3);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose2Fragment basicPose2Fragment = new BasicPose2Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose2Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
