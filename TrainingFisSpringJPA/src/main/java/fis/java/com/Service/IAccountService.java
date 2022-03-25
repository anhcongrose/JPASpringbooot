package fis.java.com.Service;

import java.util.List;

import fis.java.com.Entity.Account;

public interface IAccountService {
	Account save(Account account);

	Account update(Account account);

	void deleteById(Long accountId);

	List<Account> getByfullname(String fullName);

	void getByID(Long accountId);

}
