import java.util.ArrayList;
import java.util.List;

public class ComplexAction extends Action {
    final private List<Action> aList;

    /**
     * Creates a new empty complex action.
     * @param pName
     *      Name of action
     * @param pRobot
     *      Robot to be performed on
     */
    public ComplexAction(String pName, Robot pRobot) {
        super(pName, pRobot);
        aList = new ArrayList<>();
    }

    /**
     * Creates a new complex action that takes a pre-initialized list of actions
     *
     * @param pName
     *      Name of action
     * @param pRobot
     *      Robot to perform action on
     * @param pList
     *      List of actions to include in complex action
     */
    public ComplexAction(String pName, Robot pRobot, List<Action> pList){
        super(pName, pRobot);
        aList = new ArrayList<>(pList);
    }

    @Override
    public Boolean perform(){
        for ( Action basicAction : aList ) {
            Boolean performed = basicAction.perform();
            if ( !performed ) {
                return false;
            }
        }
        return true;

    }

    @Override
    public Boolean checkPreConditions() {
        return aList.get(0).checkPreConditions();
    }

    /**
     * Empty, will delegate execution to basic actions
     */
    @Override
    protected void execute() {}

    @Override
    public void accept(ActionVisitor pVisitor) {
        pVisitor.visitComplexAction(this);
        for (Action currentAction : aList ) {
            currentAction.accept(pVisitor);
        }
    }

    public void addAction(Action pAction){
        aList.add(pAction);
    }

    public void removeAction(int pIndex){
        aList.remove(pIndex);
    }

}
