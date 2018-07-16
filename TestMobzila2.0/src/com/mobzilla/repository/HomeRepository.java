package com.mobzilla.repository;

import java.util.List;

import com.mobzilla.entity.BrandBean;
import com.mobzilla.entity.ProductBean;

public interface HomeRepository {
	
	public List<ProductBean> getAllProducts();

	public ProductBean getProductDesc(int id);

	public List<ProductBean> getProductByBrand(int brand);

	public List<BrandBean> getAllBrands();

}
