package Entity;

import java.util.ArrayList;

/**
 * This is User entity class which contains information of user
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */

public class User extends Account{
	
	/**
	 * List of School name that user has been saved
	 */
	private ArrayList<String> savedSchool;
	
	/**
	 * User Constructor sets all the basic information
     * Call constructor of the superclass Account
	 * 
	 * @param firstname first name of the user
	 * @param lastname last name of the user
	 * @param username user name of the user
	 * @param password password of the user
	 * @param status status of the user whether the account is activated or not
	 * @param loggedIn status of the user whether the account is loggedIn
	 */
	public User(String firstname, String lastname, String username, String password, String status,
			boolean loggedIn) {
		super(firstname, lastname, username, password, "u", status, loggedIn);
		savedSchool = new ArrayList<String>();
	}
	
	/**
	 * Method which will return list of saved school of user
	 * 
	 * @return list of savedSchool of user
	 */
	public ArrayList<String> getSavedSchool(){
		return this.savedSchool;
	}
	
	/**
	 * Method which will add name of the school to the school list
	 * 
	 * @param schoolName name of the school to add
	 * @return true if successfully add school to the list
	 */
	public boolean addSavedSchool(String schoolName){
		savedSchool.add(schoolName);
		return false;
	}
	
	/**
	 * Method which will remove name of the school from the school list
	 * 
	 * @param schoolName name of the school to remove
	 * @return true if successfully remove school from the list
	 */
	public boolean removeSavedSchool(String schoolName){
		savedSchool.remove(schoolName);
		return false;
	}
}
