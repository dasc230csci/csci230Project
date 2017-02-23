/*
 * File: University.java
 */

import java.util.*;

public class University {
  
  private String schoolName, state, location, control;
  private int numOfEnrolled, totNumOfApplicant, academicsScale, socialScale, qualOfLifeScale;
  private Double femaleRatio, satVerbal, satMath, expenses, perAdmitted, perEnrolled;
  private ArrayList<String> emphases;
  
  /**
   * Constructor of the University class to create an university with the specific information for parameter
   * 
   * @param schoolName school name
   * @param state state school is in
   * @param location specific location of the school
   * @param control private or public
   * @param numOfEnrolled number of enrollment
   * @param totNumOfApplican total number of applicant
   * @param academicScale scale of academic from 1-5
   * @param socialScale the quality of the community and social life
   * @param qualOfLifeScale the quality of life scale
   * @param femaleRatio the ratio of female to male
   * @param satVerbal the SAT verbal score 
   * @param satMath the SAT math score 
   * @param expenses the expenses of one school year
   * @param perAdmitted the percentage of applicants that get accepted
   * @param perEnrolled the percentage of applicants that enrolled
   * @param emphases the emphases of the school
   */
  public University(String schoolName, String state, String location, String control, int numOfEnrolled, int totNumOfApplicant, int academicScale, int socialScale, int qualOfLifeScale, double femaleRatio, double satVerbal, double satMath, double expenses, double perAdmitted, double perEnrolled, ArrayList<String> emphases)
  {
    this.schoolName=schoolName;
    this.state=state;
    this.location=location;
    this.control=control;
    this.numOfEnrolled=numOfEnrolled;
    this.totNumOfApplicant = totNumOfApplicant;
    this.academicsScale = academicScale;
    this.socialScale = socialScale;
    this.qualOfLifeScale = qualOfLifeScale;
    this.femaleRatio = femaleRatio;
    this.satVerbal = satVerbal;
    this.satMath = satMath;
    this.expenses = expenses;
    this.perAdmitted = perAdmitted;
    this.perEnrolled = perEnrolled;
    this.emphases = emphases;
  }
  
  /**
   * method to set the state of the school
   * 
   * @param state state school is in
   */
  public void setState(String state)
  {
    this.state = state;
  }
  
  /**
   * method to set the name of the school
   * 
   * @param schoolName name of the school
   */
  public void setSchoolName(String schoolName)
  {
    this.schoolName=schoolName;
  }
  
  /**
   * method to set the location of the school
   * 
   * @param location location of the school
   */
  public void setLocation(String location)
  {
    this.location=location;
  }
  
  /**
   * method to set if the school is public or private
   * 
   * @param control public or private
   */
  public void setControl(String control)
  {
  }
  
  /**
   * method to set the number of enrolled students
   * 
   * @param numOfEnrolled number of enrolled student
   */
  public void setNumOfEnrolled(int numOfEnrolled)
  {
  }
  
  /**
   * method to set the academic scale
   * 
   * @param academicScale the academic scale
   */
  public void setAcademicScale(int academicScale)
  {
  }
  
  /**
   * method to set the emphases of the school
   * 
   * @param emphases the emphases of the school
   */
  public void setEmphases(ArrayList<String> setEmphases)
  {
  }
  
  /**
   * method to set the social scale of the school
   * 
   * @param socialScale the social scale of the school
   */
  public void setSocialScale(int socialScale)
  {
  }
  
  /**
   * method to set the quality of life scale
   * 
   * @param qualOflifeScale the scale of quality of life
   */
  public void setQualOfLifeScale(int qualOfLifeScale)
  {
  }
  
  /**
   * method to set the total number of applicant
   * 
   * @param totNumOfApplicant total number of applicant
   */
  public void setTotNumOfApplicant(int totNumOfApplicant)
  {
  }
  
  /**
   * method to set the female ratio
   * 
   * @param femaleRatio the demale ratio
   */
  public void setFemaleRatio(double femaleRatio)
  {
  }
  
  /**
   * method to set the SAT verbal
   * 
   * @param satVerbal the SAT verbal
   */
  public void setSatVerbal(double satVerbal)
  {
  }
  
  /**
   * method to set the SAT math score
   * 
   * @param satMath the SAT math score 
   */
  public void setSatMath(double satMath)
  {
  }
  
  /**
   * method to set the expenses for the school
   * 
   * @param expenses the expenses for the school
   */
  public void setExpenses(double expenses)
  {
  }
  
  /**
   * method to set the percentaged of admitted applicants
   * 
   * @param perAdmitted percentage of admitted applicants
   */
  public void setPerAdmitted(double perAdmitted)
  {
  }
  
  /**
   * method to set the percentaged of enrolled students
   * 
   * @param perEnrolled percentage of enrolled students
   */
  public void setPerEnrolled(double perEnrolled)
  {
  }
}
