package catchBox;

import agentSearch.Action;
import agentSearch.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {
    //TODO this class might require the definition of additional methods and/or attributes

    protected int[][] matrix;
    private  int lengthMatrix;
//    private   int lineaAgente;
//    private  int colunaAgente;

    private int lineGoal;
    private int columnGoal;
    private int catchLine;
    private int catchColumn;
    private int  numBoxes;
    private int steps;
    public CatchState(int[][] matrix) {
        lengthMatrix=matrix.length;
        this.matrix=new int[matrix.length][matrix.length];
        numBoxes=0;
        steps = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                this.matrix[i][j] = matrix[i][j];
                if(matrix[i][j]==1){
                    catchLine=i;
                    catchColumn=j;
                }else{
                    if(matrix[i][j]==2){
                        numBoxes++;
                    }
                }


            }
        }


    }

    public void executeAction(Action action) {
        action.execute(this);
        fireUpdatedEnvironment();
    }

    public boolean canMoveUp() {
        return catchLine != 0 && matrix[catchLine-1][catchColumn] != 3 ;

    }

    public boolean canMoveRight() {
        return catchColumn != lengthMatrix-1 && matrix[catchLine][catchColumn+1] != 3 ;

    }

    public boolean canMoveDown() {
        return catchLine != lengthMatrix-1 && matrix[catchLine+1][catchColumn] != 3 ;

    }

    public boolean canMoveLeft() {
        return catchColumn != 0 && matrix[catchLine][catchColumn-1] != 3 ;

    }

    public void moveUp() {
    matrix[catchLine-1][catchColumn] = matrix[catchLine][catchColumn];
    matrix[catchLine][catchColumn] = 0;
    catchLine--;
    steps++;
    }

    public void moveRight() {
        matrix[catchLine][catchColumn+1] = matrix[catchLine][catchColumn];
        matrix[catchLine][catchColumn] = 0;
        catchColumn++;
        steps++;
    }

    public void moveDown() {
        matrix[catchLine+1][catchColumn] = matrix[catchLine][catchColumn];
        matrix[catchLine][catchColumn] = 0;
        catchLine++;
        steps++;
    }

    public void moveLeft() {
        matrix[catchLine][catchColumn-1] = matrix[catchLine][catchColumn];
        matrix[catchLine][catchColumn] = 0;
        catchColumn--;
        steps++;
    }

    public double computeManhattan(){

        double h= Math.abs(catchLine-lineGoal)+Math.abs(columnGoal-catchColumn);
        return h;
    }

    public int getNumBox() {

        return numBoxes;
    }

    public void setCellCatch(int line, int column) {

        catchColumn=column;
        catchLine=line;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getLineGoal() {
        return lineGoal;
    }

    public int getColumnGoal() {
        return columnGoal;
    }

    public int getCatchLine() {
        return catchLine;
    }

    public int getCatchColumn() {
        return catchColumn;
    }
    public void setGoal(int line, int column) {

       lineGoal=line;
       columnGoal=column;

    }

    public int getSteps() {

        //throw new UnsupportedOperationException("Not Implemented Yet");
        return steps; //implementar
    }

    public int getSize() {
        return matrix.length;
    }

    public Color getCellColor(int line, int column) {
        switch (matrix[line][column]) {
            case Properties.BOX:
                return Properties.COLORBOX;
            case Properties.CATCH:
                return Properties.COLORCATCH;
            case Properties.DOOR:
                return Properties.COLORDOOR;
            case Properties.WALL:
                return Properties.COLORWALL;
            default:
                return Properties.COLOREMPTY;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CatchState)) {
            return false;
        }

        CatchState o = (CatchState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public CatchState clone() {
        CatchState clone=new CatchState(matrix);
        clone.setCellCatch(catchLine,catchColumn);
        clone.setGoal(lineGoal,columnGoal);
        return clone;
    }

    //Listeners
    private final ArrayList<EnvironmentListener> listeners = new ArrayList<>();

    public synchronized void addEnvironmentListener(EnvironmentListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public synchronized void removeEnvironmentListener(EnvironmentListener l) {
        listeners.remove(l);
    }

    public void fireUpdatedEnvironment() {
        for (EnvironmentListener listener : listeners) {
            listener.environmentUpdated();
        }
    }

}
