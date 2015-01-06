package com.plm.conn.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PLMATTRIBUTEMAPPING database table.
 * 
 */
@Entity
@Table(name="PLMATTRIBUTEMAPPING")
@NamedQuery(name="PlmAttributeMapping.findAll", query="SELECT p FROM PlmAttributeMapping p")
public class PlmAttributeMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PlmAttributeMappingPK id;

	@Column(name="PLM1_ATTRIBUTE_NAME", length=100)
	private String plm1AttributeName;

	@Column(name="PLM1_TYPE_NAME", length=100)
	private String plm1TypeName;

	@Column(name="PLM2_ATTRIBUTE_NAME", length=100)
	private String plm2AttributeName;

	@Column(name="PLM2_TYPE_NAME", length=100)
	private String plm2TypeName;

	public PlmAttributeMapping() {
	}

	public PlmAttributeMappingPK getId() {
		return this.id;
	}

	public void setId(PlmAttributeMappingPK id) {
		this.id = id;
	}

	public String getPlm1AttributeName() {
		return this.plm1AttributeName;
	}

	public void setPlm1AttributeName(String plm1AttributeName) {
		this.plm1AttributeName = plm1AttributeName;
	}

	public String getPlm1TypeName() {
		return this.plm1TypeName;
	}

	public void setPlm1TypeName(String plm1TypeName) {
		this.plm1TypeName = plm1TypeName;
	}

	public String getPlm2AttributeName() {
		return this.plm2AttributeName;
	}

	public void setPlm2AttributeName(String plm2AttributeName) {
		this.plm2AttributeName = plm2AttributeName;
	}

	public String getPlm2TypeName() {
		return this.plm2TypeName;
	}

	public void setPlm2TypeName(String plm2TypeName) {
		this.plm2TypeName = plm2TypeName;
	}

}