package com.example.nbpapp.service;

import com.example.nbpapp.dto.AverageExchangeRateResponse;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class NBPRateService {

    private final ExchangeRateAPI exchangeRateAPI;

    public NBPRateService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nbp.pl/api/exchangerates/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        exchangeRateAPI = retrofit.create(ExchangeRateAPI.class);
    }

    public AverageExchangeRateResponse getAverageRateResponse(String currency, String date) throws IOException {


        return exchangeRateAPI.getApiResponse(currency, date).execute().body();
    }

    public AverageExchangeRateResponse getLastRatesResponse(String currency, int count) throws IOException {

        return exchangeRateAPI.getLastRatesResponse(currency, count).execute().body();
    }

    public AverageExchangeRateResponse getBidAndAskResponse(String currency, int count) throws IOException {
        return exchangeRateAPI.getBidAndAskResponse(currency, count).execute().body();
    }
}


