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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.mynameismidori.currencypicker.CurrencyPicker;
import com.mynameismidori.currencypicker.CurrencyPickerListener;

import java.util.ArrayList;
import java.util.PriorityQueue;

import isep.lizhaojia.project1.R;

public class fragment_main_currency extends Fragment {

    private static final String TAG = "fragment_main_currency";

    TextView header,currency_choosed,history, show_history;
    ArrayList<String> selected_history = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_currency, container, false);

        header = view.findViewById(R.id.header);
        currency_choosed = view.findViewById(R.id.currency_choosed);
        history = view.findViewById(R.id.history);
        show_history = view.findViewById(R.id.show_history);

        CurrencyPicker picker = CurrencyPicker.newInstance("select Currency");
        picker.setListener(new CurrencyPickerListener() {
            @Override
            public void onSelectCurrency(String s, String s1, String s2, int i) {
                Toast.makeText(getContext(),s + " selected",Toast.LENGTH_SHORT).show();
                currency_choosed.setText(s + " " + s2);
                selected_history.add(s + " " + s2);

            }
        });
        picker.show(getFragmentManager(),"CURRENCY_PICKER");
        return view;
    }





}