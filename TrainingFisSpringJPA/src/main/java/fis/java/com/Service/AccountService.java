package fis.java.com.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fis.java.com.Entity.Account;
import fis.java.com.Repository.AccountRepository;

public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository accountrepo;

	@Override
	public Account save(Account account) {

		return accountrepo.save(account);
	}

	@Override
	public Account update(Account account) {
		account.setUpdateDate(new Date());
		return accountrepo.save(account);
	}

	@Override
	public void deleteById(Long accountId) {

		accountrepo.deleteById(accountId);
	}

	@Override
	public void getByID(Long accountId) {

		accountrepo.findById(accountId);
	}

	@Override
	public List<Account> getByfullname(String fullName) {

		return accountrepo.getByFullname(fullName);
	}

}
