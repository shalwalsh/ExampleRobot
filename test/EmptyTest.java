import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmptyTest {
    private StubRobot testBot;
    private EmptyCompactorAction testAction;

    @Before
    public void setUp() {
        testBot = new StubRobot();
        testAction = new EmptyCompactorAction(testBot);
    }

    @Test
    public void testExecute_AlreadyEmpty() {
        testAction.execute();
        assertFalse(testBot.emptyCompactCalled);

    }

    @Test
    public void testExecute_NotEmpty() {
        testBot.compactedItems = 2;
        testAction.execute();
        assertTrue(testBot.emptyCompactCalled);
    }

    @Test
    public void testAccept(){
        StubVisitor testVisitor = new StubVisitor();
        testAction.accept(testVisitor);
        assertTrue(testVisitor.emptyVisitCalled);
    }

}
