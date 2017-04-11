package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controller.AccountController;
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
 public void testUserFuncController(){
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
 public void testSearch(){
  ArrayList<String> criteria = new ArrayList<String>();
  criteria.add("");// SCHOOL 0
  criteria.add("NEW YORK");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("500");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("30");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = userFuncController.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be included", u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL >= 500", u.getSatVerbal()>=500.0);
   assertTrue("Financial Aid >=30", u.getPerFinanAid() >=30);
  }
 }

 @Test
 public void testGetProfile() {
  assertTrue(this.userFuncController.getProfile("userun") instanceof User);
 }

 @Test
 public void testSearchRecommendation(){
  ArrayList<University> recomList = userFuncController.searchRecommendation("BARD");
  assertTrue("List should contain TOURO", recomList.get(5).getSchoolName().equals("TOURO"));
  assertTrue("List should contain CLARKSON UNIVERSITY", recomList.get(1).getSchoolName().equals("CLARKSON UNIVERSITY"));
  assertTrue("List should contain VASSAR", recomList.get(2).getSchoolName().equals("VASSAR"));
  assertTrue("List should contain RENSSELAER", recomList.get(4).getSchoolName().equals("RENSSELAER"));
  assertTrue("List should contain COLLEGE OF NEWROCHELLE", recomList.get(3).getSchoolName().equals("COLLEGE OF NEWROCHELLE"));
  assertTrue("List should contain BARD", recomList.get(0).getSchoolName().equals("BARD"));
 }

}