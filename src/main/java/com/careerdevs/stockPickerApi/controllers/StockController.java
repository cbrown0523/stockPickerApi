package com.careerdevs.stockPickerApi.controllers;

import com.careerdevs.stockPickerApi.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private Environment env;
    //https://www.alphavantage.co/query?function=OVERVIEW&symbol=IBM&apikey=demo
    @GetMapping("/test")
    private String test(){
        return "testing 123" ;
    }

    @GetMapping("/overview")
    private StockModel companyStockToday(RestTemplate restTemplate,
    @RequestParam ( value = "symbol" , required = false , defaultValue = "IBM") String symbol

    ){
        String API_key = env.getProperty("Api_key");
        String url ="https://www.alphavantage.co/query?function=OVERVIEW&symbol="+ symbol + "&apikey=" + API_key;
        StockModel response = restTemplate.getForObject(url, StockModel.class );
        System.out.println(response);
        return response;



    }

private Object testing(RestTemplate restTemplate){
        String API_Key = env.getProperty("stockApi_key");
        String url ="https://www.alphavantage.co/query?function=OVERVIEW&symbol=IBM&apikey=" + API_Key;
        Object response = restTemplate.getForObject(url, Object.class );
        System.out.println(response);
        return response;

        //is there always one set of lines 34  - 39

}

}
