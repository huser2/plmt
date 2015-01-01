package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PLM_MAPPING database table.
 * 
 */
@Entity
@Table(name="PLM_MAPPING")
@NamedQuery(name="PlmMapping.findAll", query="SELECT p FROM PlmMapping p")
public class PlmMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false, length=100)
	private String plm;

	@Column(name="PLM_HOSTNAME", length=100)
	private String plmHostname;

	@Column(name="PLM_IPADDRESS", length=100)
	private String plmIpaddress;

	@Column(name="PLM_STATUS", length=100)
	private String plmStatus;

	@Column(name="WNC_HOSTNAME", length=100)
	private String wncHostname;

	@Column(name="WNC_IPADDRESS", length=100)
	private String wncIpaddress;

	@Column(name="WNC_STATUS", length=100)
	private String wncStatus;

	public PlmMapping() {
	}

	public String getPlm() {
		return this.plm;
	}

	public void setPlm(String plm) {
		this.plm = plm;
	}

	public String getPlmHostname() {
		return this.plmHostname;
	}

	public void setPlmHostname(String plmHostname) {
		this.plmHostname = plmHostname;
	}

	public String getPlmIpaddress() {
		return this.plmIpaddress;
	}

	public void setPlmIpaddress(String plmIpaddress) {
		this.plmIpaddress = plmIpaddress;
	}

	public String getPlmStatus() {
		return this.plmStatus;
	}

	public void setPlmStatus(String plmStatus) {
		this.plmStatus = plmStatus;
	}

	public String getWncHostname() {
		return this.wncHostname;
	}

	public void setWncHostname(String wncHostname) {
		this.wncHostname = wncHostname;
	}

	public String getWncIpaddress() {
		return this.wncIpaddress;
	}

	public void setWncIpaddress(String wncIpaddress) {
		this.wncIpaddress = wncIpaddress;
	}

	public String getWncStatus() {
		return this.wncStatus;
	}

	public void setWncStatus(String wncStatus) {
		this.wncStatus = wncStatus;
	}

}