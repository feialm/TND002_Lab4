

package lab4;

import java.util.ArrayList;

/**
 * @author Fei Alm
 * @version 1.0
 * @since 2019
 */
public class Director extends Employee{
	
	private ArrayList<Worker> workersThisDirectorList;
	
	
	//This constructor is called with the details of the worker
	//and it passes these on to the constructor of the superclass
	
	/**
	 * Constructor for class Director.
	 * Makes a new list for every new director
	 * 
	 * @param firstName - name of worker/director, type String
	 * @param secondName - surname of worker/director, type String
	 * @param eNumber - employee number, type int 
	 * @param salary - salary for employee, type double
	 */
	public Director (String firstName, String secondName, int eNumber, double salary) {
		
		super(firstName, secondName, eNumber, salary);
		workersThisDirectorList = new ArrayList<Worker>();
	}
	
	
	
	/***
	 * Add worker into the the director list for his/hers employees
	 * @param aWorker - a worker that works for a director, type Worker
	 */
	// lägger in worker som arbetar för en viss director i array
	public void addEmployee(Worker aWorker) {
		workersThisDirectorList.add(aWorker);	
	}
	
		
	/**
	 * @param aDirector - the director that will be compared with the other directors, type Employee
	 */
	public int compareTo(Employee aDirector) {
		
		// hämta en directors salary
		
		// Varför samma method som gör samma sak i director o worker??? varför inte i Employee

		// sortera BYNAME, BYSALARY, BYTAXES
		double aDirectorsSalary = aDirector.getSalary();
		double aDirectorsTax = aDirector.computeTaxes();
		int a = 0; 
		
		int comparingNames = this.secondName.compareTo(aDirector.secondName);
		
		if (Employee.sortCriterion == Employee.BYNAME) {
			a = comparingNames;
		}
		
		
		if(Employee.sortCriterion == Employee.BYSALARY) {
			if(this.getSalary() == aDirectorsSalary) {
				a =0;
			}
			
			if(this.getSalary() < aDirectorsSalary) {
				a = 1;
			}
			
			if(this.getSalary() > aDirectorsSalary) {
				a = -1;
			}
		}

		
		
		if(Employee.sortCriterion == Employee.BYTAXES) {
			if(this.computeTaxes() == aDirectorsTax) {
				a =0;
			}
			
			if(this.computeTaxes() < aDirectorsTax) {
				a = 1;
			}
			
			if(this.computeTaxes() > aDirectorsTax) {
				a = -1;
			}
		}
		
		return a;
	}
	
	
	
	/**
	 * Method takes no argument
	 * Calculate the bonus a director will get according to how many workers he/she has
	 * 
	 * @return sum_bonus , the sum of the bonus a director will get
	 */
	public double computeBonus() {
		
		double sum_bonus = 0.0;
		double bonus = 0.1;
		
		for (int i = 0; i < workersThisDirectorList.size(); i++) {
			
			sum_bonus += workersThisDirectorList.get(i).salary;
		}
		
		sum_bonus= sum_bonus*bonus;
		
		
		return sum_bonus;
	}
	
	/**
	 * Takes no argument
	 * Calculates the tax for a director
	 * 
	 * @return result
	 * */
	
	public double computeTaxes() {
		
		double taxes = 0.25;
		double result = 0.0;
		
		double the_bonus = this.computeBonus();
		
		result = (the_bonus + salary)*taxes;
		
		return result;
	}
	
	
}