package isep.lizhaojia.project1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static isep.lizhaojia.project1.API_keys.currency_API_key.API_KEY;

import isep.lizhaojia.project1.R;

public class Convertor extends AppCompatActivity {

    private static final String link = "http://data.fixer.io/api/latest?access_key=" + API_KEY;
    TextView currency2_textview,textView,textView2;
    EditText input_edittext;
    Button convert_button;
    Spinner currency1_spinner, currency2_spinner;
    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;
    ArrayList<String> ID_list = new ArrayList<String>();
    ArrayList<String>rate_list = new ArrayList<String>();
    Map<String,String> map = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        currency2_textview = findViewById(R.id.currency2_textView);
        textView = findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        input_edittext = findViewById(R.id.input_editText);
        convert_button = findViewById(R.id.convert_button);
        currency1_spinner = findViewById(R.id.currency1_spinner);
        currency2_spinner = findViewById(R.id.currency2_spinner);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jasonObjectRequest = new JsonObjectRequest(Request.Method.POST,link,null , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{
                    String success = response.getString("success");
                    if(success.equals("true")){
                        JSONObject rates = response.getJSONObject("rates");
                        System.out.println(rates);


                        Iterator<?> ID = rates.keys();
                        double value_;
                        String value = "";
                        String Id = null;
                        while(ID.hasNext()){
                            Id = (String)ID.next().toString();
                            value_ = rates.getDouble(Id);
                            value = String.valueOf(value_);
                            map.put(Id,value);
                            ID_list.add(Id);
                            rate_list.add(value);

//                            String show = textView.getText().toString() + ", "+ Id;
//                            textView.setText(show);
                        }
                        //System.out.println(ID_list);
                    }
                    else{
                        currency2_textview.setText("fail");
                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                currency2_textview.setText("convert failure");
                Log.e("TAG", error.getMessage(),error );
            }
        });
        requestQueue.add(jasonObjectRequest);

        ID_list.add("-select-");

        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ID_list);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency1_spinner.setAdapter(adapter1);

        currency1_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"selected " + adapter1.getItem(position),Toast.LENGTH_SHORT).show();
                String select1 = adapter1.getItem(position);
                String get1 = map.get(select1);
                textView.setText(get1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"please select",Toast.LENGTH_SHORT).show();
            }
        });



        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ID_list);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currency2_spinner.setAdapter(adapter2);
        currency2_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"selected "+adapter2.getItem(position),Toast.LENGTH_SHORT).show();
                String select2 = adapter2.getItem(position);
                String get2 = map.get(select2);
                textView2.setText(get2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"please select",Toast.LENGTH_SHORT).show();
            }
        });


        convert_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1;
                num1 = input_edittext.getText().toString();
                String get1 = textView.getText().toString();
                String get2 = textView2.getText().toString();
                calculate(get1,get2,num1);
            }
        });
    }
    public void calculate(String get1, String get2, String num1){
        double get_1,get_2,num_1,final_;
        get_1 = Double.parseDouble(get1);
        get_2 = Double.parseDouble(get2);
        num_1 = Double.parseDouble(num1);
        final_ = num_1*get_2/get_1;
        currency2_textview.setText(String.valueOf(final_));

    }
}
