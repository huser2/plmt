package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PLMTYPELIST database table.
 * 
 */
@Entity
@Table(name="PLMTYPELIST")
@NamedQuery(name="PlmTypeList.findAll", query="SELECT p FROM PlmTypeList p")
public class PlmTypeList implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="PLM_NAME", length=100)
	private String plmName;

	@Column(name="TYPE_ID", length=100)
	private String typeId;

	@Column(name="TYPE_NAME", length=100)
	private String typeName;

	public PlmTypeList() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlmName() {
		return this.plmName;
	}

	public void setPlmName(String plmName) {
		this.plmName = plmName;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}