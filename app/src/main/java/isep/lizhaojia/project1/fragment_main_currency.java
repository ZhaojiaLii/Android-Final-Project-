package isep.lizhaojia.project1;

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

import java.util.ArrayList;

public class fragment_main_currency extends Fragment {

    private static final String TAG = "fragment_main_currency";

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<String> mNames = new ArrayList<>();
    private  ArrayList<String> mImageUrls = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_currency, container, false);
        initImageBitmaps();
        mRecyclerView = (RecyclerView)view.findViewById(R.id.main_currency_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNames,mImageUrls);



        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: started currency fragment");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1200px-Flag_of_the_People%27s_Republic_of_China.svg.png");
        mNames.add("CNY");

        mImageUrls.add("https://wiki.mbalib.com/w/images/0/04/European-Union_Logo.jpg");
        mNames.add("EUR");
    }


}