package isep.lizhaojia.project1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mynameismidori.currencypicker.CurrencyPicker;
import com.mynameismidori.currencypicker.CurrencyPickerListener;

import isep.lizhaojia.project1.R;
import isep.lizhaojia.project1.fragments.fragment_account;

public class Add_account extends AppCompatActivity {

    EditText type_account_name, type_amount;
    TextView currency;

    Button save_account;
    Fragment fragment = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_account);



        type_account_name = (EditText)findViewById(R.id.type_account_name);
        type_amount = (EditText)findViewById(R.id.type_amount);
        save_account = (Button)findViewById(R.id.save_account);
        currency = (TextView)findViewById(R.id.currency);

        CurrencyPicker picker = CurrencyPicker.newInstance("select Currency");
        picker.setListener(new CurrencyPickerListener() {
            @Override
            public void onSelectCurrency(String s, String s1, String s2, int i) {
                Toast.makeText(getApplicationContext(),s + " selected as currency",Toast.LENGTH_SHORT).show();
                currency.setText(s);

            }
        });
        picker.show(getSupportFragmentManager(),"CURRENCY_PICKER");


        save_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                fragment = new fragment_account();
//                load_fragment(fragment);

                Intent intent = new Intent(Add_account.this,MainActivity.class);
                intent.putExtra("account name",type_account_name.getText().toString());
                intent.putExtra("total amount",type_amount.getText().toString());
                startActivity(intent);
            }
        });



    }


//    private void load_fragment(Fragment fragment){
//
//        FragmentManager fm = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container,fragment);
//        fragmentTransaction.commit();
//    }


}
