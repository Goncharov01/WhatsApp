package com.example.whatsapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;


public class NewFragment extends Fragment {
    RecyclerView recyclerView;
    @Inject
    CatAdapter catAdapter;
    @Inject
    Cat cat;

    @Inject
    FirebaseFirestore db;

    @Override
    public void onAttach(@NonNull Activity activity) {
        AndroidSupportInjection.inject(this);
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_new, container, false);
         recyclerView= view.findViewById(R.id.fragmentRecyclerView);
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
         recyclerView.setAdapter(catAdapter);
        db.collection("cats")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
//                            Query query = db.collection("cats").orderBy("age",Query.Direction.DESCENDING);
//                            FirestoreRecyclerOptions<Cat> options = new FirestoreRecyclerOptions.Builder<Cat>()
//                                    .setQuery(query, Cat.class)
//                                    .build();


                            for (QueryDocumentSnapshot queryDocumentSnapshots:task.getResult()
                            ) {
                                System.out.println(queryDocumentSnapshots.getData() + "ssssssss");
                            }
                            System.out.println("All Collection" + task.getResult());
                        }
                    }
                });
         return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        System.out.println("&&&&&&&&&&&&&&&&&&&&" + db);


// Add a new document with a generated ID
        db.collection("cats")
                .add(cat)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("Succes11 " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Failure22 " + e);
                    }
                });
    }




    @Override
    public void onStart() {
        super.onStart();
        catAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        catAdapter.stopListening();
    }
}