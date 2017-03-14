package Controller;

import java.util.ArrayList;

import Entity.Account;
import Entity.User;
import dblibrary.project.csci230.UniversityDBLibrary;


/**
 * This class is for managing DB which it enables to update, add, get information of
 * User or University
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Mar 4, 2017
 */
public class AccountDBController {
	
	/**
	 * University Database
	 */
	private UniversityDBLibrary dblib;
	
	public AccountDBController(){
		dblib = new UniversityDBLibrary("dasc","dasc","csci230");
	}
	//////////////////////////////////////////////////////////////////// leave for testing
	public UniversityDBLibrary getdblib(){
		return dblib;
	}
	public void deleteUser(String username){
		ArrayList<String> oldList = getAccount(username).getSavedSchool();
		for(int i=0; i < oldList.size(); i++){
			dblib.user_removeSchool(username, oldList.get(i));
		}
		dblib.user_deleteUser(username);
	}
//////////////////////////////////////////////////////////////////
	
	/**
	  * Obtain Account object from the database
	  * Searching by username
	  * 
	  * @param name username of the user
	  * @return corresponding Account object
	  */
	public User getAccount(String username){
		String[][] account = dblib.user_getUsers();
		String[][] savedSchool = dblib.user_getUsernamesWithSavedSchools();
		User user = null;
		
		for(int i =0; i < account.length ;i++){
			if(account[i][2].equals(username)){
				user = new User(account[i][0], account[i][1], account[i][2], account[i][3], account[i][5],false);
			}
		}
		for(int i =0 ; i< savedSchool.length; i++){
			if(savedSchool[i][0].equals(user.getUsername())){
				user.addSavedSchool(savedSchool[i][1]);
			}
		}
		return user;
	}
	
	/**
	  * Update Account information and store in DB
	  * 
	  * @param account Account objects that had been updated
	  * @return true if the Account information can be updated
	  */
	public boolean updateAccount(Account account){
		int failed = dblib.user_editUser(account.getUsername(), account.getFirstName(), account.getLastName(), account.getPassword(), 
				account.getType().charAt(0), account.getStatus().charAt(0));
		if(failed != -1){
			return true;
		}
		else
			return false;
	}
	
	/**
	  * Update user information and store in DB
	  * 
	  * @param account Account objects that had been updated
	  * @return true if the Account information can be updated
	  */
	public boolean updateUser(User user){
		int failed = dblib.user_editUser(user.getUsername(), user.getFirstName(), user.getLastName(), user.getPassword(), 
				user.getType().charAt(0), user.getStatus().charAt(0));
		ArrayList<String> oldSchoolList = getAccount(user.getUsername()).getSavedSchool();
		ArrayList<String> newSchoolList = user.getSavedSchool();
		for(int i =0; i < oldSchoolList.size(); i++){
			dblib.user_removeSchool(user.getUsername(), oldSchoolList.get(i));
		}
		for(int i =0; i < newSchoolList.size(); i++){
			dblib.user_saveSchool(user.getUsername(), newSchoolList.get(i));
		}
		if(failed != -1){
			return true;
		}
		else
			return false;
	}
	
	/**
	  * Add new Account information and store in DB
	  * 
	  * @param account Account objects that had been added
	  * @return true if the Account information can be added
	  */
	public boolean addAccount(Account account){
		int failed = dblib.user_addUser(account.getFirstName(), account.getLastName(), account.getUsername(), 
				account.getPassword(), account.getType().charAt(0));
		if(failed != -1){
			return true;
		}
		return false;
	}
	
	/**
	  * Add new User information and store in DB
	  * 
	  * @param account Account objects that had been added
	  * @return true if the Account information can be added
	  */
	public boolean addUser(User user){
		int failed = dblib.user_addUser(user.getFirstName(), user.getLastName(), user.getUsername(), 
				user.getPassword(), user.getType().charAt(0));
		for(int i =0; i < user.getSavedSchool().size() ; i++){
			dblib.user_saveSchool(user.getUsername(), user.getSavedSchool().get(i));
		}
		if(failed != -1){
			return true;
		}
		return false;
	}
}
