public abstract class LoggingSystem extends ActionObserver{

    @Override
    public void actionPerformed(Action pAction) {
        log(pAction.getName() + " action performed, battery level is " + pAction.getRobot().getBatteryCharge());
    }

    /**
     * Implements behavior to log string.
     *
     * @param pString
     *      String to log
     */
    public abstract void log(String pString);
}
