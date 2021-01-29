package com.example.whatsapp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    public Cat getCat() {
        return new Cat();

    }
}
