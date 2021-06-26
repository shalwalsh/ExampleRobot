public class StubRobot implements Robot {
    protected boolean turnCalled = false;
    protected boolean moveCalled = false;
    protected boolean rechargeCalled = false;
    protected boolean compactCalled = false;
    protected boolean emptyCompactCalled = false;
    protected boolean retractedCalled = false;
    protected boolean extendedCalled = false;
    protected boolean openGripperCalled = false;
    protected boolean closeGripperCalled = false;
    protected GripperState gripperState;
    protected ArmState armState;
    protected int charge = 100;
    protected int compactedItems = 0;

    @Override
    public void turnRobot(double pDegrees) {
        turnCalled = true;
    }

    @Override
    public void moveRobot(double pDistance) {
        moveCalled = true;
    }

    @Override
    public void openGripper() {
        openGripperCalled = true;
        gripperState = GripperState.OPEN;
    }

    @Override
    public void closeGripper() {
        closeGripperCalled = true;
        gripperState = GripperState.EMPTY;
    }

    @Override
    public GripperState getGripperState() {
        return gripperState;
    }

    @Override
    public void extendArm() {
        extendedCalled = true;
        armState = ArmState.EXTENDED;
    }

    @Override
    public void retractArm() {
        retractedCalled = true;
        armState = ArmState.RETRACTED;
    }

    @Override
    public ArmState getArmState() {
        return armState;
    }

    @Override
    public void compact() {
        compactCalled = true;
    }

    @Override
    public void emptyCompactor() {
        emptyCompactCalled = true;
    }

    @Override
    public int getCompactorLevel() {
        return compactedItems;
    }

    @Override
    public void rechargeBattery() {
        rechargeCalled = true;
    }

    @Override
    public void updateBatteryLevel() {

    }

    @Override
    public int getBatteryCharge() {
        return 0;
    }
}
