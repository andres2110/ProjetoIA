package catchBox;

import agentSearch.Action;
import agentSearch.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CatchState extends State implements Cloneable {
    //TODO this class might require the definition of additional methods and/or attributes

    protected int[][] matrix;
    private   int lineaAgente;
    private  int colunaAgente;
    private int [][] goal_matrix;
    private int lineGoal;
    private int columnGoal;
    private int catchLine;
    private int catchColumn;
    private int  numBoxes;
    private  int steps;
    public CatchState(int[][] matrix) {
        goal_matrix=matrix;
        this.matrix=matrix;
        numBoxes=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                if(matrix[i][j]==1){
                    lineaAgente=i;
                    colunaAgente=j;
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
        steps++;
        fireUpdatedEnvironment();

    }

    public boolean canMoveUp() {
        return catchLine != 0 && matrix[catchLine+1][catchColumn] != 3 ;

    }

    public boolean canMoveRight() {
        return catchColumn != 5 && matrix[catchLine][catchColumn+1] != 3 ;

    }

    public boolean canMoveDown() {
        return catchLine != 5 && matrix[catchLine-1][catchColumn] != 3 ;

    }

    public boolean canMoveLeft() {
        return catchColumn != 0 && matrix[catchLine][catchColumn-1] != 3 ;

    }

    public void moveUp() {
    matrix[catchLine+1][catchColumn] = matrix[catchLine][catchColumn];
    matrix[catchLine][catchColumn] = 0;
    }

    public void moveRight() {
        matrix[catchLine][catchColumn+1] = matrix[catchLine][catchColumn];
        matrix[catchLine][catchColumn] = 0;
    }

    public void moveDown() {
        matrix[catchLine-1][catchColumn] = matrix[catchLine][catchColumn];
        matrix[catchLine][catchColumn] = 0;
    }

    public void moveLeft() {
        matrix[catchLine][catchColumn-1] = matrix[catchLine][catchColumn];
        matrix[catchLine][catchColumn] = 0;
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
        return steps;
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
        //TODO
        return new CatchState(matrix);
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
