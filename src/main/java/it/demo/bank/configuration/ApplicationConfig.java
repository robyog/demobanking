package it.demo.bank.configuration;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Configuration
public class ApplicationConfig {
	@Autowired
	FabrickApiConnectionParam fabrickApiConnectionParam;
	
    
    @Bean
    public RestTemplate fabrickRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        
        return restTemplate;
    }
}
