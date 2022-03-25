package fis.java.com.AccountDao;

import java.util.List;

import fis.java.com.Entity.Account;

public interface AccountDao {

	List<Account> getByFullname(String fullname);
}
