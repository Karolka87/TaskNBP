package com.example.nbpapp.service;

import com.example.nbpapp.dto.AverageExchangeRateResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ExchangeRateAPI {

    @GET("rates/a/{currency}/{date}/?format=json")
    Call<AverageExchangeRateResponse> getApiResponse(@Path("currency") String currency, @Path("date") String date);

    //dwie parametry codecurrency i date
    @GET("rates/a/{currency}/last/{count}/?format=json")
    Call<AverageExchangeRateResponse> getLastRatesResponse(@Path("currency") String currency, @Path("count") int count);

    @GET("rates/c/{currency}/last/{count}/?format=json")
    Call<AverageExchangeRateResponse> getBidAndAskResponse(@Path("currency") String currency, @Path("count") int count);
}

