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
        this.cellsBoxes=(LinkedList<Cell>) cellsBoxes.clone();
        this.pairs=(LinkedList<Pair>) pairs.clone();
        this.cellCath=new Cell(cellCatch.getLine(),cellCatch.getColumn());
        this.door= new Cell(door.getLine(),door.getColumn());

    }

    @Override
    public CatchIndividual getNewIndividual() {
       return  new CatchIndividual(this,pairs.size());
    }

    @Override
    public String toString() {
        //TODO
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
