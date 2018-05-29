package com.project.pojo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TReport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_report")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TReport implements java.io.Serializable {

	// Fields

	private String RId;
	private TUser TUser;
	private String RCode;
	private String RName;
	private String RImage;
	private String RRegion;
	private String RAddress;
	private String RDate;
	private String RType;
	private String RGrade;
	private String RInformant;
	private String RTel;
	private String RNum;
	private String RArea;
	private String RDesc;
	private String RStatus;
	private Set<TResubmit> TResubmits = new HashSet<TResubmit>(0);

	// Constructors

	/** default constructor */
	public TReport() {
	}

	/** full constructor */
	public TReport(TUser TUser, String RCode, String RName, String RImage,
			String RRegion, String RAddress, String RDate, String RType,
			String RGrade, String RInformant, String RTel, String RNum,
			String RArea, String RDesc, String RStatus,
			Set<TResubmit> TResubmits) {
		this.TUser = TUser;
		this.RCode = RCode;
		this.RName = RName;
		this.RImage = RImage;
		this.RRegion = RRegion;
		this.RAddress = RAddress;
		this.RDate = RDate;
		this.RType = RType;
		this.RGrade = RGrade;
		this.RInformant = RInformant;
		this.RTel = RTel;
		this.RNum = RNum;
		this.RArea = RArea;
		this.RDesc = RDesc;
		this.RStatus = RStatus;
		this.TResubmits = TResubmits;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "r_id", unique = true, nullable = false, length = 32)
	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(name = "r_code")
	public String getRCode() {
		return this.RCode;
	}

	public void setRCode(String RCode) {
		this.RCode = RCode;
	}

	@Column(name = "r_name", length = 24)
	public String getRName() {
		return this.RName;
	}

	public void setRName(String RName) {
		this.RName = RName;
	}

	@Column(name = "r_image")
	public String getRImage() {
		return this.RImage;
	}

	public void setRImage(String RImage) {
		this.RImage = RImage;
	}

	@Column(name = "r_region")
	public String getRRegion() {
		return this.RRegion;
	}

	public void setRRegion(String RRegion) {
		this.RRegion = RRegion;
	}

	@Column(name = "r_address", length = 100)
	public String getRAddress() {
		return this.RAddress;
	}

	public void setRAddress(String RAddress) {
		this.RAddress = RAddress;
	}

	@Column(columnDefinition="DATETIME",name = "r_date")
	public String getRDate() {
		return this.RDate;
	}

	public void setRDate(String RDate) {
		this.RDate = RDate;
	}

	@Column(name = "r_type")
	public String getRType() {
		return this.RType;
	}

	public void setRType(String RType) {
		this.RType = RType;
	}

	@Column(name = "r_grade")
	public String getRGrade() {
		return this.RGrade;
	}

	public void setRGrade(String RGrade) {
		this.RGrade = RGrade;
	}

	@Column(name = "r_informant", length = 24)
	public String getRInformant() {
		return this.RInformant;
	}

	public void setRInformant(String RInformant) {
		this.RInformant = RInformant;
	}

	@Column(name = "r_tel", length = 24)
	public String getRTel() {
		return this.RTel;
	}

	public void setRTel(String RTel) {
		this.RTel = RTel;
	}

	@Column(name = "r_num", length = 24)
	public String getRNum() {
		return this.RNum;
	}

	public void setRNum(String RNum) {
		this.RNum = RNum;
	}

	@Column(name = "r_area", length = 24)
	public String getRArea() {
		return this.RArea;
	}

	public void setRArea(String RArea) {
		this.RArea = RArea;
	}

	@Column(name = "r_desc")
	public String getRDesc() {
		return this.RDesc;
	}

	public void setRDesc(String RDesc) {
		this.RDesc = RDesc;
	}

	@Column(name = "r_status")
	public String getRStatus() {
		return this.RStatus;
	}

	public void setRStatus(String RStatus) {
		this.RStatus = RStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TReport")
	public Set<TResubmit> getTResubmits() {
		return this.TResubmits;
	}

	public void setTResubmits(Set<TResubmit> TResubmits) {
		this.TResubmits = TResubmits;
	}

	
	
	
	
	

}