package com.puzzleGame.demo.service;

import com.puzzleGame.demo.model.Puzzle;

public interface ITileMovementService {
    Puzzle moveUp(Puzzle puzzle);
    Puzzle moveDown(Puzzle puzzle);
    Puzzle moveLeft(Puzzle puzzle);
    Puzzle moveRight(Puzzle puzzle);
}
