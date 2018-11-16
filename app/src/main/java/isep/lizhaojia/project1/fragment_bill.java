package isep.lizhaojia.project1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class fragment_bill extends Fragment {


    private ImageButton ButtonConvertor,BudgetButton;
    private TextView expenditure;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bill, container, false);}

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            ButtonConvertor = (ImageButton) getActivity().findViewById(R.id.imageButton_convertor);
            BudgetButton = (ImageButton) getActivity().findViewById(R.id.budgetbutton);
            expenditure = (TextView)getActivity().findViewById(R.id.expenditure);

            budget();
            ButtonConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Convertor.class);
                startActivity(intent);

            }

        });
    }

    public void budget(){
        BudgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogEditText();

            }
        });

    }

    public void dialogEditText(){


    }
}
