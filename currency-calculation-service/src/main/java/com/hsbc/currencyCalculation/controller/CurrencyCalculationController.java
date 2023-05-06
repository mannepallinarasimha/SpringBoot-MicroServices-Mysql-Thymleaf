package com.hsbc.currencyCalculation.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hsbc.currencyCalculation.facade.CurrencyExchangeProxy;
import com.hsbc.currencyCalculation.model.CalculationAmount;

@RestController
public class CurrencyCalculationController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/currency-calculation/from/{from}/to/{to}/quantity/{quantity}")
	public CalculationAmount retriveCalculatedValue(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CalculationAmount> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CalculationAmount.class, uriVariables);
		CalculationAmount body = forEntity.getBody();
		CalculationAmount calculationAmount = new CalculationAmount(body.getId(), body.getFrom(),body.getTo(),body.getConversionMultiple(), quantity, quantity.multiply(body.getConversionMultiple()),body.getPort());
		return calculationAmount;
	}
	
	@GetMapping("/currency-calculation-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CalculationAmount retriveCalculatedValueFeign(
			@PathVariable("from") String from,
			@PathVariable("to") String to,
			@PathVariable("quantity") BigDecimal quantity) {
//		Map<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//		ResponseEntity<CalculationAmount> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CalculationAmount.class, uriVariables);
//		CalculationAmount body = forEntity.getBody();
		CalculationAmount body = currencyExchangeProxy.retriveExchangeValue(from, to);
		CalculationAmount calculationAmount = new CalculationAmount(body.getId(), body.getFrom(),body.getTo(),body.getConversionMultiple(), quantity, quantity.multiply(body.getConversionMultiple()),body.getPort());
		return calculationAmount;
	}
}
