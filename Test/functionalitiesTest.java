/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import UI.*;
import Controller.*;
import Entity.*;

/**
 * @author sjhalloran
 *
 */

public class functionalitiesTest {

 private UserFuncController userFuncController1;
 private UserUI userUI1;
 private UserUI userUI2;
 private UserUI userUI3;
 private AdminUI adminui; 
 private AdminUI adminUI;
 private AccountController accountController1;
 private AccountDBController accountDBController1;
 private AdminFuncController adminFuncController1;
 private LoginController loginController1;
 private LoginUI loginUI1;
 private UniversityController uniController1;
 private UniversityDBController universitydbController1;
 private ArrayList<String> emphases1;
 private University editUniTest1;
 /**
  * @throws java.lang.Exception
  */
 @Before
 public void setUp() throws Exception {
   userUI1 = new UserUI("juser");
   userUI2 = new UserUI("luser");
   userUI3 = new UserUI("jcena");
   userFuncController1 = new UserFuncController();
   accountController1 = new AccountController();
   adminFuncController1 = new AdminFuncController();
   accountDBController1 = new AccountDBController();
   adminui = new AdminUI("nadmin");
   adminUI = new AdminUI("anhtran"); 
   uniController1 = new UniversityController();
   universitydbController1 = new UniversityDBController();
   loginUI1 = new LoginUI();
   loginController1 = new LoginController();
   ArrayList<String> emphases1 = new ArrayList<String>();
   emphases1.add(0, "English");
   emphases1.add(1, "Science"); 
   editUniTest1 = new University("editTest", "testState", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0,  0, 0, emphases1);

 }

 @Test
 public void testUserUISaveUniversity() {
  assertTrue(this.userUI1.saveUniversity("BARD"));
  userUI1.removeSavedUniversity("BARD");
 }
 
 @Test
 public void testUserFuncControllerSaveSchool() {
  assertTrue(this.userFuncController1.saveSchool("juser", "HARVARD"));
  userUI1.removeSavedUniversity("HARVARD");
 }
 
 @Test
 public void testAccoutControllerSaveSchool() {
  assertTrue(this.accountController1.saveSchool("juser", "BARNARD"));
  userUI1.removeSavedUniversity("BARNARD");
 }
 
 @Test
 public void testAccoutDBControllerSaveSchool() {
  assertTrue(this.accountDBController1.saveSchool("juser", "BROWN"));
  userUI1.removeSavedUniversity("BROWN");
 }
 /////////////////////////////////////////////////////////////////
 
 @Test
 public void testAdminUIViewAllUser() {
  assertTrue(this.adminui.viewAllUser() instanceof ArrayList);
 }

 @Test
 public void testAdminFuncControllerViewAllUser() {
  assertTrue(this.adminFuncController1.viewAllUser() instanceof ArrayList);
 }
 
 @Test
 public void testAccountControllerGetAccountList() {
  assertTrue(this.accountController1.getAccountList() instanceof ArrayList);
 }
 
 @Test
 public void testAccountDBControllerGetAcccountList() {
  assertTrue(this.accountDBController1.getAccountList() instanceof ArrayList);
 }
 ///////////////////////////////////////////////////////////////////
 
 @Test
 public void testLoginUIVerifyUser() {
  assertTrue(this.loginUI1.verifyUser("juser", "user").equals("u"));
 }
 
 @Test
 public void testLoginControllerVerifyUser() {
  assertTrue(this.loginController1.verifyUser("juser", "user").equals("u"));
 }
 
 @Test
 public void testAccountControllerVerifyAccount() {
  assertTrue(this.accountController1.verifyAccount("juser", "user").equals("u"));
 }
 /////////////////////////////////////////////////////////////////////
 
 @Test
 public void testAccountDBControllerGetUser() {
  assertTrue(this.accountDBController1.getAccount("juser") instanceof Account);
 }
 
 @Test
 public void testAbnormalCaseWrongPassword() {
  assertTrue(this.loginUI1.verifyUser("juser", "wrongpass").equals("failed"));
 }
 
 @Test(expected=NullPointerException.class)
 public void testAbnormalCaseWrongUsername() {
  this.loginUI1.verifyUser("wronguser", "wrongpass");
 }
 /////////////////////////////////////////////////////////////////////////
 
 @Test
 public void testUserUILogOff() {
  assertTrue(this.userUI2.logOff());
 }

////////////////////////////////////////////////////////////
 
 @Test
 public void testViewSavedSchool() {
  userUI3.saveUniversity("BARD");
  ArrayList<String> schoolList = userUI3.viewSavedSchool();
  assertTrue("the user save school is BARD", schoolList.get(0).equals("BARD"));
 }

 @Test
 public void testViewProfile() {
  User newUser = userUI3.viewProfile();
  assertTrue("the user first name is john", newUser.getFirstName().equals("john"));
  assertTrue("the user last name is cena", newUser.getLastName().equals("cena"));
  assertTrue("the user username is jcena", newUser.getUsername().equals("jcena"));
  assertTrue("the user password is password", newUser.getPassword().equals("password"));
  assertTrue("the user type is u", newUser.getType().equals("u"));
  assertTrue("the user status is N", newUser.getStatus().equals("Y"));
 }

 @Test
 public void testEditProfile_ValidCase() {
  userUI3.editProfile("BigJohn", "The Cena", "newPassword");
  User newUser = userUI3.viewProfile();
  assertTrue("the user first name is BigJohn", newUser.getFirstName().equals("BigJohn"));
  assertTrue("the user last name is The Cena", newUser.getLastName().equals("The Cena"));
  assertTrue("the user password is newPassword", newUser.getPassword().equals("newPassword"));
  userUI3.editProfile("john", "cena", "password");
 }
 
 @Test(expected = IllegalArgumentException.class)
 public void testEditProfile_InvalidCase1() {
  userUI3.editProfile(null, "The Cena", "newPassword");
 }

 @Test(expected=IllegalArgumentException.class)
 public void testEditProfile_InvalidCase2() {
  userUI3.editProfile("null", null, "newPassword");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testEditProfile_InvalidCase3() {
  userUI3.editProfile("null", "The Cena", null);
 }

 @Test
 public void testRemoveSavedUniversity() {
  userUI3.removeSavedUniversity("BARD");
  ArrayList<String> schoolList = userUI3.viewSavedSchool();
  assertTrue("The school list is empty", schoolList.isEmpty());
 }

 @Test
 public void testViewAllUniversity() {
  ArrayList<University> university = adminUI.viewUniversityList();
  assertTrue("the list has"+university.size(), university.size()==182);
 }
 //////////////////////////////////////////////////////////////
 
 @Test
 public void testSearch(){
  ArrayList<University> list = new ArrayList<University>();
  list = userUI1.search("MINNESOTA", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
    "", "", "", "", "", "", "", "", "");
  for(University u : list){
   assertTrue("list of University should be within MINNESOTA", u.getState().equals("MINNESOTA"));
  }
 }
 @Test
 public void testSearch2(){
  ArrayList<University> list = new ArrayList<University>();
  list = userUI1.search("", "", "", "", "", "", "", "", "500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
    "", "", "", "", "", "", "", "", "");
  for(University u : list){
   assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal()>=500.0);
  }
 }
 @Test
 public void testSearch3(){
  ArrayList<University> list = new ArrayList<University>();
  list = userUI1.search("", "", "", "", "", "", "", "", "", "", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", 
    "", "", "", "", "", "", "", "", "");
  for(University u : list){
   assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
  }
 }
 
 @Test
 public void testSearch4(){
  ArrayList<University> list = new ArrayList<University>();
  list = userUI1.search("", "NEW YORK", "", "", "", "", "", "", "500", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
    "", "", "", "", "", "", "", "", "");
  for(University u : list){
   assertTrue("list of University includes NEW YORK", u.getState().equals("NEW YORK"));
   assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
  }
 }
 
 @Test
 public void testSearch5(){
  ArrayList<University> list = new ArrayList<University>();
  list = userUI1.search("", "", "", "", "", "", "", "", "500", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", "", 
    "", "", "", "", "", "", "", "", "");
  for(University u : list){
   assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
   assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
  }
 }
 
 @Test
 public void testSearch6(){
  ArrayList<University> list = new ArrayList<University>();
  list = userUI1.search("", "NEW YORK", "", "", "", "", "", "", "500", "", "", "", "", "30", "", "", "", "", "", "", "", "", "", "", 
    "", "", "", "", "", "", "", "", "");
  for(University u : list){
   assertTrue("list of University includes NEW YORK", u.getState().equals("NEW YORK"));
   assertTrue("list of University SAT_VERBAL >= 500", u.getSatVerbal() >= 500);
   assertTrue("list of University Financial Aid >=30", u.getPerFinanAid() >=30);
  }
 }
 
 @Test
 public void testViewUserProfile(){
  User u = userUI1.viewProfile();
  Account a = adminui.viewProfile();
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
  University univDetail = userUI1.viewUniversityInDetail("BARD");
  assertTrue("School Name is BARD", univDetail.getSchoolName().equals("BARD"));
  ArrayList<University> recomList = userUI1.searchRecommendation("BARD");
  //for(University u: recomList){
   //System.out.println(u.getSchoolName() + "test1");}
  assertTrue("List should contain TOURO", recomList.get(5).getSchoolName().equals("TOURO"));
  assertTrue("List should contain CLARKSON UNIVERSITY", recomList.get(1).getSchoolName().equals("CLARKSON UNIVERSITY"));
  assertTrue("List should contain VASSAR", recomList.get(2).getSchoolName().equals("VASSAR"));
  assertTrue("List should contain RENSSELAER", recomList.get(4).getSchoolName().equals("RENSSELAER"));
  assertTrue("List should contain COLLEGE OF NEWROCHELLE", recomList.get(3).getSchoolName().equals("COLLEGE OF NEWROCHELLE"));
  assertTrue("List should contain BARD", recomList.get(0).getSchoolName().equals("BARD"));
 }
 @Test
 public void testViewUniversityDetail2(){
  University univDetail = userUI1.viewUniversityInDetail("VASSAR");
  assertTrue("School Name is VASSAR", univDetail.getSchoolName().equals("VASSAR"));
  ArrayList<University> recomList = userUI1.searchRecommendation("VASSAR");
  //for(University u: recomList){
   //System.out.println(u.getSchoolName());}
  assertTrue("List should contain MANHATTANVILLE COLLEGE", recomList.get(5).getSchoolName().equals("MANHATTANVILLE COLLEGE"));
  assertTrue("List should contain CLARKSON UNIVERSITY", recomList.get(3).getSchoolName().equals("CLARKSON UNIVERSITY"));
  assertTrue("List should contain VASSAR", recomList.get(0).getSchoolName().equals("VASSAR"));
  assertTrue("List should contain RENSSELAER", recomList.get(2).getSchoolName().equals("RENSSELAER"));
  assertTrue("List should contain CONNECTICUT COLLEGE", recomList.get(4).getSchoolName().equals("CONNECTICUT COLLEGE"));
  assertTrue("List should contain BARD", recomList.get(1).getSchoolName().equals("BARD"));
 }
 /////////////////////////////////////////////////////////////////////////////////
 
 @Test
 public void viewUniDetailTest() {
   University test = uniController1.getUniversityInDetailed("BARD");
   assertTrue(test instanceof University);
   assertTrue(test.getSchoolName().equals("BARD"));
   universitydbController1.deleteUniversity("editTest");
 }
 
 @Test
 public void editUniversityTest(){
  universitydbController1.addUniversity(editUniTest1);
  University Test = universitydbController1.getUniversity("editTest");
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
  adminFuncController1.editUniversityInDetailed(schoolInfo);
  University test2 = universitydbController1.getUniversity("editTest");
  assertTrue(test2.getState().equals("testStateUPDATE"));
  universitydbController1.deleteUniversity("editTest");
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
  adminFuncController1.addUniversity(schoolInfo);
  University test = universitydbController1.getUniversity("addTest");
  assertTrue(test instanceof University);
  assertTrue(test.getSchoolName().equals("addTest"));
  assertFalse(adminFuncController1.addUniversity(schoolInfo));//should fail becuase school has already been added
  universitydbController1.deleteUniversity("addTest");
 }
 
 @Test
 public void addUserTest(){
  Account addUser = new Account("addUser", "addUserl", "addUseru1", "password", "u", "N", true);
  boolean test = adminFuncController1.createUser(addUser.getFirstName(), addUser.getLastName(), addUser.getUsername(), addUser.getPassword(), "u", "N");
  assertTrue(test);
  assertTrue(accountDBController1.getAccount("addUseru") instanceof Account);
  assertTrue(accountDBController1.getAccount("addUseru").getFirstName().equals("addUser"));
  accountDBController1.deleteUser("addUseru1");
 }
 
 @Test
 public void editUserInfoTest(){
  Account addUser = new Account("addUser", "addUserl", "addUseru", "password", "u", "N", true);
  accountDBController1.addAccount(addUser);
  System.out.println(accountDBController1.getAccount("addUseru").getLastName());
  assertTrue(accountDBController1.getAccount("addUseru").getLastName().equals("addUserlUPDATE"));
  //the user elicts to change their last name to addUserlUPDATE
  adminFuncController1.editUserProfile(addUser.getFirstName(), "addUserlUPDATE", addUser.getUsername(), addUser.getPassword(), "u", "N");
  assertTrue(accountDBController1.getAccount("addUseru").getLastName().equals("addUserlUPDATE"));
 }
 
 @Test
 public void deactivateUserTest(){
  Account deAddUser = new Account("deAddUser", "deAddUserl", "deAddUseru", "password", "u", "N", true);
  accountDBController1.addAccount(deAddUser);
  assertTrue(accountDBController1.getAccount("deAddUseru").getLastName().equals("deAddUserl"));
  boolean deactivated = accountDBController1.deleteUser("deAddUseru");
  assertTrue(deactivated);
 }

}

