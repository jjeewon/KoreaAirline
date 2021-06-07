package com.gomdolstudio.travelkorea.di;

import com.gomdolstudio.travelkorea.App;

import dagger.Component;
import dagger.android.AndroidInjector;

@Component
public interface AppComponent extends AndroidInjector<App> {

    @Component.Factory
    abstract class Factory implements AndroidInjector.Factory<App>{

    }
}
