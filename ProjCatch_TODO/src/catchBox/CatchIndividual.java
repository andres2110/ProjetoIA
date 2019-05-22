package catchBox;

import ga.IntVectorIndividual;

public class CatchIndividual extends IntVectorIndividual<CatchProblemForGA, CatchIndividual> {

    private double value;
    public CatchIndividual(CatchProblemForGA problem, int size) {
        super(problem, size);
    }

    public CatchIndividual(CatchIndividual original) {
        super(original);
    }

    @Override
    public double computeFitness() {
        for (int i = 0; i < genome.length; i++) {
            Cell cellBox = problem.getCellsBoxes().get(this.getIndexof(i + 1));
            for (Pair pair : problem.getPairs()) {
                if(pair.getCell1()==problem.getCellCath()&&pair.getCell2()==cellBox){
                    value+=pair.getValue();
                }
            }
        }
        return value;
    }

    public int[] getGenome() {
        return genome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fitness: ");
        sb.append(fitness);
        sb.append("\npath: ");
        for (int i = 0; i <genome.length ; i++) {
            sb.append(genome[i]).append(" ");
        }
        return sb.toString();
    }

    /**
     * @param i
     * @return 1 if this object is BETTER than i, -1 if it is WORST than I and
     * 0, otherwise.
     */
    @Override
    public int compareTo(CatchIndividual i) {
        return (this.fitness == i.getFitness()) ? 0 : (this.fitness < i.getFitness()) ? 1 : -1;
    }

    @Override
    public CatchIndividual clone() {
        return new CatchIndividual(this);

    }
}
