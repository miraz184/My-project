package com.stock.management.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stock.management.model.Order_Info;
import com.stock.management.model.Product_Info;
import com.stock.management.model.SignUp;
import com.stock.management.service.MyService;

@RequestMapping("/")
@Component
public class MyController {
	@Autowired
	MyService ms;

	HttpSession hn;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginValidation", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute SignUp su, HttpServletRequest req) {

		SignUp sui = ms.login(su);
		if (sui != null) {
			hn = req.getSession();
			hn.setAttribute("email", su.getEmail());
			System.out.println("login success");
			return new ModelAndView("menu", "dto", su);
		} else {
			return new ModelAndView("login", "msg", "Wrong Email_id & password");
		}
	}

	@RequestMapping("/signup")
	public String registration() {
		return "signup";

	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute SignUp ui) {
		System.out.println("inside controller");
		return new ModelAndView("signup", "msg", ms.register(ui));
	}

	@RequestMapping("/add")
	public String signup() {
		return "productentry";

	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addproduct(@ModelAttribute Product_Info pi) {
		System.out.println("inside controller");
		ms.addProduct(pi);
		return new ModelAndView("menu", "msg", "product added successfully");
	}

	@RequestMapping("/searchp")
	public ModelAndView searchp() {

		return new ModelAndView("search");
	}

	@RequestMapping(value = "/searchproduct", method = RequestMethod.POST)
	public ModelAndView searchproduct(@RequestParam String search) {
		List<Product_Info> plist = ms.searchproduct(search);

		return new ModelAndView("available_product", "list", plist);
	}

	@RequestMapping(value = "/update_product", method = RequestMethod.POST)
	public ModelAndView update_product(@ModelAttribute Product_Info pi) {

		System.out.println("inside controller");
		List<Product_Info> list = ms.update_product(pi);

		return new ModelAndView("productsearch", "list", list);
	}

	@RequestMapping("/avail")
	public ModelAndView avail() {
		List<Product_Info> list = ms.avail();
		System.out.println("inside controller");
		return new ModelAndView("productsearch", "list", list);
	}

	@RequestMapping(value = "/Add_Cart", method = RequestMethod.POST)
	public ModelAndView add_cart(@ModelAttribute Product_Info pi) {
		List<Order_Info> list = ms.add_cart(pi);
		return new ModelAndView("menu");
	}

	@RequestMapping("/cart_page")
	public ModelAndView cart_page(HttpServletRequest req) {
		hn = req.getSession(false);
		String email = (String) hn.getAttribute("email");

		if (email != null) {
			List<Order_Info> list = ms.cart_page();
			return new ModelAndView("cartproduct", "list", list);
		} else {

			return new ModelAndView("login", "msg", "Login First..........");

		}

	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		if (hn.getAttribute("email") != null) {
			hn.setAttribute("email", null);
			return new ModelAndView("login", "msg", "Logout Successfully");

		} else {
			return new ModelAndView("login", "msg", "Login First..........");
		}
	}

}
