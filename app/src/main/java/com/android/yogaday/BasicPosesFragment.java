package com.android.yogaday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BasicPosesFragment extends Fragment {

    View view;
    Button pose1,pose2,pose3,pose4,pose5;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_basic_poses, container, false);

        pose1 = (Button)view.findViewById(R.id.pose1Button);
        pose2 = (Button)view.findViewById(R.id.pose2Button);
        pose3 = (Button)view.findViewById(R.id.pose3Button);
        pose4 = (Button)view.findViewById(R.id.pose4Button);
        pose5 = (Button)view.findViewById(R.id.pose5Button);
        pose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose1Fragment basicPose1Fragment = new BasicPose1Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose1Fragment);
                fragmentTransaction.commit();
            }
        });

        pose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose2Fragment basicPose2Fragment = new BasicPose2Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose2Fragment);
                fragmentTransaction.commit();
            }
        });
        pose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose3Fragment basicPose3Fragment = new BasicPose3Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose3Fragment);
                fragmentTransaction.commit();
            }
        });
        pose4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose4Fragment basicPose4Fragment = new BasicPose4Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose4Fragment);
                fragmentTransaction.commit();
            }
        });
        pose5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BasicPose5Fragment basicPose5Fragment = new BasicPose5Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, basicPose5Fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }



}
