package com.example.whatsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatViewHolder extends RecyclerView.ViewHolder {

//Оперделить переменные
    TextView textView,textView1;
    public CatViewHolder(@NonNull View itemView) {
        super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView = itemView.findViewById(R.id.textView);
        //R.id
    }
}
