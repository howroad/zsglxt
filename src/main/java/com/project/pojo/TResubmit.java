package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TResubmit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_resubmit")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TResubmit implements java.io.Serializable {

	// Fields

	private String rsId;
	private TReport TReport;
	private TUser TUser;
	private String rsDate;
	private String rsDesc;
	private String rsAddress;
	private String rsNum;
	private String rsArea;
	private String rsType;

	// Constructors

	/** default constructor */
	public TResubmit() {
	}

	/** full constructor */
	public TResubmit(TReport TReport, TUser TUser, String rsDate,
			String rsDesc, String rsAddress, String rsNum, String rsArea,
			String rsType) {
		this.TReport = TReport;
		this.TUser = TUser;
		this.rsDate = rsDate;
		this.rsDesc = rsDesc;
		this.rsAddress = rsAddress;
		this.rsNum = rsNum;
		this.rsArea = rsArea;
		this.rsType = rsType;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rs_id", unique = true, nullable = false, length = 32)
	public String getRsId() {
		return this.rsId;
	}

	public void setRsId(String rsId) {
		this.rsId = rsId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "r_id")
	@JsonIgnore
	public TReport getTReport() {
		return this.TReport;
	}

	public void setTReport(TReport TReport) {
		this.TReport = TReport;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(columnDefinition="DATETIME",name = "rs_date")
	public String getRsDate() {
		return this.rsDate;
	}

	public void setRsDate(String rsDate) {
		this.rsDate = rsDate;
	}

	@Column(name = "rs_desc")
	public String getRsDesc() {
		return this.rsDesc;
	}

	public void setRsDesc(String rsDesc) {
		this.rsDesc = rsDesc;
	}

	@Column(name = "rs_address")
	public String getRsAddress() {
		return this.rsAddress;
	}

	public void setRsAddress(String rsAddress) {
		this.rsAddress = rsAddress;
	}

	@Column(name = "rs_num", length = 40)
	public String getRsNum() {
		return this.rsNum;
	}

	public void setRsNum(String rsNum) {
		this.rsNum = rsNum;
	}

	@Column(name = "rs_area", length = 40)
	public String getRsArea() {
		return this.rsArea;
	}

	public void setRsArea(String rsArea) {
		this.rsArea = rsArea;
	}

	@Column(name = "rs_type")
	public String getRsType() {
		return this.rsType;
	}

	public void setRsType(String rsType) {
		this.rsType = rsType;
	}

}