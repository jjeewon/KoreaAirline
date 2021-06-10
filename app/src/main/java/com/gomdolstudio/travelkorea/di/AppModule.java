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
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module(includes = {ViewModelModule.class, RetrofitModule.class})
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
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .baseUrl("http://openapi.tago.go.kr/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();


    }


}
