package fis.java.com.Service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fis.java.com.Entity.Customer;
import fis.java.com.Repository.CustomerRepository;

@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public List<Customer> getAllCustomer() {

		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(Long customerId) {

		return customerRepo.findById(customerId).get();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String creatCustomers(Customer customer) {
		String masage = "số phone đã tồn tại";
		Customer customer1 = new Customer();
		if (customer.getPhone().equals(customerRepo.existsByPhone(customer1.getPhone())))
			return masage;
		if (customer.getPhone().length() < 11)
			return "số phone không hợp lệ!";
		customerRepo.save(customer);

		return "thành công";

	}

	@Override
	public Customer updateCustomer(Customer customer) {

		return customerRepo.save(customer);
	}

	@Override
	public void deleteById(Long customerId) {

		customerRepo.deleteById(customerId);
	}

	@Override
	public UserDetails loadUserByUsername(String customerName) throws UsernameNotFoundException {
		Customer customer = customerRepo.findByCustomerName(customerName);
		if (customer == null) {
			throw new UsernameNotFoundException(customerName);
		}
		return new User(
				customer.getCustomerName(),
				customer.getPassword(),
				Collections.emptyList());
	}

	@Override
	public Customer findCustomerByCustomerName(String customerName) {
		
		return customerRepo.findByCustomerName(customerName);
	}

	

}
