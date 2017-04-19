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
 * public class searchController, controls all calls made to search through the
 * university database with the methods stored in the class, then makes the call
 * to the DB controller to conducted the search.
 * 
 * @author Daniel M. Song, Anh B. Tran, Caitlin E. Harvey, Samuel J. Halloran
 * @version March 27, 2017
 */

public class SearchController {

	/**
	 * DBController to search school
	 */
	private UniversityDBController universityDBController;

	/**
	 * Default Constructor. Initialize UniversityDBController.
	 */
	public SearchController() {
		universityDBController = new UniversityDBController();
	}

	///////////////////
	private HashMap<String, Float> list = new HashMap<String, Float>();

	public HashMap<String, Float> getList() {
		return list;
	}
	///////////////////

	/**
	 * the search() method, used whenever a call is made by ] the user to search
	 * for schools similar to the provided school parameter, returning a
	 * collection of University objects with similar school statistics as the
	 * parameter
	 * 
	 * @param ArrayList<String>
	 *            information of the school to search
	 * @return ArrayList<University> a collection of University objects
	 */
	public ArrayList<University> search(ArrayList<String> criteria) {
		ArrayList<University> universityList = universityDBController.getUniversityList();
		ArrayList<University> searched = new ArrayList<University>();
		for (University compareUniv : universityList) {
			if (!compareUniv.getSchoolName().contains(criteria.get(0))) {
				continue;
			}
			if (!compareUniv.getState().contains(criteria.get(1))) {
				continue;
			}
			if (!compareUniv.getLocation().contains(criteria.get(2))) {
				continue;
			}
			if (!compareUniv.getControl().contains(criteria.get(3))) {
				continue;
			}
			if (!criteria.get(4).equals("")) {
				if (compareUniv.getNumOfEnrolled() < Integer.parseInt(criteria.get(4))) {
					continue;
				}
			}
			if (!criteria.get(5).equals("")) {
				if (compareUniv.getNumOfEnrolled() > Integer.parseInt(criteria.get(5))) {
					continue;
				}
			}
			if (!criteria.get(6).equals("")) {
				if (compareUniv.getFemaleRatio() < Double.parseDouble(criteria.get(6))) {
					continue;
				}
			}
			if (!criteria.get(7).equals("")) {
				if (compareUniv.getFemaleRatio() > Double.parseDouble(criteria.get(7))) {
					continue;
				}
			}
			if (!criteria.get(8).equals("")) {
				if (compareUniv.getSatVerbal() < Double.parseDouble(criteria.get(8))) {
					continue;
				}
			}
			if (!criteria.get(9).equals("")) {
				if (compareUniv.getSatVerbal() > Double.parseDouble(criteria.get(9))) {
					continue;
				}
			}
			if (!criteria.get(10).equals("")) {
				if (compareUniv.getSatMath() < Double.parseDouble(criteria.get(10))) {
					continue;
				}
			}
			if (!criteria.get(11).equals("")) {
				if (compareUniv.getSatMath() > Double.parseDouble(criteria.get(11))) {
					continue;
				}
			}
			if (!criteria.get(12).equals("")) {
				if (compareUniv.getExpenses() < Double.parseDouble(criteria.get(12))) {
					continue;
				}
			}
			if (!criteria.get(13).equals("")) {
				if (compareUniv.getExpenses() > Double.parseDouble(criteria.get(13))) {
					continue;
				}
			}
			if (!criteria.get(14).equals("")) {
				if (compareUniv.getPerFinanAid() < Double.parseDouble(criteria.get(14))) {
					continue;
				}
			}
			if (!criteria.get(15).equals("")) {
				if (compareUniv.getPerFinanAid() > Double.parseDouble(criteria.get(15))) {
					continue;
				}
			}
			if (!criteria.get(16).equals("")) {
				if (compareUniv.getTotNumOfApplicant() < Integer.parseInt(criteria.get(16))) {
					continue;
				}
			}
			if (!criteria.get(17).equals("")) {
				if (compareUniv.getTotNumOfApplicant() > Integer.parseInt(criteria.get(17))) {
					continue;
				}
			}
			if (!criteria.get(18).equals("")) {
				if (compareUniv.getPerAdmitted() < Double.parseDouble(criteria.get(18))) {
					continue;
				}
			}
			if (!criteria.get(19).equals("")) {
				if (compareUniv.getPerAdmitted() > Double.parseDouble(criteria.get(19))) {
					continue;
				}
			}
			if (!criteria.get(20).equals("")) {
				if (compareUniv.getPerEnrolled() < Double.parseDouble(criteria.get(20))) {
					continue;
				}
			}
			if (!criteria.get(21).equals("")) {
				if (compareUniv.getPerEnrolled() > Double.parseDouble(criteria.get(21))) {
					continue;
				}
			}
			if (!criteria.get(22).equals("")) {
				if (compareUniv.getAcademicsScale() < Integer.parseInt(criteria.get(22))) {
					continue;
				}
			}
			if (!criteria.get(23).equals("")) {
				if (compareUniv.getAcademicsScale() > Integer.parseInt(criteria.get(23))) {
					continue;
				}
			}
			if (!criteria.get(24).equals("")) {
				if (compareUniv.getSocialScale() < Integer.parseInt(criteria.get(24))) {
					continue;
				}
			}
			if (!criteria.get(25).equals("")) {
				if (compareUniv.getSocialScale() > Integer.parseInt(criteria.get(25))) {
					continue;
				}
			}
			if (!criteria.get(26).equals("")) {
				if (compareUniv.getQualOfLifeScale() < Integer.parseInt(criteria.get(26))) {
					continue;
				}
			}
			if (!criteria.get(27).equals("")) {
				if (compareUniv.getQualOfLifeScale() > Integer.parseInt(criteria.get(27))) {
					continue;
				}
			}
			for (int i = 28; i < criteria.size(); i++) {
				if (criteria.get(i).equals("")) { // emphases empty
					if (i == 28) {
						searched.add(compareUniv);
						break;
					}
					break;
				} else if (compareUniv.getEmphases().contains(criteria.get(i))) {
					if (searched.contains(compareUniv)) {
						continue; ////// duplicate detection
					}
					searched.add(compareUniv);
				}
			}
		}
		return searched;
	}

	/**
	 * the searchRecomendations() method, returns the top 5 schools it finds to
	 * be the most similar to the parameter provided University
	 * 
	 * @param University
	 *            university object to search recommendation
	 * @return ArrayList<University> a collection of 5 university objects
	 */
	public ArrayList<University> searchRecomendations(University university) {
		UniversityDBController db = new UniversityDBController();
		ArrayList<University> uni = db.getUniversityList();
		ArrayList<Double> max = new ArrayList<Double>();
		ArrayList<Double> min = new ArrayList<Double>();
		ArrayList<Double> diff = new ArrayList<Double>();
		ArrayList<University> recommendation = new ArrayList<University>();
		double dist = 0.0;
		HashMap<University, Double> sorted = new HashMap<University, Double>();

		for (int i = 0; i < 12; i++) {
			max.add(0.0);
			min.add(0.0);
		} ///// initialize max min array

		for (int i = 0; i < uni.size(); i++) {
			max.set(0, Math.max(max.get(0), uni.get(i).getNumOfEnrolled()));
			min.set(0, Math.min(min.get(0), uni.get(i).getNumOfEnrolled()));
			max.set(1, Math.max(max.get(1), uni.get(i).getFemaleRatio()));
			min.set(1, Math.min(min.get(1), uni.get(i).getFemaleRatio()));
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
		} //// find max and min from db
		for (int i = 0; i < max.size(); i++) {
			diff.add(max.get(i) - min.get(i));
		} /// calculate difference of max and min
		for (int i = 0; i < uni.size(); i++) {
			dist = Math.abs((university.getNumOfEnrolled() - uni.get(i).getNumOfEnrolled())) / diff.get(0)
					+ Math.abs((university.getFemaleRatio() - uni.get(i).getFemaleRatio())) / diff.get(1)
					+ Math.abs((university.getSatVerbal() - uni.get(i).getSatVerbal())) / diff.get(2)
					+ Math.abs((university.getSatMath() - uni.get(i).getSatMath())) / diff.get(3)
					+ Math.abs((university.getExpenses() - uni.get(i).getExpenses())) / diff.get(4)
					+ Math.abs((university.getPerFinanAid() - uni.get(i).getPerFinanAid())) / diff.get(5)
					+ Math.abs((university.getTotNumOfApplicant() - uni.get(i).getTotNumOfApplicant())) / diff.get(6)
					+ Math.abs((university.getPerAdmitted() - uni.get(i).getPerAdmitted())) / diff.get(7)
					+ Math.abs((university.getPerEnrolled() - uni.get(i).getPerEnrolled())) / diff.get(8)
					+ Math.abs((university.getAcademicsScale() - uni.get(i).getAcademicsScale())) / diff.get(9)
					+ Math.abs((university.getSocialScale() - uni.get(i).getSocialScale())) / diff.get(10)
					+ Math.abs((university.getQualOfLifeScale() - uni.get(i).getQualOfLifeScale())) / diff.get(11);
			if (!university.getState().equals(uni.get(i).getState())) {
				dist += 1.0;
			}
			if (!university.getLocation().equals(uni.get(i).getLocation())) {
				dist += 1.0;
			}
			if (!university.getControl().equals(uni.get(i).getControl())) {
				dist += 1.0;
			}
			if (!university.getSchoolName().equals(uni.get(i).getSchoolName())){
				dist += 1.0;
			}
			///////////////////////////////////////////
			//int compareEmphases = university.getEmphases().size() + uni.get(i).getEmphases().size();
			//Set<String> emphasesSet = new HashSet<String>();
			//emphasesSet.addAll(university.getEmphases());
			//emphasesSet.addAll(uni.get(i).getEmphases());
			//dist += -compareEmphases + emphasesSet.size()*2;
			///////////////////////////////////////////////////////compare emphases
			
			sorted.put(uni.get(i), dist);
		} ////// calculate distance of original school and other school to find recommendation

		Iterator it = sortByValue(sorted).iterator(); ///// sorting university

		for (int i = 0; i < 6; i++) {
			recommendation.add((University) it.next());
		}
		/////////////////////////// test
		for(int i =0; i < recommendation.size(); i++){
			list.put(recommendation.get(i).getSchoolName(), sorted.get(recommendation.get(i)).floatValue());
		}
		////////////////////////// test
		return recommendation;
	}

	/**
	 * sortByValue() sort map by value. Sort from the lowest to the highest
	 * value number of the key
	 * 
	 * @param map
	 *            to sort
	 * @return List sorted key from the lowest to the highest value
	 */
	private static List sortByValue(final Map map) {
		List<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator() {

			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}

		});
		Collections.reverse(list);
		return list;
	}
}