package com.hsbc.currencyCalculation.facade;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hsbc.currencyCalculation.model.CalculationAmount;

//@FeignClient(name="currency-exchange-service", url="http://localhost:8000")
@FeignClient(name="currency-exchange-service")
@LoadBalancerClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CalculationAmount retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to );
}
