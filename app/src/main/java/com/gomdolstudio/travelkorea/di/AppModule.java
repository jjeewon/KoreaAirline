package com.gomdolstudio.travelkorea.di;

import android.app.Application;
import android.content.Context;

import com.gomdolstudio.travelkorea.App;
import com.gomdolstudio.travelkorea.util.SingleLiveEvent;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

@Module(includes = {ViewModelModule.class})
public class AppModule {

    @Provides
    @Singleton
    Application provideApp(App app){
        return app;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(App app){
        return app;
    }

    @Singleton
    @Provides
    @Named("errorEvent")
    SingleLiveEvent<Throwable> provideErrorEvent(){
        return new SingleLiveEvent<>();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(" ")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }
}
