package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import UI.*;
import Controller.*;
import Entity.*;

public class testU9SaveSchool {

	private UserUI userUI;
	private UserFuncController userFuncController;
	private AccountController accountController;
	private AccountDBController accountDBController;
	
	@Before
	public void setUp() throws Exception {
		userUI = new UserUI("juser");
		userFuncController = new UserFuncController();
		accountController = new AccountController();
		accountDBController = new AccountDBController();
	}

	@Test
	public void testUserUISaveUniversity() {
		assertTrue(this.userUI.saveUniversity("BARD"));
		userUI.removeSavedUniversity("BARD");
	}
	
	@Test
	public void testUserFuncControllerSaveSchool() {
		assertTrue(this.userFuncController.saveSchool("juser", "HARVARD"));
		userUI.removeSavedUniversity("HARVARD");
	}
	
	@Test
	public void testAccoutControllerSaveSchool() {
		assertTrue(this.accountController.saveSchool("juser", "BARNARD"));
		userUI.removeSavedUniversity("BARNARD");
	}
	
	@Test
	public void testAccoutDBControllerSaveSchool() {
		assertTrue(this.accountDBController.saveSchool("juser", "BROWN"));
		userUI.removeSavedUniversity("BROWN");
	}

	}


