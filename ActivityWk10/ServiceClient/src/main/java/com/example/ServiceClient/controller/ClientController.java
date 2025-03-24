package com.example.ServiceClient.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.cloud.client.ServiceInstance;
	import org.springframework.cloud.client.discovery.DiscoveryClient;
	import org.springframework.stereotype.Service;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.client.RestTemplate;

	import java.util.List;

	@RestController
	public class ClientController {

	    @Autowired
	    private LoadBalancedService loadBalancedService;

	    @GetMapping("/get-message")
	    public String getMessage(@RequestParam(defaultValue = "Client") String name) {
	        return loadBalancedService.callServiceProvider(name);
	    }
	}

	@Service
	class LoadBalancedService {
	    
	    @Autowired
	    private DiscoveryClient discoveryClient;

	    @Autowired
	    private RestTemplate restTemplate;

	    public String callServiceProvider(String name) {
	        List<ServiceInstance> instances = discoveryClient.getInstances("ServiceProvider");

	        if (instances.isEmpty()) {
	            return "No instances of service-provider available.";
	        }

	        // Pick the first available instance
	        String serviceUrl = instances.get(0).getUri().toString() + "/message?name=" + name;
	        return restTemplate.getForObject(serviceUrl, String.class);
	    }
	}



