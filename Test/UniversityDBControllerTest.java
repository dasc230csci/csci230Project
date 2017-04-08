/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import Controller.*;
import Entity.*;
import java.util.*;

import org.junit.*;

/**
 * @author sjhalloran
 *
 */
public class UniversityDBControllerTest {

	private UniversityDBController uniDB;
	private University testUniversity;
	private University testUNIversity;
	private University testUniversity2;
	private University updatedTestUni2;
	private University badUni;
	private ArrayList<String> emphases;
	private ArrayList<String> emphasesUpdate;
	private ArrayList<University> uniList;
		

	@Before
	public void init(){
	 uniDB = new UniversityDBController();
	 emphases = new ArrayList<String>();
	 emphases.add("Biology");
	 emphases.add("Math");
	 emphasesUpdate = new ArrayList<String>();
	 emphasesUpdate.add("English");
	 testUniversity2 = new University("testSchool", "testState", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphases);
	 updatedTestUni2 = new University("testSchool", "testStateUpdated", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphasesUpdate);
	 badUni = new University("testSchoolUpdated", "testStateUpdated", "testLoc", "testControl", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphases);
	 University testUNIversity = new University("getlistSchool", "testState", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphases);

	 uniList = new ArrayList<University>();
	 if(uniDB.getUniversity("testSchool") != null){
		 uniDB.deleteUniversity("testSchool");
		 System.out.println("deleted testUni2");
	 }
	 else if(uniDB.getUniversity("testSchoolUpdated") != null){
		 uniDB.deleteUniversity("testSchoolUpdated");
		 System.out.println("deleted a");
	 }
	 else if(uniDB.getUniversity("getlistSchool") != null){
		 uniDB.deleteUniversity("getlistSchool");
		 System.out.println("deleted");
	 }
	 }
	
	/**
	 * Test method for getUniversity() method
	 * in the UniversityDBController class
	 */
	@Test
	public void testGetUniversity() {
		testUniversity = uniDB.getUniversity("BARD");
		Assert.assertTrue("testUniversity should be a University Object: ", testUniversity instanceof University);
		testUniversity = uniDB.getUniversity("MISPELT");//should this be null or should we throw an error
		Assert.assertNull("testUniversity should be a null instance becuase of the misspelted University name: ", testUniversity);
		testUniversity = uniDB.getUniversity("");
		Assert.assertNull("testUniversity should be a null instance because there was no schoolname provided", testUniversity);
		
	}

	/**
	 * Test method for {@link Controller.UniversityDBController#updateUniversity(Entity.University)}.
	 */
	@Test
	public void testUpdateUniversity() {
		//UniDB.deleteUniversity("testSchool");//wipping the DataBase of the test university
		boolean test2 = uniDB.addUniversity(testUniversity2);//readding it
		
		Assert.assertTrue("testUniversity2 emphasis[0] should be math", uniDB.getUniversity("testSchool").getEmphases().get(0).equals("Biology"));
		//Assert.assertFalse("Trying to updated TestUniversity2 with bad parameter University should fail: ", UniDB.updateUniversity(badUni));
		boolean test = uniDB.updateUniversity(updatedTestUni2);//updating the testUniversity2 
		System.out.println(test);
		testUniversity2 = uniDB.getUniversity("testSchool");
		ArrayList<String> testEmph = testUniversity2.getEmphases();//confirming the emphasis[0] changed from math to english
		Assert.assertTrue("new Emphasis equals enlgish", testEmph.get(0).equals("English"));
		//UniDB.deleteUniversity("testSchool");//wipping the DataBase of the test university
		
	}

	/**
	 * Test method for {@link Controller.UniversityDBController#addUniversity(Entity.University)}.
	 */
	@Test
	public void testAddUniversity() {
		//UniDB.deleteUniversity("testSchool");
		uniDB.addUniversity(testUniversity2);
		testUniversity = uniDB.getUniversity("testSchool");
		Assert.assertTrue("testUniversity2 should have been be added successfully",testUniversity instanceof University);
		Assert.assertFalse("test shoudl fail becuase testUniversity2 has already been added", uniDB.addUniversity(testUniversity2));
		//Assert.assertFalse("test should fail becuase of the invalid info in the University object", UniDB.addUniversity());
		boolean test3 = uniDB.deleteUniversity("testSchool");
		if(test3){
			System.out.println("succuss deleteing at testadd");
		}
		else{
			System.out.println("delete Method has bugs");
		}

	}

	/**
	 * Test method for {@link Controller.UniversityDBController#getUniversityList()}.
	 */
	@Test
	public void testGetUniversityList() {
		//UniDB.deleteUniversity("getlistSchool");
		uniList = uniDB.getUniversityList();
		int size = uniList.size();
		System.out.println(size);
		uniDB.addUniversity(testUNIversity);//adding 1 to confirm the new list is one more then the old
		System.out.println(uniDB.getUniversityList().size());
		Assert.assertTrue("The original list size should be one less aftering adding a uNiversity", size < uniDB.getUniversityList().size());
		boolean test2 = uniDB.deleteUniversity("getlistSchool");
		if(test2){
		Assert.assertTrue("length should be back to the same after the deletetion of the University", size == uniDB.getUniversityList().size());
		}
		else{
			System.out.println("DID not delete getlistSchool successfully");
		}
	}

}
