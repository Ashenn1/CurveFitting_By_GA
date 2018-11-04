package curveFitting;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		curveFitting_sol sol= new curveFitting_sol();
		
		String filepath="wherever your filepath is";
		sol.readFile(filepath);

		
		//sol.mutation(30);
		for(int i=1; i<=sol.numTestcases;i++) {
			System.out.println("Test Case "+ i);
			sol.go();
			System.out.println("---------------------------------------------");
			
		}
		
	
		
	}
		

	}

