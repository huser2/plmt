package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PLMATTRIBUTELIST database table.
 * 
 */
@Entity
@Table(name="PLMATTRIBUTELIST")
@NamedQuery(name="PlmAttributeList.findAll", query="SELECT p FROM PlmAttributeList p")
public class PlmAttributeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="ATTRIBUTE_ID", length=100)
	private String attributeId;

	@Column(name="ATTRIBUTE_NAME", length=100)
	private String attributeName;

	@Column(name="PLM_NAME", length=100)
	private String plmName;

	public PlmAttributeList() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getPlmName() {
		return this.plmName;
	}

	public void setPlmName(String plmName) {
		this.plmName = plmName;
	}

}