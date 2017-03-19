/**
 * File: UserFuncController.java
 */

package Controller;

import java.util.ArrayList;

import Entity.Account;
import Entity.User;
import Entity.University;

/**
 * Controller class with functions for the User.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
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
  User user = accountController.getAccountInfo(username);
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
  * @return University
  */
 public University getUniversityInDetail(String schoolName) {
  return universityController.getUniversityInDetailed(schoolName);
 }
 //////////////////
 public User getProfile(String username){
	 return accountController.getAccountInfo(username);
 }
 
}