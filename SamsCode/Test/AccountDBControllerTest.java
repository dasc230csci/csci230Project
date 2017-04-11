package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controller.AccountDBController;
import Entity.Account;
import Entity.User;

public class AccountDBControllerTest {
  private AccountDBController controller;

  @Before
  public void setUp() throws Exception {
   controller = new AccountDBController();
   Account useru = new Account("userf", "userl", "useru", "password", "u", "N", true);
   controller.addAccount(useru);
   ArrayList<Account> list = controller.getAccountList();
   for(int i=0; i <list.size(); i++){
    System.out.println(list.get(i).getUsername()+"/");
    }
  }

  @Test
  public void testUpdateAccount() {
   Account user = controller.getAccount("useru");
   user.setFirstName("userfEdit");
   controller.updateAccount(user);
   assertTrue("the user first name is userf", user.getFirstName().equals("userfEdit"));
   assertTrue("the user last name is userl", user.getLastName().equals("userl"));
   assertTrue("the user user name is useru", user.getUsername().equals("useru"));
   assertTrue("the user password is password", user.getPassword().equals("password"));
   assertTrue("the user type is u", user.getType().equals("u"));
   assertTrue("the user status is N", user.getStatus().equals("N"));
   Account userTest = controller.getAccount("useru");
   userTest.setFirstName("userf");
   controller.updateAccount(userTest);
   assertTrue("the user first name is userf", userTest.getFirstName().equals("userf"));
   assertTrue("the user last name is userl", userTest.getLastName().equals("userl"));
   assertTrue("the user user name is useru", userTest.getUsername().equals("useru"));
   assertTrue("the user password is password", userTest.getPassword().equals("password"));
   assertTrue("the user type is u", userTest.getType().equals("u"));
   assertTrue("the user status is N", userTest.getStatus().equals("N"));
  }

  @Test
  public void testGetUser_NoSavedSchool() {
   Account caitlin = controller.getAccount("caitlinharvey");
   assertTrue("the user first name is caitlin", caitlin.getFirstName().equals("Caitlin"));
   assertTrue("the user last name is harvey", caitlin.getLastName().equals("Harvey"));
   assertTrue("the user user name is caitlinharvey", caitlin.getUsername().equals("caitlinharvey"));
   assertTrue("the user password is somelamepassword", caitlin.getPassword().equals("somelamepassword"));
   assertTrue("the user type is u", caitlin.getType().equals("u"));
   assertTrue("the user status is Y", caitlin.getStatus().equals("Y"));
  }
  
  @Test
  public void testGetUser_WithSavedSchool(){
   User user = controller.getUser("useru");
   assertTrue("the user first name is userf", user.getFirstName().equals("userf"));
   assertTrue("the user last name is userl", user.getLastName().equals("userl"));
   assertTrue("the user user name is useru", user.getUsername().equals("useru"));
   assertTrue("the user password is password", user.getPassword().equals("password"));
   assertTrue("the user type is u", user.getType().equals("u"));
   assertTrue("the user status is N", user.getStatus().equals("N"));
   assertTrue("the user saved school is BARD", user.getSavedSchool().get(0).equals("BARD"));
  }

  @Test
  public void testGetAccount() {
   Account user= controller.getAccount("useru");
   assertTrue("the user first name is"+ user.getFirstName(), user.getFirstName().equals("userf"));
   assertTrue("the user last name is userl", user.getLastName().equals("userl"));
   assertTrue("the user user name is useru", user.getUsername().equals("useru"));
   assertTrue("the user password is password", user.getPassword().equals("password"));
   assertTrue("the user type is u", user.getType().equals("u"));
   assertTrue("the user status is N", user.getStatus().equals("N"));
  }

  @Test
  public void testAddAccount() {
   Account testAccount = new Account ("anh", "tran", "anhtran", "password", "a", "Y", true);
   User testUser = new User("Caitlin", "Harvey", "caitlinharvey", "somelamepassword", "Y", true);
   controller.addAccount(testAccount);
   controller.addAccount(testUser);
   Account anh = controller.getAccount("anhtran");
   assertTrue("the user first name is anh", anh.getFirstName().equals("anh"));
   assertTrue("the user last name is tran", anh.getLastName().equals("tran"));
   assertTrue("the user user name is anhtran", anh.getUsername().equals("anhtran"));
   assertTrue("the user password is password", anh.getPassword().equals("pass"));
   assertTrue("the user type is a", anh.getType().equals("a"));
   assertTrue("the user status is Y", anh.getStatus().equals("Y"));
  }

  @Test
  public void testGetAccountList() {
   ArrayList<Account> list = new ArrayList<>();
   list = controller.getAccountList();
   assertTrue("the list has " + list.size(),list.size()==15);
  }

  @Test
  public void testDeactivateAccount_ActiveAccount() {
   controller.deactivateAccount("caitlinharvey");
   assertTrue("the username caitlinharvey is deactivate", controller.getAccount("caitlinharvey").getStatus().equals("N"));
   controller.reactivateAccount("caitlinharvey");
  }
  
  @Test
  public void testDeactivateAccount_InActiveAccount() {
   controller.deactivateAccount("useru");
   assertTrue("the username useru is deactivate", controller.getAccount("useru").getStatus().equals("N"));
  }

  @Test
  public void testSaveSchool_UserwithNoSavedSchool() {
   controller.saveSchool("juser", "BARD");
   User juser = controller.getUser("juser");
   assertTrue("the user saved school is BARD", juser.getSavedSchool().get(0).equals("BARD"));
  }
  
  @Test
  public void testSaveSchool_UserwithSavedSchool() {
   controller.saveSchool("useru", "ST JOHNS UNIVERSITY");
   User user = controller.getUser("useru");
   assertTrue("the user saved schools are BARD and SAINT JOHN", user.getSavedSchool().get(0).equals("BARD"));
   assertTrue("the user saved schools are BARD and SAINT JOHN", user.getSavedSchool().get(1).equals("ST JOHNS UNIVERSITY"));
   controller.removeSavedSchool("useru", "ST JOHNS UNIVERSITY");
  }

  @Test
  public void testRemoveSavedSchool() {
   controller.removeSavedSchool("juser", "BARD");
   User juser = controller.getUser("juser");
   ArrayList<String> savedSchool = juser.getSavedSchool();
   assertTrue("the user saved school BARD has been removed", savedSchool.isEmpty());
  }

 }

