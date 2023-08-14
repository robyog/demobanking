package it.demo.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.demo.bank.exceptions.FabrickApiException;
import it.demo.bank.exceptions.ServiceException;
import it.demo.bank.external.BankRepository;
import it.demo.bank.model.Account;
import it.demo.bank.service.BankService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BankServiceImpl implements BankService {

	@Autowired
	BankRepository bankRepository;

	@Override
	public Long readAccount(String accountId) throws ServiceException {
		try {
			log.info("read account info for {} ", new Object[] { accountId });
			Account accountFound = bankRepository.getAccountInfo(accountId);
			log.info("finish read account info for {} ", new Object[] { accountId });
			if (log.isDebugEnabled()) {
				log.debug("account info found {} ",new Object[] {accountFound});
			}
			return accountFound.getAccount();
		} catch (FabrickApiException e) {
			log.error("Cannot retrieve data for accountId {} {}", new Object[] { accountId, e });
		}
		throw new ServiceException("Cannot retrieve data");
	}

}
