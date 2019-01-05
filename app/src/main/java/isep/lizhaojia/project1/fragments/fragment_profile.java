package isep.lizhaojia.project1.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mynameismidori.currencypicker.CurrencyPicker;
import com.mynameismidori.currencypicker.CurrencyPickerListener;

import java.io.IOException;

import isep.lizhaojia.project1.Activities.MainActivity;
import retrofit2.adapter.rxjava.HttpException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import isep.lizhaojia.project1.R;

import isep.lizhaojia.project1.utils.Constants;
import isep.lizhaojia.project1.network.NetworkUtil;
import isep.lizhaojia.project1.model.User;
import isep.lizhaojia.project1.model.Response;

public class fragment_profile extends Fragment {

    private TextView mTvName;
    private TextView mTvEmail;
    private TextView mTvDate;

    private ProgressBar mProgressbar;

    private SharedPreferences mSharedPreferences;
    private String mToken;
    private String mEmail;

    private CompositeSubscription mSubscriptions;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_fragment_profile, container, false);

        mSubscriptions = new CompositeSubscription();
        initViews();
        initSharedPreferences();
        loadProfile();

        return view;

    }

    private void initViews() {
        mTvName = view.findViewById(R.id.tv_name);
        mTvEmail = view.findViewById(R.id.tv_email);
        mTvDate = view.findViewById(R.id.tv_date);

        mProgressbar = view.findViewById(R.id.progress);


    }


    private void initSharedPreferences() {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mToken = mSharedPreferences.getString(Constants.TOKEN,"");
        mEmail = mSharedPreferences.getString(Constants.EMAIL,"");
    }

    private void loadProfile() {

        mSubscriptions.add(NetworkUtil.getRetrofit(mToken).getProfile(mEmail)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse,this::handleError));
    }



    private void handleResponse(User user) {
        mProgressbar.setVisibility(View.GONE);
        mTvName.setText(user.getName());
        mTvEmail.setText(user.getEmail());
        mTvDate.setText(user.getCreated_at());
    }

    private void handleError(Throwable error) {

        mProgressbar.setVisibility(View.GONE);

        if (error instanceof HttpException) {

            Gson gson = new GsonBuilder().create();

            try {

                String errorBody = ((HttpException) error).response().errorBody().string();
                Response response = gson.fromJson(errorBody,Response.class);
                showSnackBarMessage(response.getMessage());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            showSnackBarMessage("Network Error !");
        }

    }

    private void showSnackBarMessage(String message) {
        if (getView() != null) {

            Snackbar.make(getView(),message,Snackbar.LENGTH_SHORT).show();
        }
    }
}
