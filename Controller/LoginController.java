package Controller;

/**
 * This is LoginController controller class which manage account loggingin
 * Method used in subclass, Admin and User
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */
public class LoginController {
	/**
	 * AccountControllor which loginController call method in accountController
	 * in order to verify account
	 */
	 private AccountController accountController;
	 
	 private AccountDBController accountDBController;
	 
	 /**
	  * Default Constructor. Initialize AccountController.
	  */
	 public LoginController(){
		 this.accountController = new AccountController();
	 }
	 
	 /**
	  * Obtain information from UserUI in order to verify validity of user
	  * Pass information to accountController to access to DB
	  * 
	  * @param name username of the user
	  * @param password of the user
	  * @return String type of the user. "isFailed" return if invalid username or password
	  */
	 public String verifyUser(String username, String password){
		 String verify = this.accountController.verifyAccount(username, password);
		 return verify; 
	 }
	 
	 /**
	  * Logs User out of CMC system
	  * returns true if user is successfully logged out
	  * User must first be logged in to logout
	  * 
	  * @return boolean to determine if user is logged out
	  */
	 public boolean logOff(String userName){
		 boolean status = accountDBController.getAccount(userName).getLoggedIn();
		 if (status == true){
			 accountDBController.getAccount(userName).setLoggedIn(false);
			 return true;
		 }
		 else{
			 return false;
		 }
		 }
	 }
