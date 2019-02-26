package com.ca.scotiabank_homeassignment.api;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {


    private static final String ROOT_URL = "https://api.github.com/search/";


    private static Retrofit getRetrofitInstance() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);
        httpClient.connectTimeout(2, TimeUnit.MINUTES);
        httpClient.readTimeout(2, TimeUnit.MINUTES);
        httpClient.writeTimeout(2, TimeUnit.MINUTES);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request().newBuilder().
                        addHeader("Accept", "application/json").
                        build();
                return chain.proceed(request);
            }
        });

        return new Retrofit.
                Builder().
                baseUrl(ROOT_URL).
                addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).
                client(httpClient.build()).
                build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }

}

