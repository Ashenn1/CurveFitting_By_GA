package curveFitting;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		curveFitting_sol sol= new curveFitting_sol();
		
		String filepath="C:\\Users\\Soha Samad\\Desktop\\College\\Year 4\\Soft_Computing\\Tasks\\Assignment2-Curve Fitting\\CurveFitting_By_GA\\input.txt";
		sol.readFile(filepath);

		sol.GeneratingPopulation();
		sol.fitness();
		
		sol.Sort();
	
		
	}
		

	}

