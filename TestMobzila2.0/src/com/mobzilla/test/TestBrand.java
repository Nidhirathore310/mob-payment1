package com.mobzilla.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mobzilla.entity.ProductBean;
import com.mobzilla.services.HomeService;


public class TestBrand {

	/*
	 * To check whether the number of products under a brand_id is equal to the
	 * number of products of that brand in the database
	 */
	@Test
	public void brandCategorySuccess() {
		ProductBean brand = new ProductBean();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HomeService service = (HomeService) ctx.getBean("homeservice");

		int sizeOfList = (service.getProductByBrand(2)).size();

		System.out.println(sizeOfList);
	}

	@Test
	public void brandCategoryFailure() {
		ProductBean brand = new ProductBean();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HomeService service = (HomeService) ctx.getBean("homeservice");

		int sizeOfList = (service.getProductByBrand(21)).size();

		assertTrue(sizeOfList == 0);
		
	}
}
