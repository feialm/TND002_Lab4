package lab4;

import java.util.ArrayList;

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
		
		return " ";
	}
	
}