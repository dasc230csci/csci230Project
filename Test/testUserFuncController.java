package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controller.AccountController;
import Controller.LoginController;
import Controller.UserFuncController;
import Entity.Account;
import Entity.University;
import Entity.User;
import UI.UserUI;

public class testUserFuncController {

	UserFuncController userFuncController;
	AccountController accountController;
	Account testUser = new User("userfirst", "userlast", "userun", "userpw", "Y", false);
	UserUI userUI;
	
	@Before
	public void setUp() throws Exception {
		this.userFuncController = new UserFuncController();
		//this.accountController.createAccount("userfirst", "userlast", "userun", "userpw","u", "Y");
		this.userUI = new UserUI(this.testUser.getUsername());
		
	}

	@Test
	public void testUserFuncController() {
		assertTrue(this.userFuncController instanceof UserFuncController);
	}

	@Test
	public void testSaveSchool() {
		assertTrue(this.userFuncController.saveSchool("userun", "BARD"));
	}

	@Test
	public void testEditProfile() {
		assertTrue(this.userFuncController.editProfile("userun", "userfirstEDIT", "userlast", "userpw"));
	}

	@Test
	public void testViewSavedSchool() {
		this.userFuncController.saveSchool("userun", "BARNARD");
		assertTrue(this.userFuncController.viewSavedSchool("userun").contains("BARNARD"));
	}

	@Test
	public void testRemoveSavedSchool() {
		assertTrue(this.userFuncController.removeSavedSchool("userun", "BARD"));
	}

	@Test
	public void testGetUniversityInDetail() {
		University universityToGet = this.userFuncController.getUniversityInDetail("BARD");
		assertTrue(universityToGet.getSchoolName().equals("BARD"));
	}

	@Test
	public void testSearch() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProfile() {
		assertTrue(this.userFuncController.getProfile("userun") instanceof User);
	}

	@Test
	public void testSearchRecommendation() {
		assertTrue(this.userFuncController.searchRecommendation("BARD") instanceof ArrayList);
	}

}
