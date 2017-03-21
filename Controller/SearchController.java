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
  public ArrayList<University> search(ArrayList<String> schoolInfo){
	  ArrayList<String> emphases = new ArrayList<String>();
		ArrayList<University> searched = new ArrayList<University>();
		ArrayList<University> schoolList = new ArrayList<University>();
		ArrayList<University> universityList = universityDBController.getUniversityList();

		for (int i = 0; i < universityList.size(); i++) {
			if (universityList.get(i).getSchoolName().contains(schoolInfo.get(0))
					&& universityList.get(i).getState().contains(schoolInfo.get(1))
					&& universityList.get(i).getLocation().contains(schoolInfo.get(2))
					&& universityList.get(i).getControl().contains(schoolInfo.get(3))
					&& universityList.get(i).getNumOfEnrolled() >= Double.parseDouble(schoolInfo.get(4))
					&& universityList.get(i).getNumOfEnrolled() <= Double.parseDouble(schoolInfo.get(5))
					&& universityList.get(i).getFemaleRatio() >= Double.parseDouble(schoolInfo.get(6))
					&& universityList.get(i).getFemaleRatio() <= Double.parseDouble(schoolInfo.get(7))
					&& universityList.get(i).getSatVerbal() >= Double.parseDouble(schoolInfo.get(8))
					&& universityList.get(i).getSatVerbal() <= Double.parseDouble(schoolInfo.get(9))
					&& universityList.get(i).getSatMath() >= Double.parseDouble(schoolInfo.get(10))
					&& universityList.get(i).getSatMath() <= Double.parseDouble(schoolInfo.get(11))
					&& universityList.get(i).getExpenses() >= Double.parseDouble(schoolInfo.get(12))
					&& universityList.get(i).getExpenses() <= Double.parseDouble(schoolInfo.get(13))
					&& universityList.get(i).getPerFinanAid() >= Double.parseDouble(schoolInfo.get(14))
					&& universityList.get(i).getPerFinanAid() <= Double.parseDouble(schoolInfo.get(15))
					&& universityList.get(i).getTotNumOfApplicant() >= Integer.parseInt(schoolInfo.get(16))
					&& universityList.get(i).getTotNumOfApplicant() <= Integer.parseInt(schoolInfo.get(17))
					&& universityList.get(i).getPerAdmitted() >= Double.parseDouble(schoolInfo.get(18))
					&& universityList.get(i).getPerAdmitted() <= Double.parseDouble(schoolInfo.get(19))
					&& universityList.get(i).getPerEnrolled() >= Double.parseDouble(schoolInfo.get(20))
					&& universityList.get(i).getPerEnrolled() <= Double.parseDouble(schoolInfo.get(21))
					&& universityList.get(i).getAcademicsScale() >= Integer.parseInt(schoolInfo.get(22))
					&& universityList.get(i).getAcademicsScale() <= Integer.parseInt(schoolInfo.get(23))
					&& universityList.get(i).getSocialScale() >= Integer.parseInt(schoolInfo.get(24))
					&& universityList.get(i).getSocialScale() <= Integer.parseInt(schoolInfo.get(25))
					&& universityList.get(i).getQualOfLifeScale() >= Integer.parseInt(schoolInfo.get(26))
					&& universityList.get(i).getQualOfLifeScale() <= Integer.parseInt(schoolInfo.get(27))) {
				schoolList.add(universityList.get(i));
			}
		} //////////////////////// search school without emphases
		
		for (int i = 28; i < schoolInfo.size(); i++) {
			emphases.add(schoolInfo.get(i));
		} //////////////////////// create emphases from schoolInfo to search
		
		if (!emphases.isEmpty()){
			for (int i = 0; i < schoolList.size(); i++) {
				for(int j = 0 ; j < emphases.size(); j++){
					if (schoolList.get(i).getEmphases().contains(emphases.get(j))){
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
	public ArrayList<University> searchRecomendations(University university){
		UniversityDBController db = new UniversityDBController();
		ArrayList<University> uni = db.getUniversityList();
		ArrayList<Double> max = new ArrayList<Double>();
		ArrayList<Double> min = new ArrayList<Double>();
		ArrayList<Double> diff = new ArrayList<Double>();
		ArrayList<University> recommendation = new ArrayList<University>();
		double dist = 0.0;
		HashMap<University, Double> sorted = new HashMap<University, Double>();
		
		for(int i =0; i < 12; i++){
			max.add(0.0);
			min.add(0.0);
		}/////initialize max min array
		
		for(int i = 0; i < uni.size(); i++){
			max.set(0, Math.max(max.get(0), uni.get(i).getNumOfEnrolled()));
			min.set(0, Math.min(min.get(0), uni.get(i).getNumOfEnrolled()));
			max.set(1, Math.max(max.get(1), uni.get(i).getFemaleRatio()));
			min.set(1, Math.min(max.get(1), uni.get(i).getFemaleRatio()));
			max.set(2, Math.max(max.get(2), uni.get(i).getSatVerbal()));
			min.set(2, Math.min(min.get(2), uni.get(i).getSatVerbal()));
			max.set(3, Math.max(max.get(3), uni.get(i).getSatMath()));
			min.set(3, Math.min(min.get(3), uni.get(i).getSatMath()));
			max.set(4, Math.max(max.get(4), uni.get(i).getExpenses()));
			min.set(4, Math.min(min.get(4), uni.get(i).getExpenses()));
			max.set(5, Math.max(max.get(5), uni.get(i).getPerFinanAid()));
			min.set(5, Math.min(min.get(5), uni.get(i).getPerFinanAid()));
			max.set(6, Math.max(max.get(6), uni.get(i).getTotNumOfApplicant()));
			min.set(6, Math.min(min.get(6), uni.get(i).getTotNumOfApplicant()));
			max.set(7, Math.max(max.get(7), uni.get(i).getPerAdmitted()));
			min.set(7, Math.min(min.get(7), uni.get(i).getPerAdmitted()));
			max.set(8, Math.max(max.get(8), uni.get(i).getPerEnrolled()));
			min.set(8, Math.min(min.get(8), uni.get(i).getPerEnrolled()));
			max.set(9, Math.max(max.get(9), uni.get(i).getAcademicsScale()));
			min.set(9, Math.min(min.get(9), uni.get(i).getAcademicsScale()));
			max.set(10, Math.max(max.get(10), uni.get(i).getSocialScale()));
			min.set(10, Math.min(min.get(10), uni.get(i).getSocialScale()));
			max.set(11, Math.max(max.get(11), uni.get(i).getQualOfLifeScale()));
			min.set(11, Math.min(min.get(11), uni.get(i).getQualOfLifeScale()));
		}////find max and min from db
		for(int i =0; i < max.size(); i++){
			diff.add(max.get(i)-min.get(i));
		}/// calculate difference of max and min
		for(int i =0; i < uni.size(); i++){
			dist = Math.abs((university.getNumOfEnrolled() - uni.get(i).getNumOfEnrolled()))/diff.get(0) 
					+ Math.abs((university.getFemaleRatio() - uni.get(i).getFemaleRatio()))/diff.get(1)
					+ Math.abs((university.getSatVerbal() - uni.get(i).getSatVerbal()))/diff.get(2)
					+ Math.abs((university.getSatMath() - uni.get(i).getSatMath()))/diff.get(3)
					+ Math.abs((university.getExpenses() - uni.get(i).getExpenses()))/diff.get(4)
					+ Math.abs((university.getPerFinanAid() - uni.get(i).getPerFinanAid()))/diff.get(5)
					+ Math.abs((university.getTotNumOfApplicant() - uni.get(i).getTotNumOfApplicant()))/diff.get(6)
					+ Math.abs((university.getPerAdmitted() - uni.get(i).getPerAdmitted()))/diff.get(7)
					+ Math.abs((university.getPerEnrolled() - uni.get(i).getPerEnrolled()))/diff.get(8)
					+ Math.abs((university.getAcademicsScale() - uni.get(i).getAcademicsScale()))/diff.get(9)
					+ Math.abs((university.getSocialScale() - uni.get(i).getSocialScale()))/diff.get(10)
					+ Math.abs((university.getQualOfLifeScale() - uni.get(i).getQualOfLifeScale()))/diff.get(11);
			if(university.getState().equals(uni.get(i).getState())){
				dist +=1.0;
			}
			if(university.getLocation().equals(uni.get(i).getLocation())){
				dist +=1.0;
			}
			if(university.getControl().equals(uni.get(i).getControl())){
				dist +=1.0;
			}
			sorted.put(uni.get(i),dist);
		}////// calculate distance of original school and other school to find recommendation
		
		Iterator it = sortByValue(sorted).iterator(); /////sorting university
		
		for(int i =0; i < 5; i++){
			recommendation.add((University) it.next());
		}
		return recommendation;
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