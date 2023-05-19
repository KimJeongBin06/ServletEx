//com.vo 패키지
//데이터베이스의 값을 관리하는 패키지(DTO, VO)
//테이블 이름으로 클래스 이름을 지정
package com.vo;

import java.sql.Date;


public class member {
	//테이블에 있는 필드명과 동일하게 선언
	//사용안하는 필드로 가능하면 모두 선언
	//1. 변수를 선언
	//2. getter, setter를 선언, toString을 선언
	int mno;
	String mail;
	String pwd;
	String mname;
	Date cre_date;
	Date mod_date;
	//변수를 메소드를 이용해서 접근하기 위해서
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	public Date getMod_date() {
		return mod_date;
	}
	public void setMod_date(Date mod_date) {
		this.mod_date = mod_date;
	}
	@Override
	public String toString() {
		return "member [mno=" + mno + ", mail=" + mail + ", pwd=" + pwd + ", mname=" + mname + ", cre_date=" + cre_date
				+ ", mod_date=" + mod_date + "]";
	}
	
	
}
