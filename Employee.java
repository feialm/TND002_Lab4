package lab4;


/**
 * @author Fei Alm
 * @version 1.0
 * @since 2019
 */
public abstract class Employee extends Object implements Comparable <Employee>{
		
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
	
	
	/**
	 * This method receives name, surname, employee number and salary in the arguments.
	 * The arguments initialize the variables (double) salary, (int) employeeNumber, (String) secondName, (String) firstName;
	 * 
	 * @param name1 - type  string
	 * @param name2 - type string
	 * @param employeeID - type int
	 * @param aSalary - type double
	 */
	public Employee(String name1, String name2, int employeeID, double aSalary) {
		
		firstName = name1;
		secondName = name2;
		employeeNumber = employeeID;
		salary = aSalary;
	
	}
	
	
	
	/**
	 * Change what type of sorting option that is used,
	 * BYNAME, BYSALARY, BYTAXES
	 * 
	 * @param sortingOption - type int, it is the sorting option that the criterion will be changed into
	 */
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
	
	
	
	/**
	 * Returns the name of a employee
	 * @return firstName + secondName
	 */
	public String getName() {	
		return firstName + secondName;
	}
	
	/**
	 * Returns ID-number of a employee
	 * @return employeeNumber
	 */
	public int getNumber() {
		return employeeNumber;
	}
	
	/**
	 * Returns the salary of a employee
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}
	
	
	/**
	 * Writes out information about every employee
	 */
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