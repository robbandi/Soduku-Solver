package uk.ac.aber.cs21120.solution;

import jdk.swing.interop.SwingInterOpUtils;
import uk.ac.aber.cs21120.interfaces.IGrid;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;

public class Grid implements IGrid {

    private int[][] grid;

//    // row is X
//    // |
//    // |
//    // V
//    // collum is Y -->

    public Grid() {
        this.grid = new int[9][9];
    }

    @Override
    public int get(int x, int y) throws BadCellException {
        if (x > grid.length-1 || y > grid.length-1 || x < 0 || y < 0)
            throw new BadCellException(x, y);
        return grid[x][y];
    }

    @Override
    public void set(int x, int y, int val) throws BadCellException, BadDigitException {
            if (x > grid.length-1 || y > grid.length-1 || x < 0 || y < 0)
            throw new BadCellException(x, y);
            if (val > grid.length || val < 0)
            throw new BadDigitException(val);
        grid[x][y] = val;
    }

    private boolean checkCol() {
        for (int row = 0; row < grid.length; row++) {
            int[] nArray = new int[9];
            for (int col = 0; col < grid[0].length; col++) {

                //collect values from eac column
                nArray[col] = grid[row][col];

            }
            //check for duplications between a -temp- set of values from 1-9
            int testValues[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int i = 0; i < nArray.length; i++) {
                for (int j = 0; j < testValues.length; j++) {
                    if (nArray[i] != 0) {
                        if (nArray[i] == testValues[j]) {
                            nArray[i] = 0;
                            testValues[j] = 0;
                        }
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                if (nArray[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRow() {
        for (int row = 0; row < grid.length; row++) {
            int[] nArray = new int[9];
            for (int col = 0; col < grid[0].length; col++) {

                //collect values from eac column
                nArray[col] = grid[col][row];

            }
            //check for duplications between a -temp- set of values from 1-9
            int testValues[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            for (int i = 0; i < nArray.length; i++) {
                for (int j = 0; j < testValues.length; j++) {
                    if (nArray[i] != 0) {
                        if (nArray[i] == testValues[j]) {
                            nArray[i] = 0;
                            testValues[j] = 0;
                        }
                    }
                }
            }
            for (int i = 0; i < 9; i++) {
                if (nArray[i] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSubGrid() {
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                int count = 0;
                int[] nArray = new int[9];
                for (int x = row; x < row + 3; x++) {
                    for (int y = col; y < col + 3; y++) {
                        nArray[count] = grid[x][y];
                        count++;
                    }
                }

                //check for duplications between a -temp- set of values from 1-9
                int testValues[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                for (int i = 0; i < nArray.length; i++) {
                    for (int j = 0; j < testValues.length; j++) {
                        if (nArray[i] != 0) {
                            if (nArray[i] == testValues[j]) {
                                nArray[i] = 0;
                                testValues[j] = 0;
                            }
                        }
                    }
                }
                for (int i = 0; i < 9; i++) {
                    if (nArray[i] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean isValid() {
        if (grid == null || grid.length == 0) {
            return false;
        }
        if (!checkCol()) {
            return false;
        }
        if (!checkRow()) {
            return false;
        }
        if (!checkSubGrid()) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                b.append(grid[x][y]);
            }
            b.append('\n');
        }
        return b.toString();
    }
}

