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
 * TRole entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_role")
public class TRole implements java.io.Serializable {

	// Fields

	private String roleId;
	private String roleName;
	private String roleDesc;
	private Set<TUserRole> TUserRoles = new HashSet<TUserRole>(0);
	private Set<TRolePower> TRolePowers = new HashSet<TRolePower>(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** full constructor */
	public TRole(String roleName, String roleDesc, Set<TUserRole> TUserRoles,
			Set<TRolePower> TRolePowers) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
		this.TUserRoles = TUserRoles;
		this.TRolePowers = TRolePowers;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "role_id", unique = true, nullable = false, length = 32)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", length = 32)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_desc", length = 100)
	public String getRoleDesc() {
		return this.roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TUserRole> getTUserRoles() {
		return this.TUserRoles;
	}

	public void setTUserRoles(Set<TUserRole> TUserRoles) {
		this.TUserRoles = TUserRoles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRole")
	public Set<TRolePower> getTRolePowers() {
		return this.TRolePowers;
	}

	public void setTRolePowers(Set<TRolePower> TRolePowers) {
		this.TRolePowers = TRolePowers;
	}

}