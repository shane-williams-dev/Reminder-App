package second_tier;

import java.util.ArrayList;

public class DataStorage {
	// Attribute
	ArrayList<Reminder> dStore;
	// Constructor
	public DataStorage () {
		dStore = new ArrayList<Reminder>();
	}
	// Methods
	public void addAll (ArrayList<Reminder> aLP) {
		dStore.addAll (aLP);
	}
	public void add (Reminder p) {
		if (p instanceof PurchaseReminder) {
			dStore.add ((PurchaseReminder) p);
		} else {
			dStore.add ((UniReminder) p);
		}
	}
	public int size () {
		return dStore.size();
	}
	public Reminder get (int index) {
		return dStore.get (index);
	}
	public ArrayList<Reminder> getArrayList() {
		return dStore;
	}
} // end class DataStorage
