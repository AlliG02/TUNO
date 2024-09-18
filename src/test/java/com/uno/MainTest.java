package com.uno;
import com.uno.core.models.Player;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// check that the main method gets executed
public class MainTest {

    @Test
    public void initializePlayersCheck () {
        // Act
        List<Player> players = Main.initializePlayers();
        // Assert - player list should not be null
        assertNotNull(players, "The player list should be initialized and not null");
        // Assert - player list should be empty
        assertEquals(0, players.size(),"The player list should be empty and of size 0");
    }
}
