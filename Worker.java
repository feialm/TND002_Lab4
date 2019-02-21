package lab4;

public class Worker extends Employee{
	
	public Worker(String name1, String name2, int employeeID, double aSalary) {
		super( name1, name2, employeeID, aSalary);
		
	}
	
	public double computeTaxes() {
		
		double taxes = 0.25;
		double  sum = salary*taxes;

		return sum;
	}
	
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