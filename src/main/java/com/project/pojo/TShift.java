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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TShift entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_shift")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TShift implements java.io.Serializable {

	// Fields

	private String SId;
	private TUser TUser;
	private String SStarttime;
	private String SEndtime;

	// Constructors

	/** default constructor */
	public TShift() {
	}

	/** full constructor */
	public TShift(TUser TUser, String SStarttime, String SEndtime) {
		this.TUser = TUser;
		this.SStarttime = SStarttime;
		this.SEndtime = SEndtime;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "s_id", unique = true, nullable = false, length = 32)
	public String getSId() {
		return this.SId;
	}

	public void setSId(String SId) {
		this.SId = SId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(columnDefinition="DATETIME",name = "s_starttime")
	public String getSStarttime() {
		return this.SStarttime;
	}

	public void setSStarttime(String SStarttime) {
		this.SStarttime = SStarttime;
	}

	@Column(columnDefinition="DATETIME",name = "s_endtime")
	public String getSEndtime() {
		return this.SEndtime;
	}

	public void setSEndtime(String SEndtime) {
		this.SEndtime = SEndtime;
	}

}