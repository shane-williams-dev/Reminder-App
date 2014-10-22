/**
 * UniReminder contains the attributes String subject, String groupMembers and int urgency.
 **/

package second_tier;

public class UniReminder extends Reminder {
	private static final long serialVersionUID = 100L;
	
	//Attributes
		private String subject;
		private String groupMembers;
		private int urgency;
		
	//Constructor
		public UniReminder() { // Default Constructor
			super();
			subject = null;
			groupMembers = null;
			urgency = 0;
		}
		
		public UniReminder(String title, String message, double time, String subject, String groupMembers, int urgency) {
			super(title, message, time);
			this.subject = subject;
			this.groupMembers = groupMembers;
			this.urgency = urgency;
		}
		
	// Subject Getters & Setters 
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}

	// GroupMembers Getters & Setters 
		public String getGroupMembers() {
			return groupMembers;
		}
		public void setGroupMembers(String groupMembers) {
			this.groupMembers = groupMembers;
		}

	// Urgency Getters & Setters 
		public int getUrgency() {
			return urgency;
		}
		public void setUrgency(int urgency) {
			this.urgency = urgency;
		}

	//toString
		@Override
		public String toString() {
			// *** Added differentiation between Purchase and University Reminder
			return "\n!!! University Reminder !!!\n" + super.toString() + "Subject Name: " + getSubject() +
					"\nGroup Member Names: " + getGroupMembers() +
					"\nUrgency: " + getUrgency();
		}

} // end UniReminder class
