package lab4;

import java.util.*;

public class Company extends Object{
	
	// has one dynamic array that stores all employees  (workers and directors)once
	private ArrayList<Employee> theCompanyList;

	
	public Company() {
		
		// slapar nytt objekt (arraylista) som ska innehålla Employee-objekt
		theCompanyList = new ArrayList<Employee>();
	}
	
	public void addEmployee(Director directorWillBeAdded) {
		// This instance method adds a director to the dynamic array of employees.
		theCompanyList.add(directorWillBeAdded);	
	}
	
	
	
	public void addEmployee(Worker aWorker, Director theDirector) {
		
		// en chef och hans arbetare till listan
		
		theCompanyList.add(theDirector);
		theCompanyList.add(aWorker);
	
		// kopllar ihop worker och chef
		// skickar in wotker till metoden
		// lägger in i theDirector lista, alla hans/hennes workers
		theDirector.addEmployee(aWorker);	
	}


	
	public String toString() {
		
		String title = "List of Employees" + "\n------------------------";
		String result = "";
		String Employees = "";
		
		if(Employee.sortCriterion == Employee.BYNAME) {
			result = "First name    " + "Surname   " + "Number";
		}
			
		if(Employee.sortCriterion == Employee.BYSALARY){
			result = "First name    " + "Surname   " + "Number   " + "Salary";
		}
	
		
		if(Employee.sortCriterion == Employee.BYTAXES) {
			result = "First name    " + "Surname   " + "Number   " + "Taxes";
		}

		// hämtar Collections.sort med import java.util.*;
		// sorterar
		// sort metoden anropar compareTo och får svar på vad den ska sortera och hur
		Collections.sort(theCompanyList);
		
		// hämtar och skriver ut employee-listan
		for(int i = 0; i < theCompanyList.size(); i++ ) {
			Employees = "\n" + theCompanyList.get(i).toString();
		}
		
		
		title += result + Employees;
		return title;
	}
	
}