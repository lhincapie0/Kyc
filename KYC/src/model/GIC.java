package model;

import java.util.ArrayList;
import java.util.List;

public class GIC {

	
	
	private ArrayList<Variable> variables;
	private int no_variables;
	private KYCAlgorithm kyc;
	
	/**
	 * Construcs a grammar with n variables
	 * @param no_variables, variables of the grammar
	 */
	public GIC(int no_variables)
	{
		this.no_variables = no_variables;
		variables = new ArrayList<Variable>();
		 kyc = new KYCAlgorithm(this);
	}
	
	/**
	 * Returns the list with the variables of grammar
	 * @return variables
	 */
	public List<Variable> getVariables()
	{
		return variables;
	}
	
	/**
	 * Returns the number of variables that the grammar has.
	 * @return no_variables
	 */
	public int getNo_Variables()
	{
		return no_variables;
	}
	
	 /**
	  * Adds a new variable to the GIC
	  * @param name, name of the variable
	  * @param prod, productions of the variable
	  */
	public void addVariable(String name, String prod)
	{
		Variable var = new Variable(name);
		String[] productions = prod.split(",");
		for(int i = 0; i<productions.length;i++)
		{
			var.addProduction(productions[i]);
		}
		variables.add(var);
	}
	
	/**
	 * Searches the variables that produces an specific production
	 * @param productionSearched, production to be searched
	 * @return vars, list of the variables that produces the production
	 * @return null, if the production is not produced by any variable of the grammar
	 */
	public ArrayList<String> searchProduction(String productionSearched)
	{
		ArrayList<String> vars = new ArrayList<String>();
		for(int i = 0; i<no_variables;i++)
		{
			String v = variables.get(i).searchProduction(productionSearched);
			if( v != null)
			{
				vars.add(v);
				
			}
		}
		return vars;
	}
	
	
	/**
	 * Gets a chain as a string and evaluates and calls a method to evaluate if the chain is produced by this grammar.
	 * @param chain, chain to evaluate
	 * @return true, if the chain is produced by this grammar
	 * @return false, if the chain isn´t produced by this grammar
	 */
	public boolean evaluate(String chain)
	{
		kyc.constructMatrix(chain);
		return kyc.evaluate();
		
	}
	
	/**
	 * It returns a string with all the 
	 * @return grammar 
	 */
	public String toString()
	{
		String gic = "";
		for(int i = 0; i<variables.size();i++)
		{
			gic += " \n "+ variables.get(i).toString();
		}
		return gic;
	}
	
	
	
	
}
