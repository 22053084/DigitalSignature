package com.digitalsignature;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

import com.digitalsignature.login.Login;

class LoginTest {

	private Login login1;
	private Login login2;
	
	@BeforeMethod
	@BeforeEach
	void setUp() throws Exception {
		// Arrange
		login2 = new Login("Donald Trump", "123", "xxx@xxx.com", new Timestamp(System.currentTimeMillis()));
	}

	@Test
	@Order(1)
	void testLogin() {
		login1 = new Login();
		
	    System.out.println("@TestLogin: new Login()");
	    AssertJUnit.assertTrue(true);  // try true and false
	}

	/**
	 * Test method for {@link com.digitalsignature.login.Login#getLoginName()}.
	 */
	@Test
	@Order(2)
	void testGetLoginName() {
		assertEquals ("Donald Trump", login2.getLoginName());
	}

	/**
	 * Test method for {@link com.digitalsignature.login.Login#setName(java.lang.String)}.
	 */
	@Test
	@Order(3)
	void testSetName() {
		login2.setName("Donald Trump");
		assertEquals ("Donald Trump", login2.getLoginName());
	}
	@AfterMethod
	@AfterEach
	void tearDown() throws Exception {
	}


	/**
	 * Test method for {@link com.digitalsignature.login.Login#setEmail(java.lang.String)}.
	 */
	@Test
	@Order(4)
	void testSetEmail() {
		login2.setEmail("xxx@xxx.com");
		assertEquals ("xxx@xxx.com", login2.getEmail());
	}
	
	/**
	 * Test method for {@link com.digitalsignature.login.Login#getPassword()}.
	 */
	@Test
	@Order(5)
	void testGetPassword() {
		assertEquals ("123", login2.getPassword());
	}

	/**
	 * Test method for {@link com.digitalsignature.login.Login#setPassword(java.lang.String)}.
	 */
	@Test
	@Order(6)
	void testSetPassword() {
		login2.setPassword("123");
		assertEquals ("123", login2.getPassword());
	}

	/**
	 * Test method for {@link com.digitalsignature.login.Login#getEmail()}.
	 */
	@Test
	@Order(7)
	void testGetEmail() {
		assertEquals ("xxx@xxx.com", login2.getEmail());
	}

	/**
	 * Test method for {@link com.digitalsignature.login.Login#getUserID()}.
	 */
	@Test
	@Order(8)
	void testGetUserID() {
		assertEquals ("0", String.valueOf(login2.getUserID()));
	}

	
	/**
	 * Test method for {@link com.digitalsignature.login.Login#getLastLogin()}.
	 */
	@Test
	@Order(9)
	void testGetLastLogin() {
		AssertJUnit.assertNotNull(login2.getLastLogin());
	}
}
