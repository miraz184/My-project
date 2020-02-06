package com.mail.simulation.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mail.simulation.model.User_Info;
import com.mail.simulation.model.Mail_Info;

public interface MyDAO {
	
	public String register(User_Info ui);
	public User_Info login(User_Info ui);
	public boolean compose(HttpServletRequest req);
	public User_Info mailcompose(String mailby,String to,String sub,String msg);
	List<Mail_Info> getdraft(HttpServletRequest req);
	List<Mail_Info> sentmail(HttpServletRequest req);
	List<Mail_Info> getinbox(HttpServletRequest req);
	public boolean forgetpass(HttpServletRequest req);
	public boolean delete(int id);
	public boolean delete_sent(int id);
	public boolean delete_draft(int id);
	List<Mail_Info> deletedMail();
	List<Mail_Info> deletedsent();
	List<Mail_Info> deleteddraft();
	public Mail_Info  inboxfeth(int did);
	public Mail_Info  sentfetch(int did);
	public Mail_Info  draftfetch(int did);
	public boolean forgetpassword2(String password1, String password2);
	public boolean forgetpassword(String email, String scrqn, String scrans);
	 
}
