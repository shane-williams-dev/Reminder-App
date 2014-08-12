package third_tier;

import java.util.ArrayList;
import java.io.*;

import second_tier.*;

public class ReminderFileReader {
	@SuppressWarnings("unchecked")
	public ArrayList<Reminder> openFile (String fileName) throws ClassNotFoundException, IOException, FileNotFoundException {

		ObjectInputStream objIn = new ObjectInputStream (new FileInputStream (fileName));
		ArrayList<Reminder> list = new ArrayList<Reminder>();
		list = (ArrayList<Reminder>) objIn.readObject(); // we know it's an ArrayList<Reminder>!!
		objIn.close ();

		return list;
	}
}
