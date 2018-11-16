package isep.lizhaojia.project1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import android.view.View;
import android.app.Activity;
import android.content.DialogInterface;
import android.widget.TextView;

public class Income extends AppCompatActivity implements View.OnClickListener {

    Button button0,buttonPoint,buttonConfirm,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonRe;
    Spinner spinnerCurrency,spinnerAccount;
    TextView textView;
    private String str;
    boolean clr_flag;

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
        textView = (TextView)findViewById(R.id.textView);

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
                        if(clr_flag){
                            clr_flag=false;
                            str="";
                            textView.setText("");
                        }
                        textView.setText(str+((Button)v).getText());
                        break;
                }
    }

}






