package catchBox;

import agentSearch.Action;
import agentSearch.Problem;

import java.util.ArrayList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes
    CatchState goalState;
    protected List<Action> actions;
    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        actions=new ArrayList<>();
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());
        goalState= new CatchState(initialCatchState.getMatrix());
        //TODO
       // throw new UnsupportedOperationException("Not Implemented Yet");
    }

    @Override
    public List<S> executeActions(S state) {
        //TODO
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    public boolean isGoal(S state) {
        //TODO
        return goalState.equals(state);
        //throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
