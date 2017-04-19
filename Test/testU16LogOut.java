package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.*;
import UI.UserUI;

public class testU16LogOut {

	private UserUI userui;
	private LoginController loginController;
	
	@Before
	public void setUp() throws Exception {
		this.userui = new UserUI("luser");
		this.loginController = new LoginController();
	}

	@Test
	public void testUserUILogOff() {
		assertTrue(this.userui.logOff("luser"));
	}
	
	@Test
	public void testLoginControllerLogOff() {
		assertTrue(this.loginController.logOff("luser"));
	}

}
