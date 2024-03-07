package com.puzzleGame.demo;

import com.puzzleGame.demo.model.Puzzle;
import com.puzzleGame.demo.service.TileMovementService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TileMovementServiceTest {

    @Mock
    private TileMovementService tileMovementService;

    private Puzzle puzzle;

    @Before
    public void setUpBoard(){
        tileMovementService = mock(TileMovementService.class);

        int [][] board = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 0, 12},
            {13, 14, 11, 15}
        };
        puzzle = new Puzzle(board);
    }

    /*Basically TDD for the next 4 tests, to test tile movement.
        Since the methods are not implemented according to the requirements.
        When the methods are implemented we only need to change expectedBoard
         */
    @Test
    public void testMoveRight(){


        tileMovementService.moveRight(puzzle);
        int [][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 11, 15}
        };

        assertArrayEquals(expectedBoard, puzzle.getBoard());
    }

    @Test
    public void testMoveLeft(){
        tileMovementService.moveLeft(puzzle);
        int [][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 11, 15}
        };

        assertArrayEquals(expectedBoard, puzzle.getBoard());
    }

    @Test
    public void testMoveUp(){
        tileMovementService.moveUp(puzzle);
        int [][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 11, 15}
        };

        assertArrayEquals(expectedBoard, puzzle.getBoard());
    }

    @Test
    public void testMoveDown(){
        tileMovementService.moveDown(puzzle);
        int [][] expectedBoard = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 11, 15}
        };

        assertArrayEquals(expectedBoard, puzzle.getBoard());
    }
}
