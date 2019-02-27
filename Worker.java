
package lab4;

/**
 * @author Fei Alm
 * @version 1.0
 * @since 2019
 */

public class Worker extends Employee{
	
	/**
	 * Contructor for class Worker
	 * The arguments in constructor Worker defines a worker
	 * 
	 * 
	 * @param name1 - name of worker/director, type String
	 * @param name2 - surname of worker/director, type String
	 * @param employeeID - employee number, type int 
	 * @param aSalary - salary for employee, type double
	 */
	public Worker(String name1, String name2, int employeeID, double aSalary) {
		super( name1, name2, employeeID, aSalary);
		
	}
	
	
	/**
	 * Takes no argument
	 * Calculates a workers tax
	 * 
	 * @return sum
	 */
	public double computeTaxes() {
		
		double taxes = 0.25;
		double  sum = salary*taxes;

		return sum;
	}
	
	
	/**
	 * @param aWorker - the director that will be compared with the other directors, type Employee
	 */
	public int compareTo(Employee aWorker) {
		// hämta en workers salary
		// sortera BYNAME, BYSALARY, BYTAXES
		double aWorkersSalary = aWorker.getSalary();
		double aWorkersTax = aWorker.computeTaxes();
		int a = 0; 
		
		int comparingNames = this.secondName.compareTo(aWorker.secondName);
		
		if (Employee.sortCriterion == Employee.BYNAME) {
			a = comparingNames;
		}
		
		
		if(Employee.sortCriterion == Employee.BYSALARY) {
			if(this.getSalary() == aWorkersSalary) {
				a =0;
			}
			
			if(this.getSalary() < aWorkersSalary) {
				a = 1;
			}
			
			if(this.getSalary() > aWorkersSalary) {
				a = -1;
			}
		}
		
		
		if(Employee.sortCriterion == Employee.BYTAXES) {
			if(this.computeTaxes() == aWorkersTax) {
				a =0;
			}
			
			if(this.computeTaxes() < aWorkersTax) {
				a = 1;
			}
			
			if(this.computeTaxes() > aWorkersTax) {
				a = -1;
			}
		}

		return a;
	}

	
} // måsvinge till classen Worker