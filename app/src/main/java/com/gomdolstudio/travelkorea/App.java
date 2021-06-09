package com.gomdolstudio.travelkorea;


import com.gomdolstudio.travelkorea.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        return DaggerAppComponent.factory().create(this);
    }
}
