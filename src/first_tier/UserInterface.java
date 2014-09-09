package first_tier;

import java.io.*; // for FileNotFoundException

import javax.swing.JOptionPane;

import second_tier.*;
/**
* Scenario Stage 2 demo program - 1st-tier class.

**/
public class UserInterface {
	public void begin () {
		DataStorage reminder = new DataStorage();
		// Display menu and Process Uni and Purchase Reminders
		boolean finished = false, fileSaved = true;
		String objFile = "data.obj"; // Assumes that the file is named data.obj
		
		try {
			ReminderWorker rw = new ReminderWorker ();
			reminder.addAll (rw.openFile (objFile));
			JOptionPane.showMessageDialog (null, "\n** File successfully opened **\n", "Success",  JOptionPane.PLAIN_MESSAGE);
		}
		catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog (null, "\n**** ERROR: Cannot find the data file ****\n", "ERROR",  JOptionPane.ERROR_MESSAGE);
		}
		catch (IOException io) {
			JOptionPane.showMessageDialog (null, "\n*** ERROR: Cannot perform I/O operation ***\n", "ERROR",  JOptionPane.ERROR_MESSAGE);
			finished = true; // stops the while loop - ERROR stop
		}
		catch (ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog (null, "\n** ERROR: Cannot read file correctly **\n", "ERROR",  JOptionPane.ERROR_MESSAGE);
			finished = true; // stops the while loop - ERROR stop
		}
		if (finished) {
			JOptionPane.showMessageDialog (null, "\n*** Fatal ERROR - Program Ended ***\n" +
					"\n*** Please contact you computer services centre ***\n", "ERROR",  JOptionPane.ERROR_MESSAGE);
		}
		
		while (!finished) {
			int selection = showMenu ();
			switch (selection) {
				case 1: reminder.add (addPurchaseReminder ());
							fileSaved = false;
							break;
				case 2: reminder.add (addUniReminder ());
							fileSaved = false;
							break;
				case 3: JOptionPane.showMessageDialog (null, "Displaying the Reminder information ...", "Reminder List", JOptionPane.PLAIN_MESSAGE);
							for (int i = 0; i < reminder.size(); i++) {
								// When displaying the contents of an object using print() or println()
								// Java automatically looks for a toString() method, and, if available
								// uses it to display the object contents.
								// Polymorphism ensures that the correct data is displayed for each
								// Employee or Student.
								JOptionPane.showMessageDialog (null, reminder.get(i), "Reminder Details", JOptionPane.PLAIN_MESSAGE);
							}
							break;
				case 4: try {
								fileSaved = saveFile (objFile, reminder);
							}
							catch (IOException ioe) {
								JOptionPane.showMessageDialog (null, "**** ERROR: Data cannot be saved ****\n" +
										"*** Fatal ERROR Program Ended ***\n" +
										"*** Please contact you computer services centre ***",
										"FATAL ERROR", JOptionPane.ERROR_MESSAGE);
								finished = true; // stops the while loop - ERROR stop
							}
				  			break;
				case 5: String fatalStop = "OK";
							if (!fileSaved) {
							String save = "y";
							JOptionPane.showMessageDialog (null, "*** WARNING: New data has NOT been saved ***", "WARNING", JOptionPane.WARNING_MESSAGE);
							do { // loop until we get y or n
								save = JOptionPane.showInputDialog ("Do you wish to save the new data? (y or n) ").trim().toLowerCase();
							} while (!save.equals("n") && !save.equals("y"));
							if (save.equals("y")) {
								try {
									saveFile (objFile, reminder);
								}
					  			catch (IOException ioe) {
					  				JOptionPane.showMessageDialog (null, "**** ERROR: Data cannot be saved ****\n" +
					  						"*** Fatal ERROR Program Ended ***\n" +
					  						"*** Please contact you computer services centre ***",
					  						"FATAL ERROR", JOptionPane.ERROR_MESSAGE);
					  				fatalStop = "ERROR";
					  			}
					  		}
						}
						finished = true; // stops the while loop - normal & ERROR
						if (fatalStop.equals("OK")) {
							JOptionPane.showMessageDialog (null, "*** Program Ended ***\n" +
									"*** Thank you for using this program ***");
						}
						break;
				default: JOptionPane.showMessageDialog (null, "\n** Invalid Selection **\n", "ERROR", JOptionPane.ERROR_MESSAGE);
			} // end switch
		} // end while loop
	} // end begin()

	public int showMenu () {
		int selection = 0;
		String stringSelection = JOptionPane.showInputDialog (
				"******* MENU *******\n\n" +
				"1. Add a new Purchase Reminder\n" +
				"2. Add a new Uni Reminder\n" +
				"3. Display all Details\n" +
				"4. Save All Data to File\n" +
				"5. Exit Program\n\n" +
				"Type the number of your selection, and click OK: ");
		selection = Integer.parseInt (stringSelection.trim());
		return selection;
	} // end showMenu()

	public UniReminder addUniReminder () {
		UniReminder u = new UniReminder ();
		
		//Reminder Name
		String UrN = (JOptionPane.showInputDialog (null, "\nWhat is the reminders name? ")).trim();  // trim() gets rid of leading & trailing whitespace
		u.setTitle (UrN);	
		
		// Description
		String UrD = (JOptionPane.showInputDialog (null, "Describe " + UrN + ": ")).trim();  // trim() gets rid of leading & trailing whitespace
		u.setMessage (UrD);
		
		// Time
		String StringUTime = (JOptionPane.showInputDialog (null, "Time of " + UrN + ": ")).trim();  // trim() gets rid of leading & trailing whitespace
		double UTime = Double.parseDouble(StringUTime);
		u.setTime (UTime);
		
		// Subject Name
		String UrS = (JOptionPane.showInputDialog (null, "What subject is" + UrN + "is for? ")).trim();  // trim() gets rid of leading & trailing whitespace
		u.setSubject (UrS);
		
		// Group Member Names
		String UgM = (JOptionPane.showInputDialog (null, "Who is in your group?")).trim();  // trim() gets rid of leading & trailing whitespace
		u.setGroupMembers (UgM);
		
		// Urgency
		String UuInt = (JOptionPane.showInputDialog (null, "How urgent is " + UrN + "? ")).trim();  // trim() gets rid of leading & trailing whitespace
		int Uu = Integer.parseInt(UuInt);
		u.setUrgency (Uu);
		
		return u;
	}	// end addUniReminder()

	public PurchaseReminder addPurchaseReminder () {
		PurchaseReminder p = new PurchaseReminder ();

		//Reminder Name
		String PrN = (JOptionPane.showInputDialog (null, "\nWhat is the reminders name? ")).trim();  // trim() gets rid of leading & trailing whitespace
		p.setTitle (PrN);	
				
		// Description
		String PrD = (JOptionPane.showInputDialog (null, "Describe " + PrN + ": ")).trim();  // trim() gets rid of leading & trailing whitespace
		p.setMessage (PrD);
				
		// Time
		String StringPTime = (JOptionPane.showInputDialog (null, "Time of (use a . to seperate minutes and hours)" + PrN + ": ")).trim();  // trim() gets rid of leading & trailing whitespace
		double PTime = Double.parseDouble(StringPTime);
		p.setTime (PTime);
		
		// Description
		String PrI = (JOptionPane.showInputDialog (null, "What is the name of the item? ")).trim();  // trim() gets rid of leading & trailing whitespace
		p.setItem (PrI);
		
		// Description
		String PiD = (JOptionPane.showInputDialog (null, "Describe the Item or give its brand name: ")).trim();  // trim() gets rid of leading & trailing whitespace
		p.setItemDescription (PiD);
		
		// Price
		String StringPPrice = (JOptionPane.showInputDialog (null, "Estimate how much " + PrI + " will cost: ")).trim();  // trim() gets rid of leading & trailing whitespace
		double PPrice = Double.parseDouble(StringPPrice);
		p.setTime (PPrice);
		
		return p;

	} // end addPurchaseReminder()


	public boolean saveFile (String fileName, DataStorage list) throws IOException {
		ReminderWorker rw = new ReminderWorker ();
		rw.saveFile (fileName, list); // assuming file name
		JOptionPane.showMessageDialog (null, "\n** Data Successfully Saved **\n");
		return true;
	}

} // end UserInterface class
