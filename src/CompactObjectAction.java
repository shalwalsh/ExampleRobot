public class CompactObjectAction extends Action {

    public CompactObjectAction(Robot pRobot){
        super("Compact Object", pRobot);
    }

    @Override
    public Boolean checkPreConditions() {
        if ( super.getRobot().getGripperState() != Robot.GripperState.HOLDING_OBJECT ) {
            return false;
        }
        return true;
    }

    @Override
    protected void execute() {
        super.getRobot().compact();
    }

    @Override
    public void accept(ActionVisitor pVisitor) {
        pVisitor.visitCompactObjectAction(this);
    }
}
