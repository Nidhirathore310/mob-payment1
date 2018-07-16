package com.mobzilla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@SequenceGenerator(name = "product_id", sequenceName = "product_seq")
public class ProductBean {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;

	@Column(name = "product_img_url")
	private String productImgUrl;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_brand")
	private int productBrand;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "product_price", length = 10, precision = 2)
	private double productPrice;

	@Column(name = "product_specs")
	private String productSpecs;

	public String getProductSpecs() {
		return productSpecs;
	}

	public void setProductSpecs(String productSpecs) {
		this.productSpecs = productSpecs;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(int productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductImgUrl() {
		return productImgUrl;
	}

	public void setProductImgUrl(String productImgUrl) {
		this.productImgUrl = productImgUrl;
	}

}
