package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class Mutation2<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation2(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
       // int[] array = parent.clone();
        int numGenes = ind.getNumGenes();
        //get 2 random integers between 0 and size of array
        int r1 = GeneticAlgorithm.random.nextInt(numGenes);
        int r2 = GeneticAlgorithm.random.nextInt(numGenes);
        //to make sure the 2 numbers are different
        while(r1 == r2){
            r2 = GeneticAlgorithm.random.nextInt(numGenes);
        }

        //swap array elements at those indices
        int temp = ind.getGene(r1);
        ind.setGene(r1,ind.getGene(r2));
        ind.setGene(r2,temp);
    }

    @Override
    public String toString() {
        return " swap mutation(" + probability + ")";}
}