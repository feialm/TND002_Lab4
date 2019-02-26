package lab4;


import java.util.*;

/**
 * @author Fei Alm
 * @version 1.0
 * @since 2019
 */
public class Company extends Object{
	

	// has one dynamic array that stores all employees  (workers and directors)once
	private ArrayList<Employee> theCompanyList;


	/** The constructor takes no argument */
	public Company() {
		
		// skapar nytt objekt (arraylista) som ska innehålla Employee-objekt
		theCompanyList = new ArrayList<Employee>();
	}
	
	
	/**
	 * This instance method adds a director to the dynamic array of employees.
	 * @param directorWillBeAdded - the argument that is received to this method is of type Director
	 * */
	public void addEmployee(Director directorWillBeAdded) {
		// This instance method adds a director to the dynamic array of employees.
		theCompanyList.add(directorWillBeAdded);	
	}
	
	
	/**
	 * Adds a worker to theCompanyList and add worker to its directors list, theDirector
	 * @param aWorker - the worker that will be put into the list, type Worker
	 * @param theDirector - the director that the worker till be connected to
	 */
	public void addEmployee(Worker aWorker, Director theDirector) {
		
		// en chef och hans arbetare till listan
		
		theCompanyList.add(aWorker);
	
		// kopllar ihop worker och chef
		// skickar in wotker till metoden
		// lägger in i theDirector lista, alla hans/hennes workers
		theDirector.addEmployee(aWorker);	
	}



	/**
	 * Takes no argument.
	 * Displays the list of employees (workers and directors). Different titles for different sorting options
	 */
	public String toString() {
		
		String title = "List of Employees" + "\n------------------------";
		String result = "";
		String Employees = "";
		
		if(Employee.sortCriterion == Employee.BYNAME) {
			result = "\nFirst name    " + "Surname   " + "Number";
		}
			
		if(Employee.sortCriterion == Employee.BYSALARY){
			result = "\nFirst name    " + "Surname   " + "Number   " + "      Salary";
		}
	
		
		if(Employee.sortCriterion == Employee.BYTAXES) {
			result = "\nFirst name    " + "Surname   " + "Number   " + "      Taxes";
		}

		// hämtar Collections.sort med import java.util.*;
		// sorterar
		// sort metoden anropar compareTo och får svar på vad den ska sortera och hur
		Collections.sort(theCompanyList);
		
		// hämtar och skriver ut employee-listan
		for(int i = 0; i < theCompanyList.size(); i++ ) {
			Employees += "\n" + theCompanyList.get(i).toString();
		}
		
		
		title += result + Employees;
		return title;
	}
	
}