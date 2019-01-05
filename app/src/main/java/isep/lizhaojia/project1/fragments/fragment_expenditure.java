package isep.lizhaojia.project1.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

import isep.lizhaojia.project1.Adapters.RecyclerViewAdapter;
import isep.lizhaojia.project1.Adapters.expenditure_recyclerview_adapter;
import isep.lizhaojia.project1.R;

public class fragment_expenditure extends Fragment {

    private static final String TAG = "fragment_expenditure called";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private TextView text1, text2, text3, text4;

    private ArrayList<String> date_time = new ArrayList<>();
    private ArrayList<String> element_name = new ArrayList<>();
    private ArrayList<String> description_element = new ArrayList<>();
    private ArrayList<String> amount = new ArrayList<>();
    private ArrayList<String> bank_card_used = new ArrayList<>();
    private Context mContext;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_expenditure, container, false);

          text4 = view.findViewById(R.id.text4);
          initData();
//        Iterator<?> iterator = amount.iterator();
//        String amount ;
//        Double amount_despense = 0.0;
//        while (iterator.hasNext()){
//            amount = (String) iterator.next();
//            amount_despense = Double.parseDouble(amount);
//        }



        recyclerView = view.findViewById(R.id.recyclerview_expenditure);
        mContext = recyclerView.getContext();
        expenditure_recyclerview_adapter adapter = new expenditure_recyclerview_adapter(mContext,date_time,element_name,description_element,amount,bank_card_used);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void initData(){



        Log.d(TAG, "initData: prepare data of the recyclerview");
        date_time.add("18/11/2018 Sunday");
        element_name.add("Food");
        description_element.add("BurgerKing");
        amount.add("16.00");
        bank_card_used.add("SG card");

        Log.d(TAG, "initData: prepare data of the recyclerview");
        date_time.add("19/11/2018 Monday");
        element_name.add("Food");
        description_element.add("Panda Geant");
        amount.add("7.5");
        bank_card_used.add("SG card");

        Log.d(TAG, "initData: prepare data of the recyclerview");
        date_time.add("19/11/2018 Monday");
        element_name.add("Shopping");
        description_element.add("Zara");
        amount.add("56.00");
        bank_card_used.add("SG card");

        Log.d(TAG, "initData: prepare data of the recyclerview");
        date_time.add("20/11/2018 Tuesday");
        element_name.add("Food");
        description_element.add("McDonald's");
        amount.add("4.95");
        bank_card_used.add("SG card");

        Log.d(TAG, "initData: prepare data of the recyclerview");
        date_time.add("21/11/2018 Wednesday");
        element_name.add("Book");
        description_element.add("GIBERT JEUNE");
        amount.add("20.00");
        bank_card_used.add("SG card");



    }



}
