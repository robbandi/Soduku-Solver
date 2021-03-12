package uk.ac.aber.cs21120.solution;

import uk.ac.aber.cs21120.interfaces.IGrid;
import uk.ac.aber.cs21120.interfaces.ISolver;

public class Solver implements ISolver {
    //    private int[][] grid;
//    Grid gridClass = new Grid();
    private Grid grid;

    public Solver(IGrid g) {
        this.grid = (Grid) g;
    }

    @Override
    public boolean solve() {
        boolean result;
//        int count = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (grid.get(row, col) == 0) { //checking for empty cells
                    for (int digit = 1; digit <= 9; digit++) {
                        grid.set(row, col, digit); // set number if it passes all checks
                        if (grid.isValid()) {
                            result = solve();
                            if (result == true) { // backtrack if there are constraints, otherwise solve
                                return true;
                            }
                        }
                    }
                    grid.set(row, col, 0); //reset to 0 - no digits worked
                    return false;
                }
            }
        }
        return true; //if solved, return true
    }
}