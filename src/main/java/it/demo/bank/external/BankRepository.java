package it.demo.bank.external;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import it.demo.bank.configuration.FabrickApiConnectionParam;
import it.demo.bank.exceptions.FabrickApiException;
import it.demo.bank.model.Account;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BankRepository {

	@Autowired
	FabrickApiConnectionParam fabrickApiConnectionParam;
	@Autowired
	private RestTemplate fabrickRestTemplate;

	public Account getAccountInfo(String accountId) throws FabrickApiException {
		try {
			URI uriCashApi = URI.create(
					fabrickApiConnectionParam.getBaseurl().concat(fabrickApiConnectionParam.getAccountCashApi().concat(accountId)));
			HttpHeaders headers = setStandardHeaders();
			HttpEntity<String> entity = new HttpEntity<>("body", headers);
			ResponseEntity<Account> response = fabrickRestTemplate.exchange(uriCashApi, HttpMethod.GET,entity, Account.class);
			return response.getBody();
		} catch (Exception e) {
			throw new FabrickApiException("Impossible retrieve data for accountId " + accountId, e);
		}

	}

	private HttpHeaders setStandardHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Auth-Schema", fabrickApiConnectionParam.getAuthSchema());
		headers.add("apiKey", fabrickApiConnectionParam.getApiKey());
		return headers;
	}

}
