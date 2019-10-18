package com.gymnasticbodies.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    private Logger logger = LoggerFactory.getLogger((this.getClass()));

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from,to);
        //exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        logger.info("{}",exchangeValue);
        return exchangeValue;
    }

    @GetMapping("/currency-exchange/list")
    public List<ExchangeValue> getFromCurrenctyList(){
        List<ExchangeValue> responseCurrencyExchangeList=exchangeValueRepository.findAll();
        return responseCurrencyExchangeList;
    }


}
