package com.project.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_data")
public class TData implements java.io.Serializable {

	// Fields

	private Integer dataId;
	private String dataType;
	private String dataKey;
	private String dataValue;
	private String dataDesc;

	// Constructors

	/** default constructor */
	public TData() {
	}

	/** minimal constructor */
	public TData(Integer dataId) {
		this.dataId = dataId;
	}

	/** full constructor */
	public TData(Integer dataId, String dataType, String dataKey,
			String dataValue, String dataDesc) {
		this.dataId = dataId;
		this.dataType = dataType;
		this.dataKey = dataKey;
		this.dataValue = dataValue;
		this.dataDesc = dataDesc;
	}

	// Property accessors
	@Id
	@Column(name = "data_id", unique = true, nullable = false)
	public Integer getDataId() {
		return this.dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	@Column(name = "data_type", length = 24)
	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@Column(name = "data_key", length = 24)
	public String getDataKey() {
		return this.dataKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	@Column(name = "data_value", length = 24)
	public String getDataValue() {
		return this.dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	@Column(name = "data_desc", length = 100)
	public String getDataDesc() {
		return this.dataDesc;
	}

	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}

}