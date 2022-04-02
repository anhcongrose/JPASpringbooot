package fis.java.com.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginInfoCustomer {

	private int customerId;

	private String customerName;

	private String email;

	private String role;

	private String status;

	

}
