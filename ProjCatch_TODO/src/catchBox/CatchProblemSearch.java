package catchBox;

import agentSearch.Action;
import agentSearch.Problem;

import java.util.ArrayList;
import java.util.List;

public class CatchProblemSearch<S extends CatchState> extends Problem<S> {
    //TODO this class might require the definition of additional methods and/or attributes
    protected List<Action> actions;
    private Cell goalPosition;
    public CatchProblemSearch(S initialCatchState, Cell goalPosition) {
        super(initialCatchState);
        actions=new ArrayList<>();
        actions.add(new ActionUp());
        actions.add(new ActionRight());
        actions.add(new ActionDown());
        actions.add(new ActionLeft());
        this.goalPosition= goalPosition;
    }

    @Override
    public List<S> executeActions(S state) {
        List<S> successors=new ArrayList<>(4);
        for (Action action:actions) {
            if(action.isValid(state)){
                S successor= (S) state.clone();
                action.execute(successor);
                successors.add(successor);
            }
        }
        return successors;
    }

    public boolean isGoal(S state) {

        return state.getCatchColumn()==goalPosition.getColumn()&&state.getCatchLine()==goalPosition.getLine();
    }
}
