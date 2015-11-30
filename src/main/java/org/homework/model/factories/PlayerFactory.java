package org.homework.model.factories;

import org.homework.model.bean.Labyrinth;
import org.homework.model.bean.Player;

/**
 * Created by User1 on 29.11.2015.
 */
public class PlayerFactory {

    private static Player playerBot;
    private static Player player;

    public static final String BOT_NAME = "duckBot";
    public static final String PLAYER_NAME = "duckPlayer";

    public PlayerFactory() {
        Labyrinth labyrinth = LabyrinthFactory.getLabyrinth();
        playerBot = new Player(BOT_NAME, labyrinth.getStartPosition());
        player = new Player(PLAYER_NAME, labyrinth.getStartPosition());
    }

    public static Player getPlayer(String duckName) {
        if (duckName.equals(BOT_NAME)) {
            return playerBot;
        }
        if (duckName.equals(PLAYER_NAME)) {
            return player;
        }
        return null;
    }
}
