package com.project.vo;

public class ReportVO {

	private String RCode;
	private String userName;
	private String userTel;
	private String RName;
	private String RImage;
	private String RRegion;
	private String RAddress;
	private String RDate;
	private String RType;
	private String RGrade;
	private String RNum;
	private String RArea;
	private String RDesc;

	public ReportVO() {
	}

	public ReportVO(String rCode, String userName, String userTel, String rName, String rImage, String rRegion,
			String rAddress, String rDate, String rType, String rGrade, String rNum, String rArea, String rDesc) {
		super();
		RCode = rCode;
		this.userName = userName;
		this.userTel = userTel;
		RName = rName;
		RImage = rImage;
		RRegion = rRegion;
		RAddress = rAddress;
		RDate = rDate;
		RType = rType;
		RGrade = rGrade;
		RNum = rNum;
		RArea = rArea;
		RDesc = rDesc;
	}

	public String getRCode() {
		return RCode;
	}

	public void setRCode(String rCode) {
		RCode = rCode;
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

	public String getRName() {
		return RName;
	}

	public void setRName(String rName) {
		RName = rName;
	}

	public String getRImage() {
		return RImage;
	}

	public void setRImage(String rImage) {
		RImage = rImage;
	}

	public String getRRegion() {
		return RRegion;
	}

	public void setRRegion(String rRegion) {
		RRegion = rRegion;
	}

	public String getRAddress() {
		return RAddress;
	}

	public void setRAddress(String rAddress) {
		RAddress = rAddress;
	}

	public String getRDate() {
		return RDate;
	}

	public void setRDate(String rDate) {
		RDate = rDate;
	}

	public String getRType() {
		return RType;
	}

	public void setRType(String rType) {
		RType = rType;
	}

	public String getRGrade() {
		return RGrade;
	}

	public void setRGrade(String rGrade) {
		RGrade = rGrade;
	}

	public String getRNum() {
		return RNum;
	}

	public void setRNum(String rNum) {
		RNum = rNum;
	}

	public String getRArea() {
		return RArea;
	}

	public void setRArea(String rArea) {
		RArea = rArea;
	}

	public String getRDesc() {
		return RDesc;
	}

	public void setRDesc(String rDesc) {
		RDesc = rDesc;
	}

}
