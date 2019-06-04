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
        int aux1 = ind.getGene(cut2);
        for(int i = cut2-1; i > cut1 ; i--) {
            int aux2 = ind.getGene(i+1);
            ind.setGene(i+1 , ind.getGene(i));
            ind.setGene(i, aux2);
        }
        ind.setGene(cut1+1,aux1) ;
    }

    @Override
    public String toString() {
        return "Inversion Mutation (SIM)"; }
}