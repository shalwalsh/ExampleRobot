public class EmptyCompactorAction extends Action {

    public EmptyCompactorAction(Robot pRobot){
        super("Empty Compactor", pRobot);
    }
    @Override
    public Boolean checkPreConditions() {
        return true;
    }

    @Override
    protected void execute() {
        if ( super.getRobot().getCompactorLevel() != 0 ) {
            super.getRobot().emptyCompactor();
        }
    }

    @Override
    public void accept(ActionVisitor pVisitor) {
        pVisitor.visitEmptyCompactorAction(this);
    }
}
