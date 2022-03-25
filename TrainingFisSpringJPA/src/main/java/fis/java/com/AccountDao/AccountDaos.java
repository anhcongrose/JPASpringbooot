package fis.java.com.AccountDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import fis.java.com.Entity.Account;

public class AccountDaos implements AccountDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public List<Account> getByFullname(String fullname) {

		String sql = "SELECT * FROM `account` WHERE fullname = :fullname ";
		Map params = new HashMap();

		return null;
	}

}
