package ga.geneticOperators;

import catchBox.CatchIndividual;
import ga.GeneticAlgorithm;
import ga.IntVectorIndividual;
import ga.Problem;

public class Recombination2<I extends IntVectorIndividual, P extends Problem<I>> extends Recombination<I, P> {

    //TODO this class might require the definition of additional methods and/or attributes

    public Recombination2(double probability) {
        super(probability);
    }
    private int[] child1, child2, segment1, segment2;

    @Override
    public void recombine(I ind1, I ind2) {
        //TODO
        child1=new int[ind1.getNumGenes()];
        child2=new int[ind2.getNumGenes()];
        int cut1= GeneticAlgorithm.random.nextInt(ind1.getNumGenes());
        crear_filhos(cut1,ind1,ind2);
        for (int i = 0; i < child1.length; i++) {
            ind1.setGene(i, child1[i]);
            ind2.setGene(i, child2[i]);
        }
    }
    public  void crear_filhos(int cut,I ind1,I ind2){
        for (int i = 0; i <= cut; i++) {
            child1[i]=ind1.getGene(i);
            child2[i]=ind2.getGene(i);
        }
        for (int i = cut+1; i < ind1.getNumGenes(); i++) {
            child1[i]=-1;
            child2[i]=-1;
        }
        /*
        int[] dad1={1,3,5,2,8,4,7,6};
        int[] dad2={2,7,6,5,4,3,8,1};
        child1= new int[]{1,3,5,-1,-1,-1,-1,-1};
        child2= new int[]{2,7,6,-1,-1,-1,-1,-1};
        */
        int genCurrent;
        boolean listo;
        int auxinx=cut+1;
        /*
        for (int i = cut+1; i <child1.length ; i++) {
            genCurrent=dad2[i];
            if(isRepetidos(cut,genCurrent)) {
                auxinx--;
            }else{
                child1[auxinx]=genCurrent;
            }
            auxinx++;
        }
        if(!isReady()){
            for (int i = 0; i <=cut ; i++) {
                genCurrent=child2[i];
                if(isRepetidos(cut,genCurrent)){
                    auxinx--;
                }
                else {
                    child1[auxinx]=genCurrent;
                }
                auxinx++;
            }
        }
        child2=child1;
        */

            for (int i = cut+1; i <ind2.getNumGenes() ; i++) {
                    genCurrent=ind2.getGene(i);
                    if(isRepetidos(cut,genCurrent,1)) {
                        auxinx--;
                    }else{
                        child1[auxinx]=genCurrent;
                    }
                auxinx++;
            }
            if(!isReady(1)){
                for (int i = 0; i <=cut ; i++) {
                    genCurrent=child2[i];
                    if(isRepetidos(cut,genCurrent,1)){
                        auxinx--;
                    }
                    else {
                        child1[auxinx]=genCurrent;
                    }
                    auxinx++;
                }
            }
            auxinx=cut+1;

        for (int i = cut+1; i <ind2.getNumGenes() ; i++) {
            genCurrent=ind1.getGene(i);
            if(isRepetidos(cut,genCurrent,2)) {
                auxinx--;
            }else{
                child2[auxinx]=genCurrent;
            }
            auxinx++;
        }
        if(!isReady(2)){
            for (int i = 0; i <=cut ; i++) {
                genCurrent=child1[i];
                if(isRepetidos(cut,genCurrent,2)){
                    auxinx--;
                }
                else {
                    child2[auxinx]=genCurrent;
                }
                auxinx++;
            }
        }

    }

    @Override
    public String toString(){
        return "One cute" ;
    }
    private boolean isRepetidos(int cut,int gen,int child){
        switch (child){
            case 1:
                for (int i = 0; i <=cut; i++) {
                    if(gen==child1[i]){
                        return true;
                    }
                }
                break;
            case 2:
                for (int i = 0; i <=cut; i++) {
                    if(gen==child2[i]){
                        return true;
                    }
                }
                break;

        }
        return false;
    }
    private boolean isReady(int child){
        switch (child){
            case 1:
                for (int i = 0; i < child1.length; i++) {
                    if(child1[i]==-1){
                        return false;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < child1.length; i++) {
                    if(child2[i]==-1){
                        return false;
                    }
                }
                break;
        }
        return true;
    }
}