package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class Mutation3<I extends IntVectorIndividual, P extends Problem<I>> extends Mutation<I, P> {

    public Mutation3(double probability) {
        super(probability);
    }

    @Override
    public void mutate(I ind) {
        //no esta provado si funciona
        int cut1 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        int cut2;
        do {
            cut2 = GeneticAlgorithm.random.nextInt(ind.getNumGenes());
        }while (cut1==cut2);
        if (cut1 > cut2) {
            int aux = cut1;
            cut1 = cut2;
            cut2 = aux;
        }
        for(int i = cut1; i <= cut2/2 ; i++) {
            int aux = ind.getGene(i);
            ind.setGene(i , ind.getGene(cut2-cut1));
            ind.setGene(cut2, aux);
        }  }

    @Override
    public String toString() {
        return "Inversion Mutation"; }
}