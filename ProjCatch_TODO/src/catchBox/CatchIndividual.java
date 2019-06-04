package catchBox;

import ga.IntVectorIndividual;

import java.util.LinkedList;

public class CatchIndividual extends IntVectorIndividual<CatchProblemForGA, CatchIndividual> {

    public CatchIndividual(CatchProblemForGA problem, int size) {
        super(problem, size);
    }

    public CatchIndividual(CatchIndividual original) {
        super(original);
    }

    @Override
    public double computeFitness() {
        Cell cellBox=null;
        this.fitness = 0;
        Cell cellCurrent=problem.getCellCath();
        for (int i = 0; i < genome.length; i++) {
            LinkedList<Cell> boxes=problem.getCellsBoxes();
            //cellBox = problem.getCellsBoxes().get(getIndexof(i+1));
            cellBox = problem.getCellsBoxes().get(genome[i]-1);
            for (Pair pair : problem.getPairs()) {
              if((pair.getCell1().equals(cellCurrent)&&pair.getCell2().equals(cellBox))||(pair.getCell1().equals(cellBox)&&pair.getCell2().equals(cellCurrent))){
                  fitness+=pair.getValue();
                  cellCurrent=cellBox;
                  break;
              }
            }
        }
        for (Pair pair: problem.getPairs()) {
            if(pair.getCell1().equals(cellBox)&&pair.getCell2().equals(problem.getDoor())||(pair.getCell1().equals(problem.getDoor())&&pair.getCell2().equals(cellBox))){
                fitness+=pair.getValue();
            }
        }
        return fitness;
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
        sb.append("Porta");
        sb.append("\nposicao: ");
        for (int i = 0; i <genome.length ; i++) {
            sb.append(problem.getCellsBoxes().get(genome[i]-1)).append(" ");

        }
        sb.append(problem.getDoor());
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
