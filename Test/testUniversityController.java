package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Controller.UniversityController;
import Entity.University;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Controller.UniversityController;
import Controller.UniversityDBController;
import Entity.University;

public class testUniversityController {

 private UniversityController universityController;
 private University university;
 private UniversityDBController universitydbController;
 
 @Before
 public void init(){
  this.universityController = new UniversityController();
 }
 
 @Test
 public void testUniversityController() {
  assertTrue(universityController instanceof UniversityController); 
 }

 @Test
 public void testCreateUniversityCase1(){

  //Case 1= schoolInfo.size == 16 ; valid # of inputs
  ArrayList<String> schoolInfo = new ArrayList<String>(); 
  ArrayList<String> emphases = new ArrayList<String>();
  emphases.add("Science");
  
  schoolInfo.add(0, "TESTINGUNIVERSITY5");
  schoolInfo.add(1,"ALASKA");
  schoolInfo.add(2, "LOCATION");
  schoolInfo.add(3, "PUBLIC");
  schoolInfo.add(4, "0");
  schoolInfo.add(5, "0.0");
  schoolInfo.add(6, "0.0");
  schoolInfo.add(7, "0.0");
  schoolInfo.add(8, "0.0");
  schoolInfo.add(9, "0.0");
  schoolInfo.add(10, "0");
  schoolInfo.add(11, "0.0");
  schoolInfo.add(12, "0.0");
  schoolInfo.add(13, "0");
  schoolInfo.add(14, "0");
  schoolInfo.add(15, "0");
  schoolInfo.addAll(16,emphases);
  boolean test = this.universityController.createUniversity(schoolInfo);
  System.out.println(test);
  university = universityController.getUniversityInDetailed("TESTINGUNIVERSITY5");
  assertTrue(university instanceof University); 
 }
 

 @Test(expected=IndexOutOfBoundsException.class)
 public void testCreateUniversityCase2(){
  //Case 2: invalid parameters
  ArrayList<String> schoolInfo = new ArrayList<String>(); 
  ArrayList<String> emphases = new ArrayList<String>();
  
  schoolInfo.add(0, "TESTINGUNIVERSITY2");
  schoolInfo.add(1,"ALASKA");
  schoolInfo.add(2, "LOCATION");
  schoolInfo.add(3, "PUBLIC");
  schoolInfo.add(4, "0");
  schoolInfo.add(5, "0.0");
  schoolInfo.add(6, "0.0");
  schoolInfo.add(7, "0.0");
  schoolInfo.add(8, "0.0");
  schoolInfo.add(9, "0.0");
  schoolInfo.add(10, "0");
  schoolInfo.add(11, "0.0");
  schoolInfo.add(12, "0.0");
  schoolInfo.add(13, "0");
  schoolInfo.add(14, "0");
  schoolInfo.addAll(15, emphases);

  boolean testt = this.universityController.createUniversity(schoolInfo);
  System.out.println("expect " + testt);
  this.universitydbController.deleteUniversity("TESTINGUNIVERSITY2");
 }

 @Test
 public void testGetUniversityInDetailed(){
  University universityToGet = this.universityController.getUniversityInDetailed("BARD");
  assertTrue(universityToGet.getSchoolName().equals("BARD"));
 }

 @Test
 public void testEditUniversityInDetailedCase1(){
  //Case 1: Valid Input
  ArrayList<String> schoolInfo = new ArrayList<String>(); 
  ArrayList<String> emphases = new ArrayList<String>();
  
  
  schoolInfo.add(0, "TESTINGUNIVERSITY11");
  schoolInfo.add(1,"ALASKA");
  schoolInfo.add(2, "LOCATION");
  schoolInfo.add(3, "PUBLIC");
  schoolInfo.add(4, "0");
  schoolInfo.add(5, "0.0");
  schoolInfo.add(6, "0.0");
  schoolInfo.add(7, "0.0");
  schoolInfo.add(8, "0.0");
  schoolInfo.add(9, "0.0");
  schoolInfo.add(10, "0");
  schoolInfo.add(11, "0.0");
  schoolInfo.add(12, "0.0");
  schoolInfo.add(13, "0");
  schoolInfo.add(14, "0");
  schoolInfo.add(15, "0");
  schoolInfo.addAll(16,emphases);
  assertTrue(this.universityController.editUniversityInDetailed(schoolInfo));
  
  
  
  
 }
 
 @Test(expected=IndexOutOfBoundsException.class)
 public void testEditUniversityInDetailedCase2(){
  //Case 2: invalid parameters
  ArrayList<String> schoolInfo = new ArrayList<String>(); 
  ArrayList<String> emphases = new ArrayList<String>();
  
  schoolInfo.add(0, "TESTINGUNIVERSITY2");
  schoolInfo.add(1,"ALASKA");
  schoolInfo.add(2, "LOCATION");
  schoolInfo.add(3, "PUBLIC");
  schoolInfo.add(4, "0");
  schoolInfo.add(5, "0.0");
  schoolInfo.add(6, "0.0");
  schoolInfo.add(7, "0.0");
  schoolInfo.add(8, "0.0");
  schoolInfo.add(9, "0.0");
  schoolInfo.add(10, "0");
  schoolInfo.add(11, "0.0");
  schoolInfo.add(12, "0.0");
  schoolInfo.add(13, "0");
  schoolInfo.add(14, "0");
  schoolInfo.addAll(15, emphases);
  this.universityController.editUniversityInDetailed(schoolInfo);
 }
  
 

 @Test
 public void testGetUniversityList(){
  assertTrue(this.universityController.getUniversityList() instanceof ArrayList);
 }

}
