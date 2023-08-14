package it.demo.bank.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix="fabrick")
public class FabrickApiConnectionParam {
	
	private String baseurl;
	
	private String authSchema;
	
	private String apiKey;
	
	private String idChiave;
	
	private String accountCashApi;

}