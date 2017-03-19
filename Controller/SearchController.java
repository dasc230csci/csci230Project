package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Entity.University;

/**
 * public class searchController, controls all calls
 * made to search through the university database with 
 * the methods stored in the class, then makes the call
 * to the DB controller to conducted the search.
 */


public class SearchController{
	
	/**
	 * DBController to search school
	 */
	private UniversityDBController universityDBController;
	
	/**
	 * ArrayList<String> to save searched school list
	 */
	private ArrayList<String> searchedSchool;
  
  /**
   * the default constructor method for the search controller 
   * class, creates an instance of the controller in order to 
   * execute the search methods in the database.
   */
  
	/**
	 * Default Constructor
	 */
  public SearchController(){
	  universityDBController = new UniversityDBController();
  }
  
  /**
   * the search() method, used whenever a call is made by ]
   * the user to search for schools similar to the provided 
   * school parameter, returning a collection of University objects
   * with similar school statistics as the parameter
   * @param ArrayList<String> information of the school to search
   * @return a collection of University objects
   */
  public ArrayList<String> search(ArrayList<String> schoolInfo){
	  ArrayList<String> emphases = new ArrayList<String>();
		ArrayList<String> searched = new ArrayList<String>();
		ArrayList<String> schoolList = new ArrayList<String>();
		String[][] school = universityDBController.getDB().university_getUniversities();

		for (int i = 0; i < school.length; i++) {
			if (school[i][0].contains(schoolInfo.get(0)) && school[i][1].contains(schoolInfo.get(1))
					&& school[i][2].contains(schoolInfo.get(2)) && school[i][3].contains(schoolInfo.get(3))
					&& Double.parseDouble(school[i][4]) >= Double.parseDouble(schoolInfo.get(4))
					&& Double.parseDouble(school[i][4]) <= Double.parseDouble(schoolInfo.get(5))
					&& Double.parseDouble(school[i][5]) >= Double.parseDouble(schoolInfo.get(6))
					&& Double.parseDouble(school[i][5]) <= Double.parseDouble(schoolInfo.get(7))
					&& Double.parseDouble(school[i][6]) >= Double.parseDouble(schoolInfo.get(8))
					&& Double.parseDouble(school[i][6]) <= Double.parseDouble(schoolInfo.get(9))
					&& Double.parseDouble(school[i][7]) >= Double.parseDouble(schoolInfo.get(10))
					&& Double.parseDouble(school[i][7]) <= Double.parseDouble(schoolInfo.get(11))
					&& Double.parseDouble(school[i][8]) >= Double.parseDouble(schoolInfo.get(12))
					&& Double.parseDouble(school[i][8]) <= Double.parseDouble(schoolInfo.get(13))
					&& Double.parseDouble(school[i][9]) >= Double.parseDouble(schoolInfo.get(14))
					&& Double.parseDouble(school[i][9]) <= Double.parseDouble(schoolInfo.get(15))
					&& Integer.parseInt(school[i][10]) >= Integer.parseInt(schoolInfo.get(16))
					&& Integer.parseInt(school[i][10]) <= Integer.parseInt(schoolInfo.get(17))
					&& Double.parseDouble(school[i][11]) >= Double.parseDouble(schoolInfo.get(18))
					&& Double.parseDouble(school[i][11]) <= Double.parseDouble(schoolInfo.get(19))
					&& Double.parseDouble(school[i][12]) >= Double.parseDouble(schoolInfo.get(20))
					&& Double.parseDouble(school[i][12]) <= Double.parseDouble(schoolInfo.get(21))
					&& Integer.parseInt(school[i][13]) >= Integer.parseInt(schoolInfo.get(22))
					&& Integer.parseInt(school[i][13]) <= Integer.parseInt(schoolInfo.get(23))
					&& Integer.parseInt(school[i][14]) >= Integer.parseInt(schoolInfo.get(24))
					&& Integer.parseInt(school[i][14]) <= Integer.parseInt(schoolInfo.get(25))
					&& Integer.parseInt(school[i][15]) >= Integer.parseInt(schoolInfo.get(26))
					&& Integer.parseInt(school[i][15]) <= Integer.parseInt(schoolInfo.get(27))) {
				schoolList.add(school[i][0]);
			}
		} //////////////////////// search school without emphases
		
		for (int i = 28; i < schoolInfo.size(); i++) {
			emphases.add(schoolInfo.get(i));
		} //////////////////////// create emphases from schoolInfo to search
		
		if (!emphases.isEmpty()){
			for (int i = 0; i < schoolList.size(); i++) {
				for(int j = 0 ; j < emphases.size(); j++){
					if (universityDBController.getUniversity(schoolList.get(i)).getEmphases().contains(emphases.get(j))){
						searched.add(schoolList.get(i)); /////////////////////add school to final list that met with criteria
					}
				}
			}
		}
		else{
			searched = schoolList; //////////if emphases criteria is empty, then ignore it
		}
		
		return searched;
  }
  /**
   * the searchRecomendations() method, returns the top 5 schools
   * it finds to be the most similar to the parameter provided 
   * University
   * @param ArrayList<String> information of the school to search recommendation
   * @return a collection of 5 university objects
   */
	public ArrayList<University> searchRecomendations(ArrayList<String> schoolInfo) {
		University univ = universityDBController.getUniversity("ST JOHNS UNIVERSITY");
		ArrayList<University> recommendationList = new ArrayList<University>();
		HashMap<String, Double> map = new HashMap<String, Double>();
		String[][] str = universityDBController.getDB().university_getUniversities();
		
		for (int i = 0; i < str.length; i++) {
			double dist = findDiff(univ.getState(), str[i][1]) + findDiff(univ.getLocation(), str[i][2])
					+ findDiff(univ.getControl(), str[i][3]) + findDiff(univ.getNumOfEnrolled(), i, 4, str)
					+ findDiff(univ.getFemaleRatio(), i, 5, str) + findDiff(univ.getSatVerbal(), i, 6, str)
					+ findDiff(univ.getSatMath(), i, 7, str) + findDiff(univ.getExpenses(), i, 8, str)
					+ findDiff(univ.getPerFinanAid(), i, 9, str) + findDiff(univ.getTotNumOfApplicant(), i, 10, str)
					+ findDiff(univ.getPerAdmitted(), i, 11, str) + findDiff(univ.getPerEnrolled(), i, 12, str)
					+ findDiff(univ.getAcademicsScale(), i, 13, str) + findDiff(univ.getSocialScale(), i, 14, str)
					+ findDiff(univ.getQualOfLifeScale(), i, 15, str);			
				map.put(str[i][0], dist);
		}
		Iterator it = sortByValue(map).iterator();
		
		for(int i =0; i < 5 ; i++){
			String schoolName = (String) it.next();
			University recommendation = universityDBController.getUniversity(schoolName);
			recommendationList.add(recommendation);
		}
		
		return recommendationList;
	}
  ////////////////////////////////////////newly added method
  public double findMaxMin(int fix, String[][] str) {
		double max = 0;
		double min = 0;
		for (int i = 0; i < str.length; i++) {
			if (Double.parseDouble(str[i][fix]) >= max) {
				max = Double.parseDouble(str[i][fix]);
			}
		}
		for (int i = 0; i < str.length; i++) {
			if (Double.parseDouble(str[i][fix]) <= min) {
				min = Double.parseDouble(str[i][fix]);
			}
		}
		return Math.abs(max - min);
	}

	public static int findDiff(String origin, String compare) {
		int diff = 0;
		if (origin.equals(compare)) {
			diff = 1;
		}
		return diff;
	}

	public static double findDiff(double origin, int front, int rear, String[][] str) {
		double max = 0;
		double min = 0;
		for (int i = 0; i < str.length; i++) {
			if (Double.parseDouble(str[i][rear]) >= max) {
				max = Double.parseDouble(str[i][rear]);
			}
		}
		for (int i = 0; i < str.length; i++) {
			if (Double.parseDouble(str[i][rear]) <= min) {
				min = Double.parseDouble(str[i][rear]);
			}
		}
		return Math.abs(origin - Double.parseDouble(str[front][rear])) / Math.abs(max - min);
	}
	
	public static List sortByValue(final Map map) {
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
         
        Collections.sort(list,new Comparator() {
             
            public int compare(Object o1,Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);
                 
                return ((Comparable) v2).compareTo(v1);
            }
             
        });
        Collections.reverse(list);
        return list;
    }
}