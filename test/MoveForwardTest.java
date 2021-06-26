import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MoveForwardTest {
    private StubRobot testBot;
    private MoveForwardAction testAction;

    @Before
    public void setUp() {
        testBot = new StubRobot();
        testAction = new MoveForwardAction(testBot, 20);
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
    public void testAccept(){
        StubVisitor testVisitor = new StubVisitor();
        testAction.accept(testVisitor);
        assertTrue(testVisitor.moveVisitCalled);
    }

}
