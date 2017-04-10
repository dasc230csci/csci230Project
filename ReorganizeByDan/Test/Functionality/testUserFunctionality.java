package Test.Functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Entity.Account;
import Entity.University;
import Entity.User;
import UI.AdminUI;
import UI.UserUI;

public class testUserFunctionality {

	private UserUI userUI;
	
	@Before
	public void init(){
		userUI = new UserUI("testu");
	}
	
	@Test
	public void testViewSavedSchool() {
		userUI.saveUniversity("BARD");
		ArrayList<String> schoolList = userUI.viewSavedSchool();
		assertTrue("the user save school is BARD", schoolList.get(0).equals("BARD"));
	}
	
	@Test
	public void testViewProfile() {
		User newUser = userUI.viewProfile();
		Assert.assertTrue("the user first name is testuf", newUser.getFirstName().equals("testuf"));
		Assert.assertTrue("the user last name is testul", newUser.getLastName().equals("testul"));
		Assert.assertTrue("the user username is testu", newUser.getUsername().equals("testu"));
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
		userUI.editProfile("testuf", "testul", "password");
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
	public void testUserUILogOff() {
		assertTrue(this.userUI.logOff());
	}
	
	@Test
	public void testSearch(){
		ArrayList<University> list = new ArrayList<University>();
		list = userUI.search("MINNESOTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University should be within MINNESOTA", u.getState().equals("MINNESOTA"));
		}
	}
	@Test
	public void testSearch2(){
		ArrayList<University> list = new ArrayList<University>();
		list = userUI.search("", "", "", "", "", "", "", "", "500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal()>=500.0);
		}
	}
	@Test
	public void testSearch3(){
		ArrayList<University> list = new ArrayList<University>();
		list = userUI.search("", "", "", "", "", "", "", "", "", "", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
		}
	}
	
	@Test
	public void testSearch4(){
		ArrayList<University> list = new ArrayList<University>();
		list = userUI.search("", "NEW YORK", "", "", "", "", "", "", "500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University includes NEW YORK", u.getState().equals("NEW YORK"));
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
		}
	}
	
	@Test
	public void testSearch5(){
		ArrayList<University> list = new ArrayList<University>();
		list = userUI.search("", "", "", "", "", "", "", "", "500", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
			assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
		}
	}
	
	@Test
	public void testSearch6(){
		ArrayList<University> list = new ArrayList<University>();
		list = userUI.search("", "NEW YORK", "", "", "", "", "", "", "500", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University includes NEW YORK", u.getState().equals("NEW YORK"));
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
			assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
		}
	}
	
	@Test
	public void testViewUserProfile(){
		User u = userUI.viewProfile();
		
		assertTrue("username should be testu", u.getUsername().equals("testu"));
		assertTrue("fistName should be testuf", u.getFirstName().equals("testuf"));
		assertTrue("laseName should be testul", u.getLastName().equals("testul"));
		assertTrue("password should be password", u.getPassword().equals("password"));
		assertTrue("type should be u", u.getType().equals("u"));
		assertTrue("status should be Y", u.getStatus().equals("Y"));
	}
	
	@Test
	public void testViewUniversityDetail1(){
		University univDetail = userUI.viewUniversityInDetail("BARD");
		assertTrue("School Name is BARD", univDetail.getSchoolName().equals("BARD"));
		ArrayList<University> recomList = userUI.searchRecommendation("BARD");
		assertTrue("List should contain TOURO", recomList.get(5).getSchoolName().equals("TOURO"));
		assertTrue("List should contain CLARKSON UNIVERSITY", recomList.get(1).getSchoolName().equals("CLARKSON UNIVERSITY"));
		assertTrue("List should contain VASSAR", recomList.get(2).getSchoolName().equals("VASSAR"));
		assertTrue("List should contain RENSSELAER", recomList.get(4).getSchoolName().equals("RENSSELAER"));
		assertTrue("List should contain COLLEGE OF NEWROCHELLE", recomList.get(3).getSchoolName().equals("COLLEGE OF NEWROCHELLE"));
		assertTrue("List should contain BARD", recomList.get(0).getSchoolName().equals("BARD"));
	}
	@Test
	public void testViewUniversityDetail2(){
		University univDetail = userUI.viewUniversityInDetail("VASSAR");
		assertTrue("School Name is VASSAR", univDetail.getSchoolName().equals("VASSAR"));
		ArrayList<University> recomList = userUI.searchRecommendation("VASSAR");
		assertTrue("List should contain MANHATTANVILLE COLLEGE", recomList.get(5).getSchoolName().equals("MANHATTANVILLE COLLEGE"));
		assertTrue("List should contain CLARKSON UNIVERSITY", recomList.get(3).getSchoolName().equals("CLARKSON UNIVERSITY"));
		assertTrue("List should contain VASSAR", recomList.get(0).getSchoolName().equals("VASSAR"));
		assertTrue("List should contain RENSSELAER", recomList.get(2).getSchoolName().equals("RENSSELAER"));
		assertTrue("List should contain CONNECTICUT COLLEGE", recomList.get(4).getSchoolName().equals("CONNECTICUT COLLEGE"));
		assertTrue("List should contain BARD", recomList.get(1).getSchoolName().equals("BARD"));
	}
}
