public class StubVisitor implements ActionVisitor{
    boolean compactVisitCalled = false;
    boolean complexVisitCalled = false;
    boolean emptyVisitCalled = false;
    boolean grabVisitCalled = false;
    boolean moveVisitCalled = false;
    boolean releaseVisitCalled = false;
    boolean turnVisitCalled = false;

    @Override
    public void visitCompactObjectAction(CompactObjectAction pAction) {
        compactVisitCalled = true;
    }

    @Override
    public void visitComplexAction(ComplexAction pAction) {
        complexVisitCalled = true;
    }

    @Override
    public void visitEmptyCompactorAction(EmptyCompactorAction pAction) {
        emptyVisitCalled = true;
    }

    @Override
    public void visitGrabAction(GrabAction pAction) {
        grabVisitCalled = true;
    }

    @Override
    public void visitMoveForwardAction(MoveForwardAction pAction) {
        moveVisitCalled = true;
    }

    @Override
    public void visitReleaseAction(ReleaseAction pAction) {
        releaseVisitCalled = true;
    }

    @Override
    public void visitTurnAction(TurnAction pAction) {
        turnVisitCalled = true;
    }
}
