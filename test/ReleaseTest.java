import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReleaseTest {
    private StubRobot testBot;
    private ReleaseAction testAction;

    @Before
    public void setUp() {
        testBot = new StubRobot();
        testAction = new ReleaseAction(testBot);
    }

    @Test
    public void testConditions_fail() {
        testBot.gripperState = Robot.GripperState.OPEN;
        assertFalse(testAction.checkPreConditions());
    }

    @Test
    public void testConditions_pass(){
        testBot.gripperState = Robot.GripperState.HOLDING_OBJECT;
        assertTrue(testAction.checkPreConditions());
    }

    @Test
    public void testExecute_ArmExtended() {
        testBot.armState = Robot.ArmState.EXTENDED;
        testAction.execute();
        assertTrue(testBot.retractedCalled);

    }

    @Test
    public void testExecute_ArmRetracted() {
        testBot.armState = Robot.ArmState.RETRACTED;
        testAction.execute();
        assertFalse(testBot.retractedCalled);
    }

    @Test
    public void testExecute_callsOpenGripper(){
        testAction.execute();
        assertTrue(testBot.openGripperCalled);
    }

    @Test
    public void testAccept(){
        StubVisitor testVisitor = new StubVisitor();
        testAction.accept(testVisitor);
        assertTrue(testVisitor.releaseVisitCalled);
    }

}
