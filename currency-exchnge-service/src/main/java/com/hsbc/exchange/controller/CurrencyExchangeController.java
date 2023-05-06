package com.hsbc.exchange.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.exchange.model.ExchangeValue;
import com.hsbc.exchange.repository.ExchangeVaueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeVaueRepository exchangeVaueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to ) {
		//ExchangeValue exchangeValue =  new ExchangeValue(1000L, "USD", "INR", BigDecimal.valueOf(70), Integer.parseInt( environment.getProperty("local.server.port")));
		ExchangeValue exchangeValue = exchangeVaueRepository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt( environment.getProperty("local.server.port")));
		System.out.println(exchangeValue);
		return exchangeValue;
	}
}
