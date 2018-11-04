package curveFitting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		curveFitting_sol sol= new curveFitting_sol();
		
		String filepath="C:\\Users\\Soha Samad\\Desktop\\College\\Year 4\\Soft_Computing\\Tasks\\Assignment2-Curve Fitting\\CurveFitting_By_GA\\input.txt";
		sol.readFile(filepath);

		// Assume default encoding.
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		
		try {
			
			fileWriter = new FileWriter("output.txt");
			 // Always wrap FileWriter in BufferedWriter.
			bufferedWriter = new BufferedWriter(fileWriter);
			
			
			//sol.mutation(30);
			for(int i=1; i<=sol.numTestcases;i++) {
				System.out.println("Test Case "+ i);
				sol.go(fileWriter , bufferedWriter);
				System.out.println("---------------------------------------------");
				
			}
			
			bufferedWriter.close();
			
		}
			
	 catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("out here in the main class chilin");
			e.printStackTrace();
		}
		
	
		

	}
	
}

