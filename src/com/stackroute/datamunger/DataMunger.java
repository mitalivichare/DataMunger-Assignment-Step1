package com.stackroute.datamunger;

import java.util.Arrays;
import java.util.Scanner;

public class DataMunger {
	
	public static void main(String[] args) {
		// read the query from the user into queryString variable
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please enter the query : ");
		String queryString=scanner.nextLine();
		DataMunger dataMunger=new DataMunger();
		
		// call the parseQuery method and pass the queryString variable as a parameter
		dataMunger.parseQuery(queryString);
		scanner.close();

	}
	

	
	public void parseQuery(String queryString) {
		//call the methods
		System.out.println(getSplitStrings(queryString));
		getFile(queryString);
		getBaseQuery(queryString);
		getConditionsPartQuery(queryString);
		getConditions(queryString);
		getLogicalOperators(queryString);
		getFields(queryString);
		getOrderByFields(queryString);
		getGroupByFields(queryString);
		getAggregateFunctions(queryString);
	}
	
	// parse the queryString into words and display
	public String[] getSplitStrings(String queryString) {
	
		String[] words=queryString.split("\\w+");
		return words;
	}

	// get and display the filename
	public String getFile(String queryString) {
		
		String fileName=queryString.split("from")[1].split("\\s+")[1];
		return fileName;
	}
	
	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {
		
		String baseQuery=queryString.split("where")[0].split("group by")[0].split("order by")[0];
		return baseQuery;

	}
	
	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {
		
		if(queryString.contains("where"))
		{
			String whereCondition=queryString.split("where")[1].trim().split("group by")[0].trim().split("order by")[0].trim();
			return whereCondition;
		}
		else
		{
		return null;
		}

	}
	
	/* parse the where conditions and display the propertyName, propertyValue and
	 conditionalOperator for each conditions*/
	public String[] getConditions(String queryString) {
		
	
		return null;
	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		
		
		return null;
		
	}
	public String[] getFields(String queryString) {
		
		String[] allfields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");
		return allfields;
		
	}
	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {
		
		String[] orderByField=queryString.split("order by")[1].trim().split("\\s,+");
		return orderByField;
	}
	
	// get group by fields if group by clause exists
	public String[] getGroupByFields(String queryString) {
		
		String[] groupByField=queryString.split("group by")[1].trim().split("\\s,+");
		return groupByField;
	}
	
	// parse and display aggregate functions(if applicable)
	public String[] getAggregateFunctions(String queryString) {
		

		return null;
	}

	
	
	
	
}