package com.ca.scotiabank_homeassignment.api;

import com.ca.scotiabank_homeassignment.model.RepoDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import rx.Observable;

public interface ApiService {

    @GET("repositories")
    Observable<RepoDetail> getGithubUserRepositores(@Query("q") String search, @Query(":")String body);
}
