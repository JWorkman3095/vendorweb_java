package com.maxtrain.bootcamp.invoiceline;

import javax.persistence.*;

import com.maxtrain.bootcamp.invoice.Invoice;
import com.maxtrain.bootcamp.product.Product;

@Entity
public class InvoiceLine {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int")
	private int id;
	private int quantity;
	@ManyToOne(optional=false)
	@JoinColumn(name="invoiceId", columnDefinition="int")
	private Invoice invoice; //FK
	@ManyToOne(optional=false)
	@JoinColumn(name="productId", columnDefinition="int")
	private Product product; //FK
	
	//Default Constructor
	public InvoiceLine() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
