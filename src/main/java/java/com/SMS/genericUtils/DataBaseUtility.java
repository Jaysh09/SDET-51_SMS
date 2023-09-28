package java.com.SMS.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con=null;
	 /**
 * This method is used to connect database 
 * @throws SQLException
 */
		public void connectToDB() throws SQLException {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(IpathConstants.dbURL,IpathConstants.dbUsername,IpathConstants.dbpassword);

		}
		/**
		 * This method is used to execute query and get the data
		 * @param query
		 * @param columnNo
		 * @param ExpData
		 * @return
		 * @throws SQLException
		 */
		public String exceuteQueryAndGetData(String query,int columnNo,String ExpData) throws SQLException {
			ResultSet result = con.createStatement().executeQuery(query);
			boolean flag=false;
			while(result.next()) {
				String data=result.getString(columnNo);
				if(data.equalsIgnoreCase(ExpData))
				{
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("data is verified");
				return ExpData;
			}
			else {
				System.out.println("data is not verified");
				return "";
			}
		}
		/**
		 * This method is used to close database connection
		 * @throws SQLException
		 */
		public void closeDB() throws SQLException {
			con.close();
		}

	}


