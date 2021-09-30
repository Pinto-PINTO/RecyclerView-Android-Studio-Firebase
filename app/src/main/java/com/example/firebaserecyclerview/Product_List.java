package com.example.firebaserecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Product_List extends AppCompatActivity {

    // Initializing
    RecyclerView recyclerView;
    DatabaseReference dbRef;
    P_MyAdapter myAdapter;
    ArrayList<ProductData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        // Recycler View
        recyclerView = (RecyclerView) findViewById(R.id.productList);

        // DB Reference
//        dbRef = FirebaseDatabase.getInstance().getReference("Products");
        dbRef = FirebaseDatabase.getInstance().getReference().child("Products");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        // My Adapter
        myAdapter = new P_MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);


        // DB Fetch onChange
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    ProductData prod = dataSnapshot.getValue(ProductData.class);
                    list.add(prod);
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}