package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Entity.Account;
import Entity.User;

public class UserTest {
	private User user;
	@Before
	public void setUp() throws Exception {
		user= new User("firstName", "lastName", "username", "password", "Y", true);
	}

	@Test
	public void testUserValid() {
		assertTrue(user instanceof User);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserConstructor_InvalidFirstName(){
		User newAccount = new User(null, "lastName", "username", "password", "Y", true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserConstructor_InvalidLastName(){
		User newAccount = new User("firstName", null, "username", "password", "Y", true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserConstructor_InvalidUserName(){
		User newAccount = new User("firstName", "lastName", null, "password", "Y", true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserConstructor_InvalidPassword(){
		User newAccount = new User("firstName", "lastName", "username", null, "Y", true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserConstructor_InvalidStatus_Case1(){
		User newAccount = new User("firstName", "lastName", "username", "password", "B", true);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testUserConstructor_InvalidStatus_Case2(){
		User newAccount = new User("firstName", "lastName", "username", "password", null, true);
	}


	@Test
	public void testGetSavedSchool() {
		user.addSavedSchool("BARD");
		assertTrue("The user have 1 saved school", user.getSavedSchool().size()==1);
		assertTrue("The user saved school is/are BARD", user.getSavedSchool().get(0).equals("BARD"));
	}

	@Test
	public void testAddSavedSchool() {
		user.addSavedSchool("BARD");
		user.addSavedSchool("ST JOHN UNIVERSITY");
		assertTrue("The user have 2 saved school", user.getSavedSchool().size()==2);
		assertTrue("The user saved school is/are BARD", user.getSavedSchool().get(0).equals("BARD"));
		assertTrue("The user saved school is/are BARD", user.getSavedSchool().get(1).equals("ST JOHN UNIVERSITY"));
	}

	@Test
	public void testRemoveSavedSchool() {
		user.addSavedSchool("BARD");
		user.addSavedSchool("ST JOHN UNIVERSITY");
		user.removeSavedSchool("ST JOHN UNIVERSITY");
		assertTrue("The user have 1 saved school", user.getSavedSchool().size()==1);
		assertTrue("The user saved school is/are BARD", user.getSavedSchool().get(0).equals("BARD"));
	}

}
