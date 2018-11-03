package curveFitting;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		curveFitting_sol sol= new curveFitting_sol();
		
		String filepath="M:\\fci\\semester 7\\Soft Computing\\Assignments\\CurveFitting_By_GA\\input.txt";
		sol.readFile(filepath);

		sol.GeneratingPopulation();
		//sol.mutation(30);
		sol.go();
		sol.Output();
	
		
	}
		

	}

