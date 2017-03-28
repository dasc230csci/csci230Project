/**
 * File: UserFuncController.java
 */

package Controller;

import java.util.ArrayList;

import Entity.User;
import Entity.University;

/**
 * Controller class with functions for the User.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */
public class UserFuncController {
 
 /**
  * University controller to control university
  */
 private UniversityController universityController;
 
 /**
  * AccountController to edit profile
  */
 private AccountController accountController;
 
 /**
  * SearchController to search university
  */
 private SearchController searchController;
 
 /**
  * Creates the Controller.
  */
 public UserFuncController() {
   accountController = new AccountController();
   universityController= new UniversityController();
   searchController = new SearchController();
 }
 
 /**
  * Saves a school to User account.
  * @param schoolName - Name of school to save
  * @returns true if the school is successfully saved 
  */
 public boolean saveSchool(String username, String schoolName) {   
   accountController.saveSchool(username, schoolName);
   return true; 
 }
 
 /**
  * Allows user to edit individual profile.
  * 
  * @param firstname first name of the user
  * @param lastname last name of the user
  * @param password password of the user
  * @return true if successfully edit profile
  */
 public boolean editProfile(String username, String firstName, String lastName, String password){
   accountController.userEditProfile(username, firstName, lastName, password);
   return true;
 }

 /**
  * Allows user to view the list of saved school
  * 
  * @return ArrayList<String> list of saved school of user
  */
 public ArrayList<String> viewSavedSchool(String username){
  User user = accountController.getUserInfo(username);
  return user.getSavedSchool();
 }
 
 /**
  * Removes a saved University from user account.
  * 
  * @param schoolName name of the school to remove
  * @return true if the school is successfully removed;
  */
 public boolean removeSavedSchool(String username, String schoolName){
  if(accountController.removeSavedSchool(username, schoolName))
	  return true;
  return false;
 }
 
 /**
  * Gets the university is greater detail.
  * 
  * @param schoolName name of the school to view in detail
  * @return University university object which contains school information
  */
 public University getUniversityInDetail(String schoolName) {
  return universityController.getUniversityInDetailed(schoolName);
 }
 
/**
 * Search schools based on the criteria that
 * user provided
 * @param criteria that user provided
 * @return ArrayList<University> completed search list of school
 */
 public ArrayList<University> search(ArrayList<String> criteria){
	 ArrayList<String> schoolInfo = criteria;
	 for(int i =0; i< schoolInfo.size(); i++){
		 if(i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14 || i == 16 
				 || i == 18 || i ==20 || i == 22 || i == 24 || i ==26){
			 if(schoolInfo.get(i).equals("")){
				 schoolInfo.set(i, "0");
			 }
		 }////////////Set Minimum value to 0 if criteria is empty
		 else if(i == 5 || i == 13 || i == 17){
			 if(schoolInfo.get(i).equals("")){
				 schoolInfo.set(i, "1000000");
			 }
		 }///////////Set max value to 1000000 if criteria is empty
		 else if(i == 7 || i == 15 || i == 19 || i == 21){
			 if(schoolInfo.get(i).equals("")){
				 schoolInfo.set(i, "100");
			 }
		 }///////////Set Minimum value to 0 if criteria is empty(percentage)
		 else if(i == 9 || i == 11){
			 if(schoolInfo.get(i).equals("")){
				 schoolInfo.set(i, "800");
			 }
		 }///////////Set Max value to 800 if criteria is empty(SAT score)
		 else if(i == 23 || i == 25 || i == 27){
			 if(schoolInfo.get(i).equals("")){
				 schoolInfo.set(i, "5");
			 }
		 }///////////Set Max value to 5 if criteria is empty(scale)
	 }
  ArrayList<University> searched = searchController.search(schoolInfo);
  return searched;
 }
 
 /**
  * Get profile of user using username
  * 
  * @param username of the user to get User object
  * @return User user object
  */
 public User getProfile(String username){
	 return accountController.getUserInfo(username);
 }
 /**
  * Search recommendation school similar to the school that
  * user viewed in detail
  * @param schoolName name of the school user viewed
  * @return ArrayList<University> recommendation list of searched university
  */
 public ArrayList<University> searchRecommendation(String schoolName){
	 University university = universityController.getUniversityInDetailed(schoolName);
	 return searchController.searchRecomendations(university);
 }
 
}