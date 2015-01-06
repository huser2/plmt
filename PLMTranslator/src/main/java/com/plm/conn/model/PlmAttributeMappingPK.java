package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PLMATTRIBUTEMAPPING database table.
 * 
 */
@Embeddable
public class PlmAttributeMappingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PLM1_TYPE_ID", unique=true, nullable=false, length=100)
	private String plm1TypeId;

	@Column(name="PLM1_NAME", unique=true, nullable=false, length=100)
	private String plm1Name;

	@Column(name="PLM1_ATTRIBUTE_ID", unique=true, nullable=false, length=100)
	private String plm1AttributeId;

	@Column(name="PLM2_NAME", unique=true, nullable=false, length=100)
	private String plm2Name;

	@Column(name="PLM2_ATTRIBUTE_ID", unique=true, nullable=false, length=100)
	private String plm2AttributeId;

	@Column(name="PLM2_TYPE_ID", unique=true, nullable=false, length=100)
	private String plm2TypeId;

	public PlmAttributeMappingPK() {
	}
	public String getPlm1TypeId() {
		return this.plm1TypeId;
	}
	public void setPlm1TypeId(String plm1TypeId) {
		this.plm1TypeId = plm1TypeId;
	}
	public String getPlm1Name() {
		return this.plm1Name;
	}
	public void setPlm1Name(String plm1Name) {
		this.plm1Name = plm1Name;
	}
	public String getPlm1AttributeId() {
		return this.plm1AttributeId;
	}
	public void setPlm1AttributeId(String plm1AttributeId) {
		this.plm1AttributeId = plm1AttributeId;
	}
	public String getPlm2Name() {
		return this.plm2Name;
	}
	public void setPlm2Name(String plm2Name) {
		this.plm2Name = plm2Name;
	}
	public String getPlm2AttributeId() {
		return this.plm2AttributeId;
	}
	public void setPlm2AttributeId(String plm2AttributeId) {
		this.plm2AttributeId = plm2AttributeId;
	}
	public String getPlm2TypeId() {
		return this.plm2TypeId;
	}
	public void setPlm2TypeId(String plm2TypeId) {
		this.plm2TypeId = plm2TypeId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PlmAttributeMappingPK)) {
			return false;
		}
		PlmAttributeMappingPK castOther = (PlmAttributeMappingPK)other;
		return 
			this.plm1TypeId.equals(castOther.plm1TypeId)
			&& this.plm1Name.equals(castOther.plm1Name)
			&& this.plm1AttributeId.equals(castOther.plm1AttributeId)
			&& this.plm2Name.equals(castOther.plm2Name)
			&& this.plm2AttributeId.equals(castOther.plm2AttributeId)
			&& this.plm2TypeId.equals(castOther.plm2TypeId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.plm1TypeId.hashCode();
		hash = hash * prime + this.plm1Name.hashCode();
		hash = hash * prime + this.plm1AttributeId.hashCode();
		hash = hash * prime + this.plm2Name.hashCode();
		hash = hash * prime + this.plm2AttributeId.hashCode();
		hash = hash * prime + this.plm2TypeId.hashCode();
		
		return hash;
	}
}