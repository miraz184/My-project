package com.stock.management.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class Product_Info implements Serializable {
@Id
@GenericGenerator(name="auto",strategy = "increment")
@GeneratedValue(generator = "auto")

private int pid;
private String name;
private String category;
private String company;
private double quantity;
private double price;
private int addqty;
private int addmulcart;




@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(name ="order_history_info",joinColumns = @JoinColumn(name="pid"),inverseJoinColumns = @JoinColumn(name="oid"))

private List<Order_Info>olist;



public int getAddqty() {
	return addqty;
}

public void setAddqty(int addqty) {
	this.addqty = addqty;
}

public int getAddmulcart() {
	return addmulcart;
}

public void setAddmulcart(int addmulcart) {
	this.addmulcart = addmulcart;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public double getQuantity() {
	return quantity;
}

public void setQuantity(double quantity) {
	this.quantity = quantity;
}

public List<Order_Info> getOlist() {
	return olist;
}

public void setOlist(List<Order_Info> olist) {
	this.olist = olist;
}


}