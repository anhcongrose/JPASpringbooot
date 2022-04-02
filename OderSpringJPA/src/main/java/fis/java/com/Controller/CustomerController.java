package fis.java.com.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fis.java.com.Entity.Customer;
import fis.java.com.Service.ICustomerService;

@RestController
@RequestMapping(value = "/customer")

public class CustomerController {
	@Autowired
	private ICustomerService cusrService;

	@GetMapping()
	public ResponseEntity<?> getAllCustomer() {

		return new ResponseEntity<>(cusrService.getAllCustomer(), HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")

	public ResponseEntity<?> getCustomerByID(@PathVariable(name = "id") Long customerId) {
		return new ResponseEntity<Customer>(cusrService.getCustomerById(customerId), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {

		return new ResponseEntity<String>(cusrService.creatCustomers(customer), HttpStatus.OK);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id")@Valid Long customerId, String customerName,
			@RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		cusrService.updateCustomer(customer);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(name = "id") Long customerId) {
		cusrService.deleteById(customerId);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

}
