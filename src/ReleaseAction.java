public class ReleaseAction extends Action {

    public ReleaseAction(Robot pRobot) {
        super("Release", pRobot);
    }

    /**
     * Ensures that gripper is not already open.
     * Release can be called even if gripper is empty.
     *
     * @return Boolean
     */
    @Override
    public Boolean checkPreConditions() {
        if ( super.getRobot().getGripperState() == Robot.GripperState.OPEN ){
            return false;
        }
        return true;
    }

    @Override
    protected void execute() {
        if ( super.getRobot().getArmState() != Robot.ArmState.RETRACTED ){
            super.getRobot().retractArm();
        }
        super.getRobot().openGripper();
    }

    @Override
    public void accept(ActionVisitor pVisitor) {
        pVisitor.visitReleaseAction(this);
    }
}
