package org.homework.game;

import org.homework.application.GameApp;
import org.homework.model.factories.LabyrinthFactory;
import org.homework.model.factories.PlayerFactory;

import javax.swing.*;

/**
 * Created by User1 on 29.11.2015.
 */
public class Game {

    private static String labyrinhPath = "/labyrinth/labyrinth1.xml";

    public static void main(String[] args) {
        // initialize a labyrinth
        new LabyrinthFactory(labyrinhPath);

        // initialize a bot and a player
        new PlayerFactory();

        // Start app
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GameApp("Duck game");
            }
        });


    }

}
