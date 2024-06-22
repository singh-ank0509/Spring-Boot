package com.ankur.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="welcome-api/api/welcome")
public interface GreetFeignClient {

	@GetMapping("/")
	public String welcomeApiCall();
}
