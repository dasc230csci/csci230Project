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
  * SearchController to search for school
  */
 private SearchController searchController;
 
 /**
  * username of the User
  */
 private String username;
  
 /**
  * the constructor to create a UserUI for a specific user
  * @param user the user using the system
  */
 
 public UserUI(String username){
   this.searchController= new SearchController();
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
   * the search() method, used whenever a call is made by
   * the user to search for schools, 
   * returning a collection of University string name
   * 
   * @param schoolName school name
   * @param state state school is in
   * @param location specific location of the school
   * @param control private or public
   * @param numOfEnrolled number of enrollment
   * @param femaleRatio the ratio of female to male
   * @param satVerbal the SAT verbal score
   * @param satMath the SAT math score
   * @param expenses the expenses of one school year
   * @param perFinanAid the percentage of students get financial aid
   * @param totNumOfApplicant total number of applicant
   * @param perAdmitted the percentage of applicants that get accepted
   * @param perEnrolled the percentage of applicants that enrolled
   * @param academicScale scale of academic from 1-5
   * @param socialScale the quality of the community and social life
   * @param qualOfLifeScale the quality of life scale 
   * @param emphases the emphases of the school
   * @return a collection of University name
   */  
  public ArrayList<String> search(String schoolName, String state, String location, String control, int numOfEnrolled,
   double femaleRatio, double satVerbal, double satMath, double expenses, double perFinanAid,
   int totNumOfApplicant, double perAdmitted, double perEnrolled, int academicScale, int socialScale, int qualOfLifeScale,
   ArrayList<String> emphases){
   ArrayList<String> schoolInfo=new ArrayList<>();
   schoolInfo.add(schoolName);
   schoolInfo.add(state);
   schoolInfo.add(location);
   schoolInfo.add(control);
   schoolInfo.add(numOfEnrolled+"");
   schoolInfo.add(femaleRatio+"");
   schoolInfo.add(satVerbal+"");
   schoolInfo.add(satMath+"");
   schoolInfo.add(expenses+"");
   schoolInfo.add(perFinanAid+"");
   schoolInfo.add(totNumOfApplicant+"");
   schoolInfo.add(perAdmitted+"");
   schoolInfo.add(perEnrolled+"");
   schoolInfo.add(academicScale+"");
   schoolInfo.add(socialScale+"");
   schoolInfo.add(qualOfLifeScale+"");
   schoolInfo.add(emphases+"");
   ArrayList<String> schoolNames = searchController.search(schoolInfo);
   return schoolNames; //////////////////////// Array should be changed --> see Test.java
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
   * @param schoolName name of the school to be saved
   * @return ArrayList<String> information of the school
   */
  public ArrayList<String> viewUniversityInDetail(String schoolName){
   University university = userFuncController.getUniversityInDetail(schoolName);
   ArrayList<String> schoolInfo = new ArrayList<>();
   schoolInfo.add(university.getSchoolName());
   schoolInfo.add(university.getState());
   schoolInfo.add(university.getLocation());
   schoolInfo.add(university.getControl());
   schoolInfo.add(university.getNumOfEnrolled()+"");
   schoolInfo.add(university.getTotNumOfApplicant()+"");
   schoolInfo.add(university.getAcademicsScale()+"");
   schoolInfo.add(university.getSocialScale()+"");
   schoolInfo.add(university.getQualOfLifeScale()+"");
   schoolInfo.add(university.getFemaleRatio()+"");
   schoolInfo.add(university.getSatVerbal()+"");
   schoolInfo.add(university.getSatMath()+"");
   schoolInfo.add(university.getExpenses()+"");
   schoolInfo.add(university.getPerAdmitted()+"");
   schoolInfo.add(university.getPerEnrolled()+"");
   schoolInfo.add(university.getEmphases()+"");
   schoolInfo.add(university.getPerFinanAid()+"");
   return schoolInfo;
  }
}