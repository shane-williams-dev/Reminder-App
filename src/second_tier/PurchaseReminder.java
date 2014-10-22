/**
 * PurchaseReminder contains the attributes String item, String itemDescription and estimatedPrice.
 **/

package second_tier;

public class PurchaseReminder extends Reminder {
	private static final long serialVersionUID = 100L;
	// Attributes
		private String item;
		private String itemDescription;
		private double estimatedPrice;
		
	// Constructor
		public PurchaseReminder() { // Default Constructor
			super();
			item = null;
			itemDescription = null;
			estimatedPrice = 0.0;
		}
		
		public PurchaseReminder(String title, String message, double time,
				String item, String itemDescription, double estimatedPrice) {
			super(title, message, time);
			this.item = item;
			this.itemDescription = itemDescription;
			this.estimatedPrice = estimatedPrice;
		}

	// Item Getters & Setters 
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}

	// ItemDescription Getters & Setters 
		public String getItemDescription() {
			return itemDescription;
		}
		public void setItemDescription(String itemDescription) {
			this.itemDescription = itemDescription;
		}

	// EstimatedPrice Getters & Setters 
		public double getEstimatedPrice() {
			return estimatedPrice;
		}
		public void setEstimatedPrice(double estimatedPrice) {
			this.estimatedPrice = estimatedPrice;
		}

	//toString
		@Override
		public String toString() {
			// *** Added differentiation between Purchase and University Reminder
			return "\n!!! Purchase Reminder !!!\n" +  super.toString() + "Item Name: " + getItem() +
					"\nItem Description: " + getItemDescription() +
					"\nEstimated Price: $" + getEstimatedPrice();
		}

} // end PurchaseReminder class
