import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CompactTest {
    private StubRobot testBot;
    private CompactObjectAction testAction;

    @Before
    public void setUp() {
        testBot = new StubRobot();
        testAction = new CompactObjectAction(testBot);
    }

    @Test
    public void testConditions_holdingObject() {
        testBot.gripperState = Robot.GripperState.HOLDING_OBJECT;
        assertTrue(testAction.checkPreConditions());

    }

    @Test
    public void testCondiitons_NoObject() {
        testBot.gripperState = Robot.GripperState.EMPTY;
        assertFalse(testAction.checkPreConditions());
    }

    @Test
    public void testExecute_callsCompact(){
        testAction.execute();
        assertTrue(testBot.compactCalled);
    }

    @Test
    public void testAccept(){
        StubVisitor testVisitor = new StubVisitor();
        testAction.accept(testVisitor);
        assertTrue(testVisitor.compactVisitCalled);
    }

}
