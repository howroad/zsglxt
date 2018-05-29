package com.project.vo;

public class ResubmitVO {

	private String RCode;
	private String userName;
	private String userTel;
	private String rsGrade;
	private String rsDate;
	private String rsDesc;
	private String rsNum;
	private String rsArea;

	public ResubmitVO() {
	}

	public ResubmitVO(String rCode, String userName, String userTel, String rsGrade, String rsDate, String rsDesc,
			String rsNum, String rsArea) {
		super();
		RCode = rCode;
		this.userName = userName;
		this.userTel = userTel;
		this.rsGrade = rsGrade;
		this.rsDate = rsDate;
		this.rsDesc = rsDesc;
		this.rsNum = rsNum;
		this.rsArea = rsArea;
	}

	public String getRCode() {
		return RCode;
	}

	public void setRCode(String rCode) {
		RCode = rCode;
	}

	public String getRsGrade() {
		return rsGrade;
	}

	public void setRsGrade(String rsGrade) {
		this.rsGrade = rsGrade;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getRsDate() {
		return rsDate;
	}

	public void setRsDate(String rsDate) {
		this.rsDate = rsDate;
	}

	public String getRsDesc() {
		return rsDesc;
	}

	public void setRsDesc(String rsDesc) {
		this.rsDesc = rsDesc;
	}

	public String getRsNum() {
		return rsNum;
	}

	public void setRsNum(String rsNum) {
		this.rsNum = rsNum;
	}

	public String getRsArea() {
		return rsArea;
	}

	public void setRsArea(String rsArea) {
		this.rsArea = rsArea;
	}

}
