package com.mail.simulation.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mail.simulation.model.Mail_Info;
import com.mail.simulation.model.User_Info;

@Component
public class MyDAOimp1 implements MyDAO {
	@Autowired
	SessionFactory sf;
	
	HttpSession hn;

	@Override
	public String register(User_Info ui) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", ui.getEmail()));
		User_Info uif = (User_Info) cr.uniqueResult();
		if (uif != null) {

			return "User Already Exist!";
		} else {
			ss.save(ui);
			ss.beginTransaction().commit();
			ss.close();
			return "Register Successfully";

		}
	}

	@Override
	public User_Info login(User_Info ui) {

		Session ss = sf.openSession();

		Criteria cr = ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", ui.getEmail()));
		cr.add(Restrictions.eq("password", ui.getPassword()));
		User_Info uui = (User_Info) cr.uniqueResult();

		ss.close();

		return uui;
	}

	@Override
	public boolean compose(HttpServletRequest req) {
		Session ss = sf.openSession();
		String to = req.getParameter("to");
		String sub = req.getParameter("Subject");
		String msg = req.getParameter("msg");
		this.hn = req.getSession();
		String mailby = (String) hn.getAttribute("email");
		Mail_Info min = null;
		Criteria cr = ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", to));
		User_Info uinf = (User_Info) cr.uniqueResult();

		if (uinf != null) {
			min = new Mail_Info();
			min.setInbox(msg);
			min.setSubject(sub);
			min.setSent(to);
			min.setMailFrom(mailby);
			min.setStatus("success");
			Criteria cr1 = ss.createCriteria(User_Info.class);
			cr1.add(Restrictions.eq("email", mailby));
			User_Info uin = (User_Info) cr1.uniqueResult();
			List<Mail_Info> mlist1 = uin.getMlist();
			mlist1.add(min);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			min = new Mail_Info();
			min.setDraft(to);
			min.setSubject(sub);
			min.setMailFrom(mailby);
			min.setDraft_message(msg);
			min.setStatus("failed");
			Criteria cr1 = ss.createCriteria(User_Info.class);
			cr1.add(Restrictions.eq("email", mailby));
			User_Info uin = (User_Info) cr1.uniqueResult();
			List<Mail_Info> mlist = uin.getMlist();
			mlist.add(min);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();
			ss.close();

			return false;
		}

		

	}

	@Override
	public List<Mail_Info> getdraft(HttpServletRequest req) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		hn=req.getSession(false);
		String mailby = (String) hn.getAttribute("email");
		cr.add(Restrictions.eq("mailFrom", mailby));
		System.out.println("my em" + mailby);
		cr.add(Restrictions.isNull("sent"));
		cr.add(Restrictions.isNotNull("draft"));
		cr.add(Restrictions.isNotNull("draft_message"));
		List<Mail_Info> mlist = cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public List<Mail_Info> sentmail(HttpServletRequest req) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		hn=req.getSession(false);
		String mailby = (String) hn.getAttribute("email");
		cr.add(Restrictions.eq("mailFrom", mailby));
		cr.add(Restrictions.isNull("draft"));
		cr.add(Restrictions.ne("status", "deleteSent"));
		List<Mail_Info> mlist = cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public List<Mail_Info> getinbox(HttpServletRequest req) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		hn=req.getSession(false);
		String mailby = (String) hn.getAttribute("email");
		cr.add(Restrictions.eq("sent", mailby));
		cr.add(Restrictions.isNull("draft"));
		cr.add(Restrictions.ne("status", "deleteInbox"));

		List<Mail_Info> mlist = cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public boolean forgetpass(HttpServletRequest req) {

		Session ss = sf.openSession();
		String old = req.getParameter("old_email");
		String ew = req.getParameter("new_email");
		this.hn = req.getSession();
		Criteria cr = ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", old));
		User_Info uinf = (User_Info) cr.uniqueResult();

		if (uinf != null) {
			uinf.setPassword(ew);
			ss.saveOrUpdate(uinf);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {

			return false;
		}

	}

	@Override
	public boolean delete(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info min = (Mail_Info) cr.uniqueResult();
		Criteria cr1 = ss.createCriteria(User_Info.class);
		String mailby = (String) hn.getAttribute("email");
		cr1.add(Restrictions.eq("email", mailby));
		User_Info uin = (User_Info) cr1.uniqueResult();

		if (min != null) {
			
			
			min.setStatus("deleteInbox");
		
			List<Mail_Info> mlist = uin.getMlist();
			mlist.add(min);
			ss.saveOrUpdate(min);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete_sent(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info min = (Mail_Info) cr.uniqueResult();
		Criteria cr1 = ss.createCriteria(User_Info.class);
		String mailby = (String) hn.getAttribute("email");
		cr1.add(Restrictions.eq("email", mailby));
		User_Info uin = (User_Info) cr1.uniqueResult();

		if (min != null) {
			min.setStatus("deleteSent");
			List<Mail_Info> mlist = uin.getMlist();
			mlist.add(min);
			ss.update(uin);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Mail_Info> deletedMail() {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		String mailby = (String) hn.getAttribute("email");
		System.out.println(mailby);
		cr.add(Restrictions.eq("sent", mailby));
		cr.add(Restrictions.eq("status", "deleteInbox"));
		cr.add(Restrictions.isNull("inbox"));
		cr.add(Restrictions.isNotNull("deleteinbx"));
		List<Mail_Info> mlist = cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public List<Mail_Info> deletedsent() {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		String mailby = (String) hn.getAttribute("email");
		System.out.println(mailby);
		cr.add(Restrictions.eq("mailFrom", mailby));
		cr.add(Restrictions.eq("status", "deleteSent"));
		cr.add(Restrictions.isNull("inbox"));
		cr.add(Restrictions.isNotNull("deleteinbx"));
		List<Mail_Info> mlist = cr.list();
		ss.close();
		return mlist;
	}

	@Override
	public List<Mail_Info> deleteddraft() {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		String mailby = (String) hn.getAttribute("email");
		System.out.println(mailby);
		cr.add(Restrictions.eq("mailFrom", mailby));
		cr.add(Restrictions.eq("status", "deletedraft"));
		cr.add(Restrictions.isNull("draft_message"));
		cr.add(Restrictions.isNotNull("deleteinbx"));
		List<Mail_Info> mlist = cr.list();
		ss.close();
		return mlist;

	}

	@Override
	public boolean delete_draft(int id) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", id));
		Mail_Info min = (Mail_Info) cr.uniqueResult();
		Criteria cr1 = ss.createCriteria(User_Info.class);
		String mailby = (String) hn.getAttribute("email");
		cr1.add(Restrictions.eq("email", mailby));
		User_Info uin = (User_Info) cr1.uniqueResult();

		if (min != null) {
			min.setStatus("deletedraft");
			List<Mail_Info> mlist = uin.getMlist();
			mlist.add(min);
			ss.update(uin);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public Mail_Info inboxfeth(int did) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", did));
		String mailby=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("mailFrom", mailby));
		cr.add(Restrictions.isNull("inbox"));
		cr.add(Restrictions.isNotNull("deleteinbx"));
		cr.add(Restrictions.isNotNull("mailFrom"));
		Mail_Info min1 = (Mail_Info) cr.uniqueResult();
		ss.close();

		return min1;

	}

	@Override
	public Mail_Info sentfetch(int did) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", did));
		cr.add(Restrictions.isNull("draft"));
		cr.add(Restrictions.isNull("draft_message"));
		cr.add(Restrictions.isNotNull("sent"));
		Mail_Info min1 = (Mail_Info) cr.uniqueResult();
		ss.close();

		return min1;
	}

	@Override
	public Mail_Info draftfetch(int did) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(Mail_Info.class);
		cr.add(Restrictions.eq("mid", did));
		Mail_Info min1 = (Mail_Info) cr.uniqueResult();
		System.out.println(min1.getDraft());
		ss.close();
		return min1;
	}

	@Override
	public User_Info mailcompose(String mailby, String to, String sub, String msg) {
		Session ss = sf.openSession();
		Criteria cr = ss.createCriteria(User_Info.class);
		cr.add(Restrictions.eq("email", to));
		User_Info uinf = (User_Info) cr.uniqueResult();
		List<Mail_Info> mlist;
		if (uinf != null) {
			int mid = (int) hn.getAttribute("mid");
			cr = ss.createCriteria(Mail_Info.class);
			cr.add(Restrictions.eq("mid", mid));
			Mail_Info min = (Mail_Info) cr.uniqueResult();
			min.setMailFrom(mailby);
			min.setSent(to);
			min.setInbox(msg);
			min.setSubject(sub);

			mlist = uinf.getMlist();
			mlist.add(min);
			uinf.setMlist(mlist);
			ss.update(uinf);
			ss.beginTransaction().commit();
			ss.close();
			return uinf;
		} else {
			int mid = (int) hn.getAttribute("mid");
			cr = ss.createCriteria(Mail_Info.class);
			cr.add(Restrictions.eq("mid", mid));
			Mail_Info min = (Mail_Info) cr.uniqueResult();
			min.setMailFrom(mailby);
			min.setSent(to);
			min.setInbox(msg);
			min.setSubject(sub);

			mlist = uinf.getMlist();
			mlist.add(min);
			uinf.setMlist(mlist);
			ss.update(uinf);
			ss.beginTransaction().commit();
			ss.close();
			return null;
		}

	}

	@Override
	public boolean forgetpassword2(String password1, String password2) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_Info.class);
		String email=(String) hn.getAttribute("email");
		cr.add(Restrictions.eq("email", email));
		User_Info uin =(User_Info) cr.uniqueResult();
		if(uin!=null) {
			if(password1.equals(password2));
			uin.setPassword(password2);
			ss.saveOrUpdate(uin);
			ss.beginTransaction().commit();
			ss.close();
			return true;
		}else {
			ss.close();
		return false;
		}
	}

	@Override
	public boolean forgetpassword(String email, String scrqn, String scrans) {
		Session ss=sf.openSession();
		Criteria cr=ss.createCriteria(User_Info.class);
		
		cr.add(Restrictions.eq("email", email));
		cr.add(Restrictions.eq("scrqn", scrqn));
		cr.add(Restrictions.eq("scrans", scrans));
		User_Info uin =(User_Info) cr.uniqueResult();
		if(uin!=null) {
			
			ss.close();
			return true;
		}else {
		ss.close();
		return false;
		}
		
	}


}
