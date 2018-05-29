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
 * TRolePower entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_role_power")
public class TRolePower implements java.io.Serializable {

	// Fields

	private String rpId;
	private TRole TRole;
	private TPower TPower;

	// Constructors

	/** default constructor */
	public TRolePower() {
	}

	/** full constructor */
	public TRolePower(TRole TRole, TPower TPower) {
		this.TRole = TRole;
		this.TPower = TPower;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rp_id", unique = true, nullable = false, length = 32)
	public String getRpId() {
		return this.rpId;
	}

	public void setRpId(String rpId) {
		this.rpId = rpId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "power_id")
	public TPower getTPower() {
		return this.TPower;
	}

	public void setTPower(TPower TPower) {
		this.TPower = TPower;
	}

}