package isep.lizhaojia.project1.fragments;

import android.nfc.Tag;
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

import com.mynameismidori.currencypicker.CurrencyPicker;
import com.mynameismidori.currencypicker.CurrencyPickerListener;

import java.util.ArrayList;

import isep.lizhaojia.project1.R;

public class fragment_main_currency extends Fragment {

    private static final String TAG = "fragment_main_currency";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_expenditure, container, false);
        CurrencyPicker picker = CurrencyPicker.newInstance("select Currency");
        picker.setListener(new CurrencyPickerListener() {
            @Override
            public void onSelectCurrency(String s, String s1, String s2, int i) {
                //code here
            }
        });
        picker.show(getFragmentManager(),"CURRENCY_PICKER");
        return view;
    }




}