package curveFitting;

import javafx.util.*;


import java.io.*;

import java.util.*;

public class curveFitting_sol {
	
	final int popSize = 30;

	int numIterations = 500;
	int numPoints;
	int numTestcases;

	int degreeOfPoly;
	
	List<Pair<Float,Float>>point = new ArrayList<>(numPoints);
	List<Chromosome> Generation = new ArrayList<>(popSize); //place to store next generation.

	void readFile(String filepath) {
		String[] values;
		Pair<Float,Float>xyPoints;
		try {
			
			FileReader filereader=new FileReader(filepath);
			BufferedReader in= new BufferedReader(filereader);
			String line;
			int cnt=0;
			while((line=in.readLine())!= null) {
				    values=line.split("\\s+");
				    
				 
				    if(cnt==0) {
				    	numTestcases=Integer.parseInt(values[0]);
				    }
				    
				    else if(cnt==1) {
				    	numPoints=Integer.parseInt(values[0]);
				    	degreeOfPoly=Integer.parseInt(values[1]);
				    }
				    else {
				        xyPoints = new Pair<>(Float.parseFloat(values[0]), Float.parseFloat(values[1]));
				        point.add(xyPoints);
				    }
				    
				    
				    cnt++;
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("File is not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem with input/output.");
			e.printStackTrace();
		}
		
		
		
	}

	
	
	 
	
	void GeneratingPopulation() {
		/*generating random numbers by multiplying an integer with a float 
		  3ashan msh la2yeen function to generate random float numbers with a range*/
		Random r = new Random();
		float random;
		int in;
		float f;	
		Chromosome ch = null;
		List <Float> dummy = new ArrayList<>(degreeOfPoly + 1);
		
		for(int i = 0; i < popSize; i++) {
			for(int j = 0; j <= degreeOfPoly; j++) {

				//dummy = new ArrayList<>(degreeOfPoly + 1);
				in = r.nextInt(10 + 1 - -10) + -10;
				f = r.nextFloat();
				random = in * f;
				dummy.add(random);
			}

			ch = new Chromosome((float) 0.0, dummy);

			Generation.add(i, ch);
			System.out.println(Generation.get(i).getGenes());
			System.out.println("--------------------------------------------");
			dummy.clear();
			
		}
		
		
		
		
	}

	 void fitness() { //depending on the benefit only until now.
		    Float error= (float) 0.0;
			Float sum = (float) 0.0;
			Float sum2=(float) 0.0;
		
		for(int z = 0; z < popSize; z++) {
			
			for(int i = 0; i<numPoints;i++) {
				 
				 Float yCalc=(float) 0.0;
				 float x = point.get(i).getKey();
				 for(int j = 0; j<=degreeOfPoly;j++) {
		 
					 yCalc= (float) (yCalc + (Generation.get(z).getGenes().get(j))* (Math.pow(x ,j)  )); //had to recast it again to float.
					 
				 }
				 sum+=(yCalc) - (point.get(i).getValue()); //yCalc-yActual
				 
				 sum2=(float) Math.pow(sum , 2); // (yCalc-yActual)^2
				
				 
			 }
			float val =1/(float)numPoints;
			
			error= (val*sum2);
			Generation.get(z).setFitness((float)error);
			System.out.println(Generation.get(z).getGenes());
			System.out.println("Fitness equals = " + Generation.get(z).getFitness());
			System.out.println("--------------------------------------------");
		}
		 
		
		
		
		
	}
	 
	 void Sort(){ //sorting fitness by minimum
		 
		 Generation.sort(new Comparator<Chromosome>(){
		 @Override
			 public int compare(Chromosome v1 ,Chromosome v2) {
				 
				 if (v1.getFitness() < v2.getFitness()) {
		                return -1;
		            } else if (v1.getFitness().equals(v2.getFitness())) {
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

		 int randNum = r.nextInt(degreeOfPoly ); //lw 0 htb2a el crossover point b3d el 0 w  lw 1 el cp b3d el 1 l7d el numItems-2
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
				
				

			}
			
	 }
	 
	 
	 public void Output() {
		 
	 }
	
}
