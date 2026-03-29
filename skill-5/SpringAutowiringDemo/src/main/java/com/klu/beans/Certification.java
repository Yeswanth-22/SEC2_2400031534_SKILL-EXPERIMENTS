package com.klu.beans;


public class Certification {
	private long cid;
	private String cname;
	private String doc;
	
	public Certification(long cid, String cname, String doc) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.doc = doc;
	}
	public void display() {
		System.out.println("certificationId:"+cid);
		System.out.println("CertificateName:"+cname);
		System.out.println("DateofCompletion:"+doc);
	}
}
