package isep.lizhaojia.project1.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;

import isep.lizhaojia.project1.R;
import isep.lizhaojia.project1.fragments.fragment_login;



public class Login extends Activity {

    public static final String TAG = Login.class.getSimpleName();

    private fragment_login mLoginFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {

            loadFragment();
        }
    }

    private void loadFragment(){

        if (mLoginFragment == null) {

            mLoginFragment = new fragment_login();
        }
        getFragmentManager().beginTransaction().replace(R.id.fragmentFrame,mLoginFragment,fragment_login.TAG).commit();
    }




    private void showSnackBarMessage(String message) {

        Snackbar.make(findViewById(R.id.activity_login),message,Snackbar.LENGTH_SHORT).show();

    }
}
