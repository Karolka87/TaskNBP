package com.example.nbpapp.api;

import com.example.nbpapp.dto.AverageExchangeRateResponse;
import com.example.nbpapp.dto.Rate;
import com.example.nbpapp.service.NBPRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = {"/api"})
public class NBPController {

    private final NBPRateService nbpRateService;

    public NBPController(NBPRateService nbpRateService) {
        this.nbpRateService = nbpRateService;
    }

    @GetMapping(path = {"/exchange/{currency}/{date}"})
    public String exchangeCurrency(
            @PathVariable final String currency,
            @PathVariable final String date

    ) throws IOException {
        return "Average exchange rate for " + currency + " is: " + nbpRateService.getAverageRateResponse(currency, date).getRates().get(0).getMid();
    }

    @GetMapping(path = {"/averageValue/{currency}/{count}"})
    public String averageValue(
            @PathVariable final String currency,
            @PathVariable final int count
    ) throws IOException {

        AverageExchangeRateResponse lastRatesResponse = nbpRateService.getLastRatesResponse(currency, count);

        double regValue = 0;
        double maxValue = regValue;
        double minValue = -1;

        for (int i = 0; i < count; i++) {

            regValue = lastRatesResponse.getRates().get(i).getMid();

            if (minValue == -1) {
                minValue = regValue;
            }

            if (regValue < minValue) {
                minValue = regValue;
            }

            if (regValue > maxValue) {
                maxValue = regValue;
            }

        }

        return "Min average exchange rates was: " + minValue + " and the max average exchange rates was: " + maxValue;
    }

    @GetMapping(path = {"/bidAndAsk/{currency}/{count}"})
    public String bidAndAsk(
            @PathVariable final String currency,
            @PathVariable final int count
    ) throws IOException {

        AverageExchangeRateResponse bidAndAskResponse = nbpRateService.getBidAndAskResponse(currency, count);
        List<Rate> rates = bidAndAskResponse.getRates();

        double maxDifference = 0;

        for (int i = 0; i < rates.size(); i++) {

            double bidRate = rates.get(i).getBid();
            double askRate = rates.get(i).getAsk();
            double difference = askRate - bidRate;

            if (maxDifference == 0) {
                maxDifference = difference;

            }
            if (maxDifference <= difference) {
                maxDifference = difference;

            }
        }

        return "Biggest difference was: " + maxDifference;

    }

}
