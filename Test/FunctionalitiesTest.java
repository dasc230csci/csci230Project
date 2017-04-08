package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Entity.University;
import Entity.User;
import UI.UserUI;
import UI.AdminUI;

public class FunctionalitiesTest {
	private UserUI userUI;
	private AdminUI adminUI;

	@Before
	public void setUp() throws Exception {
		userUI = new UserUI("jcena");
		adminUI = new AdminUI("anhtran"); 
	}

	@Test
	public void testViewSavedSchool() {
		userUI.saveUniversity("BARD");
		ArrayList<String> schoolList = userUI.viewSavedSchool();
		Assert.assertTrue("the user save school is BARD", schoolList.get(0).equals("BARD"));
	}

	@Test
	public void testViewProfile() {
		User newUser = userUI.viewProfile();
		Assert.assertTrue("the user first name is john", newUser.getFirstName().equals("john"));
		Assert.assertTrue("the user last name is cena", newUser.getLastName().equals("cena"));
		Assert.assertTrue("the user username is jcena", newUser.getUsername().equals("jcena"));
		assertTrue("the user password is password", newUser.getPassword().equals("password"));
		assertTrue("the user type is u", newUser.getType().equals("u"));
		assertTrue("the user status is N", newUser.getStatus().equals("Y"));
	}

	@Test
	public void testEditProfile_ValidCase() {
		userUI.editProfile("BigJohn", "The Cena", "newPassword");
		User newUser = userUI.viewProfile();
		Assert.assertTrue("the user first name is BigJohn", newUser.getFirstName().equals("BigJohn"));
		Assert.assertTrue("the user last name is The Cena", newUser.getLastName().equals("The Cena"));
		assertTrue("the user password is newPassword", newUser.getPassword().equals("newPassword"));
		userUI.editProfile("john", "cena", "password");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEditProfile_InvalidCase1() {
		userUI.editProfile(null, "The Cena", "newPassword");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testEditProfile_InvalidCase2() {
		userUI.editProfile("null", null, "newPassword");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEditProfile_InvalidCase3() {
		userUI.editProfile("null", "The Cena", null);
	}

	@Test
	public void testRemoveSavedUniversity() {
		userUI.removeSavedUniversity("BARD");
		ArrayList<String> schoolList = userUI.viewSavedSchool();
		Assert.assertTrue("The school list is empty", schoolList.isEmpty());
	}

	@Test
	public void testViewAllUniversity() {
		ArrayList<University> university = adminUI.viewUniversityList();
		Assert.assertTrue("the list has"+university.size(), university.size()==182);
	}
}
