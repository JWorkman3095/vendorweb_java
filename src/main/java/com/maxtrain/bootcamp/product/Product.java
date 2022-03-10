package com.maxtrain.bootcamp.product;

import javax.persistence.*;

@Entity
//unique
@Table(uniqueConstraints=@UniqueConstraint(name="UIDX_code", columnNames={"partNbr"}))
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int")
	private int id;
	@Column(length=50, nullable=false)
	//Unique
	private String partNbr;
	@Column(length=50, nullable=false)
	private String name;
	@Column(columnDefinition="decimal(9,2) NOT NULL")
	private double price;
	
	//Default Constructor
	public Product() {}
	
	//Get Set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPartNbr() {
		return partNbr;
	}
	public void setPartNbr(String partNbr) {
		this.partNbr = partNbr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}	

}
