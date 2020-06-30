package Utilities;

import java.util.Date;

public class DateUtils {

	/**********************************
	 * Get the time stamp
	 ***********************************/
	
	public static String getTimeStamp() {
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}
