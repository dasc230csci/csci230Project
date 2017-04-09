package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.AccountController;
import Controller.LoginController;
import Controller.UniversityController;
import Entity.Account;
import Entity.User;
import UI.UserUI;

public class testLoginController {

	LoginController loginController;
	AccountController accountController;
	Account testUser = new User("userfirst", "userlast", "userun", "userpw", "Y", false);
	UserUI userUI;
	
	
	@Before
	public void setUp() throws Exception {
		this.loginController = new LoginController();
		this.accountController = new AccountController();
		this.userUI = new UserUI(this.testUser.getUsername());
		this.accountController.createAccount("userfirst", "userlast", "userun", "userpw","u", "Y");
		
	}

	@Test
	public void testLoginController() {
		assertTrue(this.loginController instanceof LoginController);
	}

	@Test
	public void testVerifyUserCase1() {
		//Case 1: Valid UN & Valid PW
		assertTrue(this.loginController.verifyUser("userun", "userpw").equals("u"));
	}
	
	@Test
	public void testVerifyUserCase2() {
		//Case 2: Valid UN & Invalid PW
		assertTrue(this.loginController.verifyUser("userun", "userpwwww").equals("failed"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testVerifyUserCase3() {
		//Case 3: Invalid UN & Valid PW
		this.loginController.verifyUser("useruuuu", "userpw");
	}
	
	@Test(expected=NullPointerException.class)
	public void testVerifyUserCase4() {
		//Case 4: Invalid UN & Invalid PW
		this.loginController.verifyUser("useruuuu", "userpwwww");
	}
	
	

}
