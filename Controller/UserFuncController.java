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
   if(accountController.saveSchool(username, schoolName)){
	   return true;
   }
   return false; 
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
   if(accountController.userEditProfile(username, firstName, lastName, password)){
	   return true;
   }
   return false;
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
  ArrayList<University> searched = searchController.search(criteria);
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