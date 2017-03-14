package Controller;

import java.util.ArrayList;
import Entity.Account;
import dblibrary.project.csci230.UniversityDBLibrary;

/**
 * This is AccountController controller class which enable functionalities such as 
 * edit, add, create, remove, and update the Account
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */
public class AccountController {
	
	/**
	 * Account account which contains information of account
	 */
	private Account account;
	
	/**
	 * DBController dbController which enable access to the database to obtain
	 * or update information of Account
	 */
	private DBController dbController;
	
	//need UniversityDBLibrary to call methods from the given DB libray class
	private UniverysityDBLibrary dbLibrary;
	
	/**
	 * Default Constructor
	 */
	public AccountController(){
		this.dbController = new DBController();
	}
	
	/**
	 * Account constructor which has Account object to edit information
	 * @param account to edit information
	 */
	public AccountController(Account account){
		this.account = account;
		this.dbController = new DBController();
	}
	
	/**
	 * Method that create new Account with specified information
	 * and save into database
	 * 
	 * @param firstname first name of the user
	 * @param lastname last name of the user
	 * @param username user name of the user
	 * @param password password of the user
	 * @param type type of the account: "a" for admin and "u" for user
	 * @param status status of the user whether the account is activated or not
	 * @return true if successfully create new Account
	 */
	public boolean createAccount(String firstName, String lastName, String userName, String password, String type, String status){
		return false;
	}
	
	/**
	 * Method that editProfile for Admin
	 * Enable edit profile with specified information and save into database
	 * @param firstname first name of the user
	 * @param lastname last name of the user
	 * @param username user name of the user
	 * @param password password of the user
	 * @param type type of the account: "a" for admin and "u" for user
	 * @param status status of the user whether the account is activated or not
	 * @return true if successfully edit profile
	 */
	public boolean adminEditProfile(String firstName, String lastName, String passWord, String type, String status){
		return false;
	}
	
	/**
	 * Method that editProfile for User
	 * Enable edit profile with specified information and save into database
	 * @param firstname first name of the user
	 * @param lastname last name of the user
	 * @param username user name of the user
	 * @param password password of the user
	 * @return true if successfully edit profile
	 */
	public boolean userEditProfile(String firstName, String lastName, String password){
		return false;
	}
	
	/**
	 * Method that deactivate Account
	 * Set status of the Account with "N" which means deactivated
	 * @param username username of the Account to deactivate
	 * @return true if successfully edit profile
	 */
	public boolean deactivateAccount(String username){
		return false;
	}
	
	/**
	 * Method that reset information of the Account before edit
	 * @param username username of the Account to reset
	 * @return Account which contains information of the user
	 */
	public Account resetAccountInfo(String username){
		return null;
	}
	
	/**
	 * Method that verify information of the Account
	 * Access to the database for verification 
	 * @param username username of the Account to verify
	 * @param password password of the Account to verify
	 * @return true if Account is valid to access
	 */
	public boolean verifyAccount(String username, String password){
		return false;
	}
	
	/**
	 * Method that return the specific Account object from database
	 * @param username username of the Account to get
	 * @return Account object returned from database
	 */
	public Account getAccountInfo(String username){
		return null;
	}
	
	/**
	 * Method that get all the users in database for admin
	 * @return ArrayList<String> list of all users in database
	 */
	public ArrayList<String> getUsernameList(){
		return null;
	}
	
	/**
	 * Method that enable users to save(add) school in user's school list
	 * @param schoolName name of the school want to save(add)
	 * @return true if successfully saved
	 */
	public boolean saveSchool(String schoolName){
		return false;
	}
	
	/**
	 * Method that enable users to remove school in user's school list
	 * @param schoolName name of the school want to remove
	 * @return true if successfully removed
	 */
	public boolean removeSavedSchool(String schoolName){
		return false;
	}
}
