package model;

import java.util.ArrayList;

public class Spot {

	private ArrayList<String> variables;
	
	/**
	 * Constructs an array with variables inside of it
	 * @param variables
	 */
	public Spot(ArrayList<String> variables)
	{
		this.variables = variables;
	}
	
	/**
	 * Returns the variables inside this spot
	 * @return variables
	 */
	public ArrayList<String> getVariables()
	{
		return variables;
	}
	
	
	/**
	 * Returns the variables in a string
	 * @return s, variables
	 */
	public String getString()
	{
		String s = "";
		for(int i = 0; i<variables.size();i++)
		{
			if(s.equals(""))
			{

				s += variables.get(i);
			}else
			{
				s+= "," + variables.get(i);
			}
			
		}
		return s;
	}
}
