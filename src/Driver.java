import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        WallE myWallE = new WallE(); //my tester robot

        /**
         * Perform each basic action in a program
         * At the end, include an action that forces battery to recharge
         */
        System.out.println("********** Basic Action Program Test **********");

        Program basicActionProgram = new Program();
        basicActionProgram.addObserver(new PrintLoggingSystem());

        basicActionProgram.addAction(new MoveForwardAction(myWallE, 20));
        basicActionProgram.addAction(new TurnAction(myWallE, 180));
        basicActionProgram.addAction(new GrabAction(myWallE));
        basicActionProgram.addAction(new ReleaseAction(myWallE));
        basicActionProgram.addAction(new GrabAction(myWallE)); //to have something to compact
        basicActionProgram.addAction(new CompactObjectAction(myWallE));
        basicActionProgram.addAction(new EmptyCompactorAction(myWallE));
        basicActionProgram.addAction(new AlwaysRechargeDecorator(new MoveForwardAction(myWallE, 20)));

        basicActionProgram.executeProgram();


        /**
         * Creating a complex action (move backwards) using turn and then move forward
         * Loads action to a program and executes with a logger to "see" it performed
         */

        System.out.println("********** Complex Action Program Test **********");

        Action moveForward = new MoveForwardAction(myWallE, 180);
        Action turnAround = new TurnAction(myWallE, 180);

        ComplexAction moveBackwards = new ComplexAction("Move Backwards", myWallE);
        moveBackwards.addAction(turnAround);
        moveBackwards.addAction(moveForward);

        Program complexActionProgram = new Program();
        complexActionProgram.addAction(moveBackwards);
        complexActionProgram.addObserver(new PrintLoggingSystem());

        complexActionProgram.executeProgram();

        /**
         * Calculate distance moved and items compacted in Complex Action Program
         */

        System.out.println("********** Complex Program Computations **********");

        DistanceMovedVisitor complexDistance = new DistanceMovedVisitor();
        complexActionProgram.accept(complexDistance);
        System.out.println("Total distance moved: " + complexDistance.getTotalDistance());

        CompactCountVisitor complexCompact = new CompactCountVisitor();
        complexActionProgram.accept(complexCompact);
        System.out.println("Total items compacted: " + complexCompact.getCount());

        /**
         * Calculate distance moved and items compacted in Basic Action Program
         */

        System.out.println("********** Basic Program Computations **********");

        DistanceMovedVisitor basicDistance = new DistanceMovedVisitor();
        basicActionProgram.accept(basicDistance);
        System.out.println("Total distance moved: " + basicDistance.getTotalDistance());

        CompactCountVisitor basicCompact = new CompactCountVisitor();
        complexActionProgram.accept(basicCompact);
        System.out.println("Total items compacted: " + basicCompact.getCount());


    }
}
