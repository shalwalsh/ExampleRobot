public class DistanceMovedVisitor extends AbstractActionVisitor {
    private double totalDistance = 0;

    @Override
    public void visitMoveForwardAction(MoveForwardAction pAction) {
        totalDistance += pAction.getDistance();
    }

    public double getTotalDistance(){
        return totalDistance;
    }
}
