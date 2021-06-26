import java.util.ArrayList;
import java.util.List;

public abstract class Action {
    private String aName;
    final private Robot aRobot;

    /**
     *
     * @param pName
     *      Name of action
     * @param pRobot
     *      Robot to call action on
     * @pre pName != null && pRobot != null
     */
    public Action(String pName, Robot pRobot){
        assert pName != null && pRobot != null;
        aRobot = pRobot;
        aName = pName;
    }

    /**
     * Checks that the pre-conditions for the action are met
     * @return Boolean
     *      True if conditions are met, false if not
     */
    public abstract Boolean checkPreConditions();

    /**
     * Performs the action.
     *
     * @return Boolean
     *      true if the action was successfully performed and false if not (if pre-conditions aren't met)
     */
    public Boolean perform() {
        if ( !checkPreConditions() ) {
            return false;
        }
        if ( aRobot.getBatteryCharge() <= 5 ) {
            aRobot.rechargeBattery();
        }
        execute();
        aRobot.updateBatteryLevel();
        //notifyObservers();
        return true;
    }

    /**
     * Holds execution implementation of specific actions.
     * Should only ever be called from perform() method (to ensure pre-conditions are met)
     *
     * @pre is called from perform()
     */
    protected abstract void execute();

    public String getName(){
        return aName;
    }

    /**
     *
     * @param pName
     *      new name for action
     * @pre pName != null
     */
    public void setName(String pName){
        assert pName != null;
        aName = pName;
    }

    public Robot getRobot(){
        return aRobot;
    }

    public abstract void accept(ActionVisitor pVisitor);

    /*public Action clone() {
        try {
            Action clone = (Action) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            assert false;
            return null;
        }
    }*/


}
