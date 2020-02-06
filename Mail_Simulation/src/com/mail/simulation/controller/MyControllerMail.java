package com.mail.simulation.controller;

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

import com.mail.simulation.model.Mail_Info;
import com.mail.simulation.model.User_Info;
import com.mail.simulation.service.MyService;;

@Component
@RequestMapping("/")
public class MyControllerMail {
	@Autowired
	MyService ms;
	SessionFactory sf;
	HttpSession hn;

	@RequestMapping("/login")
	public String login() {

		return "login";

	}

	@RequestMapping("/Home")

	public ModelAndView home(HttpServletRequest req) {

		hn = req.getSession();

		String msg = (String) hn.getAttribute("email");

		Session sss = sf.openSession();
		Criteria cr = sss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", msg));
		User_Info uinf = (User_Info) cr.uniqueResult();
		return new ModelAndView("menu", "dto", uinf);

	}

	@RequestMapping("/compose")
	public String composeMail() {
		if ((String) hn.getAttribute("email") != null) {
			return "compose";
		} else {
			return "login";
		}
	}

	@RequestMapping("/forget")
	public String forgetpassword() {
		return "forgetpassword";

	}

	@RequestMapping("/draftMail")
	public ModelAndView draft(HttpServletRequest req) {
		List<Mail_Info> mlist = ms.getdraft(req);

		return new ModelAndView("draft", "msg", mlist);

	}

	@RequestMapping("/sentMail")
	public ModelAndView sent(HttpServletRequest req) {
		if (hn.getAttribute("email") != null) {
			List<Mail_Info> mlist = ms.sentmail(req);

			return new ModelAndView("sent", "msg", mlist);
		} else {
			return new ModelAndView("login");
		}
	}

	@RequestMapping("/inboxMail")
	public ModelAndView inbox(HttpServletRequest req) {
		if (hn.getAttribute("email") != null) {
			List<Mail_Info> mlist = ms.getinbox(req);

			return new ModelAndView("inbox", "msg", mlist);

		} else {
			return new ModelAndView("login", "msg", "login first");

		}
	}

	@RequestMapping("/registration")
	public String registration() {
		return "registration";

	}

	@RequestMapping("/logoutmail")
	public ModelAndView logout() {
		if (hn.getAttribute("email") != null) {
			hn.setAttribute("email", null);

			return new ModelAndView("login", "msg", "Log Out Successfully");
		} else {
			return new ModelAndView("login", "msg", "Log in first");
		}
	}

	@RequestMapping(value = "/loginmail", method = RequestMethod.POST)
	public ModelAndView loginmail(@ModelAttribute User_Info ui, HttpServletRequest req) {

		User_Info uinf = ms.login(ui);
		if (uinf != null) {
			hn = req.getSession();
			hn.setAttribute("email", uinf.getEmail());
			System.out.println("login success");
			return new ModelAndView("menu", "dto", uinf);
		} else {
			return new ModelAndView("login", "msg", "Wrong Email_id & password");
		}
	}

	@RequestMapping(value = "/regmail", method = RequestMethod.POST)
	public ModelAndView regmail(@ModelAttribute User_Info ui) {

		System.out.println("inside controller");

		return new ModelAndView("registration", "msg", ms.register(ui));
	}

	@RequestMapping(value = "/composemail", method = RequestMethod.POST)
	public ModelAndView composemail(HttpServletRequest req) {
		hn = req.getSession(false);
		String em = (String) hn.getAttribute("email");
		System.out.println("inside controller");
		if (em != null) {
			boolean b = ms.compose(req);
			if (b) {
				return new ModelAndView("menu", "msg", "Mail has been sent");
			} else {
				return new ModelAndView("menu", "msg", "Mail saved as draft");
			}

		} else {
			return new ModelAndView("login", "msg", "Login First");
		}
	}

	@RequestMapping(value = "/forgetpassword", method = RequestMethod.POST)
	public ModelAndView forget(HttpServletRequest req) {

		System.out.println("inside controller");
		boolean b = ms.forgetpass(req);
		if (b) {
			return new ModelAndView("login", "msg", "Password Updated Successfully");
		} else {
			return new ModelAndView("login", "msg", "Password enter again");
		}
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {

		boolean b = ms.delete(id);
		if (b) {
			return new ModelAndView("menu", "msg", "Message Deleted Successfully");
		} else {
			return new ModelAndView("menu");
		}
	}

	@RequestMapping("/delete_sent")
	public ModelAndView delete_sent(@RequestParam int id) {

		boolean b = ms.delete_sent(id);
		if (b) {
			return new ModelAndView("menu", "msg", "Message Deleted Successfully");
		} else {
			return new ModelAndView("menu");
		}
	}

	@RequestMapping("/delete_draft")
	public ModelAndView delete_draft(@RequestParam int id) {

		boolean b = ms.delete_draft(id);
		if (b) {
			return new ModelAndView("menu", "msg", "Message Deleted Successfully");
		} else {
			return new ModelAndView("menu");
		}
	}

	@RequestMapping("/deletedinbox")
	public ModelAndView deletedmail() {
		String em = (String) hn.getAttribute("email");
		if (em != null) {

			List<Mail_Info> mlist = ms.deletedMail();
			return new ModelAndView("deletedinbox", "list", mlist);
		} else {
			return new ModelAndView("login", "msg", "Login First");
		}
	}

	@RequestMapping("/deletedsent")
	public ModelAndView deletedsent() {
		String em = (String) hn.getAttribute("email");
		if (em != null) {

			List<Mail_Info> mlist = ms.deletedsent();
			return new ModelAndView("deletedsent", "list", mlist);
		} else {
			return new ModelAndView("login", "msg", "Login First");
		}
	}

	@RequestMapping("/deleteddraft")
	public ModelAndView deleteddraft() {
		String em = (String) hn.getAttribute("email");
		if (em != null) {

			List<Mail_Info> mlist = ms.deleteddraft();
			return new ModelAndView("deleteddraft", "list", mlist);
		} else {
			return new ModelAndView("login", "msg", "Login First");
		}
	}

	@RequestMapping("/inboxfeth")
	public ModelAndView inboxfeth(@RequestParam int did) {
		String em = (String) hn.getAttribute("email");
		if (hn.getAttribute("email") != null) {
			Mail_Info min = ms.inboxfeth(did);
			if (min != null) {

				return new ModelAndView("inboxfeth", "mailobj", min);
			} else {
				return new ModelAndView("login", "msg", "Login First");
			}
		} else {
			return new ModelAndView();
		}
	}

	@RequestMapping("/sentfetch")
	public ModelAndView sentfetch(@RequestParam int did) {
		String em = (String) hn.getAttribute("email");
		if (hn.getAttribute("email") != null) {
			Mail_Info min = ms.sentfetch(did);
			if (min != null) {

				return new ModelAndView("sentfetch", "mailobj", min);
			} else {
				return new ModelAndView("login", "msg", "Login First");
			}
		} else {
			return new ModelAndView();
		}
	}

	@RequestMapping("/draftfetch")
	public ModelAndView draftfetch(@RequestParam int did) {
		hn.setAttribute("mid", did);
		if (hn.getAttribute("email") != null) {

			Mail_Info min = ms.draftfetch(did);
			System.out.println(min.getStatus());
			return new ModelAndView("composedraft", "mailobj", min);
		} else {
			return new ModelAndView("login", "msg", "Login First");
		}
	}

	@RequestMapping(value = "/mailcompose", method = RequestMethod.POST)
	public ModelAndView mailcompose(String to, String sub, String msg) {
		String mailby = (String) hn.getAttribute("email");
		System.out.println("inside controller");
		User_Info uin = ms.mailcompose(mailby, to, sub, msg);
		if (uin != null) {
			return new ModelAndView("menu", "msg", "Mail has been sent");
		} else {
			return new ModelAndView("menu", "msg", "Mail saved as draft");
		}
	}

	@RequestMapping("/forgetpass")
	public String forget() {
		return "forget";
	}

	@RequestMapping(value = "/ForgetPassword", method = RequestMethod.POST)
	public ModelAndView forgetpassword(@RequestParam String email, String scrqn, String scrans) {
		boolean b = ms.forgetpassword(email, scrqn, scrans);
		if (b) {
			hn.setAttribute("email", email);
			return new ModelAndView("forget2");
		} else {
			return new ModelAndView("forget", "forget", "Invalid Entry....");
		}
	}

	@RequestMapping(value = "/ForgetConfirm", method = RequestMethod.POST)
	public ModelAndView forgetpassword2(@RequestParam String password1, String password2) {
		boolean b = ms.forgetpassword2(password1, password2);
		if (b) {

			return new ModelAndView("login", "pass", "Password Change Successfully");
		} else {
			return new ModelAndView("forget2", "pass", "Invalid Entries.....");
		}
	}

}