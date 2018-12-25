package isep.lizhaojia.project1.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.os.CpuUsageInfo;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import isep.lizhaojia.project1.R;

import static com.android.volley.Request.*;
import static com.android.volley.Request.Method.GET;

public class Convertor extends AppCompatActivity {

    private static final String url = "http://data.fixer.io/api/latest?access_key=0e37054c216e76b0d707c210a2f1d83";

    TextView textView,Currency1,Currency2;
    EditText editText;
    Button button;
    double result;
    Spinner spinner1,spinner2;
    ArrayList<String> Currency = new ArrayList<>();
    ArrayList<String>Value = new ArrayList<>();
    Map<String, String> map = new LinkedHashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        Currency1 = findViewById(R.id.textView2);
        Currency2 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);


        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest jasonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    String finish = response.getString("success");
                    if(finish.equals("true")){
                        JSONObject rates = response.getJSONObject("rates");
                        //Map<String, String> map = new LinkedHashMap<>();
                        Iterator<?> ID = rates.keys();
                        double value_;
                        String value = "";
                        String currency = null;
                        System.out.println(rates);


                        while(ID.hasNext()){
                            currency = (String)ID.next().toString();
                            value_ = rates.getDouble(currency);
                            value = String.valueOf(value_);
                            Currency.add(currency);
                            Value.add(value);
                            map.put(currency,value);
                        }

                        Set<Map.Entry<String, String>> set = map.entrySet();
                        for (Map.Entry<String, String> me : set) {
                            String key = me.getKey();
                            String v1 = me.getValue();
                            System.out.println(key + "---" + v1);
                        }
                    }
                    else{
                        textView.setText("failure");
                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("failure 2");
                Toast.makeText(getApplicationContext(), "FAILURE, PLZ WAIT",Toast.LENGTH_SHORT ).show();
            }
        });

        requestQueue.add(jasonObjectRequest);

        Currency.add("select");

        final Spinner spinner1 =(Spinner)findViewById(R.id.spinner1);
        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Currency);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
        //spinner1.setOnItemSelectedListener(this);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String currency1= dataAdapter.getItem(i);
                String str1 = map.get(currency1);
                Currency1.setText(str1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final Spinner spinner2 =(Spinner)findViewById(R.id.spinner2);
        final ArrayAdapter<String> data2Adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Currency);
        data2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(data2Adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String currency2= data2Adapter.getItem(i);
                String str2 = map.get(currency2);
                Currency2.setText(str2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CONVERT();
            }
        });
    }

    public void CONVERT(){
        String initiation =editText.getText().toString();
        double initiation1 = Double.parseDouble(initiation);
        String initiation2 = Currency1.getText().toString();
        double initiation22 = Double.parseDouble(initiation2);
        String initiation3 = Currency2.getText().toString();
        double initiation33 = Double.parseDouble(initiation3);
        result = initiation1/initiation22*initiation33;
        textView.setText(""+result);
    }

}
