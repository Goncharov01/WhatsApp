package com.example.whatsapp;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public FirebaseFirestore getFireBaseStore(){
        return FirebaseFirestore.getInstance();
    }

    @Provides
    @Singleton
    public Cat getCat() {
        return new Cat("Barsik",29);

    }
    @Provides
    @Singleton
    public FirestoreRecyclerOptions<Cat> setUpRecycklerView(FirebaseFirestore firebaseFirestore){
        Query query = firebaseFirestore
                .collection("cats");

        FirestoreRecyclerOptions<Cat> options = new FirestoreRecyclerOptions.Builder<Cat>()
                .setQuery(query, Cat.class).build();
        return options;
    }
    @Provides
    @Singleton
    public CatAdapter getCatAdapter(FirestoreRecyclerOptions<Cat> firestoreRecyclerOptions){
        return new CatAdapter(firestoreRecyclerOptions);
    }

}
