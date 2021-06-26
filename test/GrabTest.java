import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GrabTest {
    private StubRobot testBot;
    private GrabAction testAction;

    @Before
    public void setUp() {
        testBot = new StubRobot();
        testAction = new GrabAction(testBot);
    }

    @Test
    public void testPreconditions_fail() {
        testBot.gripperState = Robot.GripperState.HOLDING_OBJECT;
        assertFalse(testAction.checkPreConditions());
    }

    @Test
    public void testPreconditions_pass() {
        testBot.gripperState = Robot.GripperState.OPEN;
        assertTrue(testAction.checkPreConditions());
    }

    @Test
    public void testExecute_GripperClosed() {
        testBot.gripperState = Robot.GripperState.EMPTY;
        testAction.execute();
        assertTrue(testBot.openGripperCalled);
    }


    @Test
    public void testExecute_ArmRetracted() {
        testBot.armState = Robot.ArmState.RETRACTED;
        testAction.execute();
        assertTrue(testBot.extendedCalled);
    }

    @Test
    public void testExecute_callsCloseGripper(){
        testAction.execute();
        assertTrue(testBot.closeGripperCalled);
    }

    @Test
    public void testExecute_retractedCalled(){
        testAction.execute();
        assertTrue(testBot.retractedCalled);
    }

    @Test
    public void testAccept(){
        StubVisitor testVisitor = new StubVisitor();
        testAction.accept(testVisitor);
        assertTrue(testVisitor.grabVisitCalled);
    }

}
