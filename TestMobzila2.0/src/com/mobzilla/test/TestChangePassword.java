  package com.mobzilla.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mobzilla.entity.ForgotBean;

import com.mobzilla.services.UserService;

public class TestChangePassword {

	@Test
	public void forgotPasswordSuccess() {
		// to check if the password changes when the user resets the password
		ForgotBean forgot = new ForgotBean();

		forgot.setEmail("aayushi@gmail.com");

		forgot.setPassword1("234");
		forgot.setPassword2("234");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertTrue(service.changePassword(forgot));

	}

	@Test
	public void forgotPasswordMismatch() {
		/* To check whether the person enters two different password while re-setting
		 the password.*/
		ForgotBean forgot = new ForgotBean();

		forgot.setEmail("aayushi@gmail.com");

		forgot.setPassword1("password");
		forgot.setPassword2("mismatch");
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertFalse(service.changePassword(forgot));

	}
	
}
