package com.gomdolstudio.travelkorea.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.gomdolstudio.travelkorea.R;
import com.gomdolstudio.travelkorea.databinding.ActivityMainBinding;
import com.gomdolstudio.travelkorea.di.ActivityContext;
import com.gomdolstudio.travelkorea.di.ActivityScope;
import com.gomdolstudio.travelkorea.di.FragmentScope;
import com.gomdolstudio.travelkorea.ui.flight.FlightFragment;
import com.gomdolstudio.travelkorea.ui.flight.FlightModule;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {
    @Provides
    @ActivityScope
    static ActivityMainBinding provideBinding(MainActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

    @Provides
    @ActivityContext
    static Context provideContext(MainActivity activity){
        return activity;
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = FlightModule.class)
    abstract FlightFragment getFlightFragment();

}
