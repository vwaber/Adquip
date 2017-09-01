package com.vwaber.quipstage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StageFragment extends Fragment {


    public StageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_stage, container, false);

        Bundle args = getArguments();
        QuipParcelable quip = args.getParcelable(QuipParcelable.EXTRA_KEY);

        if(quip == null) return rootView;

        TextView setupView = rootView.findViewById(R.id.tv_setup);
        TextView punchlineView = rootView.findViewById(R.id.tv_punchline);

        setupView.setText(quip.getSetup());
        punchlineView.setText(quip.getPunchline());

        return rootView;
    }

}
