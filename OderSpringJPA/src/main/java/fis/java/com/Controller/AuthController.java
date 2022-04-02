package fis.java.com.Controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.java.com.DTO.LoginInfoCustomer;
import fis.java.com.Entity.Customer;
import fis.java.com.Service.ICustomerService;

@RestController
@RequestMapping(value = "api/v1/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ICustomerService customerservice;

	@GetMapping("/login")
	public LoginInfoCustomer login(Principal principal) {

		String customerName = principal.getName();
		Customer entity = customerservice.findCustomerByCustomerName(customerName);

		// convert entity --> dto
		LoginInfoCustomer dto = modelMapper.map(entity, LoginInfoCustomer.class);

		return dto;
	}
}
