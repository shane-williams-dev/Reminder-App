package first_tier;

import java.util.*; // for Scanner and ArrayList
import java.io.*; // for FileNotFoundException

import second_tier.*;
import second_tier.PurchaseReminder;
import second_tier.UniReminder;

public class UserInterface {
	public void begin () {
		Scanner input = new Scanner (System.in);
		// Creates the Reminder ArrayList object
		DataStorage reminder = new DataStorage();
		// Display menu and Process Uni and Purchase Reminders
		boolean finished = false, openedFile = false, fileSaved = true;
		String fileName = "data.obj"; // Assumes that the file is named data.obj
		while (!finished) {
			int selection = showMenu (input);
			switch (selection) {
				case 1: try {
								if (!openedFile) { // addAll() Appends the file data to the ArrayList data - Comes from ReminderWorker in 2nd tier.
									ReminderWorker pw = new ReminderWorker ();
									reminder.addAll (pw.openFile (fileName));
									System.out.println ("\n** File successfully opened **\n");
									openedFile = true;
								} else { // Don't double-up the data in the ArrayList
									System.out.println ("\n*** ERROR: File was not found or has already been opened ***\n");
								}
							}
							catch (ClassNotFoundException cnfe) {
								System.out.println ("\n**** ERROR: Problem with data type ****");
								openedFile = true;
							}
							catch (FileNotFoundException fnfe) {
								System.out.println ("\n**** ERROR: Cannot find the data file ****\n");
								openedFile = true; // To prevent doubling-up the data in the ArrayList
							}
							catch (IOException io) {
								System.out.println ("\n*** ERROR: Cannot perform I/O operation ***\n");
							}
							break;
				case 2: reminder.add (addPurchaseReminder (input));
							fileSaved = false;
							break;
				case 3: reminder.add (addUniReminder (input));
							fileSaved = false;
							break;
				case 4: System.out.println ("\nDisplaying the Reminder Information information ...");
							for (int i = 0; i < reminder.size(); i++) {
								// When displaying the contents of an object using print() or println()
								// Java automatically looks for a toString() method, and, if available
								// uses it to display the object contents.
								// Polymorphism ensures that the correct data is displayed for each
								// Uni or Purchase Reminder.
								System.out.println (reminder.get(i)); // equivalent to p.get(i).toString()
								System.out.println ("---------------------------------");
							}
							break;
				case 5: try {
								if (!openedFile) {
									System.out.println ("WARNING: This action will overwrite the data in the file -->");
									System.out.println ("Please open the file before saving!!");
								} else {
									fileSaved = saveFile (fileName, reminder);
								}
							}
				  			catch (IOException ioe) {
				  				System.out.println ("\n**** ERROR: Data cannot be saved ****\n");
				  			}
				  			break;
				case 6: if (!fileSaved) {
								String save = null;
								System.out.println ("\n*** WARNING: New data has NOT been saved ***\n");
								do { // Loop until user inputs y or n
									System.out.print ("Do you wish to save the new data? (y or n) ");
									save = input.nextLine().trim().toLowerCase();
								} while (!save.equals("n") && !save.equals("y"));
								if (save.equals("y")) {
									try {
										saveFile (fileName, reminder);
									}
						  			catch (IOException ioe) {
						  				System.out.println ("\n**** ERROR: Data cannot be saved ****\n");
						  			}
						  		}
							}
							finished = true; // Stops the while loop
							System.out.println ("\n*** Program Ended ***");
							System.out.println ("*** Thank you for using the Reminder App ***\n");
							break;
				default: System.out.println ("\n** Invalid Selection **\n");
			} // end switch
		} // end while loop
	} // end begin()

	public int showMenu (Scanner input) {
		int selection = 0, count = 0;
		System.out.println ("\n******* MENU *******\n");
		System.out.println (++count + ". Open Existing File");
		System.out.println (++count + ". Add a new Purchase Reminder");
		System.out.println (++count + ". Add a new Uni Reminder");
		System.out.println (++count + ". Display all details");
		System.out.println (++count + ". Save All Data to File");
		System.out.println (++count + ". Exit Program\n");
		System.out.print ("Type the number of your selection, and tap the Enter key: ");
		selection = input.nextInt();
		input.nextLine(); // flush the input line
		return selection;
	} // End of showMenu()

	public UniReminder addUniReminder (Scanner input) {
		//Reminder Name
		System.out.print ("\nReminder Name: ");
		String UrN = input.nextLine().trim(); 	
		
		// Description
		System.out.print (UrN+" description: ");
		String UrD = input.nextLine().trim();
		
		// Time
		System.out.print (UrN+" at time (seperate hours and minutes with a full stop): ");
		String StringUtime = input.nextLine().trim();
		double Utime = Double.parseDouble(StringUtime);
		
		// Subject Name
		System.out.print (UrN+" subject Name: ");
		String UrS = input.nextLine().trim();
		
		// Group Member Names
		System.out.print (UrN+" group member names (if any): ");
		String UgM = input.nextLine().trim();
		
		// Urgency
		System.out.print (UrN+" urgency (out of 10): ");
		int Uu = input.nextInt();
		
		input.nextLine();
		
		// Uni Reminder object created based on inputs and returned out of the function
		UniReminder u = new UniReminder (UrN, UrD, (double) Utime, UrS, UgM, (int) Uu);
		
		// *** Added success message
		System.out.println("*** University Reminder input successfully ***");
		
		return u;
	}	// end addUniReminder()

	public PurchaseReminder addPurchaseReminder (Scanner input) {


		// Reminder Name
		System.out.print ("\nReminder Name: ");
		String UrN = input.nextLine().trim(); 			
		
		// Description
		System.out.print (UrN+" description: ");
		String UrD = input.nextLine().trim();
		
		// Time
		System.out.print (UrN+" at time (seperate hours and minutes with a full stop): ");
		String StringUtime = input.nextLine().trim();
		double Utime = Double.parseDouble(StringUtime);
		
		// Item Name
		System.out.print (UrN+" brand name: ");
		String UiN = input.nextLine().trim();
		
		// Item Description
		System.out.print (UrN+" extra item information (if any): ");
		String UdN = input.nextLine().trim();
		
		// Estimated Price
		System.out.print (UrN+" estimated price (seperate dollars and cents with a full stop): $");
		double UeP = input.nextDouble();

		input.nextLine();
		
		// Purchase Reminder object creation based on inputs and returned out of the function
		PurchaseReminder p = new PurchaseReminder (UrN, UrD, Utime, UiN, UdN, (double) UeP);
		
		// *** Added success message
		System.out.println("\n*** Purchase Reminder input successfully ***");
		
		return p;

	} // end addPurchaseReminder()


	public boolean saveFile (String fileName, DataStorage list) throws IOException {
		ReminderWorker pw = new ReminderWorker ();
		pw.saveFile (fileName, list); // assuming file name
		System.out.println ("\n** Data Successfully Saved **\n");
		return true;
	}

} // end UserInterface class
