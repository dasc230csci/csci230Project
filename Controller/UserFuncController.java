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
  * Account instance variable
  */
 private User account;
 
 /**
  * Creates the Controller.
  */
 public UserFuncController(User account) {
   accountController= new AccountController();
   this.account=account;
   universityController= new UniversityController();
 }
 
 /**
  * Saves a school to User account.
  * @param schoolName - Name of school to save
  * @returns true if the school is successfully saved 
  */
 public boolean saveSchool(String schoolName) {   
   accountController.saveSchool(schoolName);
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
 public boolean editProfile(String firstName, String lastName, String password){
   accountController.userEditProfile(firstName, lastName, password);
   return true;
 }

 /**
  * Allows user to view the list of saved school
  * 
  * @return ArrayList<String> list of saved school of user
  */
 public ArrayList<String> viewSavedSchool(){
  return account.getSavedSchool();
 }
 
 /**
  * Removes a saved University from user account.
  * 
  * @param schoolName name of the school to remove
  * @return true if the school is successfully removed;
  */
 public boolean removeSavedUniversity(String schoolName){
  accountController.removeSavedSchool(schoolName);
  return true;
 }
 
 /**
  * Resets user information.
  * 
  * @return ArrayList<String> information of the user
  */
 public Account resetUserInfo(String username) {
  return accountController.resetAccountInfo(username);
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
}
