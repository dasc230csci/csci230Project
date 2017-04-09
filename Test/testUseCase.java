package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Entity.Account;
import Entity.University;
import Entity.User;
import UI.AdminUI;
import UI.UserUI;

public class testUseCase {

	private UserUI user;
	private AdminUI admin;
	
	@Before
	public void init() {
		user = new UserUI("juser");
		admin = new AdminUI("nadmin");
	}
	
	@Test
	public void testSearch(){
		ArrayList<University> list = new ArrayList<University>();
		list = user.search("MINNESOTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University should be within MINNESOTA", u.getState().equals("MINNESOTA"));
		}
	}
	@Test
	public void testSearch2(){
		ArrayList<University> list = new ArrayList<University>();
		list = user.search("", "", "", "", "", "", "", "", "500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal()>=500.0);
		}
	}
	@Test
	public void testSearch3(){
		ArrayList<University> list = new ArrayList<University>();
		list = user.search("", "", "", "", "", "", "", "", "", "", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
		}
	}
	
	@Test
	public void testSearch4(){
		ArrayList<University> list = new ArrayList<University>();
		list = user.search("", "NEW YORK", "", "", "", "", "", "", "500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University includes NEW YORK", u.getState().equals("NEW YORK"));
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
		}
	}
	
	@Test
	public void testSearch5(){
		ArrayList<University> list = new ArrayList<University>();
		list = user.search("", "", "", "", "", "", "", "", "500", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
			assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
		}
	}
	
	@Test
	public void testSearch6(){
		ArrayList<University> list = new ArrayList<University>();
		list = user.search("", "NEW YORK", "", "", "", "", "", "", "500", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", "", 
				"", "", "", "", "", "", "", "", "");
		for(University u : list){
			assertTrue("list of University includes NEW YORK", u.getState().equals("NEW YORK"));
			assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
			assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
		}
	}
	
	@Test
	public void testViewUserProfile(){
		User u = user.viewProfile();
		Account a = admin.viewProfile();
		assertTrue("username should be juser", u.getUsername().equals("juser"));
		assertTrue("fistName should be John", u.getFirstName().equals("John"));
		assertTrue("laseName should be User", u.getLastName().equals("User"));
		assertTrue("password should be user", u.getPassword().equals("user"));
		assertTrue("type should be u", u.getType().equals("u"));
		assertTrue("status should be Y", u.getStatus().equals("Y"));
		
		assertTrue("username should nadmin", a.getUsername().equals("nadmin"));
		assertTrue("fistName should be Noreen", a.getFirstName().equals("Noreen"));
		assertTrue("laseName should be Admin", a.getLastName().equals("Admin"));
		assertTrue("password should be admin", a.getPassword().equals("admin"));
		assertTrue("type should be a", a.getType().equals("a"));
		assertTrue("status should be Y", a.getStatus().equals("Y"));
	}
	
	@Test
	public void testViewUniversityDetail1(){
		University univDetail = user.viewUniversityInDetail("BARD");
		assertTrue("School Name is BARD", univDetail.getSchoolName().equals("BARD"));
		ArrayList<University> recomList = user.searchRecommendation("BARD");
		assertTrue("List should contain TOURO", recomList.get(5).getSchoolName().equals("TOURO"));
		assertTrue("List should contain CLARKSON UNIVERSITY", recomList.get(1).getSchoolName().equals("CLARKSON UNIVERSITY"));
		assertTrue("List should contain VASSAR", recomList.get(2).getSchoolName().equals("VASSAR"));
		assertTrue("List should contain RENSSELAER", recomList.get(4).getSchoolName().equals("RENSSELAER"));
		assertTrue("List should contain COLLEGE OF NEWROCHELLE", recomList.get(3).getSchoolName().equals("COLLEGE OF NEWROCHELLE"));
		assertTrue("List should contain BARD", recomList.get(0).getSchoolName().equals("BARD"));
	}
	@Test
	public void testViewUniversityDetail2(){
		University univDetail = user.viewUniversityInDetail("VASSAR");
		assertTrue("School Name is VASSAR", univDetail.getSchoolName().equals("VASSAR"));
		ArrayList<University> recomList = user.searchRecommendation("VASSAR");
		assertTrue("List should contain MANHATTANVILLE COLLEGE", recomList.get(5).getSchoolName().equals("MANHATTANVILLE COLLEGE"));
		assertTrue("List should contain CLARKSON UNIVERSITY", recomList.get(3).getSchoolName().equals("CLARKSON UNIVERSITY"));
		assertTrue("List should contain VASSAR", recomList.get(0).getSchoolName().equals("VASSAR"));
		assertTrue("List should contain RENSSELAER", recomList.get(2).getSchoolName().equals("RENSSELAER"));
		assertTrue("List should contain CONNECTICUT COLLEGE", recomList.get(4).getSchoolName().equals("CONNECTICUT COLLEGE"));
		assertTrue("List should contain BARD", recomList.get(1).getSchoolName().equals("BARD"));
	}
	
	
	
/*
 * -search university (U7)
-view own user profile(U20)
 */
}

