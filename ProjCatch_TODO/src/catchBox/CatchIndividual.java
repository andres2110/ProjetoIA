package catchBox;

import ga.IntVectorIndividual;

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
        for (int i = 0; i < genome.length; i++) {
           cellBox = problem.getCellsBoxes().get(this.getIndexof(i + 1));
            for (Pair pair : problem.getPairs()) {
                if(pair.getCell1().getLine()==problem.getCellCath().getLine()&&pair.getCell1().getColumn()==problem.getCellCath().getColumn()&&
                        pair.getCell2().getLine()==cellBox.getLine()&&pair.getCell2().getColumn()==cellBox.getColumn()){
                    fitness+=pair.getValue();
                }

            }
        }
        for (Pair pair: problem.getPairs()) {
            if(pair.getCell1().getLine()==cellBox.getLine()&&pair.getCell1().getColumn()==cellBox.getColumn()
                    &&pair.getCell2().getLine()==problem.getDoor().getLine()&&pair.getCell2().getColumn()==problem.getDoor().getColumn()){
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
