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
        for(int i= 0; i< ind.getNumGenes();i++){


            if(GeneticAlgorithm.random.nextDouble() < probability ) {
                int aux =ind.getGene(i);
                int cut;
                do {
                    cut = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
                }while (cut != i);
                ind.setGene(i,ind.getGene(cut));
                ind.setGene(cut,aux);
            }
        }
    }

    @Override
    public String toString() {
        return " exchange mutation (" + probability + ")";}
}