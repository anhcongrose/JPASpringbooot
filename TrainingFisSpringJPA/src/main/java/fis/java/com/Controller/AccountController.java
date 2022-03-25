package fis.java.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fis.java.com.Entity.Account;
import fis.java.com.Service.AccountService;
import fis.java.com.Service.IAccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private IAccountService Iaccountservice;

	@PostMapping("/save")
	@ResponseBody
	public ResponseEntity<?> save(@RequestBody Account account) {

		return ResponseEntity.ok(Iaccountservice.save(account));
	}

}
