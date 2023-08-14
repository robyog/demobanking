package it.demo.bank.service;

import it.demo.bank.exceptions.ServiceException;

public interface BankService {

	public Long readAccount(String accountId) throws ServiceException;

}
