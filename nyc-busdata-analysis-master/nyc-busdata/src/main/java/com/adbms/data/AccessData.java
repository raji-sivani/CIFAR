package com.adbms.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.adbms.dto.Transport;
import com.mysql.cj.jdbc.MysqlDataSource;

public class AccessData {
	
	//This function is used to create connection with the MySQL server hosted on AWS
	//It returns a datasource object
	public static DataSource getMysqlDataSource() throws SQLException {
		MysqlDataSource dataSource = new MysqlDataSource();
		
		dataSource.setServerName("ec2-18-188-195-37.us-east-2.compute.amazonaws.com");
		dataSource.setPortNumber(3306);
		dataSource.setDatabaseName("new_york");
		dataSource.setUser("root");
		dataSource.setPassword("password1");
		return dataSource;
	}
	
	//The code fetches data from the database corresponding to the day, start time and end time recieved 
	//It returns a list of Tranport DTO
	public List<Transport> getTrasnportDetailsForDay(String day, String startTime, String endTime){
		try {
			
			//Establish connection
			Connection con = getMysqlDataSource().getConnection();
			
			Statement stmt = con.createStatement();
			
			//Get dates corresponding to the day received as parameter 
			String allDates = DayToDate.getDateFromDay(day);
			
			//Execute the query and get the output in a result set
			ResultSet resultSet = stmt.executeQuery("select * from new_york_city_bus where RecordedTime between '" + startTime + 
					"' and '" + endTime + "' and RecordedDate in (" + allDates + ")");
			
			//Create a list of Transport DTO
			List<Transport> transportDetails = new ArrayList<Transport>();
			
			while (resultSet.next()) {
				Transport transport = new Transport();
				transport.setOriginName(resultSet.getString("OriginName"));
				transport.setDestinationName(resultSet.getString("DestinationName"));
				transport.setNextStopPointName(resultSet.getString("NextStopPointName"));
				transport.setExpectedArrivalTime(resultSet.getString("ExpectedArrTime"));
				transport.setScheduledArrivalTime(resultSet.getString("ScheduledArrivalTime"));
				
				transportDetails.add(transport);
			}
			
			return transportDetails;
			
		} catch(Exception exe) {
			exe.printStackTrace();
		}
		
		List<Transport> transportDetails = new ArrayList<Transport>();
		return transportDetails;
	}

		
}
