package com.example.afalse.androidmonthdemo.PortService;

import com.example.afalse.androidmonthdemo.bean.CodeBean;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.Part;

public interface PortraitService {

    @Headers({"User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0", "Connection: keep-alive"})
    @Multipart
    Call<CodeBean> getCodeString(@Part MultipartBody.Part file);
}
