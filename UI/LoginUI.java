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
  * Verifying whether the user is valid to access
  * 
  * @param name username of the user
  * @param password of the user
  * @return true if successfully verified
  */
 public boolean verifyUser(String username, String password){
	 //method needs to take user login info parameters to pass along to LoginController method
	 this.loginController = new LoginController();
	 boolean verify = this.loginController.verifyUser(username, password);
	 if (verify)
		 return true;
	 return false;
 }
}