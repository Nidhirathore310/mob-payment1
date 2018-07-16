package com.mobzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobzilla.entity.BrandBean;
import com.mobzilla.entity.ProductBean;
import com.mobzilla.repository.HomeRepository;

@Service("homeservice")
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private HomeRepository repo;

	@Override
	public List<ProductBean> getAllProducts() {
		// TODO Auto-generated method stub
		
		return repo.getAllProducts();
	}

	@Override
	public ProductBean getProductDesc(int id) {
		// TODO Auto-generated method stub
		return repo.getProductDesc(id);
	}

	@Override
	public List<ProductBean> getProductByBrand(int brand) {
		// TODO Auto-generated method stub
		return repo.getProductByBrand(brand);
	}

	@Override
	public List<BrandBean> getAllBrands() {
		// TODO Auto-generated method stub
		return repo.getAllBrands();
	}

}
