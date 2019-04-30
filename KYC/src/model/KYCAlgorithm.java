package model;

import java.util.ArrayList;

public class KYCAlgorithm {

	
	
	private Spot[][] matrix;
	private int n;
	private GIC grammar;
	
	/**
	 * Constructor of tha KYCAlgorithm class
	 * @param g, grammar to be evaluated
	 */
	public KYCAlgorithm(GIC g)
	{
		grammar = g;
	}
	
	/**
	 * Constructs the matrix depending on the length of the matrix, and the matrix is filled
	 * @param chain
	 */
	public void constructMatrix(String chain)
	{
		 n = chain.length();
		 matrix = new Spot[n+1][n+1];
		 fillFirstColumn(chain);
		 fillMatrix();
		 printMatrix();
		 
	}
	
	/**
	 * Searches for the [1][n] spot and sees if the initial variable is contained on it 
	 * @return true, the initial variable is contained in the last spot
	 * @return false, the initial variable isn't contained on it
	 */
	public boolean evaluate()
	{
		 if(matrix[1][n].getVariables().contains(grammar.getVariables().get(0).getName()))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	}
	
	
	/**
	 * Fills the fist column on the matrix, as the algorithm deteminates.
	 * @param w, chain to be evaluated.
	 */
	public void fillFirstColumn(String w)	
	{
		String[] chain = new String[n];
		for(int i = 0; i<n;i++)
		{
			//CREO QUE ESTE ARREGLO SOBRA
			chain[i] = w.charAt(i) + "";
			matrix[i+1][1] = new Spot(grammar.searchProduction(chain[i]));
			
		}
	}
	
	/**
	 * Fills the matrix beginning in the second column
	 */
	public void fillMatrix()
	{
		for(int j = 2; j<n+1; j++)
		{
			fillColumn(j);
		}
	}
	
	
	/**
	 * Fills a column in the matrix, depending on its number (j)
	 * @param j, index of the column
	 */
	public void fillColumn(int j)
	{
		int iMax = n-j+1;
		int kMax = j-1;
		for(int i = 1; i<iMax+1; i++)
		{
			ArrayList<String> newSpot = new ArrayList<String>();
			for(int k = 1; k<kMax +1; k++)
			{
				int pos_i = i+k;
				int pos_j = j-k;
				ArrayList<String> results = concat(matrix[i][k].getVariables(), matrix[pos_i][pos_j].getVariables());
				if( results != null)
				{
					
					for(int m = 0; m<results.size(); m++)
					{
						if( grammar.searchProduction(results.get(m)) != null);
						{
							for(int h = 0;h< grammar.searchProduction(results.get(m)).size();h++)
							{
								if(!newSpot.contains(grammar.searchProduction(results.get(m)).get(h)) )
								{
									newSpot.add(grammar.searchProduction(results.get(m)).get(h));
								}
							}
						}
					}
					
				}
			}
			if(newSpot != null)
			{
				matrix[i][j] = new Spot(newSpot);
			}
			//printMatrix();	
		}
	}
	
	/**
	 * Prints the matrix
	 */
	public void printMatrix()
	{
		String line = "";
		for(int i = 1; i<matrix.length; i++)
		{
			for(int j = 1; j<matrix.length; j++)
			{
				if(matrix[i][j] == null)
				{
					line += "{ / }    ";
				}else {
					line += "{"+matrix[i][j].getString() + "}    ";
				}
				
			}
			System.out.println(line);
			line = "";
		}
	}
	
	
	/**
	 * Joins an array of variables with another one
	 * @param first, array of variables
	 * @param second, array of variables
	 * @return array of the variables joined.
	 */
	public ArrayList<String> concat(ArrayList<String> first, ArrayList<String> second)
	{
		ArrayList<String> comb = new ArrayList<>();
		if(first != null && second != null)
		{
			for(int i = 0; i < first.size();i++)
			{
				for(int j = 0; j<second.size();j++)
				{
					String c = first.get(i) + second.get(j);
					comb.add(c);
				}
			}
		}
		return comb;
		
	} 
}
