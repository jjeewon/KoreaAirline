package com.gomdolstudio.travelkorea.di;

import com.gomdolstudio.travelkorea.ui.MainActivity;
import com.gomdolstudio.travelkorea.ui.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {
    /**
     * MainAcitivity를 위한 서브 컴포넌트를 정의
     */
    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
