package com.puzzleGame.demo;

import com.puzzleGame.demo.service.PuzzleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PuzzleServiceTest {

    @Autowired
    private PuzzleService puzzleService;

    @Test
    public void isSolvable_ReturnsTrue(){
        int [][] solvablePuzzle = {
                {13, 0, 9, 3},
                {1, 2, 5, 10},
                {7, 12, 6, 15},
                {4, 11, 8, 14}
        };
        assertTrue(puzzleService.isSolvable(solvablePuzzle));
    }
    @Test
    public void isSolvable_ReturnsFalse(){
        int[][] unsolvablePuzzle = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 15, 14, 0}
        };
        assertFalse(puzzleService.isSolvable(unsolvablePuzzle));
    }

    @Test
    public void testGetEmptyTileRow_EmptyTileIsInFirstRow(){
        int [][] puzzle = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };

        assertEquals(4, puzzleService.getEmptyTileRow(puzzle));
    }

    @Test
    public void testGetEmptyTileRow_EmptyTileIsInSecondRow(){
        int [][] puzzle = {
                {4, 1, 2, 3},
                {0, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };

        assertEquals(3, puzzleService.getEmptyTileRow(puzzle));
    }

    @Test
    public void testGetEmptyTileRow_EmptyTileIsInThirdRow(){
        int [][] puzzle = {
                {8, 1, 2, 3},
                {4, 5, 6, 7},
                {0, 9, 10, 11},
                {12, 13, 14, 15}
        };

        assertEquals(2, puzzleService.getEmptyTileRow(puzzle));
    }

    @Test
    public void testGetEmptyTileRow_EmptyTileIsInFourthRow(){
        int [][] puzzle = {
                {12, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {0, 13, 14, 15}
        };

        assertEquals(1, puzzleService.getEmptyTileRow(puzzle));
    }
}
