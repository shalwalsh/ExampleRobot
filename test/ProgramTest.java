import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProgramTest {
    private ActionTest.StubAction testAction;
    private Program testProgram;
    private StubRobot testBot;

    @Before
    public void setUp(){
        testProgram = new Program();
        testBot = new StubRobot();
        testAction = new ActionTest.StubAction("stub", testBot);
        testProgram.addAction(testAction);
    }

    @Test
    public void testExecute(){
        testProgram.executeProgram();
        assertTrue(testAction.hasExecuted);
    }

}
