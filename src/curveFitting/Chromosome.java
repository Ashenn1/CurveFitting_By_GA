package curveFitting;

import java.util.ArrayList;
import java.util.List;

public class Chromosome {
	private float fitness;
	private List <Float> Genes = new ArrayList<>();
	
	public Chromosome(float fitness, List<Float> genes) {
		super();
		this.fitness = fitness;
		Genes = genes;
	}

	public float getFitness() {
		return fitness;
	}
	public void setFitness(float fitness) {
		this.fitness = fitness;
	}
	public List<Float> getGenes() {
		return Genes;
	}
	public void setGenes(List<Float> genes) {
		Genes = genes;
	}

}
