package com.puzzleGame.demo.service;

import com.puzzleGame.demo.model.Puzzle;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class PuzzleService implements IPuzzleService {

    @Override
    public Puzzle createNewPuzzle(){
        int[][] board = initialize();
        while (!isSolvable(board)){
            board = initialize();
        }
        return new Puzzle(board);
    }
    
    private int[][] initialize(){

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0); // Assuming 0 represents empty tile
        Collections.shuffle(numbers);

        int[][] board = new int[4][4];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                board[i][j] = numbers.get(i * 4 +j);
            }
        }
        return board;
    }



    public boolean isSolvable(int[][] puzzle)
    {

        int size = puzzle.length * puzzle[0].length;
        // from 2D Array to 1D array
        int[] flatArray = new int[size];
        int index = 0;
        for(int i = 0; i < puzzle.length; i++){
            for(int j = 0; j < puzzle[i].length;j++){
                flatArray[index++] = puzzle[i][j];
            }
        }

        // counting inversions

        int inversions = 0;
        for (int i = 0; i < size -1; i++){
            for(int j = i + 1; j <size; j++){
                if(flatArray[i] != 0 && flatArray[j] !=0 && flatArray[i] > flatArray[j]){
                    inversions++;
                }
            }
        }

        if (puzzle.length % 2 == 1){
            return inversions % 2 == 0;
        }
        else {
            int emptyTilePosition = getEmptyTileRow(puzzle);
            if (emptyTilePosition % 2 == 1){
                return inversions % 2 == 0;
            }
            else {
                return inversions % 2 == 1;
            }
        }

    }
    public int getEmptyTileRow(int[][] puzzle){

        for(int i = puzzle.length - 1; i >= 0; i--){
            for(int j = puzzle.length - 1; j >= 0; j--){
                if (puzzle[i][j] == 0){
                    return puzzle.length - i;
                }
            }
        }
        return -1;
    }
}
