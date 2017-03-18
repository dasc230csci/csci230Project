import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Controller.AccountDBController;
import Controller.DBController;
import Controller.UniversityController;
import Entity.Account;
import Entity.University;
import Entity.User;
import dblibrary.project.csci230.UniversityDBLibrary;

public class Test {

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
        Collections.reverse(list); // 주석시 오름차순
        return list;
    }
	
	
	public static void main(String args[]) {

		Test t = new Test();

		DBController db = new DBController();
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
		while(it.hasNext()){
			String temp = (String) it.next();
            System.out.println(temp + " = " + map.get(temp));
		}
		

	}
}
