package com.capgemini.configclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class ConfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigclientApplication.class, args);
	}
	/*@RefreshScope
	@RestController
	class Message{
		@Value("${message}")
		private String message;
			
		@RequestMapping("/message")
		String getMessage() {
			return this.message;
		}
		
		}*/
	@RestController
	class ServiceInstancerestController{
		 @Autowired
		private DiscoveryClient discoveryClient;
		 @RequestMapping("/serviceinstance/{name}")
		 public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String name){
			 return this.discoveryClient.getInstances(name);
		 }
		 
		 
		
	}
	}

