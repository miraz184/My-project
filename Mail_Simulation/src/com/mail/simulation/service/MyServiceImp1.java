package com.mail.simulation.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.mail.simulation.dao.MyDAO;
import com.mail.simulation.model.Mail_Info;
import com.mail.simulation.model.User_Info;
@Component
public class MyServiceImp1 implements MyService {
	@Autowired
	MyDAO md;
	
	@Override
	public String register (User_Info ui) {

		System.out.println("inside service");
		return md.register(ui);
	}
	@Override
	public User_Info login(User_Info ui) {
		System.out.println("inside service");
		User_Info b=md.login(ui);
	return b;
	}
//	@Override
//	public List<Mail_Info> getinbox() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	@Override
	public boolean compose(HttpServletRequest req) {
		
		return md.compose(req);
	}
	@Override
	public List<Mail_Info> getdraft(HttpServletRequest req) {
		List<Mail_Info> mlist=md.getdraft(req);
		return mlist;
	}
	@Override
	public List<Mail_Info> sentmail(HttpServletRequest req) {
		List<Mail_Info> mlist=md.sentmail(req);
		return mlist;
	}
	@Override
	public List<Mail_Info> getinbox(HttpServletRequest req) {
		List<Mail_Info> mlist=md.getinbox(req);
		return mlist;
	}
	@Override
	public boolean forgetpass(HttpServletRequest req) {
		
		return md.forgetpass(req);
	}
	@Override
	public boolean delete(int id) {
		boolean b=md.delete(id);
		return b;
	}
	
	
	@Override
	public List<Mail_Info> deletedMail() {
		List<Mail_Info> list=md.deletedMail();
		return list;
	}
	@Override
	public List<Mail_Info> deletedsent() {
		List<Mail_Info> list=md.deletedsent();
		return list;
	}
	@Override
	public List<Mail_Info> deleteddraft() {
		List<Mail_Info> list=md.deleteddraft();
		return list;
	}
	@Override
	public boolean delete_sent(int id) {
		boolean b=md.delete_sent(id);
		return b;
	}
	@Override
	public boolean delete_draft(int id) {
		boolean b=md.delete_draft(id);
		return b;
	}
	@Override
	public Mail_Info inboxfeth(int did) {
		Mail_Info min1=md.inboxfeth(did);
		return min1;
	}
	@Override
	public Mail_Info sentfetch(int did) {
Mail_Info min1=md.sentfetch(did);
		return min1;
	}
	/*
	 * @Override public List<Mail_Info> draftfetch(int did) { List<Mail_Info>
	 * list=md.draftfetch(did); return list; }
	 */
	@Override
	public Mail_Info draftfetch(int did) {
		Mail_Info min1=md.draftfetch(did);
		return min1;
	}
	@Override
	public User_Info mailcompose(String mailby, String to, String sub, String msg) {
		User_Info uinf=md.mailcompose(mailby, to, sub, msg);
		return uinf;
	}
	@Override
	public boolean forgetpassword2(String password1, String password2) {
		
		return md.forgetpassword2(password1, password2);
	}
	@Override
	public boolean forgetpassword(String email, String scrqn, String scrans) {
		
		return md.forgetpassword(email, scrqn, scrans);
	}
	
}
