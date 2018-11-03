package curveFitting;

import javafx.util.*;


import java.io.*;

import java.util.*;

public class curveFitting_sol {
	
	final int popSize = 48; //to be able to cut it into even halves.

	int numIterations = 500;
	int numPoints;
	int numTestcases;

	int degreeOfPoly;
	
	List<Pair<Float,Float>>point = new ArrayList<>(numPoints);
	List<Chromosome> Generation = new ArrayList<>(popSize); //place to store next generation.
	List<Chromosome>nextGen = new ArrayList<>(popSize);
	
	
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
		    float error= 0;
			float sum = 0;
			float sum2= 0;
		
		for(int z = 0; z < popSize; z++) {
			
			for(int i = 0; i<numPoints;i++) {
				 
				 float yCalc= 0;
				 float x = point.get(i).getKey();
				 
				 for(int j = 0; j<=degreeOfPoly;j++) { // calculates yCal only.
		 
					 yCalc= (float) (yCalc + (Generation.get(z).getGenes().get(j))* (Math.pow(x ,j)  )); //had to recast it again to float.
					 
				 }
				 sum=(yCalc) - (point.get(i).getValue()); //yCalc-yActual
				 
				 sum2+=(float) Math.pow(sum , 2); // (yCalc-yActual)^2
				
				 
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
         
		 Sort();
		 //Selecting the best half of the old generation.
		 for(int i=0;i<(popSize/2);i++) {
			 nextGen.add(i, Generation.get(i));
		 }
		 
		 
	 }
	 
	 
	 
	
	 void crossOver () {  //crossing over the selected and adding the other (best) half from the old gen.
		 Random r = new Random(); //we could try other selection and crossover mechanisms.

		 int randNum = r.nextInt(degreeOfPoly); //lw 0 htb2a el crossover point b3d el 0 w  lw 1 el cp b3d el 1 l7d el numItems-2
		 randNum+=1; //bec we want 0 to be excluded.
		 
		 for(int i=0;i<nextGen.size();i+=2) {
			 
			 int cnt=randNum;
			 while(cnt<=degreeOfPoly) { //swapping values.
				 Float temp = nextGen.get(i).getGenes().get(cnt);
				 nextGen.get(i).getGenes().set(cnt, nextGen.get(i+1).getGenes().get(cnt) );
				 nextGen.get(i+1).getGenes().set(cnt, temp);
				 
				 cnt++;
			 }
		 }
		 
		 for(int i=0;i<(popSize/2);i++) { //adding the best first half from the old generation.
			 nextGen.add( Generation.get(i));
		 }
		 
		 System.out.println("Crossover point is : "+ randNum);
		 System.out.println("New Generation after crossover : ");
		 for(int i=0;i<popSize;i++) {
			 System.out.println(nextGen.get(i).getGenes());
				System.out.println("--------------------------------------------");
		 }
		 
	

	 }
	 
	 void mutation (int generationNum)
		{
			 
		 for(int i=0;i<(nextGen.size()/2); i++) //mutation over the selected only.
		 {
			 
			 for(int j=0 ;j<=degreeOfPoly;j++) { //for loop for the genes inside each chromosome.
				 
				    Random r = new Random();
					float x = r.nextFloat(); 
					float p;
					float newVal = 0;
					
					if(x<=0.1) { //probability of the gene to get mutated 10%.
						
						float r1= r.nextFloat();
						if(r1<=0.5) { //Y = LowerBound if r1<=0.5 (newVal = oldVal - equation)
							
						    p = (1-generationNum)/numIterations; //(1-t)/T
						    p = (float) Math.pow(p, 1.23); // ((1-t)/T)^d --> dependency factor ~ 1..5
						    p= 1- p ;
						    newVal = nextGen.get(i).getGenes().get(j) - p ;
						    nextGen.get(i).getGenes().set(j, newVal);
						}
						
						else { //Y = UpperBound if r1>0.5 (newVal = oldVal + equation)
							
							p = (1-generationNum)/numIterations; //(1-t)/T
						    p = (float) Math.pow(p, 1.23); // ((1-t)/T)^d --> dependency factor ~ 1..5
						    p= 1- p ;
						    newVal = nextGen.get(i).getGenes().get(j) + p ;
						    nextGen.get(i).getGenes().set(j, newVal);
						}
						
					}
				 
					
					
			 }
			 
			 
			 }
		 
	      //making the new generation the old generation now.
		  for(int i=0; i<popSize;i++ ) {
			  for(int j=0; j<=degreeOfPoly;j++) {
				  Generation.get(i).getGenes().set(j, nextGen.get(i).getGenes().get(j));  
			  }
		  }
	
		  System.out.println("New Generation after mutation : ------------------------------------");
			 for(int i=0;i<popSize;i++) {
				 System.out.println(Generation.get(i).getGenes());
					System.out.println("--------------------------------------------");
			 }
		  
			
			
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
				
				mutation(numIterations);
				//System.out.println("After mutation: "+nextGen);
				
				

			}
			
			Generation.clear();
			nextGen.clear();
			
	 }
	 
	 
	 public void Output() {
		 
		 
		 
	 }
	
}
