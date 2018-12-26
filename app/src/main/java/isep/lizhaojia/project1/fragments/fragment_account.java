package isep.lizhaojia.project1.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import isep.lizhaojia.project1.Activities.Add_account;
import isep.lizhaojia.project1.R;

public class fragment_account extends Fragment {


    Button add_btn;
    RelativeLayout relativeLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_account, container, false);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        add_btn = (Button)getActivity().findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Add_account.class);
                intent.putExtra("add account","add a new account");
                startActivity(intent);

                Intent intent1 = getActivity().getIntent();
                String msg1 = intent1.getStringExtra("account name");
                String msg2 = intent1.getStringExtra("total amount");

            }
        });

    }

}
