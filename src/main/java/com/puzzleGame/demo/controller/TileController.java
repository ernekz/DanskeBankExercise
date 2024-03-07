package com.puzzleGame.demo.controller;

import com.puzzleGame.demo.DTO.MoveRequest;
import com.puzzleGame.demo.model.Puzzle;
import com.puzzleGame.demo.service.GameService;
import com.puzzleGame.demo.service.TileMovementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tiles")
public class TileController {

    private final TileMovementService tileMovementService;
    private final GameService gameService;

    public TileController(TileMovementService tileMovementService, GameService gameService) {
        this.tileMovementService = tileMovementService;
        this.gameService = gameService;
    }

    @PostMapping("/{gameId}/move")
    public ResponseEntity<Puzzle> moveTile(@PathVariable int gameId, @RequestBody MoveRequest moveRequest){
        Puzzle board = gameService.getGameBoard(gameId);

        if (board == null){
            return ResponseEntity.notFound().build();
        }

        switch (moveRequest.getDirection()){
            case "UP":
                tileMovementService.moveUp(board);
                break;
            case "DOWN":
                tileMovementService.moveDown(board);
                break;
            case "RIGHT":
                tileMovementService.moveRight(board);
                break;
            case "LEFT":
                tileMovementService.moveLeft(board);
                break;

        }

        return ResponseEntity.ok(board);
    }
}
