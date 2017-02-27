package Controller;

import java.util.ArrayList;
import Entity.*;

/**
 * This class is for managing DB which it enables to update, add, get information of
 * User or University
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */
public class DBController {
	private University university;
	private Account account;
	
	/**
	  * Default Constructor
	  */
	public DBController(){
	}
	
	/**
	  * Obtain University object from the database
	  * Searching by name of the school
	  * 
	  * @param schoolName name of the school
	  * @return corresponding University object
	  */
	public University getUniversity(String schoolName){
		return null;
	}
	
	/**
	  * Obtain Account object from the database
	  * Searching by username
	  * 
	  * @param name username of the user
	  * @return corresponding Account object
	  */
	public Account getAccount(String username){
		return null;
	}
	
	/**
	  * Update University information and store in DB
	  * 
	  * @param university University objects that had been updated
	  * @return true if the information can be updated
	  */
	public boolean updateUniversity(University university){
		return false;
	}

	/**
	  * Add new University in DB
	  * 
	  * @param university University objects that had been added
	  * @return true if the University can be added
	  */
	public boolean addUniversity(University university){
		return false;
	}

	/**
	  * Update Account information and store in DB
	  * 
	  * @param account Account objects that had been updated
	  * @return true if the Account information can be updated
	  */
	public boolean updateAccount(Account account){
		return false;
	}

	/**
	  * Search the university with the criteria that user input the information
	  * 
	  * @param schoolInfo ArrayList<String> that user want to search
	  * @return list of name of school within criteria that user input
	  */
	public ArrayList<String> search(ArrayList<String> schoolInfo){
		return null;
	}
	
	/**
	  *not completed
	  */
	public ArrayList<University> searchRecommendation(University university){
		return null;
	}
	
	/**
	  * Add new Account information and store in DB
	  * 
	  * @param account Account objects that had been added
	  * @return true if the Account information can be added
	  */
	public boolean addAccount(Account account){
		return false;
	}


}
