package com.example.whatsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CatAdapter extends FirestoreRecyclerAdapter<Cat, CatViewHolder> {


    public CatAdapter(@NonNull FirestoreRecyclerOptions<Cat> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CatViewHolder holder, int position, @NonNull Cat model) {
        holder.textView.setText(model.getAge()+"");
        holder.textView1.setText(model.getName());

    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new CatViewHolder(view);
    }
}
