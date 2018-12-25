package isep.lizhaojia.project1.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;

import isep.lizhaojia.project1.Activities.Convertor;
import isep.lizhaojia.project1.Activities.Income;
import isep.lizhaojia.project1.Activities.Note;
import isep.lizhaojia.project1.R;

public class fragment_bill extends Fragment {


    private ImageButton ButtonConvertor;
    private Button IncomeButton, NoteButton, BudgetButton;
    private TextView expenditure, remainedbudget, trySP, tryNOTE2, tryNOTE, expenditure_total;
    ArrayList<String> tryList = new ArrayList<String>();
    String income, note, buget, now;
    double total,remainedbudget_value;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bill, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ButtonConvertor = (ImageButton) getActivity().findViewById(R.id.imageButton_convertor);
        BudgetButton = (Button) getActivity().findViewById(R.id.budgetbutton);
        IncomeButton = (Button) getActivity().findViewById(R.id.income);
        NoteButton = (Button) getActivity().findViewById(R.id.note);
        expenditure = (TextView) getActivity().findViewById(R.id.expenditure);
        expenditure_total = (TextView) getActivity().findViewById(R.id.expenditure_total);
        remainedbudget = (TextView) getActivity().findViewById(R.id.remain_budget);
        trySP = (TextView) getActivity().findViewById(R.id.trySP);
        tryNOTE2 = (TextView) getActivity().findViewById(R.id.tryNOTE2);
        tryNOTE = (TextView) getActivity().findViewById(R.id.tryNOTE);


        budget();
        trydata();
        trynotedata();
        gettotal();

        ButtonConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), Convertor.class);
                startActivity(intent1);

            }

        });

        IncomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), Income.class);
                startActivity(intent2);
            }
        });

        NoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(), Note.class);
                startActivity(intent3);
            }
        });
    }


    public void budget() {
        BudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEditText();

            }
        });

    }

    public void dialogEditText() {
        final EditText editText = new EditText(getActivity());
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), 3);
        builder.setTitle("input budget");
        builder.setView(editText);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), editText.getText().toString() + "", Toast.LENGTH_LONG).show();
                buget = editText.getText().toString();
                now = expenditure_total.getText().toString();
                double buget_value = Double.parseDouble(buget);
                double now_value = Double.parseDouble(now);
                remainedbudget_value = buget_value + now_value;
                remainedbudget.setText(String.valueOf(remainedbudget_value));
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.create().show();
    }

    public void trydata() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("IncomeInfo", Context.MODE_PRIVATE);
        String income = sharedPreferences.getString("Income_", null);
        trySP.setText(income);

    }

    public void trynotedata() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("NoteInfo", Context.MODE_PRIVATE);
        String note = sharedPreferences.getString("Note_", null);
        tryNOTE.setText(note);
        tryNOTE2.setText("others");

    }

    public void gettotal() {

        note = tryNOTE.getText().toString();
        income = trySP.getText().toString();

        double note_value = Double.parseDouble(note);
        double income_value = Double.parseDouble(income);
        total = income_value - note_value;

        expenditure_total.setText(String.valueOf(total));

    }
}