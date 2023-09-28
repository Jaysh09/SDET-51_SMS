package java.com.SMS.genericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of java related methods
 * @author jayas
 *
 */

public class JavaUtility {
	/**
	 * This method is used to get the random number
	 * @return
	 */
		public int getRandomNumber() {
			Random r=new Random();
			int randNum=r.nextInt(1000);
			return randNum;
		}
		/** This method will fetch system date in IST format
		 * 
		 * @return
		 */
		public String getSystemDate() {
			Date date=new Date();
			return date.toString();
			
			}
		public String getSystemDateInFormat()
		{
			Date dateTime=new Date();
			String[] d = dateTime.toString().split(getSystemDate());
			
			String day=d[0];
			String month=d[1];
			String date=d[2];
			String year=d[5];
			
			String finalFormat = day+" "+month+" "+date+" "+year;
			return finalFormat;
		}
		
	}