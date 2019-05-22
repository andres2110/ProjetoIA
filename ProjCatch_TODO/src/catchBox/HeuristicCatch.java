package catchBox;

import agentSearch.Heuristic;

public class HeuristicCatch extends Heuristic<CatchProblemSearch, CatchState> {

    @Override
    public double compute(CatchState state) {
       return state.computeManhattan();
    }

    @Override
    public String toString() {
        return "Mangattnah Heuristic";
    }
}