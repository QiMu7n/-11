package com.example.afalse.androidmonthdemo.PortService;

import com.example.afalse.androidmonthdemo.bean.DynastyBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DynastyService {
    @GET("getTangPoetry")
    Call<DynastyBean> getDynasty(@Query("page") String page,
                              @Query("count") String count);
}
