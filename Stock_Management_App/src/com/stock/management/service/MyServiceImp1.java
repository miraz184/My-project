package com.stock.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.management.dao.MyDAO;
import com.stock.management.model.Order_Info;
import com.stock.management.model.Product_Info;
import com.stock.management.model.SignUp;
@Component
public class MyServiceImp1 implements MyService {
@Autowired
MyDAO md;

@Override
public String register(SignUp su) {
	System.out.println("inside service");
	return md.register(su);
	
}

@Override
public SignUp login(SignUp su) {
	System.out.println("inside service");
	SignUp b=md.login(su);
return b;
}

@Override
public void addProduct(Product_Info pi) {
	System.out.println("Inside Service.");
	md.addProduct(pi);
	
}

@Override
public List<Product_Info> searchproduct(String search) {
	List<Product_Info> plist=md.searchproduct(search);
	return plist;
}

//@Override
//public List<Product_Info> searchproduct(String search,String filter) {
//	List<Product_Info>mlist=md.searchproduct(search,filter);
//	return  mlist;
//}


@Override
public List<Product_Info> update_product(Product_Info pi) {
	List<Product_Info> b=md.update_product(pi);
	return b;
}

@Override
public List<Product_Info> avail() {
	List<Product_Info> b=md.avail();
	return b;
}

@Override
public List<Order_Info> add_cart(Product_Info pi) {
	List<Order_Info> clist=md.add_cart(pi);
	return clist;
}

@Override
public List<Order_Info> cart_page() {
	List<Order_Info> olist=md.cart_page();
	return olist;
}

//@Override
//public List<Product_Info> edit(Product_Info pi) {
//	List<Product_Info> b=md.edit(pi);
//	return b;
//}
//


}
