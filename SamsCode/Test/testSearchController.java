package Test;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import Controller.SearchController;
import Controller.UniversityDBController;
import Entity.University;

public class testSearchController {
 
 private SearchController sc;
 private ArrayList<String> criteria;
 private ArrayList<University> listOfUniv;
 private UniversityDBController univDB;
 
 
 @Before
 public void init(){
  this.sc = new SearchController();
  this.univDB = new UniversityDBController();
  this.criteria = new ArrayList<String>();
  this.listOfUniv = new ArrayList<University>();
  listOfUniv = univDB.getUniversityList();
 }
 
 @Test
 public void testSearchController() {
  assertTrue("Default Constructor does work", sc instanceof SearchController);
 }
 
 @Test
 public void testSearch1() {
  criteria.add("");// SCHOOL 0
  criteria.add("NEW YORK");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be included", u.getState().equals("NEW YORK"));
  }
  ArrayList<University> compare = new ArrayList<University>();
  for(University u : listOfUniv){
   for(University uc : searched){
    if(u.getSchoolName().equals(uc.getSchoolName())){
     compare.add(u);
    }
   }
  }
  listOfUniv.removeAll(compare);
  for(University u : listOfUniv){
   assertTrue("NEW YORK should not be included", !u.getState().equals("NEW YORK"));
  }
 }
 @Test
 public void testSearch2() {
  criteria.add("");// SCHOOL 0
  criteria.add("");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("500");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("SAT_VERBAL >= 500", u.getSatVerbal()>=500.0);
  }
  ArrayList<University> compare = new ArrayList<University>();
  for(University u : listOfUniv){
   for(University uc : searched){
    if(u.getSchoolName().equals(uc.getSchoolName())){
     compare.add(u);
    }
   }
  }
  listOfUniv.removeAll(compare);
  for(University u : listOfUniv){
   assertTrue("SAT_VERBAL <= 500", u.getSatVerbal()<=500.0);
  }
 }
 
 @Test
 public void testSearch3() {
  criteria.add("");// SCHOOL 0
  criteria.add("");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("30");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("Financial Aid >=30", u.getPerFinanAid() >=30);
  }
  ArrayList<University> compare = new ArrayList<University>();
  for(University u : listOfUniv){
   for(University uc : searched){
    if(u.getSchoolName().equals(uc.getSchoolName())){
     compare.add(u);
    }
   }
  }
  listOfUniv.removeAll(compare);
  for(University u : listOfUniv){
   assertTrue("Financial Aid <=30", u.getPerFinanAid() <=30);
  }
 }

 @Test
 public void testSearch4() {
  criteria.add("");// SCHOOL 0
  criteria.add("NEW YORK");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("500");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("30");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be included", u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL >= 500", u.getSatVerbal()>=500.0);
   assertTrue("Financial Aid >=30", u.getPerFinanAid() >=30);
  }
 }
 @Test
 public void testSearch5(){
  criteria.add("");// SCHOOL 0
  criteria.add("TEXAS");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("500");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("30");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be not included", !u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL >=500", u.getSatVerbal()>=500.0);
   assertTrue("Financial Aid >= 30", u.getPerFinanAid() >=30);
  }
 }
 @Test
 public void testSearch6(){
  criteria.add("");// SCHOOL 0
  criteria.add("TEXAS");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("");// SATVERB_LEAST
  criteria.add("500");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("30");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be not included", !u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL should be <= 500", u.getSatVerbal() <= 500.0);
   assertTrue("Financial Aid >= 30", u.getPerFinanAid() >=30);
  }
 }
 @Test
 public void testSearch7(){
  criteria.add("");// SCHOOL 0
  criteria.add("TEXAS");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("");// SATVERB_LEAST
  criteria.add("500");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("");// %FINANAID_LEAST
  criteria.add("30");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be not included", !u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL should be <= 500", u.getSatVerbal() <= 500.0);
   assertTrue("Financial Aid should be <= 30", u.getPerFinanAid() <= 30);
  }
 }
 
 @Test
 public void testSearch8(){
  criteria.add("");// SCHOOL 0
  criteria.add("NEW YORK");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("500");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("");// %FINANAID_LEAST
  criteria.add("30");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be included", u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL should be >= 500", u.getSatVerbal() >= 500.0);
   assertTrue("Financial Aid should be <= 30", u.getPerFinanAid() <= 30);
  }
 }
 
 @Test
 public void testSearch9(){
  criteria.add("");// SCHOOL 0
  criteria.add("NEW YORK");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("");// SATVERB_LEAST
  criteria.add("500");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("");// %FINANAID_LEAST
  criteria.add("30");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be included", u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL should be <= 500", u.getSatVerbal() <= 500.0);
   assertTrue("Financial Aid should be <= 30", u.getPerFinanAid() <= 30);
  }
 }
 
 @Test
 public void testSearch10(){
  criteria.add("");// SCHOOL 0
  criteria.add("TEXAS");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("500");// SATVERB_LEAST
  criteria.add("");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("");// %FINANAID_LEAST
  criteria.add("30");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be not included", !u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL should be  >= 500", u.getSatVerbal() >= 500);
   assertTrue("Financial Aid should be <= 30", u.getPerFinanAid() <= 30);
  }
 }
 
 @Test
 public void testSearch11(){
  criteria.add("");// SCHOOL 0
  criteria.add("NEW YORK");// STATE
  criteria.add("");// LOC
  criteria.add("");// CONTRO 3
  criteria.add("");// #STUDENT_LEAST 0 IF NULL
  criteria.add("");// #STUDENT_MOST INFINITE IF NULL
  criteria.add("");// %FEMALE_LEAST 0 IF NULL
  criteria.add("");// %FEMALE_MOST INFINTE IF NULL
  criteria.add("");// SATVERB_LEAST
  criteria.add("500");// SATVERB_MOST
  criteria.add("");// SATMATH_LEAST
  criteria.add("");// SATMATH_MOST
  criteria.add("");// EXPENSES_LEAST
  criteria.add("");// EXPENSES_MOST
  criteria.add("30");// %FINANAID_LEAST
  criteria.add("");// %FINANAID_MOST
  criteria.add("");// #APPLICANTS_LEAST 16
  criteria.add("");// #APPLICANTS_MOST 17
  criteria.add("");// %ADMIT_LEAST
  criteria.add("");// %ADMIT_MOST
  criteria.add("");// %ENROLL_LEAST
  criteria.add("");// %ENROLL_MOST
  criteria.add("");// ACA_SCALE_LEAST
  criteria.add("");// ACA_SCALE_MOST
  criteria.add("");// SOC_SCALE_LEAST
  criteria.add("");// SOC_SCALE_MOST
  criteria.add("");// LIFE_SCALE_LEAST
  criteria.add("");// LIFE_SCALE_MOST 27
  criteria.add("");// EMPHASES #1 28
  criteria.add("");// EMPHASES #2
  criteria.add("");// EMPHASES #3
  criteria.add("");// EMPHASES #4
  criteria.add("");// EMPHASES #5 32
  ArrayList<University> searched = sc.search(criteria);
  for(University u : searched){
   assertTrue("NEW YORK should be included", u.getState().equals("NEW YORK"));
   assertTrue("SAT_VERBAL should be  <= 500", u.getSatVerbal() <= 500);
   assertTrue("Financial Aid should be >= 30", u.getPerFinanAid() >= 30);
  }
 }

 @Test
 public void testSearchRecomendations1(){
  DecimalFormat form = new DecimalFormat("#.######");
  University testUniversity = univDB.getUniversity("BARD");
  sc.searchRecomendations(testUniversity);
  HashMap<String, Float> test = sc.getList();
  assertTrue("BARD dist should be 0", test.get("BARD") == 0.0);
  assertTrue("TOURO dist should be 2.909442", Double.parseDouble(form.format(test.get("TOURO"))) == 2.909442);
  assertTrue("CLARKSON UNIVERSITY dist should be 1.738340", Double.parseDouble(form.format(test.get("CLARKSON UNIVERSITY"))) == 1.738340);
  assertTrue("VASSAR dist should be 2.342632", Double.parseDouble(form.format(test.get("VASSAR"))) == 2.342632);
  assertTrue("RENSSELAER dist should be 2.792881", Double.parseDouble(form.format(test.get("RENSSELAER"))) == 2.792881);
  assertTrue("COLLEGE OF NEWROCHELLE dist should be 2.579644", Double.parseDouble(form.format(test.get("COLLEGE OF NEWROCHELLE"))) == 2.579644);
 }
 @Test
 public void testSearchRecomendations2(){
  DecimalFormat form = new DecimalFormat("#.######");
  University testUniversity = univDB.getUniversity("VASSAR");
  sc.searchRecomendations(testUniversity);
  HashMap<String, Float> test = sc.getList();
  assertTrue("VASSAR dist should be 0", test.get("VASSAR") == 0.0);
  assertTrue("CONNECTICUT COLLEGE dist should be 2.905642", Double.parseDouble(form.format(test.get("CONNECTICUT COLLEGE"))) == 2.905642);
  assertTrue("RENSSELAER dist should be 2.762438", Double.parseDouble(form.format(test.get("RENSSELAER"))) == 2.762438);
  assertTrue("CLARKSON UNIVERSITY dist should be 2.876107", Double.parseDouble(form.format(test.get("CLARKSON UNIVERSITY"))) == 2.876107);
  assertTrue("BARD dist should be 2.342632", Double.parseDouble(form.format(test.get("BARD"))) == 2.342632);
  assertTrue("MANHATTANVILLE COLLEGE dist should be 2.980380", Double.parseDouble(form.format(test.get("MANHATTANVILLE COLLEGE"))) == 2.980380);
 }
 @Test
 public void testSearchRecomendations3(){
  DecimalFormat form = new DecimalFormat("#.######");
  University testUniversity = univDB.getUniversity("CASE WESTERN");
  sc.searchRecomendations(testUniversity);
  HashMap<String, Float> test = sc.getList();
  assertTrue("CASE WESTERN dist should be 0", test.get("CASE WESTERN") == 0.0);
  assertTrue("GEORGE WASHINGTON  dist should be 3.114810", Double.parseDouble(form.format(test.get("GEORGE WASHINGTON"))) == 3.114810);
  assertTrue("STEVENS dist should be 2.722127", Double.parseDouble(form.format(test.get("STEVENS"))) ==2.722127);
  assertTrue("UNIVERSITY OF ROCHESTER dist should be 3.145592", Double.parseDouble(form.format(test.get("UNIVERSITY OF ROCHESTER"))) == 3.145592);
  assertTrue("BUTLER dist should be 2.930467", Double.parseDouble(form.format(test.get("BUTLER"))) == 2.930467);
  assertTrue("OBERLIN dist should be 3.094839", Double.parseDouble(form.format(test.get("OBERLIN"))) == 3.094839);
 }
 

}
