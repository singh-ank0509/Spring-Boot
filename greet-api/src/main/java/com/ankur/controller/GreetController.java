package com.ankur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankur.clients.GreetFeignClient;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/api/greet")
public class GreetController {
	
	@Autowired
	private GreetFeignClient feignClient;
	
	@Autowired
	private Environment env;

	@GetMapping("/")
	public String welcome() {
		
		String welcomeMsg = feignClient.welcomeApiCall();
		
		String port = env.getProperty("server.port");
		
//		return "Good Morning... Cricketing Fellows!!";
		return "Good Morning ...(" + port +") "  + welcomeMsg;
	}
	
	 @GetMapping("/client-ip")
	    public String getClientIp(HttpServletRequest request) {
	        String ipAddress = request.getHeader("X-Forwarded-For");
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("Proxy-Client-IP");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("HTTP_CLIENT_IP");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	            ipAddress = request.getHeader("HTTP_X_FORWARDED_FOR");
	        }
	        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
	        	System.err.println("IpAddress " +  ipAddress);
	            ipAddress = request.getRemoteAddr();
	            System.err.println("IpAddress " +  ipAddress);
	        }

	        // In case of multiple IPs in X-Forwarded-For header, take the first one
	        if (ipAddress != null && ipAddress.contains(",")) {
	            ipAddress = ipAddress.split(",")[0];
	        }

	        return "Client IP address: " + ipAddress;
	    }
}
