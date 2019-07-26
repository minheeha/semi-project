package com.kh.hp.admin.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class UpdateUserVO implements Serializable {
	
	private int userSeq;
	private String userEmail;
	private String userNm;
	private String userNick;
	private String userPhone;
	private int userGradeCd;
	private Date enrollDt;
	private int snsCd;
	private char leaveTf;
	private Date leaveDt;

	
	public UpdateUserVO () {}


	public UpdateUserVO(int userSeq, String userEmail, String userNm, String userNick, String userPhone,
			int userGradeCd, Date enrollDt, int snsCd, char leaveTf, Date leaveDt) {
		super();
		this.userSeq = userSeq;
		this.userEmail = userEmail;
		this.userNm = userNm;
		this.userNick = userNick;
		this.userPhone = userPhone;
		this.userGradeCd = userGradeCd;
		this.enrollDt = enrollDt;
		this.snsCd = snsCd;
		this.leaveTf = leaveTf;
		this.leaveDt = leaveDt;
	}


	public int getUserSeq() {
		return userSeq;
	}


	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getUserNm() {
		return userNm;
	}


	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public int getUserGradeCd() {
		return userGradeCd;
	}


	public void setUserGradeCd(int userGradeCd) {
		this.userGradeCd = userGradeCd;
	}


	public Date getEnrollDt() {
		return enrollDt;
	}


	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}


	public int getSnsCd() {
		return snsCd;
	}


	public void setSnsCd(int snsCd) {
		this.snsCd = snsCd;
	}


	public char getLeaveTf() {
		return leaveTf;
	}


	public void setLeaveTf(char leaveTf) {
		this.leaveTf = leaveTf;
	}


	public Date getLeaveDt() {
		return leaveDt;
	}


	public void setLeaveDt(Date leaveDt) {
		this.leaveDt = leaveDt;
	}


	@Override
	public String toString() {
		return "UpdateUserVO [userSeq=" + userSeq + ", userEmail=" + userEmail + ", userNm=" + userNm + ", userNick="
				+ userNick + ", userPhone=" + userPhone + ", userGradeCd=" + userGradeCd + ", enrollDt=" + enrollDt
				+ ", snsCd=" + snsCd + ", leaveTf=" + leaveTf + ", leaveDt=" + leaveDt + "]";
	}
	
	
	
	

}
