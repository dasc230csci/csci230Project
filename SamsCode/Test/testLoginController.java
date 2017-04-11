package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.LoginController;


public class testLoginController {

 private LoginController loginController; 
 
 @Before
 public void setUp() throws Exception {
  this.loginController = new LoginController();
 }

 @Test
 public void testLoginController() {
  assertTrue(loginController instanceof LoginController);
 }

 @Test
 public void testVerifyUserCase1() {
  //Case 1: Valid UN & Valid PW
  assertTrue(this.loginController.verifyUser("userun", "userpw").equals("u"));
 }
 
 @Test
 public void testVerifyUserCase2() {
  //Case 2: Valid UN & Invalid PW
  assertTrue(loginController.verifyUser("userun", "userpwwww").equals("failed"));
 }
 
 @Test(expected=NullPointerException.class)
 public void testVerifyUserCase3() {
  //Case 3: Invalid UN & Valid PW
  this.loginController.verifyUser("useruuuu", "userpw");
 }
 
 @Test(expected=NullPointerException.class)
 public void testVerifyUserCase4() {
  //Case 4: Invalid UN & Invalid PW
  this.loginController.verifyUser("useruuuu", "userpwwww");
 }

}