package com.gomdolstudio.travelkorea.di;

import com.gomdolstudio.travelkorea.data.SearchService;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import retrofit2.Retrofit;

@Module
public class RetrofitModule {
    @Provides
    @Reusable
    SearchService provideSearchService(Retrofit retrofit){
        return retrofit.create(SearchService.class);
    }
}
