package com.project.pojo;

import java.sql.Timestamp;
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
 * TRota entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_rota")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"}) 
public class TRota implements java.io.Serializable {

	// Fields

	private String rotaId;
	private TUser TUser;
	private String rotaEvent;
	private String rotaDate;
	private String rotaDesc;

	// Constructors

	/** default constructor */
	public TRota() {
	}

	/** full constructor */
	public TRota(TUser TUser, String rotaEvent, String rotaDate,
			String rotaDesc) {
		this.TUser = TUser;
		this.rotaEvent = rotaEvent;
		this.rotaDate = rotaDate;
		this.rotaDesc = rotaDesc;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "rota_id", unique = true, nullable = false, length = 32)
	public String getRotaId() {
		return this.rotaId;
	}

	public void setRotaId(String rotaId) {
		this.rotaId = rotaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	@Column(name = "rota_event")
	public String getRotaEvent() {
		return this.rotaEvent;
	}

	public void setRotaEvent(String rotaEvent) {
		this.rotaEvent = rotaEvent;
	}

	@Column(columnDefinition="DATETIME",name = "rota_date")
	public String getRotaDate() {
		return this.rotaDate;
	}

	public void setRotaDate(String rotaDate) {
		this.rotaDate = rotaDate;
	}

	@Column(name = "rota_desc")
	public String getRotaDesc() {
		return this.rotaDesc;
	}

	public void setRotaDesc(String rotaDesc) {
		this.rotaDesc = rotaDesc;
	}

}