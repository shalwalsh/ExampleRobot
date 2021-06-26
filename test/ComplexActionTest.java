import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComplexActionTest {
    private StubRobot testBot;
    private ComplexAction complex;
    private ActionTest.StubAction testAction1;
    private ActionTest.StubAction testAction2;
    private ActionTest.StubAction testAction3;

    @Before
    public void setUp() {
        testBot = new StubRobot();
        testAction1 = new ActionTest.StubAction("Stub", testBot);
        testAction2 = new ActionTest.StubAction("Stub", testBot);
        List<Action> testList = new ArrayList<>();
        testList.add(testAction1);
        testList.add(testAction2);
        complex = new ComplexAction("Stub", testBot, testList);
        testAction3 = new ActionTest.StubAction("Stub", testBot);
    }

   @Test
    public void testExecute(){
        complex.execute();
        assertTrue(testAction1.hasExecuted && testAction2.hasExecuted);
   }

   @Test
    public void testAdd() {
        complex.addAction(testAction3);
        complex.execute();
        assertTrue(testAction3.hasExecuted);
   }

   @Test
    public void testRemove() {
        complex.removeAction(0);
        complex.execute();
        assertFalse(testAction1.hasExecuted);
   }
}
