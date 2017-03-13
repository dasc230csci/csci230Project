package Entity;

/**
 * This is Admin entity class which contains information of admin
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */



public class Admin extends Account{

   /**
     * Admin Constructor sets all the basic information
     * Call constructor of the superclass Account
     * 
     * @param firstname first name of the user
     * @param lastname last name of the user
     * @param username user name of the user
     * @param password password of the user
     * @param status status of the user whether the account is activated or not
     * @param loggedIn status of the user whether the account is loggedIn
	 */
	public Admin(String firstname, String lastname, String username, String password, String status,
			boolean loggedIn){
		super(firstname, lastname, username, password, "a", status, loggedIn);
	}
}
