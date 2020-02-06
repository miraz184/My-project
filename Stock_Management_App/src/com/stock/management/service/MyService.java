package com.stock.management.service;

import java.util.List;

import com.stock.management.model.Order_Info;
import com.stock.management.model.Product_Info;
import com.stock.management.model.SignUp;

public interface MyService {
	public String register(SignUp su);
	public void addProduct( Product_Info pi);
	public SignUp login(SignUp su);
	List<Product_Info> searchproduct(String search);
//	public List<Product_Info> searchproduct(String search,String filter);
	List<Product_Info> update_product (Product_Info pi);
	//List<Product_Info> edit (Product_Info pi);
	List<Product_Info> avail();
	List<Order_Info> add_cart(Product_Info pi);
	List<Order_Info> cart_page();
}
