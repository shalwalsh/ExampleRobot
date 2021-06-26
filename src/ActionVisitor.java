public interface ActionVisitor {
    void visitCompactObjectAction( CompactObjectAction pAction );
    void visitComplexAction( ComplexAction pAction );
    void visitEmptyCompactorAction( EmptyCompactorAction pAction );
    void visitGrabAction( GrabAction pAction );
    void visitMoveForwardAction( MoveForwardAction pAction );
    void visitReleaseAction( ReleaseAction pAction );
    void visitTurnAction( TurnAction pAction );
}
