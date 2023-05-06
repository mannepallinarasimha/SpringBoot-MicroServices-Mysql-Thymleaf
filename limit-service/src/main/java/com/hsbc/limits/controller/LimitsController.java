package com.hsbc.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.limits.bean.LimitConfiguration;

@RestController
public class LimitsController {
	
	@Autowired
	private LimitConfiguration limitConfiguration;
	
	@GetMapping("/limits")
	public LimitConfiguration returnLimits() {
		return new LimitConfiguration(limitConfiguration.getMaximum(), limitConfiguration.getMinimum());
	}

}
