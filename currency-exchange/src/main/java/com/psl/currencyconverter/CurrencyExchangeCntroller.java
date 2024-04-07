package com.psl.currencyconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyExchangeCntroller {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyRepo repo;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange exchange(@PathVariable String from ,
                                     @PathVariable String to){
        String property = environment.getProperty("local.server.port");
        CurrencyExchange byFromAndTo = repo.findByFromAndTo(from, to);
        byFromAndTo.setEnvironment(property);
        return byFromAndTo;
    }
}
