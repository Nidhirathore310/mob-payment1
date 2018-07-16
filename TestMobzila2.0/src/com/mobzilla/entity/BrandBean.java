package com.mobzilla.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="brand_table")
@SequenceGenerator(name="brand_id",sequenceName="brand_seq")
public class BrandBean {
	
	@Id
	@Column(name="brand_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int brandId;
	
	@Column(name="brand_name")
	private String brandName;
	
	@OneToMany(mappedBy="productBrand", fetch=FetchType.EAGER, cascade={javax.persistence.CascadeType.ALL})
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<ProductBean> products;

	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	
	

}
