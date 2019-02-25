/**
 * @author Fei Alm
 * @version 1.0
 */


package lab4;

public abstract class Employee extends Object implements Comparable <Employee>{
	
	// ska dessa vara h�r?
	public static final int BYNAME = 0;
	public static final int BYSALARY = 1;	
	public static final int BYTAXES = 2;
	// de ska anv�ndas f�r att �ndra sortCriterion till 0, 1, 2
	
	static int sortCriterion = 0;
	// s�tter den som noll
	// ska �ndra hur man sorterar
	
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
	// it is implemented in the subclasses, allts� ska INGEN kod skrivas f�r den h�r
	// kod f�r denna method skrivs i Director och Worker
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
		// sedan kan man l�gga till mera beroende p� vilken  sorteringstyp man vill ha
		
		String result= String.format( "%-15s%-15s%-10d", firstName, secondName, employeeNumber);
		
		if (sortCriterion == BYSALARY) {
			// h�r l�gger till salary till string
			result = result + String.format("%-8f" ,salary) ;
		}
		
		
		if(sortCriterion == BYTAXES){
			// h�r l�gger till salary OCH taxes till string
			
			// double tax = computeTaxes(); //h�mtar tax fr�n director eller worker, fungerar f�r b�da
			
			result = result + String.format("%-8f" , computeTaxes());
		}
		
		return result;
	}
	
}