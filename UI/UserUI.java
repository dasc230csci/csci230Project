/**
 * File: UserUI.java
 */

package UI;

import java.util.ArrayList;
import Entity.*;
import Controller.*;

/**
 * Class to represent the User UI.
 * 
 * @author  Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version Feburary 27, 2017
 */


public class UserUI{
 /**
  * UserFuncController which provide
  * functionality of user
  */
 private UserFuncController userFuncController;
 
 /**
  * username of the User
  */
 private String username;
  
 /**
  * the constructor to create a UserUI for a specific user
  * @param user the user using the system
  */
 
 public UserUI(String username){
   this.userFuncController= new UserFuncController();
   this.username = username;
 }

 
  /**
   * the viewSavedSchools method, returns the current
   * array list of saved schools associated with the
   * current user signed in.
   */
  public ArrayList<String> viewSavedSchool(){
    ArrayList<String> savedSchool = this.userFuncController.viewSavedSchool(username);
    return savedSchool;
  }
  
  /**
   * the viewProfile() method, returns a Account object(either User or Admin)
   * and allows the user to alter his/her personal profile as they 
   * see fit.
   * @return an instance of the Users Account
   */ 
  public User viewProfile(){
	User user = userFuncController.getProfile(username);
    return user;
  }
  
  /**
   * this method edit the profile of user
   * 
   * @param firstname first name of the user
   * @param lastname last name of the user
   * @param password password of the user
   * @return true if successfully edit profile
   */  
  public boolean editProfile(String firstName, String lastName, String password){
    if(userFuncController.editProfile(username, firstName, lastName, password)){
     return true; 
    }
   return false;
  }
  
  /**
   * the saveScool() method, sends the University chosen
   * to be saved to the savedSchools array list 
   * that is saved for the user.
   * 
   * @param schoolName name of the school to be saved
   * @returns true if the school is successfully saved 
   */
  public boolean saveSchool(String schoolName){
    if(userFuncController.saveSchool(username, schoolName)){
      return true;
    }
   return false;
  }
  
  /**
   * the removeSavedSchool() method, removes a specified school
   * (assuming it is present in the users savedSchools array) and 
   * return a boolean true if it was successfully removed.
   * 
   * @param schoolName name of the school to be saved
   * @returns true if the school successfully removed 
   */ 
  public boolean removeSavedUniversity(String schoolName){
    if(userFuncController.removeSavedSchool(username, schoolName)){
      return true;
    }
    return false;
  }
  
  /**
   * the viewUniversityInDetail() method, displays all the previously
   * hidden information about the schools academics and other
   * statistics users may find useful
   * 
   * @param schoolName name of the school to view
   * @return university information of the school
   */
  public University viewUniversityInDetail(String schoolName){
    return userFuncController.getUniversityInDetail(schoolName);
  }
  /////////////////////////
  public ArrayList<University> search(String schoolName, String state, String location, String control,
		  String minNumOfEnrolled, String maxNumOfEnrolled, String minFemaleRatio, String maxFemaleRatio,
		  String minSatVerbal, String maxSatVerbal, String minSatMath, String maxSatMath, 
		  String minExpenses, String maxExpenses, String minPerFinanAid, String maxPerFinanAid,
		  String minTotNumOfApplicant, String maxTotNumOfApplicant, String minPerAdmitted, String maxPerAdmitted,
		  String minPerEnrolled, String maxPerEnrolled, String minAcademicScale, String maxAcademicScale, 
		  String minSocialScale, String maxSocialScale, String minQualOfLifeScale, String maxQualOfLifeScale,
		  String emphases1, String emphases2, String emphases3, String emphases4, String emphases5){
	  ArrayList<String> criteria = new ArrayList<String>();
	  criteria.add(schoolName);
	  criteria.add(state);
	  criteria.add(location);
	  criteria.add(control);
	  criteria.add(minNumOfEnrolled);
	  criteria.add(maxNumOfEnrolled);
	  criteria.add(minFemaleRatio);
	  criteria.add(maxFemaleRatio);
	  criteria.add(minSatVerbal);
	  criteria.add(maxSatVerbal);
	  criteria.add(minSatMath);
	  criteria.add(maxSatMath);
	  criteria.add(minExpenses);
	  criteria.add(maxExpenses);
	  criteria.add(minPerFinanAid);
	  criteria.add(maxPerFinanAid);
	  criteria.add(minTotNumOfApplicant);
	  criteria.add(maxTotNumOfApplicant);
	  criteria.add(minPerAdmitted);
	  criteria.add(maxPerAdmitted);
	  criteria.add(minPerEnrolled);
	  criteria.add(maxPerEnrolled);
	  criteria.add(minAcademicScale);
	  criteria.add(maxAcademicScale);
	  criteria.add(minSocialScale);
	  criteria.add(maxSocialScale);
	  criteria.add(minQualOfLifeScale);
	  criteria.add(maxQualOfLifeScale);
	  criteria.add(emphases1);
	  criteria.add(emphases2);
	  criteria.add(emphases3);
	  criteria.add(emphases4);
	  criteria.add(emphases5);
	  ArrayList<University> searched = userFuncController.search(criteria);
	  return searched;
  }
 }
