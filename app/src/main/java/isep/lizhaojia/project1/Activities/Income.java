package isep.lizhaojia.project1.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.ArrayList;

import isep.lizhaojia.project1.R;


public class Income extends AppCompatActivity implements View.OnClickListener {

    Button button0,buttonPoint,buttonConfirm,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonRe;
    Spinner spinnerCurrency,spinnerAccount;
    TextView textView;
    private String str,str1;
    boolean clr_flag;
    //double str1_value;
    ArrayList<String> IncomeList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPoint = (Button) findViewById(R.id.buttonpoint);
        buttonConfirm = (Button) findViewById(R.id.confirm);
        buttonRe = (Button)findViewById(R.id.button13);
        textView = (TextView)findViewById(R.id.textView_income);
        spinnerAccount = (Spinner) findViewById(R.id.spinner);
        spinnerCurrency =(Spinner)findViewById(R.id.spinner2);


        String[] arr={"SG","CIC","HSBC","ONLINE ACCOUNT"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        spinnerAccount.setAdapter(adapter);

        String[] arr1={"EURO","DOLLAR","POUNDS","YEN","YUAN"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr1);
        spinnerCurrency.setAdapter(adapter1);


        buttonConfirm.setOnClickListener(this);
        buttonPoint.setOnClickListener(this);
        buttonRe.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        



                    }

            public void onClick(View v) {
                str = (String) textView.getText();
                switch (v.getId()) {
                    case R.id.button13:
                        textView.setText("");
                        break;
                    case R.id.button0:
                    case R.id.button1:
                    case R.id.button2:
                    case R.id.button3:
                    case R.id.button4:
                    case R.id.button5:
                    case R.id.button6:
                    case R.id.button7:
                    case R.id.button8:
                    case R.id.button9:
                    case R.id.buttonpoint:
                        if(clr_flag){
                            clr_flag=false;
                            str="";
                            textView.setText("");
                        }
                        textView.setText(str+((Button)v).getText());
                        break;
                    case R.id.confirm:
                        if(textView.length()>0){
                            SAVE();
                            Toast.makeText(Income.this, "SAVE", Toast.LENGTH_LONG).show();
                            Intent intent4 = new Intent(Income.this , MainActivity.class);
                            intent4.putExtra("id", 2);
                            startActivity(intent4);}
                        else {
                            Intent intent4 = new Intent(Income.this , MainActivity.class);
                            intent4.putExtra("id", 2);
                            startActivity(intent4);}
                        break;

                }
    }


    public void SAVE(){
        str1 = (String)textView.getText();
        double str1_value = Double.parseDouble(str1);
        IncomeList.add(str1);
        SharedPreferences sharedPreferences = getSharedPreferences("IncomeInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("income", IncomeList.size());
        for (int i = 0; i < IncomeList.size(); i++) {
            editor.putString("Income_", IncomeList.get(i));
        }
        editor.commit();

    }

}






