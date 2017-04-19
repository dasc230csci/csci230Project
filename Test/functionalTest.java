/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controller.AccountDBController;
import Controller.UniversityDBController;
import Controller.UniversityController;
import Controller.AccountController;
import Controller.LoginController;
import Controller.AdminFuncController;
import Entity.User;
import Entity.Account;
import Entity.University;

/**
 * @author sjhalloran
 *
 */
public class functionalTest {

 private AccountDBController controller;
 private AccountController Acontroller;
 private UniversityDBController universitydbController;
 private UniversityController uniController;
 private AdminFuncController adminCon;
 private ArrayList<String> emphases;
 private University editUniTest;
 
 @Before
 public void setUp(){
 controller = new AccountDBController();
 Acontroller = new AccountController();
 adminCon = new AdminFuncController();
 uniController = new UniversityController();
 universitydbController = new UniversityDBController();
 //edited University info
 ArrayList<String> emphases = new ArrayList<String>();
 emphases.add(0, "English");
 emphases.add(1, "Science"); 
 editUniTest = new University("editTest", "testState", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0,  0, 0, emphases);
 }
 @Test
 public void viewUniDetailTest() {
   University test = uniController.getUniversityInDetailed("BARD");
   assertTrue(test instanceof University);
   assertTrue(test.getSchoolName().equals("BARD"));
   universitydbController.deleteUniversity("editTest");
 }
 
 @Test
 public void editUniversityTest(){
  universitydbController.addUniversity(editUniTest);
  University Test = universitydbController.getUniversity("editTest");
  assertTrue(Test instanceof University);
  assertTrue(Test.getSchoolName().equals("editTest"));
  ArrayList<String> schoolInfo = new ArrayList<String>(); 
  ArrayList<String> emphases = new ArrayList<String>();
  emphases.add(0, "English");
  emphases.add(1, "Science");
  schoolInfo.add(0, "editTest");
  schoolInfo.add(1,"testStateUPDATE");
  schoolInfo.add(2, "testLocUPDATE");
  schoolInfo.add(3, "testControl");
  schoolInfo.add(4, "0");
  schoolInfo.add(5, "0.0");
  schoolInfo.add(6, "0.0");
  schoolInfo.add(7, "0.0");
  schoolInfo.add(8, "0.0");
  schoolInfo.add(9, "0.0");
  schoolInfo.add(10, "0");
  schoolInfo.add(11, "0.0");
  schoolInfo.add(12, "0.0");
  schoolInfo.add(13, "0");
  schoolInfo.add(14, "0");
  schoolInfo.add(15, "0");
  schoolInfo.addAll(16,emphases);
  adminCon.editUniversityInDetailed(schoolInfo);
  University test2 = universitydbController.getUniversity("editTest");
  assertTrue(test2.getState().equals("testStateUPDATE"));
  universitydbController.deleteUniversity("editTest");
 }
 
 @Test
 public void addUniversityTest(){
  ArrayList<String> schoolInfo = new ArrayList<String>(); 
  ArrayList<String> emphases = new ArrayList<String>();
  emphases.add(0, "English");
  emphases.add(1, "Science");
  schoolInfo.add(0, "addTest");
  schoolInfo.add(1,"testStateUPDATE");
  schoolInfo.add(2, "testLocUPDATE");
  schoolInfo.add(3, "testControl");
  schoolInfo.add(4, "0");
  schoolInfo.add(5, "0.0");
  schoolInfo.add(6, "0.0");
  schoolInfo.add(7, "0.0");
  schoolInfo.add(8, "0.0");
  schoolInfo.add(9, "0.0");
  schoolInfo.add(10, "0");
  schoolInfo.add(11, "0.0");
  schoolInfo.add(12, "0.0");
  schoolInfo.add(13, "0");
  schoolInfo.add(14, "0");
  schoolInfo.add(15, "0");
  schoolInfo.addAll(16,emphases);
  adminCon.addUniversity(schoolInfo);
  University test = universitydbController.getUniversity("addTest");
  assertTrue(test instanceof University);
  assertTrue(test.getSchoolName().equals("addTest"));
  assertFalse(adminCon.addUniversity(schoolInfo));//should fail becuase school has already been added
  universitydbController.deleteUniversity("addTest");
 }
 
 @Test
 public void addUserTest(){
  Account addUser = new Account("addUser", "addUserl", "addUseru", "password", "u", "N", true);
  boolean test = adminCon.createUser(addUser.getFirstName(), addUser.getLastName(), addUser.getUsername(), addUser.getPassword(), "u", "N");
  assertTrue(test);
  assertTrue(controller.getAccount("addUseru") instanceof Account);
  assertTrue(controller.getAccount("addUseru").getFirstName().equals("addUser"));
  controller.deleteUser("addUseru");
 }
 
 @Test
 public void editUserInfoTest(){
  Account addUser = new Account("addUser", "addUserl", "addUseru", "password", "u", "N", true);
  controller.addAccount(addUser);
  assertTrue(controller.getAccount("addUseru").getLastName().equals("addUserl"));
  //the user elicts to change their last name to addUserlUPDATE
  adminCon.editUserProfile(addUser.getFirstName(), "addUserlUPDATE", addUser.getUsername(), addUser.getPassword(), "u", "N");
  assertTrue(controller.getAccount("addUseru").getLastName().equals("addUserlUPDATE"));
 }
 
 @Test
 public void deactivateUserTest(){
  Account deAddUser = new Account("deAddUser", "deAddUserl", "deAddUseru", "password", "u", "N", true);
  controller.addAccount(deAddUser);
  assertTrue(controller.getAccount("deAddUseru").getLastName().equals("deAddUserl"));
  boolean deactivated = adminCon.deactivateUser("deAddUseru");
  assertTrue(deactivated);
 }
 
}
