package fis.java.com.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Oder", catalog = "oderdemojpa")
public class Oder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oderId")
	private Long oderId;

	@Column(name = "oderNumber", nullable = false, length = 10, unique = false)
	private String oderNumber;

	@Column(name = "oderName", nullable = false, length = 15)
	private String oderName;

	private Customer customer;

	@Column(name = "creatdate")
	private Date creatdate;

	@Column(name = "totalPrice")
	private Double totalPrice;

	public String getOderNumber() {
		return oderNumber;
	}

	public void setOderNumber(String oderNumber) {
		this.oderNumber = oderNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Oder() {
		super();
	}

	public Oder(Long oderId, String oderNumber, String oderName, Customer customer, Date creatdate, Double totalPrice) {
		super();
		this.oderId = oderId;
		this.oderNumber = oderNumber;
		this.oderName = oderName;
		this.customer = customer;
		this.creatdate = creatdate;
		this.totalPrice = totalPrice;
	}

	public Long getOderId() {
		return oderId;
	}

	public void setOderId(Long oderId) {
		this.oderId = oderId;
	}

	public String getOderName() {
		return oderName;
	}

	public void setOderName(String oderName) {
		this.oderName = oderName;
	}

	public Date getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
