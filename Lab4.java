package lab4;


import javax.swing.*; // för att dialog window ska vara i programmet, importerar JOptionPane
import java.io.*; //så att BufferedReader och InputStreamReader ska fungera

/**
 * 
 * Lab4 is the main class.
 * 
 * @author Fei Alm
 * @version 1.0
 * @since 2019
 *
 */


public class Lab4 {

	/**
	 * This method (main) is where input are put into the program and where the output are shown
	 * @param args - array of type string
	 * @throws IOException to see if the inputs are correct
	 */
	public static void main(String[] args) throws IOException{
		
		Company theCompany = new Company();


		Director director1 = new Director("John", "Smith", 1, 700000.0);
		Director director2 = new Director("Elaine", "Garret", 2, 670000.0);
		
		// We add the directors to the company

		
		theCompany.addEmployee(director1);theCompany.addEmployee(director2);
		
		
		
		// We add workers to the company and assign them to a director.

		theCompany.addEmployee(new Worker("Paul", "Johnson", 3, 400000.0),director1);
		theCompany.addEmployee(new Worker("Sarah", "Davidson", 4, 420000.0),director1);
		theCompany.addEmployee(new Worker("Doris","McClure", 5, 470000.0),director1);
		theCompany.addEmployee(new Worker("James", "Adams", 6, 340000.0),director1);
		theCompany.addEmployee(new Worker("Sam", "Cooper", 7, 460000.0),director2);
		theCompany.addEmployee(new Worker("Andrea","Lester", 8, 460000.0),director2);
		theCompany.addEmployee(new Worker("Olga", "Gibbs", 9, 420000.0),director2);
		
		//Here we change the sorting criterium using the class constants of Employee: 
		//BYNAME = 0, BYSALARY = 1, BYTAXES = 2.
		
		// This is the code for part B.
		
		//System.out.println("Sort by name (enter 0), sort by salary (1), sort by taxes (2)");

		do {
		JOptionPane.showMessageDialog(null, "You want to sort by Surname (1), Salary (2) or paid Taxes (3)?");
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		String text  = in.readLine();	
		
		
		
		// NumberFormatException gångar det sorterns fel
		try{
				int x = Integer.parseInt(text);
								
				//Beroende på vilket input, anrop funktion och förbed hur allt ska sorteras
				if ( x == 1 ) {
					Employee.changeCriterion(Employee.BYNAME);
				}
				else if(x == 2) {
					Employee.changeCriterion(Employee.BYSALARY);
				}
				else if(x == 3) {
					Employee.changeCriterion(Employee.BYTAXES);
				}
				else {
					throw new Exception("Try again, wrong number!");
				}
				
				
				//System.out.println(theCompany);
				JOptionPane.showMessageDialog(null,theCompany);
				// skriva ut företaget, directors med deras workers, det är typ theCompany.toString, Java vet det redan
				break;
			
		}
		catch(java.lang.NumberFormatException e) {
			//System.out.println("Try again, wrong inputformat!");
			JOptionPane.showMessageDialog(null, "Try again");
		}
		catch(Exception e) {
			
			System.out.println("Try again!");
			
			JOptionPane.showMessageDialog(null, e.getMessage());
			// skriver ut från throw new Exception("Wrong type of input!");
			// om ett fel sker, hämtar den den sortens fel och dess felmeddleande och skriver ut
			// då skitvs int heller listan ut	
		}
	
		}while(true);
	
	}
		
}// måsvinge till klassen lab4