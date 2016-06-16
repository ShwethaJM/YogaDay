package com.android.yogaday;


import android.content.Context;
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
public class DetailsSuryanamaskaraFragment extends Fragment {

    View view;
    ImageView arrow;
    StepsSuryanamaskara SS;

    public DetailsSuryanamaskaraFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details_suryanamaskara, container, false);
        arrow = (ImageView)view.findViewById(R.id.clickArrowSteps);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // SS.callStepsSuryanamaskara();
                SuryanamaskaraStep1Fragment suryanamaskaraStepsFragment = new SuryanamaskaraStep1Fragment();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.relativeLayout_for_fragment, suryanamaskaraStepsFragment);
                fragmentTransaction.commit();
            }
        });

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof StepsSuryanamaskara) {
            SS = (StepsSuryanamaskara) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement DetailSuryanamaskara");
        }
    }

    public interface StepsSuryanamaskara{

        void callStepsSuryanamaskara();
    }

}
