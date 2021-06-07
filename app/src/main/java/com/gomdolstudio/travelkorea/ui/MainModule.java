package com.gomdolstudio.travelkorea.ui;

import android.content.Context;

import androidx.databinding.DataBindingUtil;

import com.gomdolstudio.travelkorea.R;
import com.gomdolstudio.travelkorea.databinding.ActivityMainBinding;
import com.gomdolstudio.travelkorea.di.ActivityContext;
import com.gomdolstudio.travelkorea.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

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
}
