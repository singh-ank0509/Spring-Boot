package com.ankur.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="welcome-api")
public interface GreetFeignClient {

	@GetMapping("/welcome")
	public String welcomeApiCall();
}
