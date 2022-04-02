package fis.java.com.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OderDetail", catalog = "oderdemojpa")
public class OderDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", length = 50, nullable = false)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oderId", nullable = false)
	private Oder oder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	private Product product;

	private Double price;
	private Double amount;

	public OderDetail() {
		super();
	}

	public OderDetail(Oder oder, Product product, int quanity, Double price, Double amount) {
		super();

		this.oder = oder;
		this.product = product;

		this.price = price;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Oder getOder() {
		return oder;
	}

	public void setOder(Oder oder) {
		this.oder = oder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
