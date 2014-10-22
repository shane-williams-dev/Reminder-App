/**
 * ReminderWorker passes the information entered into the ArrayList<Reminder> down to the third tier to save.
 * It also passes data contained in the data.obj back up to the UI to veiw.
 **/

package second_tier;

import java.util.ArrayList;
import java.io.*;

import third_tier.*;

public class ReminderWorker {

	public ArrayList<Reminder> openFile (String fileName) throws ClassNotFoundException, IOException, FileNotFoundException {
		ReminderFileReader pfr = new ReminderFileReader ();
		ArrayList<Reminder> list = pfr.openFile (fileName);
		return list;
	}

	public void saveFile (String fileName, DataStorage list) throws IOException {
		ReminderFileWriter pfw = new ReminderFileWriter ();
		pfw.saveFile (fileName, list);
	}
}
