package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.*;
import Entity.*;
import UI.*;

public class U1LoginTest {

	private LoginUI loginUI;
	private LoginController loginController;
	private AccountController accountController;
	private AccountDBController accountDBController;
	
	@Before
	public void setUp() throws Exception {
		loginUI = new LoginUI();
		loginController = new LoginController();
		accountController = new AccountController();
		accountDBController = new AccountDBController();
	}

	@Test
	public void testLoginUIVerifyUser() {
		assertTrue(this.loginUI.verifyUser("juser", "user").equals("u"));
	}
	
	@Test
	public void testLoginControllerVerifyUser() {
		assertTrue(this.loginController.verifyUser("juser", "user").equals("u"));
	}
	
	@Test
	public void testAccountControllerVerifyAccount() {
		assertTrue(this.accountController.verifyAccount("juser", "user").equals("u"));
	}
	
	@Test
	public void testAccountDBControllerGetUser() {
		assertTrue(this.accountDBController.getAccount("juser") instanceof Account);
	}
	
	@Test
	public void testAbnormalCaseWrongPassword() {
		assertTrue(this.loginUI.verifyUser("juser", "wrongpass").equals("failed"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAbnormalCaseWrongUsername() {
		this.loginUI.verifyUser("wronguser", "wrongpass");
	}

} 
