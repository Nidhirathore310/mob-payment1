package com.mobzilla.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mobzilla.entity.LoginBean;
import com.mobzilla.services.UserService;

public class TestLogin {
	// to check if the login is successful with provided email and password

	@Test
	public void testLoginSuccess() {

		LoginBean login = new LoginBean();
		login.setEmail("aayushi@gmail.com");
		login.setPassword("234");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertTrue( service.validate(login));

	}

	// to check if the login is failed with provided email and password
	
	@Test
	public void testLoginFailed() {

		LoginBean login = new LoginBean();
		login.setEmail("aayush344i@gmail.com");
		login.setPassword("123");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertFalse( service.validate(login));

	}
	
	// to check if the login is failed with provided null email
	
	@Test
	public void testNullEmail() {

		LoginBean login = new LoginBean();
		login.setEmail("");
		login.setPassword("123");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertFalse( service.validate(login));
	}	
	
	// to check if the login is failed with null password
	
	@Test
	public void testLoginPassword() {

		LoginBean login = new LoginBean();
		login.setEmail("aayushi@gmail.com");
		login.setPassword("");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertFalse( service.validate(login));
	}

}
