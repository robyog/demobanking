package it.demo.bank;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import it.demo.bank.exceptions.FabrickApiException;
import it.demo.bank.exceptions.ServiceException;
import it.demo.bank.external.BankRepository;
import it.demo.bank.model.Account;
import it.demo.bank.service.BankService;
import it.demo.bank.service.impl.BankServiceImpl;
import it.demo.bank.exceptions.FabrickApiException;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	@Mock
	BankRepository bankRepository;
	
	@InjectMocks
	BankService bankService = new BankServiceImpl();
	
	@Mock
	Account accountFound;
	
	@Test
	void when_account_info_exist_then_return_account() throws FabrickApiException, ServiceException {
		accountFound = Mockito.spy(new Account());
		accountFound.setAccount(Long.parseLong("13245"));
		when(bankRepository.getAccountInfo(Mockito.anyString())).thenReturn(accountFound);
		Long account = bankService.readAccount("1234");
		verify(bankRepository.getAccountInfo(Mockito.anyString()),times(1));
		Assert.isTrue(account == 13245, "acccount vale not correct");
	}
	
	

	
	
}
