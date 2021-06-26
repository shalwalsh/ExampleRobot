public class AlwaysRechargeDecorator extends Action {
    final Action decoratedAction;

    public AlwaysRechargeDecorator(Action pAction) {
        super("Recharge and " + pAction.getName(), pAction.getRobot());
        decoratedAction = pAction;
    }

    /**
     * Charges battery no matter the level, then delegates perform() to original Action
     * @return Boolean
     */
    @Override
    public Boolean perform() {
        decoratedAction.getRobot().rechargeBattery();
        return decoratedAction.perform();
    }

    @Override
    public Boolean checkPreConditions() {
        return decoratedAction.checkPreConditions();
    }

    @Override
    protected void execute() {
        decoratedAction.execute();
    }

    @Override
    public void accept(ActionVisitor pVisitor) {
        decoratedAction.accept(pVisitor);
    }


}
