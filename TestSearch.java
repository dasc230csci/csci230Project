import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import Controller.SearchController;
import Controller.UniversityDBController;
import Entity.University;
import dblibrary.project.csci230.UniversityDBLibrary;

public class TestSearch {

	public static void main(String[] args) {
		SearchController s = new SearchController();
		ArrayList<String> schoolInfo = new ArrayList<String>();
		ArrayList<String> searched = new ArrayList<String>();

		schoolInfo.add("ST");// SCHOOL 0
		schoolInfo.add("");// STATE
		schoolInfo.add("");// LOC
		schoolInfo.add("");// CONTRO 3
		schoolInfo.add("0");// #STUDENT_LEAST 0 IF NULL
		schoolInfo.add("100000");// #STUDENT_MOST INFINITE IF NULL
		schoolInfo.add("0");// %FEMALE_LEAST 0 IF NULL
		schoolInfo.add("100");// %FEMALE_MOST INFINTE IF NULL
		schoolInfo.add("0");// SATVERB_LEAST
		schoolInfo.add("800");// SATVERB_MOST
		schoolInfo.add("0");// SATMATH_LEAST
		schoolInfo.add("800");// SATMATH_MOST
		schoolInfo.add("0");// EXPENSES_LEAST
		schoolInfo.add("100000");// EXPENSES_MOST
		schoolInfo.add("0");// %FINANAID_LEAST
		schoolInfo.add("100");// %FINANAID_MOST
		schoolInfo.add("0");// #APPLICANTS_LEAST 16
		schoolInfo.add("1000000");// #APPLICANTS_MOST 17
		schoolInfo.add("0");// %ADMIT_LEAST
		schoolInfo.add("100");// %ADMIT_MOST
		schoolInfo.add("0");// %ENROLL_LEAST
		schoolInfo.add("100");// %ENROLL_MOST
		schoolInfo.add("0");// ACA_SCALE_LEAST
		schoolInfo.add("5");// ACA_SCALE_MOST
		schoolInfo.add("0");// SOC_SCALE_LEAST
		schoolInfo.add("5");// SOC_SCALE_MOST
		schoolInfo.add("0");// LIFE_SCALE_LEAST
		schoolInfo.add("5");// LIFE_SCALE_MOST 27
		schoolInfo.add("FINE-ARTS");// EMPHASES #1 28
		schoolInfo.add("BIOLOGY");// EMPHASES #2
		//schoolInfo.add("");// EMPHASES #3
		//schoolInfo.add("");// EMPHASES #4
		//schoolInfo.add("");// EMPHASES #5 32
		////////////////////////////basic ArrayList structure for search. ArrayList must have 27 entries for now
		/////// all Entries except for emphases cannot be null, which means if the input value is null, then it must have default value
		////standard format for search method
		
		searched = s.search(schoolInfo);
		
		for (int i = 0; i < searched.size(); i++) {
			System.out.println(searched.get(i));
		}
		////////////////////////////////////////////////////
		TestSearch t = new TestSearch();

		UniversityDBController db = new UniversityDBController();
		UniversityDBLibrary dblib = db.getDB();
		University univ = db.getUniversity("ST JOHNS UNIVERSITY");
		ArrayList<String> recommendationList = new ArrayList<String>();
		HashMap<String, Double> map = new HashMap<String, Double>();
		
		String[][] str = dblib.university_getUniversities();
		
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
		Iterator it = t.sortByValue(map).iterator();
			
		/*for (int i = 0; i < 5; i++) {
			String temp = (String) it.next();
            System.out.println(temp + " = " + map.get(temp));
            recommendationList.add(temp);
		}*/
		/*while(it.hasNext()){
			String temp = (String) it.next();
            System.out.println(temp + " = " + map.get(temp));
		}*/
		for(int i =0; i < 5 ; i++){
			String tmp = (String) it.next();
			recommendationList.add(tmp);
		}
		/*for(int i=0; i < recommendationList.size(); i++){
			System.out.println(recommendationList.get(i));
		}*/
	}

	
	////////////////////////////////////////////////////////
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
