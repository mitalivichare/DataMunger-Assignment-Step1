package com.stackroute.datamunger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		
		queryString=queryString.toLowerCase();
		//call the methods
		getSplitStrings(queryString);
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
		//avoid using a regex here, make it simple, the students will not know regex at this point in time
		String[] words=queryString.split("\\s+");
		for(String word : words)
		{
			//what will you print? would it remain empty?
			System.out.println(
);
		}
		
		return words;
	}

	// get and display the filename
	public String getFile(String queryString) {
		
		//avoid regex
		String fileName=queryString.split("from")[1].split("\\s+")[1];
		System.out.println(fileName);
		return fileName;
	}
	
	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {
		//good compact code
		String baseQuery=queryString.split("order by")[0].split("group by")[0].split("where")[0];
		System.out.println(baseQuery);
		return baseQuery;

	}
	
	// get and display the where conditions part(if where condition exists)
	public String getConditionsPartQuery(String queryString) {
		
		queryString=queryString.toLowerCase();
		if(queryString.contains("where"))
		{
			String whereCondition=queryString.split("order by")[0].split("group by")[0].split("where")[1];
			System.out.println(whereCondition);
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
		
		queryString=queryString.toLowerCase();
		String[] nameAndValue;
		String propertyName,propertyValue,conditionalOperator;
		int counter=1;
		if(queryString.contains("where"))
		{
			String whereCondition=queryString.split("order by")[0].trim().split("group by")[0].trim().split("where")[1].trim();
			//can we change this line without using regex
			String[] conditions=whereCondition.split("\\s+and\\s+|\\s+or\\s+");
			for(String condition : conditions)
			{
				nameAndValue=condition.split("<=|>=|!=|=|<|>");
				propertyName=nameAndValue[0].trim();
				propertyValue=nameAndValue[1].trim();
				conditionalOperator=condition.split(propertyName)[1].trim().split(propertyValue)[0].trim();
				System.out.println("Condition "+counter+" :");
				System.out.println("variable : "+propertyName);
				System.out.println("operator : "+conditionalOperator);
				System.out.println("value : "+propertyValue);
				counter++;
			}
			return conditions;
		}
		else
		{
			return null;
		}
	}
	
	// get the logical operators(applicable only if multiple conditions exist)
	public String[] getLogicalOperators(String queryString) {

		queryString=queryString.toLowerCase();
		String[] logicalOperators;
		//dont use an arraylist in this assignment
		List<String> operators=new ArrayList<>();

		if(queryString.contains("where"))
		{
			String whereCondition=queryString.split("order by")[0].trim().split("group by")[0].trim().split("where")[1].trim();
			//avoid regex
			String[] conditions=whereCondition.split("\\s+");
			for(String word : conditions)
			{
				if(word.equals("and"))
				{
					operators.add("and");
					//logicalOperators=new String[]{"and"};
				}
				else if(word.equals("or"))
				{
					operators.add("or");
					//logicalOperators=new String[]{"or"};
				}
			}
			logicalOperators=new String[operators.size()];
			logicalOperators=operators.toArray(logicalOperators);
		return logicalOperators;
		}
		else
		{
			return null;
		}
		
	}
	public String[] getFields(String queryString) {
		//avoid regex
		String[] requiredfields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");
		for(String field : requiredfields)
		{
			System.out.println(field);
		}
		return requiredfields;
		
	}
	// get order by fields if order by clause exists
	public String[] getOrderByFields(String queryString) {
		
		if(queryString.contains("order by"))
		{
			//avoid regex
			String[] orderByField=queryString.split("order by")[1].trim().split("[\\s,]+");
			return orderByField;
		}
		else
		{
			return null;
		}
	}
	
	// get group by fields if group by clause exists
	public String[] getGroupByFields(String queryString) {
		
		if(queryString.contains("group by"))
		{
			//avoid regex
			String[] groupByField=queryString.split("group by")[1].trim().split("[\\s,]+");
			return groupByField;
		}
		else
		{
			return null;
		}
	}
	
	// parse and display aggregate functions(if applicable)
	public String[] getAggregateFunctions(String queryString) {
		
		String aggregateName,aggregateField;
		int counter=1;
		if(queryString.contains("count") || queryString.contains("sum") || queryString.contains("min") || queryString.contains("max") || queryString.contains("avg"))
		{
			//please check the requirements. Is it actually required?
			String[] aggregateFunctions=queryString.split("select")[1].trim().split("from")[0].trim().split(",");
			for(String function : aggregateFunctions)
			{
				aggregateName=function.split("\\(")[0].trim();
				aggregateField=function.split("\\(")[1].trim().split("\\)")[0].trim();
				System.out.println("Aggregate "+counter+" :");
				System.out.println("Aggregate Name : "+aggregateName);
				System.out.println("Aggregate Field : "+aggregateField);
				counter++;
			}
			return aggregateFunctions;
		}
		else
		{
			return null;
		}
	}

	
	
	
	
}	
