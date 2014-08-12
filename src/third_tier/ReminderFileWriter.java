package third_tier;

import java.io.*;

import second_tier.*;

public class ReminderFileWriter {
	public void saveFile (String fileName, DataStorage list) throws IOException {
		ObjectOutputStream objOut = new ObjectOutputStream (new FileOutputStream (fileName));
		objOut.writeObject (list.getArrayList());
		objOut.close();
	}
}

