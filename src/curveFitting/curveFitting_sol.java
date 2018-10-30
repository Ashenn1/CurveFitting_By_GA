package curveFitting;

import javafx.util.*;
import java.util.*;

public class curveFitting_sol {
	
	final int popSize = 30;

	String [] Chromos = new String[popSize]; //The population
	
	
	int numIterations = 500;
	int numItems ;
	List<Pair<String,Integer>> chromeFitness = new ArrayList<>(popSize);
	List <String> nextGen = new ArrayList<>(); //place to store the next generation.
	
	Pair<String,Integer> bestFitness = new Pair<String, Integer>("", 2); // to carry best fitness seen until now.
	
	
	
	
	
	
	void GeneratingPopulation() {
		Random r = new Random();
		String ch;
		
		
		
		
	}
	
	boolean Valid(String chrome) { //example-->(1111) weight=150 kg & knapsack only takes 100 kg,so it isn't valid
		
			return false;
		
	}
	
	 void fitness() { //depending on the benefit only until now.
		
		 
		 
		
		
	}
	 
	 void Sort(){ //sorting fitness by minimum
		 
		 chromeFitness.sort(new Comparator<Pair<String, Integer>>(){
			 @Override
			 public int compare(Pair<String, Integer> v1 ,Pair<String, Integer> v2) {
				 
				 if (v1.getValue() < v2.getValue()) {
		                return -1;
		            } else if (v1.getValue().equals(v2.getValue())) {
		                return 0; 
		                
		            } else {
		                return 1;
		            }
			 }
		 });
		 
		 
	 }
	 
	 
	 void selection() { //sort by the best fitness 
         
	 }
	 
	
	 void crossOver () {
		 Random r = new Random();
		 int randNum = r.nextInt(numItems - 1); //lw 0 htb2a el crossover point b3d el 0 w  lw 1 el cp b3d el 1 l7d el numItems-2
		 randNum+=1;
	

	 }
	 
	 void mutation ()
		{
			 
			
			
			
			
		}
	 
	 
	 
	 void go()
	 {
		 
			
			for(int i = 0;i< numIterations ;i++)
			{	
				fitness();
				//System.out.println("their fitness : ");
				//System.out.println(getChromeFitness());
				
				selection();
				//System.out.println("The Selected: "+ nextGen);
				
				crossOver();
				//System.out.println("After crossover: "+nextGen);
				
				mutation();
				//System.out.println("After mutation: "+nextGen);
				
				
				nextGen.clear();
				chromeFitness.clear();
				
				
			}
			
	 }
	 
	 
	 public void Output() {
		 
	 }
	
}
