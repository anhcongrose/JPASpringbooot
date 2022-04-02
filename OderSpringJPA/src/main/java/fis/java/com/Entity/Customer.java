package fis.java.com.Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer", catalog = "oderdemojpa")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId")
	private Long customerId;

	@Column(name = "customerName", nullable = false, length = 15)
	@NotNull(message = "không được để trống dữ customer")
	@Length(max = 15, min = 5)
	private String customerName;

	@Column(name = "`email`", nullable = false, length = 50, unique = true)
	private String email;

	@Column(name = "`password`", nullable = false, length = 800)
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name = "phone", nullable = false, length = 11, unique = false)
	@NotNull(message = "không được để trống phone")
	private String phone;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Oder> ListOder;

	@Column(name = "role", nullable = false)
	private String role = "Employee";

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "`status`", nullable = false)
	private CustomerStatus status = CustomerStatus.NOT_ACTIVE;

}
