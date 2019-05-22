package catchBox;

import ga.Problem;

import java.util.LinkedList;

public class CatchProblemForGA implements Problem<CatchIndividual> {
    //TODO this class might require the definition of additional methods and/or attributes
    private LinkedList<Cell> cellsBoxes;
    private LinkedList<Pair> pairs;
    private Cell cellCath;
    private Cell door;

    public CatchProblemForGA(
            LinkedList<Cell> cellsBoxes,
            LinkedList<Pair> pairs,
            Cell cellCatch,
            Cell door) {
        this.cellsBoxes= new LinkedList<>();
        this.cellsBoxes=(LinkedList<Cell>) cellsBoxes.clone();
        this.pairs=(LinkedList<Pair>) pairs.clone();


    }

    @Override
    public CatchIndividual getNewIndividual() {
        //TODO
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public String toString() {
        //TODO
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
