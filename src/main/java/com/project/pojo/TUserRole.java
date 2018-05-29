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

/**
 * TUserRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user_role")
public class TUserRole implements java.io.Serializable {

	// Fields

	private String urId;
	private TUser TUser;
	private TRole TRole;

	// Constructors

	/** default constructor */
	public TUserRole() {
	}

	/** full constructor */
	public TUserRole(TUser TUser, TRole TRole) {
		this.TUser = TUser;
		this.TRole = TRole;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ur_id", unique = true, nullable = false, length = 32)
	public String getUrId() {
		return this.urId;
	}

	public void setUrId(String urId) {
		this.urId = urId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

}