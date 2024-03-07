package com.puzzleGame.demo.DTO;

public class GameInfo {

    private int gameId;
    private int[][] initialBoard;

    public GameInfo(int gameId, int[][] initialBoard) {
        this.gameId = gameId;
        this.initialBoard = initialBoard;
    }

    public GameInfo(){}

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int[][] getInitialBoard() {
        return initialBoard;
    }

    public void setInitialBoard(int[][] initialBoard) {
        this.initialBoard = initialBoard;
    }
}
