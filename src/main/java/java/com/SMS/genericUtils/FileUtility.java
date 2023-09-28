package java.com.SMS.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This method is used to fetch common data present inside the property file 
	 * @param Key
	 * @return
	 * @throws IOException 
	 * @throws  IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(IpathConstants.propertyFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}


