package com.project.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String userPassword;
	private String userRname;
	private String userGender;
	private Date userBirth;
	private String userTel;
	private String userAddress;
	private String userEmail;
	private String userDate;
	private Integer userStatus;
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);
	private Set<TRota> TRotas = new HashSet<TRota>(0);
	private Set<TShift> TShifts = new HashSet<TShift>(0);
	private Set<TResubmit> TResubmits = new HashSet<TResubmit>(0);
	private Set<TReport> TReports = new HashSet<TReport>(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(String userName, String userPassword, String userRname,
			String userGender, Date userBirth, String userTel,
			String userAddress, String userEmail, String userDate,
			Integer userStatus, Set<TUserRole> TUserRoles, Set<TRota> TRotas,
			Set<TShift> TShifts, Set<TResubmit> TResubmits,
			Set<TReport> TReports) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRname = userRname;
		this.userGender = userGender;
		this.userBirth = userBirth;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userDate = userDate;
		this.userStatus = userStatus;
		this.TUserRoles = TUserRoles;
		this.TRotas = TRotas;
		this.TShifts = TShifts;
		this.TResubmits = TResubmits;
		this.TReports = TReports;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", length = 32)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", length = 32)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_rname", length = 32)
	public String getUserRname() {
		return this.userRname;
	}

	public void setUserRname(String userRname) {
		this.userRname = userRname;
	}

	@Column(name = "user_gender", length = 10)
	public String getUserGender() {
		return this.userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "user_birth", length = 10)
	public Date getUserBirth() {
		return this.userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	@Column(name = "user_tel", length = 15)
	public String getUserTel() {
		return this.userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	@Column(name = "user_address", length = 100)
	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "user_email", length = 50)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(columnDefinition="DATE",name = "user_date")
	public String getUserDate() {
		return this.userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	@Column(name = "user_status")
	public Integer getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	@JsonIgnore
	public Set<TUserRole> getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	@JsonIgnore
	public Set<TRota> getTRotas() {
		return this.TRotas;
	}

	public void setTRotas(Set<TRota> TRotas) {
		this.TRotas = TRotas;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	@JsonIgnore
	public Set<TShift> getTShifts() {
		return this.TShifts;
	}

	public void setTShifts(Set<TShift> TShifts) {
		this.TShifts = TShifts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	@JsonIgnore
	public Set<TResubmit> getTResubmits() {
		return this.TResubmits;
	}

	public void setTResubmits(Set<TResubmit> TResubmits) {
		this.TResubmits = TResubmits;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TUser")
	@JsonIgnore
	public Set<TReport> getTReports() {
		return this.TReports;
	}

	public void setTReports(Set<TReport> TReports) {
		this.TReports = TReports;
	}

}