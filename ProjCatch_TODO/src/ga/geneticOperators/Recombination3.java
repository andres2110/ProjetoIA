package ga.geneticOperators;

import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class Recombination3<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination3(double probability) {
        super(probability);
    }
    private int[] segment1,segmet2,chil1,child2;
    int cut1,cut2;

    @Override
    public void recombine(I ind1, I ind2) {
        //TODO
        chil1= new int[ind1.getNumGenes()];
        child2= new int[ind2.getNumGenes()];
        cut1 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        cut2 = GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        if (cut1 > cut2) {
            int aux = cut1;
            cut1 = cut2;
            cut2 = aux;
        }
        create_segments(ind1,ind2);
        create_childs(ind1,ind2);
        for (int i = 0; i < chil1.length; i++) {
            ind1.setGene(i, chil1[i]);
            ind2.setGene(i, child2[i]);
        }
    }

    private void create_segments(I ind1,I ind2){
        int capacity_ofSegments = (cut2- cut1) + 1;
        segment1= new int[capacity_ofSegments];
        segmet2= new int[capacity_ofSegments];
        int indAux=cut1;
        for (int i = 0; i < segment1.length&&indAux<=cut2; i++,indAux++) {
            segment1[i]=ind1.getGene(indAux);
            segmet2[i]= ind2.getGene(indAux);
        }
    }
    private void create_childs(I ind1,I ind2){
        int indAux=0;
        for (int i = 0; i < chil1.length; i++) {
            if(!exists(ind2.getGene(i),1)){
                chil1[indAux]=ind2.getGene(i);
                indAux++;
            }
        }
        if(indAux<chil1.length){
            int j=0;
            for (int i = indAux; i <chil1.length ; i++,j++) {
                chil1[i]=segment1[j];
            }
        }
        indAux=0;
        for (int i = 0; i < chil1.length; i++) {
            if(!exists(ind1.getGene(i),2)){
                child2[indAux]=ind1.getGene(i);
                indAux++;
            }
        }
        if(indAux<chil1.length){
            int j=0;
            for (int i = indAux; i <chil1.length ; i++,j++) {
                child2[i]=segmet2[j];
            }
        }


    }
    @Override
    public String toString(){
        return "crossover";
    }
    public boolean exists(int value,int child){
        switch (child){
            case 1:
                for (int i = 0; i <segment1.length ; i++) {
                    if(segment1[i]==value){
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i <segment1.length ; i++) {
                    if(segmet2[i]==value){
                        return true;
                    }
                }
                break;
        }
        return false;
    }

}