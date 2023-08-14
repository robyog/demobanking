package it.demo.bank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import it.demo.bank.exceptions.ControllerException;
import it.demo.bank.exceptions.ServiceException;
import it.demo.bank.service.BankService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class BankController {

	
	@Autowired
	BankService bankService;
	
	@GetMapping("/get/{accountId}")
	@ApiOperation(value = "get account info", notes = "get account info")
	public ResponseEntity<Long> readAccount(@PathVariable("accountId")  String accountId) throws ControllerException {
		try {
			log.info ("read account info for {} ", new Object[] {accountId});
			Long account = bankService.readAccount(accountId);
			return new ResponseEntity<Long>(account, HttpStatus.OK);
		} catch (ServiceException e) {
			log.error("Error into account read operation for accountId {} {}", new Object[] {accountId,e});
		}
		throw new ControllerException("Error into account read operation ", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
	
}
