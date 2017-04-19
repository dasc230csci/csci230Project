package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Controller.AccountController;
import Controller.AccountDBController;
import Entity.Account;
import Entity.User;
import dblibrary.project.csci230.UniversityDBLibrary;


public class AccountControllerTest {
 private AccountController ac;
 private AccountDBController controller;
 private UniversityDBLibrary dblib;
 @Before
 public void setUp() throws Exception {
  ac = new AccountController();
  controller = new AccountDBController();
  dblib = new UniversityDBLibrary("dasc","dasc","csci230");
  dblib.user_deleteUser("irahal");
  dblib.user_deleteUser("testNew");
 }

 @Test
 public void testCreateAccount_ValidCaseUser(){
  ac.createAccount("imad", "rahal", "irahal", "p", "u", "Y");
  User newUser = ac.getUserInfo("irahal");
  Assert.assertTrue("the newUser user name is "+newUser.getUsername(), newUser.getUsername().equals("irahal"));
  Assert.assertTrue("the newUser first name is "+newUser.getFirstName(), newUser.getFirstName().equals("imad"));
  Assert.assertTrue("the newUser last name is "+newUser.getLastName(), newUser.getLastName().equals("rahal"));
  Assert.assertTrue("the newUser password is "+newUser.getPassword(), newUser.getPassword().equals("p"));
  Assert.assertTrue("the newUser type is "+newUser.getType(), newUser.getType().equals("u"));
  Assert.assertTrue("the newUser status is "+newUser.getStatus(), newUser.getStatus().equals("Y"));
 }

 @Test
 public void testCreateAccount_ValidCaseAccount(){
  ac.createAccount("test", "test", "testNew", "p", "a", "Y");
  Account newAccount = ac.getAccountInfo("testNew");
  Assert.assertTrue("the account user name is "+newAccount.getUsername(), newAccount.getUsername().equals("testNew"));
  Assert.assertTrue("the account first name is "+newAccount.getFirstName(), newAccount.getFirstName().equals("test"));
  Assert.assertTrue("the account last name is "+newAccount.getLastName(), newAccount.getLastName().equals("test"));
  Assert.assertTrue("the account password is "+newAccount.getPassword(), newAccount.getPassword().equals("p"));
  Assert.assertTrue("the account type is "+newAccount.getType(), newAccount.getType().equals("a"));
  Assert.assertTrue("the account status is "+newAccount.getStatus(), newAccount.getStatus().equals("Y"));
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testCreateAccount_InvalidCase(){
  ac.createAccount("test", "test", "dsong", "test", "a", "Y");
 }

 @Test
 public void testAdminEditProfile_ValidCaseEditUser() {
  ac.adminEditProfile("daniel2", "song2", "dsong", "pass", "a", "Y");
  Account newUser = ac.getAccountInfo("dsong");
  Assert.assertTrue("the newUser user name is "+newUser.getUsername(), newUser.getUsername().equals("dsong"));
  Assert.assertTrue("the newUser first name is "+newUser.getFirstName(), newUser.getFirstName().equals("daniel2"));
  Assert.assertTrue("the newUser last name is "+newUser.getLastName(), newUser.getLastName().equals("song2"));
  Assert.assertTrue("the newUser password is "+newUser.getPassword(), newUser.getPassword().equals("pass"));
  Assert.assertTrue("the newUser type is "+newUser.getType(), newUser.getType().equals("a"));
  Assert.assertTrue("the newUser status is "+newUser.getStatus(), newUser.getStatus().equals("Y"));
 }
 
 @Test
 public void testAdminEditProfile_ValidCaseEditAdmin() {
  ac.adminEditProfile("anh", "tran", "anhtran", "pass", "a", "Y");
  Account newUser = ac.getAccountInfo("anhtran");
  Assert.assertTrue("the newUser user name is "+newUser.getUsername(), newUser.getUsername().equals("anhtran"));
  Assert.assertTrue("the newUser first name is "+newUser.getFirstName(), newUser.getFirstName().equals("anh"));
  Assert.assertTrue("the newUser last name is "+newUser.getLastName(), newUser.getLastName().equals("tran"));
  Assert.assertTrue("the newUser password is "+newUser.getPassword(), newUser.getPassword().equals("pass"));
  Assert.assertTrue("the newUser type is "+newUser.getType(), newUser.getType().equals("a"));
  Assert.assertTrue("the newUser status is "+newUser.getStatus(), newUser.getStatus().equals("Y"));
  
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAdminEditProfile_InvalidFirstName(){
  ac.adminEditProfile(null, "lastName", "username", "password", "u", "Y");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAdminEditProfile_InvalidLastName(){
  ac.adminEditProfile("firstName", null, "username", "password", "u", "Y");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAdminEditProfile_InvalidPassword(){
  ac.adminEditProfile("f", "lastName", "username", null, "u", "Y");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAdminEditProfile_InvalidType(){
  ac.adminEditProfile("f", "lastName", "username", "password", "c", "Y");
  
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAdminEditProfile_InvalidType_Case2(){
  ac.adminEditProfile("firstName", "lastName", "username", "password",null, "Y");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAdminEditProfile_InvalidStatus(){
  ac.adminEditProfile("f", "lastName", "username", "password", "u", "B");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testAdminEditProfile_InvalidStatus_Case2(){
  ac.adminEditProfile("firstName", "lastName", "username", "password","a", null);
 }

 @Test
 public void testUserEditProfile_ValidCase() {
  ac.userEditProfile("dsong", "daniel3", "song3", "pass");
  User newUser = ac.getUserInfo("dsong");
  Assert.assertTrue("the newUser user name is "+newUser.getUsername(), newUser.getUsername().equals("dsong"));
  Assert.assertTrue("the newUser first name is "+newUser.getFirstName(), newUser.getFirstName().equals("daniel3"));
  Assert.assertTrue("the newUser last name is "+newUser.getLastName(), newUser.getLastName().equals("song3"));
  Assert.assertTrue("the newUser password is "+newUser.getPassword(), newUser.getPassword().equals("pass"));
  ac.userEditProfile("dsong", "daniel", "song", "p");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testUserEditProfile_InvalidFirstName(){
  ac.userEditProfile("dsong", null, "username", "password");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testUserEditProfile_InvalidLastName(){
  ac.userEditProfile("dsong", "son", null, "password");
 }
 
 @Test(expected=IllegalArgumentException.class)
 public void testUserEditProfile_InvalidPassword(){
  ac.userEditProfile("dsong", "null", "username", null);
 }

 @Test
 public void testDeactivateAccount() {
  ac.deactivateAccount("dsong");
  assertTrue("the username dsong is deactivate", controller.getAccount("dsong").getStatus().equals("N"));
  controller.reactivateAccount("dsong");
 }

 @Test
 public void testVerifyAccount() {
  assertTrue("the account is an "+ac.verifyAccount("dsong", "p"), ac.verifyAccount("dsong", "p").equals("a"));
 }

 @Test
 public void testGetUserInfo() {
  User newUser = ac.getUserInfo("jcena");
  Assert.assertTrue("the newUser user name is "+newUser.getUsername(), newUser.getUsername().equals("jcena"));
  Assert.assertTrue("the newUser first name is "+newUser.getFirstName(), newUser.getFirstName().equals("john"));
  Assert.assertTrue("the newUser last name is "+newUser.getLastName(), newUser.getLastName().equals("cena"));
  Assert.assertTrue("the newUser password is "+newUser.getPassword(), newUser.getPassword().equals("password"));
  Assert.assertTrue("the newUser type is "+newUser.getType(), newUser.getType().equals("u"));
  Assert.assertTrue("the newUser status is "+newUser.getStatus(), newUser.getStatus().equals("Y"));
 }

 @Test
 public void testGetAccountInfo() {
  Account newAccount = ac.getAccountInfo("anhtran");
  Assert.assertTrue("the account user name is "+newAccount.getUsername(), newAccount.getUsername().equals("anhtran"));
  Assert.assertTrue("the account first name is "+newAccount.getFirstName(), newAccount.getFirstName().equals("anh"));
  Assert.assertTrue("the account last name is "+newAccount.getLastName(), newAccount.getLastName().equals("tran"));
  Assert.assertTrue("the account password is "+newAccount.getPassword(), newAccount.getPassword().equals("pass"));
  Assert.assertTrue("the account type is "+newAccount.getType(), newAccount.getType().equals("a"));
  Assert.assertTrue("the account status is "+newAccount.getStatus(), newAccount.getStatus().equals("Y"));
 }

 @Test
 public void testGetAccountList() {
  ArrayList<Account> list = new ArrayList<>();
  list = ac.getAccountList();
  int listSize= list.size();
  assertTrue("the list has " + list.size(),listSize==12);
 }

 @Test
 public void testSaveSchool() {
  ac.saveSchool("dsong", "BARD");
  User dsong = controller.getUser("dsong");
  assertTrue("the user saved school is BARD", dsong.getSavedSchool().get(0).equals("BARD"));
 }

 @Test
 public void testRemoveSavedSchool() {
  ac.removeSavedSchool("dsong", "BARD");
  User dsong = controller.getUser("dsong");
  ArrayList<String> savedSchool = dsong.getSavedSchool();
  assertTrue("the user saved school BARD has been removed", savedSchool.isEmpty());
 }

}
