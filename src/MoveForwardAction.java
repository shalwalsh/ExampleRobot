public class MoveForwardAction extends Action {
    private double aDistance;

    /**
     *
     * @param pRobot
     *      Robot to move
     * @param pDistance
     *      distance to move forward
     *
     * @pre pDistance >= 0
     */
    public MoveForwardAction(Robot pRobot, double pDistance){
        super("Move Forward", pRobot);
        assert pDistance >= 0;
        aDistance = pDistance;
    }

    @Override
    public Boolean checkPreConditions() {
        return true;
    }

    /**
     * Checks that arm is retracted and retracts it if not
     */
    @Override
    protected void execute() {
        if ( super.getRobot().getArmState() == Robot.ArmState.EXTENDED ) {
            super.getRobot().retractArm();
        }
        super.getRobot().moveRobot(aDistance);
    }

    @Override
    public void accept(ActionVisitor pVisitor) {
        pVisitor.visitMoveForwardAction(this);
    }

    public void setDistance(double pDistance){
        aDistance = pDistance;
    }

    public double getDistance() { return aDistance; };
}
