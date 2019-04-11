package de.vkb.codingdojo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MinerTests {

    @Test
    public void classExists(){

        MineEscape mineEscape = new MineEscape();

        assertNotNull(mineEscape);
    }

    @Test
    public void boardWithTwoFieldsHorizontalReturnsRight(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("rechts");

        boolean[][] board = new boolean[1][2];
        Coordinate startPosition = new Coordinate(0, 0);
        Coordinate endPosition = new Coordinate(0, 1);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);

    }

    @Test
    public void boardWithTwoFieldsHorizontalReturnLeft(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("links");

        boolean[][] board = new boolean[1][2];
        Coordinate startPosition = new Coordinate(1, 0);
        Coordinate endPosition = new Coordinate(0, 0);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);
    }

    @Test
    public void boardWithTwoFieldsVerticalReturnDown(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("runter");

        boolean[][] board = new boolean[2][1];
        Coordinate startPosition = new Coordinate(0, 0);
        Coordinate endPosition = new Coordinate(0, 1);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);
    }

    @Test
    public void boardWithTwoFieldsVerticalReturnTop(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("rauf");

        boolean[][] board = new boolean[2][1];
        Coordinate startPosition = new Coordinate(0, 1);
        Coordinate endPosition = new Coordinate(0, 0);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);
    }

    @Test
    public void minerRunsTwoFieldsRightReturnsTwoRights(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("rechts");
        expectedResult.add("rechts");

        boolean[][] board = new boolean[1][3];
        Coordinate startPosition = new Coordinate(0, 0);
        Coordinate endPosition = new Coordinate(2, 0);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);

    }

    @Test
    public void minerRunsTwoFieldsRightReturnsTwoLeft(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("links");
        expectedResult.add("links");

        boolean[][] board = new boolean[1][3];
        Coordinate startPosition = new Coordinate(2, 0);
        Coordinate endPosition = new Coordinate(0, 0);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);

    }

    @Test
    public void minerRunsTwoFieldsRightReturnsTwoDown(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("runter");
        expectedResult.add("runter");

        boolean[][] board = new boolean[3][1];
        Coordinate startPosition = new Coordinate(0, 0);
        Coordinate endPosition = new Coordinate(0, 2);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);

    }

    @Test
    public void minerRunsTwoFieldsRightReturnsTwoTop(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("rauf");
        expectedResult.add("rauf");

        boolean[][] board = new boolean[3][1];
        Coordinate startPosition = new Coordinate(0, 2);
        Coordinate endPosition = new Coordinate(0, 0);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);

    }

    @Test
    public void minerRunsTwoFieldsRightAndDownReturnsLeftTop(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("links");
        expectedResult.add("rauf");

        boolean[][] board = new boolean[2][2];
        Coordinate startPosition = new Coordinate(1, 1);
        Coordinate endPosition = new Coordinate(0, 0);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);

    }

    @Test
    public void minerRunsTwoFieldsDownAndRightReturnsDownRight(){

        ArrayList<String> expectedResult = new ArrayList<String>();
        expectedResult.add("runter");
        expectedResult.add("rechts");

        boolean[][] board = new boolean[2][2];
        board[0][0] = true;
        board[0][1] = true;
        board[1][0] = false;
        board[1][1] = true;
        Coordinate startPosition = new Coordinate(0, 0);
        Coordinate endPosition = new Coordinate(1, 1);

        MineEscape mineEscape = new MineEscape();

        List<String> result = mineEscape.calculatePath(board,startPosition,endPosition);

        assertIterableEquals(expectedResult, result);

    }
}
