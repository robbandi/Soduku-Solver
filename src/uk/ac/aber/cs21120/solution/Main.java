package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.tests.Examples;
import uk.ac.aber.cs21120.solution.Grid;

public class Main {

    /**
     * Main method for Testing
     */

    public static void main(String[] args) {
        for (int i = 0; i < 400; i++) {

            long start = System.currentTimeMillis();
//            System.out.println(start); //test
            new Solver(Examples.getExample(i)).solve();
            long timeTaken = System.currentTimeMillis();
//            System.out.println(timeTaken); //test
            long difference = (timeTaken - start);

            System.out.println("Puzzle " + i + " gap " + Examples.getGapCount(i) + " took " + difference + "ms");

//            System.out.println(Examples.getGapCount(i)); //printings for the Graph
//            System.out.println(difference); //printings for the Graph
        }
    }
}
