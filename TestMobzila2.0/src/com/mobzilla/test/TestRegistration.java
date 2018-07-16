package com.mobzilla.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mobzilla.entity.AddressBean;
import com.mobzilla.entity.UserBean;
import com.mobzilla.services.UserService;

/**
 * 
 * @author
 *
 */
public class TestRegistration {

	// To check if the user has entered a unique and not-null email(primary key) 

	@Test
	public void testRegistraionSuccess() {
		UserBean user = new UserBean();
		AddressBean address = new AddressBean();
		user.setUserFirstName("Example");
		user.setUserLastName("Ghosh");
		user.setUserEmail("aa"); 
		user.setUserContact("9876543210");
		user.setUserPass("abc");

		address.setAddressLine1("line1");
		address.setAddressLine2("line2");
		address.setCity("city name");
		address.setPin("208001");
		address.setState("uo");

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertTrue(service.registerUser(user, address));
	}
	// To check if the user has entered a non-unique email(primary key) 

	@Test
	public void testRegistraionFailure() {
		UserBean user = new UserBean();
		AddressBean address = new AddressBean();
		user.setUserFirstName("shreya");
		user.setUserLastName("Ghosh");
		user.setUserEmail("check1@gmail.com");
		user.setUserContact("9876543210");
		user.setUserPass("abc");

		address.setAddressLine1("line1");
		address.setAddressLine2("line2");
		address.setCity("city name");
		address.setPin("208001");
		address.setState("uo");

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertFalse(service.registerUser(user, address));
	}

	// To check if the user has entered the email(primary key) as null 

	@Test
	public void testRegistraionNullEmail() {
		UserBean user = new UserBean();
		AddressBean address = new AddressBean();
		user.setUserFirstName("shreya");
		user.setUserLastName("Ghosh");
		user.setUserEmail("");
		user.setUserContact("9876543210");
		user.setUserPass("abc");

		address.setAddressLine1("line1");
		address.setAddressLine2("line2");
		address.setCity("city name");
		address.setPin("208001");
		address.setState("uo");

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("service");
		assertFalse(service.registerUser(user, address));
	}
}
