package com.mail.simulation.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mail_Info implements Serializable {
@Id
@GenericGenerator(name = "auto",strategy = "increment")
@GeneratedValue(generator = "auto")
private int mid;
private String inbox;
private String sent;
private String subject;
private String draft;
private String mailFrom;
private String status;



public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
public String getInbox() {
	return inbox;
}
public void setInbox(String inbox) {
	this.inbox = inbox;
}
public String getSent() {
	return sent;
}
public void setSent(String sent) {
	this.sent = sent;
}
public String getDraft() {
	return draft;
}
public void setDraft(String draft) {
	this.draft = draft;
}
public String getMailFrom() {
	return mailFrom;
}
public void setMailFrom(String mailFrom) {
	this.mailFrom = mailFrom;
}
public String getDraft_message() {
	return draft_message;
}
public void setDraft_message(String draft_message) {
	this.draft_message = draft_message;
}
private String draft_message;



}
