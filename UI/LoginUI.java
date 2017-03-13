package UI;

import Controller.LoginController;

/**
 * File: LoginUI.java
 */

/**
 * Class to represent the Login UI.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */
public class LoginUI {
 
 /**
  * LoginController to control login of user
  */
 private LoginController loginController;
 
 /**
  * UserUI to call the UserUI class once the system
  * identified if the person is user.
  */
 private UserUI userUI;
 
  /**
  * AdminUI to call the AdminUI class once the system
  * identified if the person is admin.
  */
 private AdminUI adminUI;
 /**
  * Verifying whether the user is valid to access
  * @return true if successfully verified
  */
 public boolean verifyUser(){
  return false;
 }
}
