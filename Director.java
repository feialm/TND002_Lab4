package lab4;

import java.util.ArrayList;

public class Director extends Employee{
	
	private ArrayList<Worker> workersThisDirectorList;
	
	
	//This constructor is called with the details of the worker
	//and it passes these on to the constructor of the superclass
	public Director (String firstName, String secondName, int eNumber, double salary) {
		
		super(firstName, secondName, eNumber, salary);
	}
	
	
	
	
	// lägger in worker som arbetar för en viss director i array
	public void addEmployee(Worker aWorker) {
		workersThisDirectorList.add(aWorker);	
	}
	
	
	
	public int compareTo(Employee aDirector) {
		
		// hämta en directors salary
		
		/** Varför samma method som gör samma sak i director o worker??? varför inte i Employee */
		
		double aDirectorsSalary = aDirector.getSalary();
		int a = 0; // if(this.getSalary() == aDirectorsSalary)
		
		if(this.getSalary() < aDirectorsSalary) {
			a = 1;
		}
		
		
		if(this.getSalary() > aDirectorsSalary) {
			a = -1;
		}

		return a;
	}
	
	public double computeBonus() {
		
		double sum_bonus = 0.0;
		double bonus = 0.1;
		
		for (int i = 0; i < workersThisDirectorList.size(); i++) {
			
			sum_bonus += workersThisDirectorList.get(i).computeTaxes();
		}
		
		sum_bonus= sum_bonus*bonus;
		
		
		return sum_bonus;
	}
	
	public double computeTaxes() {
		
		double taxes = 0.25;
		double result = 0.0;
		
		double the_bonus = this.computeBonus();
		
		result = (the_bonus + salary)*taxes;
		
		return result;
	}
	
	
}