package catchBox;

import agentSearch.Action;
import agentSearch.Problem;

import java.util.ArrayList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes
    private final CatchState goalState;
    protected List<Action> actions;
    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        actions=new ArrayList<>();
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());
        int[][] matrix_clone=initialCatchState.getMatrix();
        switch (matrix_clone[initialCatchState.getCatchLine()][initialCatchState.getCatchColumn()]){
            case 1:
                if(matrix_clone[goalPosition.getLine()][goalPosition.getColumn()]==2){
                    matrix_clone[goalPosition.getLine()][goalPosition.getColumn()]=1;
                    matrix_clone[initialCatchState.getCatchLine()][initialCatchState.getCatchColumn()]=0;
                }
                break;
        }
        goalState= new CatchState(matrix_clone);

        //TODO
       // throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public List<S> executeActions(S state) {
        List<S> successors=new ArrayList<>(4);
        for (Action action:actions) {
            if(action.isValid(state)){
                S successor=(S) state.clone();
                action.execute(successor);
                successors.add(successor);
            }
        }
        return successors;
    }

    public boolean isGoal(S state) {
        //TODO
        return goalState.equals(state);
        //throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
