package model;

import java.util.ArrayList;

public class Variable {
	
	/**
	 * Array with the productions of this variable
	 */
	private ArrayList<String> productions;
	/**
	 * Name of the variable
	 */
	private String name;
	
	/**
	 * Constructs a Variable inside the GIC
	 * @param name, name of the variable
	 */
	public Variable(String name)
	{
		productions = new ArrayList<String>();
		this.name = name;
	}
	
	/**
	 * Returns the name of the variable
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	
	/**
	 * Adds a new production to the variable
	 * @param production, new production to add
	 */
	public void addProduction(String production)
	{
		productions.add(production);
	}
	
	
	/**
	 * Evaluates if an specific production is produced by this variable
	 * @param productionSearched, production to be searched
	 * @return name of the variable, if the production is produced by this variable
	 * @return null, if the production is not produced by this variable
	 */
	public String searchProduction(String productionSearched)
	{
		boolean found = false;
		for(int i = 0; i<productions.size() && ! found; i++)
		{
			if(productions.get(i).equals(productionSearched))
			{
				found = true;
			}
		}
		if(found)
		{
			return name;
		} else
		{
			return null;
		}
	}
	
	/**
	 * Returns a String with the name of the variables followed by the productions of it.
	 */
	public String toString()
	{
		String var = this.name + " --> " + productions.get(0)  ;
		for(int i = 1; i<productions.size();i++)
		{
			var += ", " +productions.get(i);
		}
		
		return var;
		
	}
	

}
