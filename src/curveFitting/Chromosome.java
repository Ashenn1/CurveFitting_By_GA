package curveFitting;

import java.util.ArrayList;
import java.util.List;

public class Chromosome {

	private Float fitness;
	
	private List<Float>Genes = new ArrayList<>();



	public Chromosome(Float fitness, List<Float>Genes) {
		super();
		this.fitness = fitness;
		for(int i=0;i<Genes.size();i++) //copying by values not by address.
		{
			this.Genes.add(i, Genes.get(i));
		}
	}

	public Float getFitness() {
		return fitness;
	}

	public void setFitness(Float fitness) {
		this.fitness = fitness;
	}

	public List<Float> getGenes() {
		return Genes;
	}

	public void setGenes(List<Float> genes) {
		Genes = genes;
	}
	
	
	
	
	
	
	
	
}
