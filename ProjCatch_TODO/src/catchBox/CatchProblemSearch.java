package catchBox;

import agentSearch.Problem;

import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes
    CatchState goalState;
    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);

        //TODO
        throw new UnsupportedOperationException("Not Implemented Yet");
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
