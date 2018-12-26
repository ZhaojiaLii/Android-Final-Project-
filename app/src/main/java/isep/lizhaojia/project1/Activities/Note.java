package isep.lizhaojia.project1.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

import isep.lizhaojia.project1.R;

public class Note extends AppCompatActivity implements View.OnClickListener {
    Button button0,buttonPoint,buttonConfirm,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonRe,button_shop,button_food;
    //ImageButton imagefood,imageshopping;
    Spinner spinnerCurrency,spinnerAccount;
    TextView textView_note;
    private String str,str1;
    boolean clr_flag;
    int food=0,shopping=0;
    //double str1_value;
    ArrayList<String> NoteList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

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
        button_food = (Button) findViewById(R.id.button_food);
        button_shop = (Button) findViewById(R.id.button_shop);
        textView_note = (TextView)findViewById(R.id.textView_note);
        spinnerAccount = (Spinner) findViewById(R.id.spinner3);
        spinnerCurrency =(Spinner)findViewById(R.id.spinner4);


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
        button_shop.setOnClickListener(this);
        button_food.setOnClickListener(this);





    }

    public void onClick(View v) {
        str = (String) textView_note.getText();
        switch (v.getId()) {
            case R.id.button13:
                textView_note.setText("");
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
                    textView_note.setText("");
                }
                textView_note.setText(str+((Button)v).getText());
                break;
            case R.id.confirm:
                if(textView_note.length()>0){
                    SAVE();
                    Toast.makeText(Note.this, "SAVE", Toast.LENGTH_LONG).show();
                    Intent intent4 = new Intent(Note.this , MainActivity.class);
                    intent4.putExtra("id", 2);
                    startActivity(intent4);}
                else {
                    Intent intent4 = new Intent(Note.this , MainActivity.class);
                    intent4.putExtra("id", 2);
                    startActivity(intent4);}
                break;

            case R.id.button_food:
                food=+1;
                break;


        }
    }


    public void SAVE(){
        str1 = (String)textView_note.getText();
        double str1_value = Double.parseDouble(str1);
        NoteList.add(str1);
        SharedPreferences sharedPreferences = getSharedPreferences("NoteInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("note", NoteList.size());
        if (food==1){
            for (int i = 0; i < NoteList.size(); i++) {
                editor.putString("Note_food", NoteList.get(i));

            }
        }
        else {
            for (int i = 0; i < NoteList.size(); i++) {
                editor.putString("Note_default", NoteList.get(i));
            }
        }
        editor.commit();
        food=0;

    }

}
