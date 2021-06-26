public class TurnAction extends Action {
    private double aDegrees;

    public TurnAction(Robot pRobot, double pDegrees){
        super("Turn", pRobot);
        aDegrees = pDegrees;
    }

    @Override
    public Boolean checkPreConditions() {
        return true;
    }

    @Override
    protected void execute() {
        if ( super.getRobot().getArmState() == Robot.ArmState.EXTENDED ) {
            super.getRobot().retractArm();
        }
        super.getRobot().turnRobot(aDegrees);
    }

    @Override
    public void accept(ActionVisitor pVisitor) {
        pVisitor.visitTurnAction(this);
    }

    public void setDegrees(double pDegrees){
        aDegrees = pDegrees;
    }

    public double getDegrees(){
        return aDegrees;
    }
}
