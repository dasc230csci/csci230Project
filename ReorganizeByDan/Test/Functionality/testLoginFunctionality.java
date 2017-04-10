package Test.Functionality;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import UI.LoginUI;

public class testLoginFunctionality {

	private LoginUI loginUI;
	
	@Before
	public void init(){
		loginUI = new LoginUI();
	}
	
	@Test
	public void testLoginUIVerifyUser() {
		assertTrue(this.loginUI.verifyUser("juser", "user").equals("u"));
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
