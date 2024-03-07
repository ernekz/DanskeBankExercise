package com.puzzleGame.demo;

import com.puzzleGame.demo.DTO.GameInfo;
import com.puzzleGame.demo.model.Puzzle;
import com.puzzleGame.demo.service.GameService;
import com.puzzleGame.demo.service.PuzzleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class GameServiceUnitTest {


    @Mock
    private PuzzleService puzzleService;

    @Test
    public void startNewGame_CreateNewGame(){
        Puzzle puzzle = new Puzzle(new int[][]{{1,2},{3,0}});
        when(puzzleService.createNewPuzzle()).thenReturn(puzzle);

        GameService gameService = new GameService(puzzleService, new HashMap<>());
        GameInfo gameInfo = gameService.startNewGame();

        verify(puzzleService, times(1)).createNewPuzzle();
        assertThat(gameInfo.getGameId()).isPositive();
        assertThat(gameInfo).isNotNull();
        assertThat(gameInfo.getInitialBoard()).isEqualTo(new int[][]{{1, 2}, {3, 0}} );
    }

    @Test
    public void deleteGame_ExistingGame(){
        int gameId = 1;

        Map<Integer, Puzzle> games = new HashMap<>();
        games.put(gameId, new Puzzle());

        GameService gameService = new GameService(puzzleService, games);

        boolean result = gameService.deleteGame(gameId);

        assertThat(result).isTrue();
        assertThat(games.containsKey(gameId)).isFalse();
    }

    @Test
    public void getAllGames_ReturnsAllGames(){
        Map<Integer, Puzzle> games = new HashMap<>();
        games.put(1, new Puzzle(new int[][]{{1, 2}, {3, 4}}));
        games.put(2, new Puzzle(new int[][]{{7, 8}, {9, 10}}));
        GameService gameService = new GameService(puzzleService, games);

        Collection<GameInfo> gameInfos = gameService.getAllGames();

        assertThat(gameInfos.size()).isEqualTo(2);
    }

    @Test
    public void getGameBoard_ReturnsTrue(){
        int gameId = 1;
        Map<Integer, Puzzle> games = new HashMap<>();
        games.put(gameId, new Puzzle());

        GameService gameService = new GameService(puzzleService, games);

        Puzzle puzzle = gameService.getGameBoard(gameId);

        assertThat(puzzle).isNotNull();
    }

}
