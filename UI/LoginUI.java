package UI;

import Controller.LoginController;

/**
 * File: LoginUI.java
 */

/**
 * Class to represent the Login UI.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */
public class LoginUI {
 
 /**
  * LoginController to control login of user
  */
 private LoginController loginController;
 
 /**
  * Default Constructor that initialize loginController
  */
 public LoginUI(){
	 this.loginController = new LoginController();
 }
 
 /**
  * Verifying whether the user is valid to access
  * 
  * @param name username of the user
  * @param password of the user
  * @return String type of the user. "isFailed" return if invalid username or password
  */
 public String verifyUser(String username, String password){
	 //method needs to take user login info parameters to pass along to LoginController method
	 String verify = this.loginController.verifyUser(username, password);
	 return verify;
 }
}