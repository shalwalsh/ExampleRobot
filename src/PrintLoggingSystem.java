public class PrintLoggingSystem extends LoggingSystem {
    @Override
    public void log(String pString) {
        System.out.println(pString);
    }
}
