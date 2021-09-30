package com.example.firebaserecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class P_MyAdapter extends RecyclerView.Adapter<P_MyAdapter.MyViewHolder>{

    // Variables
    Context context;

    ArrayList<ProductData> list;
//    ArrayList<ProductData> list = new ArrayList<>();


    // Constructor
    public P_MyAdapter(Context context, ArrayList<ProductData> list) {
        this.context = context;
        this.list = list;
    }



    // Implementing Methods START

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Creating object of view
        View v = LayoutInflater.from(context).inflate(R.layout.p_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // Using the getters to fetch the values (ProductData.java)
        ProductData prod = list.get(position);
        holder.productName.setText(prod.getProductName());
        holder.productLocation.setText(prod.getProductLocation());
        holder.productPrice.setText(prod.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Implementing Methods END



    public static class MyViewHolder extends RecyclerView.ViewHolder{

        // The three text views (ProductData.java)
        TextView productName, productLocation, productPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // Linking with the recycler view (p_item.xml)
            productName = itemView.findViewById(R.id.kProductName);
            productLocation = itemView.findViewById(R.id.kProductLocation);
            productPrice = itemView.findViewById(R.id.kProductPrice);

        }
    }


}
