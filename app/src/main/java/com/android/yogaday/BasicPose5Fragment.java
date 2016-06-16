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
public class BasicPose5Fragment extends Fragment {

    ImageView backArrow;
    View view;
    public BasicPose5Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_basic_pose5, container, false);
        backArrow = (ImageView)view.findViewById(R.id.clickBackArrowpose5);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose4Fragment basicPose4Fragment = new BasicPose4Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose4Fragment);
                fragmentTransaction.commit();
            }
        });


        return view;
    }

}
