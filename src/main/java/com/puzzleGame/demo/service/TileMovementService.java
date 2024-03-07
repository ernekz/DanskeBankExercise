package com.puzzleGame.demo.service;

import com.puzzleGame.demo.model.Puzzle;
import org.springframework.stereotype.Service;

@Service
public class TileMovementService implements ITileMovementService{
    @Override
    public Puzzle moveUp(Puzzle puzzle) {

        return puzzle;
    }

    @Override
    public Puzzle moveDown(Puzzle puzzle) {

        return puzzle;
    }

    @Override
    public Puzzle moveLeft(Puzzle puzzle) {

        return puzzle;
    }

    @Override
    public Puzzle moveRight(Puzzle puzzle) {

        return puzzle;
    }
}
