import java.util.ArrayList;

import Controller.DBController;
import dblibrary.project.csci230.UniversityDBLibrary;

public class TestSearch {

	public static void main(String[] args) {
		DBController db = new DBController();
		UniversityDBLibrary dblib = db.getDB();
		ArrayList<String> schoolInfo = new ArrayList<String>();
		ArrayList<String> schoolList = new ArrayList<String>();

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
		
		ArrayList<String> emphases = new ArrayList<String>();
		ArrayList<String> searched = new ArrayList<String>();
		String[][] school = dblib.university_getUniversities();

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
					if (db.getUniversity(schoolList.get(i)).getEmphases().contains(emphases.get(j))){
						searched.add(schoolList.get(i)); /////////////////////add school to final list that met with criteria
					}
				}
			}
		}
		else{
			searched = schoolList; //////////if emphases criteria is empty, then ignore it
		}
		
////////////////////////////////////////////////
		for (int i = 0; i < searched.size(); i++) {
			System.out.println(searched.get(i));
		}
		System.out.println("///////////////////////////////////////////////");
		for (int i = 0; i < db.getUniversity("MARIST COLLEGE").getEmphases().size(); i++) {
			System.out.println(db.getUniversity("MARIST COLLEGE").getEmphases().get(i));
		}

	}

}
