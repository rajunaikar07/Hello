package com.example.odsphonepe12.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odsphonepe12.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    Context context;
    List<ModelClass> modelClassList=new ArrayList<>();

    public UserAdapter(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.history,parent,false);
        return new UserHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        ModelClass modelClass=modelClassList.get(position);
        holder.image1.setImageResource(modelClassList.get(position).getImage1());
        holder.image2.setImageResource(modelClassList.get(position).getImage2());
        holder.name1.setText(modelClassList.get(position).getName1());
        holder.name2.setText(modelClassList.get(position).getName2());
        holder.name3.setText(modelClassList.get(position).getName3());
        holder.name4.setText(modelClassList.get(position).getName4());
        holder.name5.setText(modelClassList.get(position).getName5());

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
    TextView name1,name2,name3,name4,name5;
    ImageView image1,image2;
        public UserHolder(@NonNull View itemView) {
            super(itemView);

            image1=itemView.findViewById(R.id.imv_transaction_type);
            image2=itemView.findViewById(R.id.bank_img);
            name1=itemView.findViewById(R.id.txv_transaction_date);
            name2=itemView.findViewById(R.id.txv_transactions_type);
            name3=itemView.findViewById(R.id.txv_transaction_merchant);
            name4=itemView.findViewById(R.id.txv_transactions_amount);
            name5=itemView.findViewById(R.id.txv_transaction_credited_debited);

        }
    }
}
