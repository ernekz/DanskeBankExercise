package com.puzzleGame.demo.controller;

import com.puzzleGame.demo.DTO.GameInfo;
import com.puzzleGame.demo.model.Puzzle;
import com.puzzleGame.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService){
        this.gameService = gameService;
    }
    @PostMapping
    public ResponseEntity<GameInfo> createGame(){
        GameInfo gameInfo = gameService.startNewGame();
        return ResponseEntity.ok(gameInfo);
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameInfo> receiveGameState(@PathVariable int gameId){
        Puzzle puzzle = gameService.getGameBoard(gameId);
        GameInfo gameInfo = new GameInfo(gameId, puzzle.getBoard());
        return  ResponseEntity.ok(gameInfo);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteGame(@PathVariable int gameId){
        boolean deleted = gameService.deleteGame(gameId);
        if(deleted){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<GameInfo>> getAllGames(){
        Collection<GameInfo> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }
}
