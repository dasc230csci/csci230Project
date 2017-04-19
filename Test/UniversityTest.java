/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import Entity.University;

/**
 * @author sjhalloran
 *
 */
public class UniversityTest {

 private University Uni;
 private ArrayList<String> emphases;
 /**
  * Test method for {@link Entity.University#getSchoolName()}.
  * 
  */
 
 @Before
 public void init(){
  this.emphases = new ArrayList<String>();
  emphases.add("English");
  emphases.add("Biology");
  this.Uni = new University("testSchool", "testState", "testLoc", "testControl", 0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0.0, 0, 0, 0, emphases);
  
 }
 
 
 @Test
 public void testGetSchoolName() {
  String name = Uni.getSchoolName();
  Assert.assertTrue(name.equals("testSchool"));
 }

 /**
  * Test method for for set school name
  */
 @Test
 public void testSetSchoolName() {
  String name = "testSchoolUpdated";
  Uni.setSchoolName(name);
  Assert.assertTrue(Uni.getSchoolName().equals("testSchoolUpdated"));
    
 }

 /**
  * Test method for {@link Entity.University#getState()}.
  */
 @Test
 public void testGetState() {
  String state = Uni.getState();
  Assert.assertTrue(state.equals("testState"));
 }

 /**
  * Test method for {@link Entity.University#setState(java.lang.String)}.
  */
 @Test
 public void testSetState() {
  String newState = "Minnesota";
  Uni.setState(newState);
  Assert.assertTrue(Uni.getState().equals("Minnesota"));
 }

 /**
  * Test method for {@link Entity.University#getLocation()}.
  */
 @Test
 public void testGetLocation() {
  String loc = Uni.getLocation();
  Assert.assertTrue(loc.equals("testLoc"));
 }

 /**
  * Test method for {@link Entity.University#setLocation(java.lang.String)}.
  */
 @Test
 public void testSetLocation() {
  String newLoc = "updatedLocation";
  Uni.setLocation(newLoc);
  Assert.assertTrue(Uni.getLocation().equals("updatedLocation"));
 }

 /**
  * Test method for {@link Entity.University#getControl()}.
  */
 @Test
 public void testGetControl() {
  String control = Uni.getControl();
  Assert.assertTrue(control.equals("testControl"));
 }

 /**
  * Test method for {@link Entity.University#setControl(java.lang.String)}.
  */
 @Test
 public void testSetControl() {
  String newControl = "updatedControl";
  Uni.setControl(newControl);
  Assert.assertTrue(Uni.getControl().equals("updatedControl"));
 }

 /**
  * Test method for {@link Entity.University#getNumOfEnrolled()}.
  */
 @Test
 public void testGetNumOfEnrolled() {
  int numEnrolled = Uni.getNumOfEnrolled();
  Assert.assertTrue(numEnrolled==0);
 }

 /**
  * Test method for {@link Entity.University#setNumOfEnrolled(int)}.
  */
 @Test
 public void testSetNumOfEnrolled() {
  int newEnrolled = 5;
  Uni.setNumOfEnrolled(newEnrolled);
  Assert.assertTrue(Uni.getNumOfEnrolled()==5);
 }

 /**
  * Test method for {@link Entity.University#getTotNumOfApplicant()}.
  */
 @Test
 public void testGetTotNumOfApplicant() {
  int numApp = Uni.getTotNumOfApplicant();
  Assert.assertTrue(numApp==0);
 }

 /**
  * Test method for {@link Entity.University#setTotNumOfApplicant(int)}.
  */
 @Test
 public void testSetTotNumOfApplicant() {
  int newApp = 5;
  Uni.setTotNumOfApplicant(newApp);
  Assert.assertTrue(Uni.getTotNumOfApplicant()==5);
 }

 /**
  * Test method for {@link Entity.University#getAcademicsScale()}.
  */
 @Test
 public void testGetAcademicsScale() {
  int scale = Uni.getAcademicsScale();
  Assert.assertTrue(scale==0);
 }

 /**
  * Test method for {@link Entity.University#setAcademicsScale(int)}.
  */
 @Test
 public void testSetAcademicsScale() {
  int newScale = 5;
  Uni.setAcademicsScale(newScale);
  Assert.assertTrue(Uni.getAcademicsScale()==5);
 }

 /**
  * Test method for {@link Entity.University#getSocialScale()}.
  */
 @Test
 public void testGetSocialScale() {
  int socScale = Uni.getSocialScale();
  Assert.assertTrue(socScale==0);
 }

 /**
  * Test method for {@link Entity.University#setSocialScale(int)}.
  */
 @Test
 public void testSetSocialScale() {
  int newSocScale = 5;
  Uni.setSocialScale(newSocScale);
  Assert.assertTrue(Uni.getSocialScale()==5);
 }

 /**
  * Test method for {@link Entity.University#getQualOfLifeScale()}.
  */
 @Test
 public void testGetQualOfLifeScale() {
  int qualLife = Uni.getQualOfLifeScale();
  Assert.assertTrue(qualLife==0);
 }

 /**
  * Test method for {@link Entity.University#setQualOfLifeScale(int)}.
  */
 @Test
 public void testSetQualOfLifeScale() {
  int newQual = 5;
  Uni.setQualOfLifeScale(newQual);
  Assert.assertTrue(Uni.getQualOfLifeScale()==5);
 }

 /**
  * Test method for {@link Entity.University#getFemaleRatio()}.
  */
 @Test
 public void testGetFemaleRatio() {
  double femaleRa = Uni.getFemaleRatio();
  Assert.assertTrue(femaleRa==0.0);
 }

 /**
  * Test method for {@link Entity.University#setFemaleRatio(java.lang.Double)}.
  */
 @Test
 public void testSetFemaleRatio() {
  double FemaleRaUpdate = 1.0;
  Uni.setFemaleRatio(FemaleRaUpdate);
  Assert.assertTrue(Uni.getFemaleRatio()==1.0);
 }

 /**
  * Test method for {@link Entity.University#getSatVerbal()}.
  */
 @Test
 public void testGetSatVerbal() {
  double satV = Uni.getSatVerbal();
  Assert.assertTrue(satV==0.0);
 }

 /**
  * Test method for {@link Entity.University#setSatVerbal(java.lang.Double)}.
  */
 @Test
 public void testSetSatVerbal() {
  double newSatV = 1.0;
  Uni.setSatVerbal(newSatV);
  Assert.assertTrue(Uni.getSatVerbal()==1.0);
 }

 /**
  * Test method for {@link Entity.University#getSatMath()}.
  */
 @Test
 public void testGetSatMath() {
  double satM = Uni.getSatMath();
  Assert.assertTrue(satM==0.0);
 }

 /**
  * Test method for {@link Entity.University#setSatMath(java.lang.Double)}.
  */
 @Test
 public void testSetSatMath() {
  double newSatM = 1.0;
  Uni.setSatMath(newSatM);
  Assert.assertTrue(Uni.getSatMath()==1.0);
 }

 /**
  * Test method for {@link Entity.University#setExpenses(java.lang.Double)}.
  */
 @Test
 public void testSetExpenses() {
  Double expense = 1.0;
  Uni.setExpenses(expense);
  Assert.assertTrue(Uni.getExpenses()==1.0);
 }

 /**
  * Test method for {@link Entity.University#getPerAdmitted()}.
  */
 @Test
 public void testGetPerAdmitted() {
  double per = Uni.getPerAdmitted();
  Assert.assertTrue(per==0.0);
 }

 /**
  * Test method for {@link Entity.University#setPerAdmitted(java.lang.Double)}.
  */
 @Test
 public void testSetPerAdmitted() {
  double newPer = 1.0;
  Uni.setPerAdmitted(newPer);
  Assert.assertTrue(Uni.getPerAdmitted()==1.0);
 }

 /**
  * Test method for {@link Entity.University#getPerEnrolled()}.
  */
 @Test
 public void testGetPerEnrolled() {
  double perEnrol = Uni.getPerEnrolled();
  Assert.assertTrue(perEnrol==0.0);
 }

 /**
  * Test method for {@link Entity.University#setPerEnrolled(java.lang.Double)}.
  */
 @Test
 public void testSetPerEnrolled() {
  double newPer = 1.0;
  Uni.setPerEnrolled(newPer);
  Assert.assertTrue(Uni.getPerEnrolled()==1.0);
  
 }

 /**
  * Test method for {@link Entity.University#getEmphases()}.
  */
 @Test
 public void testGetEmphases() {
  ArrayList<String> testEmp = Uni.getEmphases();
  Assert.assertTrue(testEmp.size()==2);
 }

 /**
  * Test method for {@link Entity.University#setEmphases(java.util.ArrayList)}.
  */
 @Test
 public void testSetEmphases() {
  Assert.assertTrue(Uni.getEmphases().size()==2);
  emphases.add("Science");
  Uni.setEmphases(emphases);
  Assert.assertTrue(Uni.getEmphases().size()==3);
 }

 /**
  * Test method for {@link Entity.University#getPerFinanAid()}.
  */
 @Test
 public void testGetPerFinanAid() {
  double finanAid = Uni.getPerFinanAid();
  Assert.assertTrue(finanAid==0.0);
 }

 /**
  * Test method for {@link Entity.University#setPerFinanAid(double)}.
  */
 @Test
 public void testSetPerFinanAid() {
  double newFinanAid = 1.0;
  Uni.setPerFinanAid(newFinanAid);
  Assert.assertTrue(Uni.getPerFinanAid()==1.0);
 }

}
