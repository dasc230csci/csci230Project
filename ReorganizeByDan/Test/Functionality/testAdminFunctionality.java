package Test.Functionality;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import Entity.Account;
import Entity.University;
import Entity.User;
import UI.AdminUI;

public class testAdminFunctionality {
	
	private AdminUI adminUI;
	
	@Before
	public void init(){
		adminUI = new AdminUI("testa");
	}
	
	@Test
	public void testViewAllUniversity() {
		ArrayList<University> university = adminUI.viewUniversityList();
		assertTrue("the list has"+university.size(), university.size()==182);
	}
	
	@Test
	public void testViewProfile(){
		Account a = adminUI.viewProfile();
		
		assertTrue("username should testa", a.getUsername().equals("testa"));
		assertTrue("fistName should be testaf", a.getFirstName().equals("testaf"));
		assertTrue("laseName should be testal", a.getLastName().equals("testal"));
		assertTrue("password should be password", a.getPassword().equals("password"));
		assertTrue("type should be a", a.getType().equals("a"));
		assertTrue("status should be Y", a.getStatus().equals("Y"));
	}
	
	@Test
	public void testViewAllUser(){
		assertTrue("Admin should get all the User list", adminUI.viewAllUser().size() == 15);
	}
	
	

}
