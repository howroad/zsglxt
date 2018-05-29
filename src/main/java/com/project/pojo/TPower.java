package com.project.pojo;

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
import org.hibernate.annotations.GenericGenerator;

/**
 * TPower entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_power")
public class TPower implements java.io.Serializable {

	// Fields

	private String powerId;
	private String powerName;
	private String powerDesc;
	private Set<TRolePower> TRolePowers = new HashSet<TRolePower>(0);

	// Constructors

	/** default constructor */
	public TPower() {
	}

	/** full constructor */
	public TPower(String powerName, String powerDesc,
			Set<TRolePower> TRolePowers) {
		this.powerName = powerName;
		this.powerDesc = powerDesc;
		this.TRolePowers = TRolePowers;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "power_id", unique = true, nullable = false, length = 32)
	public String getPowerId() {
		return this.powerId;
	}

	public void setPowerId(String powerId) {
		this.powerId = powerId;
	}

	@Column(name = "power_name", length = 100)
	public String getPowerName() {
		return this.powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	@Column(name = "power_desc", length = 100)
	public String getPowerDesc() {
		return this.powerDesc;
	}

	public void setPowerDesc(String powerDesc) {
		this.powerDesc = powerDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TPower")
	public Set<TRolePower> getTRolePowers() {
		return this.TRolePowers;
	}

	public void setTRolePowers(Set<TRolePower> TRolePowers) {
		this.TRolePowers = TRolePowers;
	}

}