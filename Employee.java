/**
 * @author Fei Alm
 * @version 1.0
 */


package lab4;

public abstract class Employee extends Object implements Comparable <Employee>{
	
	// ska dessa vara här?
	public static final int BYNAME = 0;
	public static final int BYSALARY = 1;	
	public static final int BYTAXES = 2;
	// de ska användas för att ändra sortCriterion till 0, 1, 2
	
	static int sortCriterion = 0;
	// sätter den som noll
	// ska ändra hur man sorterar
	
	double salary;
	int employeeNumber;
	String secondName;
	String firstName;
	
	
	public Employee(String name1, String name2, int employeeID, double aSalary) {
		
		firstName = name1;
		secondName = name2;
		employeeNumber = employeeID;
		salary = aSalary;
	
	}
	
	public static void changeCriterion(int sortingOption) {
		
		
		if (sortingOption != BYNAME && sortingOption != BYSALARY  && sortingOption != BYTAXES) {
			
			System.out.println("Option doesn't exist!");
		} 
		else
		{
			sortCriterion  = sortingOption;
		}
	}
	
	
	// This instance method returns the taxes paid by the employee
	// it is implemented in the subclasses, alltså ska INGEN kod skrivas för den här
	// kod för denna method skrivs i Director och Worker
	public abstract double computeTaxes();
	
	public String getName() {	
		return firstName + secondName;
	}
	
	
	public int getNumber() {
		return employeeNumber;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String toString() {
		// return information about employee
		// firstname, second, employee number ska alltid vara med i return
		// sedan kan man lägga till mera beroende på vilken  sorteringstyp man vill ha
		
		String result= String.format( "%-15s%-15s%-10d", firstName, secondName, employeeNumber);
		
		if (sortCriterion == BYSALARY) {
			// här lägger till salary till string
			result = result + String.format("%-8f" ,salary) ;
		}
		
		
		if(sortCriterion == BYTAXES){
			// här lägger till salary OCH taxes till string
			
			// double tax = computeTaxes(); //hämtar tax från director eller worker, fungerar för båda
			
			result = result + String.format("%-8f" , computeTaxes());
		}
		
		return result;
	}
	
}