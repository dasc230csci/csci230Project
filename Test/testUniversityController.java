package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.UniversityController;
import Entity.University;

public class testUniversityController {

	private UniversityController universityController;
	private University university;
	
	@Before
	public void init(){
		this.universityController = new UniversityController();
	}
	
	@Test
	public void testUniversityController() {
		assertTrue(universityController instanceof UniversityController);
	}

	@Test
	public void testCreateUniversity(){
		fail("Not yet implemented");
	}

	@Test
	public void testGetUniversityInDetailed(){
		fail("Not yet implemented");
	}

	@Test
	public void testEditUniversityInDetailed(){
		fail("Not yet implemented");
	}

	@Test
	public void testGetUniversityList() {
		fail("Not yet implemented");
	}

}
