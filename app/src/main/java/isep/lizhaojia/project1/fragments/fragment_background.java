package isep.lizhaojia.project1.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import isep.lizhaojia.project1.R;

public class fragment_background extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.background, container, false);

        Button blue = (Button) view.findViewById(R.id.blue);
        Button black = (Button) view.findViewById(R.id.black);
        Button pink = (Button) view.findViewById(R.id.pink);
        Button green = (Button) view.findViewById(R.id.green);
        blue.setOnClickListener(this);
        black.setOnClickListener(this);
        pink.setOnClickListener(this);
        green.setOnClickListener(this);
        return view;
    }



    @Override
    public void onClick(View v) {
        Fragment fragment = (Fragment) getFragmentManager().findFragmentById(R.id.fragment_container);
        Fragment fragment1 = (Fragment) getFragmentManager().findFragmentById(R.id.navigation_bill);
        //fragment.getView().setBackgroundColor(Color.WHITE);

        switch(v.getId()){
            case R.id.blue:
                fragment.getView().setBackgroundColor(Color.BLUE);
                fragment1.getView().setBackgroundColor(Color.BLUE);
                break;
            case R.id.black:
                //
                break;
            case R.id.pink:
                //
                break;
            case R.id.green:
                //
                break;

        }

    }
}
