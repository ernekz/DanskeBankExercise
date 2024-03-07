package com.puzzleGame.demo.service;

import com.puzzleGame.demo.DTO.GameInfo;
import com.puzzleGame.demo.model.Puzzle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GameService implements IGameService {

    private final PuzzleService puzzleService;
    private final Map<Integer, Puzzle> games;
    private final AtomicInteger gameIdCounter = new AtomicInteger(1);

    public GameService(PuzzleService puzzleService, Map<Integer, Puzzle> games) {
        this.puzzleService = puzzleService;
        this.games = games;
    }

    @Override
    public GameInfo startNewGame(){
        int gameId = generateGameId();
        Puzzle puzzle = puzzleService.createNewPuzzle();
        games.put(gameId, puzzle);
        return new GameInfo(gameId, puzzle.getBoard());
    }

    @Override
    public boolean deleteGame(int gameId) {

        if(games.containsKey(gameId)){
            games.remove(gameId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Collection<GameInfo> getAllGames() {

        Collection<GameInfo> gameInfos = new ArrayList<>();
        for(Map.Entry<Integer, Puzzle> entry: games.entrySet()){
            Integer gameId = entry.getKey();
            Puzzle puzzle = entry.getValue();

            GameInfo gInfo = new GameInfo();
            gInfo.setGameId(gameId);
            gInfo.setInitialBoard(puzzle.getBoard());
            gameInfos.add(gInfo);
        }
        return gameInfos;
    }

    @Override
    public Puzzle getGameBoard(int gameId){
        return games.get(gameId);
    }

    private int generateGameId(){
        return gameIdCounter.getAndIncrement();
    }


}
