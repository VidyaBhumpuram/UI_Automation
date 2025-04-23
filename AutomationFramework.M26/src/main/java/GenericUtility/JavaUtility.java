package GenericUtility;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class contains the generic methods related to Java
 * @author Vidya
 */

public class JavaUtility {
	
	/**
	 * This method will return the system date in specific format
	 * @return
	 */

	public String getSystemDateInFormet() {
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = sf.format(d);
		return date;
	}
}
