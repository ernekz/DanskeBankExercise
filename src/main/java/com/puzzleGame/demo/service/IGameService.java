package com.puzzleGame.demo.service;

import com.puzzleGame.demo.DTO.GameInfo;
import com.puzzleGame.demo.model.Puzzle;

import java.util.Collection;

public interface IGameService {
    GameInfo startNewGame();
    boolean deleteGame(int gameId);

    Collection<GameInfo> getAllGames();
    Puzzle getGameBoard(int gameId);
}
