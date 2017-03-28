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
		 if(verify == null){
			 verify = "isFailed";
		 }
		 return verify; 
	 }
}