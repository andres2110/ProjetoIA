package ga;

public abstract class IntVectorIndividual<P extends Problem, I extends IntVectorIndividual> extends Individual<P, I> {
    //TODO this class might require the definition of additional methods and/or attributes

    protected int[] genome;

    public IntVectorIndividual(P problem, int size) {
        super(problem);
        genome = new int[size];
        createGenoma();

      }

    public IntVectorIndividual(IntVectorIndividual<P, I> original) {
        super(original);
        this.genome = new int[original.genome.length];
        System.arraycopy(original.genome, 0, genome, 0, genome.length);
    }
    private void createGenoma(){
        int numPreenchidos=0;
        while (numPreenchidos!=genome.length){
            int pos=GeneticAlgorithm.random.nextInt(genome.length+1);
            if(pos==0||notExistGen(pos)){
                continue;
            }else {
                genome[numPreenchidos]=pos;
                numPreenchidos++;
            }
        }
    }
    private boolean notExistGen(int gen){
        for (int i = 0; i < genome.length; i++) {
            if(genome[i]==gen){
                return true;
            }
        }
        return false;
    }
    @Override
    public int getNumGenes() {
        return genome.length;
    }

    public int getIndexof(int value){
        for (int i = 0; i < genome.length; i++) {
            if (genome[i] == value)
                return i;
        }
        return -1;
    }

    public int getGene(int index) {
        return genome[index];
    }

    public void setGene(int index, int newValue) {
        genome[index] = newValue;
    }

    @Override
    public void swapGenes(IntVectorIndividual other, int index) {
        int aux = genome[index];
        genome[index] = other.genome[index];
        other.genome[index] = aux;
    }
}
