package com.mobzilla.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mobzilla.entity.ProductBean;
import com.mobzilla.services.HomeService;

public class TestProduct {
	// To check if the product in the catalog entered, exists in the database
	@Test
	public void testProductSuccess() {

		ProductBean product = new ProductBean();
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HomeService service = (HomeService) ctx.getBean("homeservice");
		product = service.getProductDesc(2);
		System.out.println(product.getProductBrand());
		System.out.println(product.getProductName());

	}

	// To check if the product in the catalog entered, doesn't exist in the database

	@Test(expected = IndexOutOfBoundsException.class)
	public void testProductFailure() {

		ProductBean product = new ProductBean();
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		HomeService service = (HomeService) ctx.getBean("homeservice");
		product = service.getProductDesc(3);
		System.out.println(product.getProductBrand());
		System.out.println(product.getProductName());

	}

}
