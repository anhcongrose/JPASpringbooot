package fis.java.com.Service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import fis.java.com.Entity.Customer;


public interface ICustomerService extends UserDetailsService {

	List<Customer> getAllCustomer();

	Customer getCustomerById(Long customerId);

	String creatCustomers(Customer customer);

	Customer updateCustomer(Customer customer);

	void deleteById(Long customerId);

	Customer findCustomerByCustomerName(String customerName);

}
