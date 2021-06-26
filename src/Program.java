import java.util.ArrayList;
import java.util.List;

public class Program {
    final private List<Action> actionList;
    final private List<ActionObserver> aObservers = new ArrayList<>();

    public Program(){
        actionList = new ArrayList<>();
    }

    public Program(List<Action> pList) {
        actionList = pList;
    }

    public Boolean executeProgram() {
        for ( Action currentAction : actionList ) {
            Boolean performed = currentAction.perform();
            if (!performed) {
                return false;
            }
            notifyObservers(currentAction);
        }
        return true;
    }

    public void addAction(Action pAction) {
        actionList.add(pAction);
    }

    public void removeAction(int pIndex) {
        actionList.remove(pIndex);
    }

    /**
     *
     * @param pObserver
     *      Observer to add to list of Observers
     * @pre pOberserver != null
     */
    public void addObserver(ActionObserver pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    /**
     *
     * @param pObserver
     *      Observer to remove from list of Observers
     */
    public void removeObserver(ActionObserver pObserver) {
        aObservers.remove(pObserver);
    }

    /**
     * Tells the observers that an action has been performed
     */
    private void notifyObservers(Action pAction){
        for (ActionObserver o : aObservers ){
            o.actionPerformed(pAction);
        }
    }

    public void accept(ActionVisitor pVisitor){
        for (Action currentAction : actionList) {
            currentAction.accept(pVisitor);
        }
    }

}
