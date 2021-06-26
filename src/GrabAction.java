public class GrabAction extends Action {

    public GrabAction(Robot pRobot){
        super("Grab", pRobot);
    }

    /**
     * Ensures that the robot arm is retracted and the gripper is open
     *
     * @return
     */
    @Override
    public Boolean checkPreConditions() {
        if ( super.getRobot().getGripperState() == Robot.GripperState.HOLDING_OBJECT ) {
            return false;
        }
        return true;
    }

    @Override
    protected void execute() {
        if (super.getRobot().getGripperState() == Robot.GripperState.EMPTY) {
            if (super.getRobot().getArmState() == Robot.ArmState.EXTENDED) {
                super.getRobot().retractArm();
            }
            super.getRobot().openGripper();
        }
        if (super.getRobot().getArmState() == Robot.ArmState.RETRACTED){
            super.getRobot().extendArm();
        }
        super.getRobot().closeGripper();
        super.getRobot().retractArm();
    }

    @Override
    public void accept(ActionVisitor pVisitor) {
        pVisitor.visitGrabAction(this);
    }
}
