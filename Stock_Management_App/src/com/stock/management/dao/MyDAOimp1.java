package com.stock.management.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stock.management.model.Order_Info;
import com.stock.management.model.Product_Info;
import com.stock.management.model.SignUp;

@Component
public class MyDAOimp1 implements MyDAO {
	@Autowired
	SessionFactory sf;

	@Override
	public String register(SignUp su) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(SignUp.class);
		cr.add(Restrictions.eq("email", su.getEmail()));
		SignUp sui = (SignUp) cr.uniqueResult();
		if (sui != null) {

			return "User Already Exist!";
		} else {
			ss.save(su);
			ss.beginTransaction().commit();
			ss.close();
			return "Register Successfully";

		}

	}

	@Override
	public void addProduct(Product_Info pi) {

		Session ss = sf.openSession();
		ss.save(pi);
		ss.beginTransaction().commit();
		ss.close();
	}

	@Override
	public SignUp login(SignUp su) {
		Session ss = sf.openSession();

		Criteria cr = ss.createCriteria(SignUp.class);
		cr.add(Restrictions.eq("email", su.getEmail()));
		cr.add(Restrictions.eq("password", su.getPassword()));
		SignUp sui = (SignUp) cr.uniqueResult();
		ss.beginTransaction().commit();
		ss.close();

		return sui;

	}

	@Override
	public List<Product_Info> searchproduct(String search) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Product_Info.class);
		Criterion name = Restrictions.ilike("name", search, MatchMode.ANYWHERE);
		Criterion company = Restrictions.ilike("company", search, MatchMode.ANYWHERE);
		Criterion category = Restrictions.ilike("category", search, MatchMode.ANYWHERE);
		Criterion all = Restrictions.disjunction().add(name).add(company).add(category);
		cr.add(all);
		List<Product_Info> plist = cr.list();
		ss.close();
		return plist;
	}

	@Override
	public List<Product_Info> update_product(Product_Info pi) {
		Session ss = sf.openSession();
		System.out.println(pi.getName());
		ss.update(pi);
		ss.beginTransaction().commit();
		Criteria cr = ss.createCriteria(Product_Info.class);
		List<Product_Info> plist = cr.list();

		return plist;
	}

	@Override
	public List<Product_Info> avail() {

		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Product_Info.class);
		List<Product_Info> plist = cr.list();

		return plist;

	}

	@Override
	public List<Order_Info> add_cart(Product_Info pi) {
		Session ss = sf.openSession();
		System.out.println("add cart dao");
		Product_Info pin = ss.load(Product_Info.class, pi.getPid());
		Order_Info oin = new Order_Info();
		oin.setTotal_price((pin.getPrice() * pi.getQuantity()));
		double gst = ((pin.getPrice() * pi.getQuantity()) * 1.18);
		oin.setTotal_price_with_gst(gst);
		pin.setQuantity(pin.getQuantity() - pi.getQuantity());
		List<Order_Info> olist = pin.getOlist();
		olist.add(oin);
		ss.saveOrUpdate(pin);
		ss.beginTransaction().commit();
		Criteria cr = ss.createCriteria(Order_Info.class);
		List<Order_Info> nolist = cr.list();

		return nolist;
	}

	@Override
	public List<Order_Info> cart_page() {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Order_Info.class);
		List<Order_Info> olist = cr.list();
		return olist;
	}

}
