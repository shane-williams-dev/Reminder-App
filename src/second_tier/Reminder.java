/**
 * Reminder is the parent class of PurchaseReminder and UniReminder
 * It's attributes are String title, String message and double time.
 **/

package second_tier;
import java.io.*;

public abstract class Reminder implements Serializable {

	private static final long serialVersionUID = 100L;
	//Attributes
		protected String title;
		protected String message;
		protected double time;
		
	// Constructor
		Reminder () {	// Default Constructor
			title = null;
			message = null;
			time = 0.0;
		}
		
		public Reminder(String title, String message, double time) {
			super();
			this.title = title;
			this.message = message;
			this.time = time;
		}


	// Title Getters & Setters
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}

	// Title Getters & Setters 
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}

	// Time Getters & Setters 
		public double getTime() {
			return time;
		}
		public void setTime(double time) {
			this.time = time;
		}

	//toString()
		@Override
		public String toString() {
			return "\nTitle: " + title + "\nDescription: " + message + "\nTime: " + time+ "\n";

		}

} // end Reminder class
