package isep.lizhaojia.project1.Adapters;

import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import isep.lizhaojia.project1.R;

public class expenditure_recyclerview_adapter extends RecyclerView.Adapter<expenditure_recyclerview_adapter.ViewHolder> {
    private static final String TAG = "expenditure_recyclervie";

    private ArrayList<String> date_time = new ArrayList<>();
    private ArrayList<String> element_name = new ArrayList<>();
    private ArrayList<String> description_element = new ArrayList<>();
    private ArrayList<String> amount = new ArrayList<>();
    private ArrayList<String> bank_card_used = new ArrayList<>();
    private Context mContext;

    public expenditure_recyclerview_adapter(
            Context mContext,
            ArrayList<String> date_time,
            ArrayList<String> element_name,
            ArrayList<String> description_element,
            ArrayList<String> amount,
            ArrayList<String> bank_card_used) {
        this.date_time = date_time;
        this.element_name = element_name;
        this.description_element = description_element;
        this.amount = amount;
        this.bank_card_used = bank_card_used;
        this.mContext = mContext;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.expenditure_list,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: onBindViewHolder called");

        
        viewHolder.date_time.setText(date_time.get(i));
        viewHolder.element_name.setText(element_name.get(i));
        viewHolder.description_element.setText(description_element.get(i));
        viewHolder.amount.setText(amount.get(i));
        viewHolder.bank_card_used.setText(bank_card_used.get(i));

//        viewHolder.expenditure.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "onClick: clicked on" + description_element.get(i));
//                Toast.makeText(mContext,description_element.get(i)+" "+amount.get(i),Toast.LENGTH_SHORT);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return element_name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView date_time,element_name, description_element,amount,bank_card_used;
        RelativeLayout expenditure;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date_time = itemView.findViewById(R.id.date_time);
            element_name = itemView.findViewById(R.id.element_name);
            description_element = itemView.findViewById(R.id.description_element);
            amount = itemView.findViewById(R.id.amount);
            bank_card_used = itemView.findViewById(R.id.bank_card_used);
        }
    }
}
