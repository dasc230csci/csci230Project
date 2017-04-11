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

 private UniversityDBController UniDB;
 private University testUniversity;
 private University testUniversity2;
 private University updatedTestUni2;
 private University badUni2;
 private ArrayList<String> emphases;
 private ArrayList<String> emphasesUpdate;
 private ArrayList<University> uniList;
  

 @Before
 public void init(){
  UniDB = new UniversityDBController();
  emphases = new ArrayList<String>();
  emphases.add("Biology");
  emphases.add("Math");
  testUniversity2 = new University("testSchool", "testState", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphases);
  badUni2 = new University("testSchoolUpdated1", "testStateUpdated1", "testLoc1", "testControl1", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphases);
  uniList = new ArrayList<University>();
  UniDB.deleteUniversity("testSchoolUpdated1");
  UniDB.deleteUniversity("testSchoolUpdated");
  UniDB.deleteUniversity("testSchool");
  }
 /**
  * Test method for getUniversity() method
  * in the UniversityDBController class
  */
 @Test
 public void testGetUniversity() {
  testUniversity = UniDB.getUniversity("BARD");
  Assert.assertTrue("testUniversity should be a University Object: ", testUniversity instanceof University);
  testUniversity = UniDB.getUniversity("MISPELT");//should this be null or should we throw an error
  Assert.assertNull("testUniversity should be a null instance becuase of the misspelted University name: ", testUniversity);
  testUniversity = UniDB.getUniversity("");
  Assert.assertNull("testUniversity should be a null instance because there was no schoolname provided", testUniversity);
  
 }

 /**
  * Test method for {@link Controller.UniversityDBController#updateUniversity(Entity.University)}.
  * @throws InterruptedException 
  */
 @Test
 public void testUpdateUniversity() throws InterruptedException {
  UniDB.addUniversity(testUniversity2);//readding it
  emphasesUpdate = new ArrayList<String>();
  emphasesUpdate.add("Spanish");
  emphasesUpdate.add("Accounting");
  emphasesUpdate.add("Science");
  updatedTestUni2 = new University("testSchool", "testStateUpdated", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphasesUpdate);
  Assert.assertTrue("emphases should originally be Biology ",testUniversity2.getEmphases().get(0).equals("Biology"));
  UniDB.updateUniversity(updatedTestUni2);//updating the testUniversity2 
  testUniversity = UniDB.getUniversity("testSchool");
  ArrayList<String> emphases1 = testUniversity.getEmphases();//confirming the emphasis[0] changed from math to english
  Assert.assertTrue("new Emphasis equals enlgish", emphases1.get(2).equals("Spanish"));  
 }

 /**
  * Test method for {@link Controller.UniversityDBController#addUniversity(Entity.University)}.
  */
 @Test
 public void testAddUniversity() {
  UniDB.addUniversity(testUniversity2);//adding testUniversity2 to the database
  testUniversity = UniDB.getUniversity("testSchool");//then grabbing that information from the DB and assigning it to a black University object
  Assert.assertTrue("testUniversity2 should have been be added successfully",testUniversity2 instanceof University);
  Assert.assertFalse("test shoudl fail becuase testUniversity2 has already been added", UniDB.addUniversity(testUniversity2));//cannot add something that has already been added
 }

 /**
  * Test method for {@link Controller.UniversityDBController#getUniversityList()}.
  */
 @Test
 public void testGetUniversityList() {
  uniList = UniDB.getUniversityList();
  int size = uniList.size();
  //System.out.println(size);
  boolean testadd = UniDB.addUniversity(badUni2);//adding 1 to confirm the new list is one more then the old
  //System.out.println("list " + testadd);
  //System.out.println(UniDB.getUniversityList().size());
  Assert.assertTrue("The original list size should be one less aftering adding a uNiversity", size < UniDB.getUniversityList().size());
  UniDB.deleteUniversity("testSchoolUpdated1");
  Assert.assertTrue("length should be back to the same after the deletetion of the University", size == UniDB.getUniversityList().size());
  
 }

}
