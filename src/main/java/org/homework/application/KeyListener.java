package org.homework.application;

import org.homework.model.bean.Cell;
import org.homework.model.bean.Player;
import org.homework.model.bean.Position;
import org.homework.model.factories.LabyrinthFactory;
import org.homework.model.factories.PlayerFactory;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by User1 on 30.11.2015.
 */
public class KeyListener extends KeyAdapter {

    private static List<Cell> cellList = LabyrinthFactory.getLabyrinth().getCellsList();

    public void keyPressed(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                updatePosition("x", -1);
                break;
            case KeyEvent.VK_RIGHT:
                updatePosition("x", 1);
                break;
            case KeyEvent.VK_UP:
                updatePosition("y", -1);
                break;
            case KeyEvent.VK_DOWN:
                updatePosition("y", 1);
                break;
        }
    }

    private void updatePosition(String line, int p) {
        Player player = PlayerFactory.getPlayer("duckPlayer");
        Position pos = player.getPosition();
        if (line.equals("x")) {
            boolean isWall = true;
            for (Cell cell : cellList) {
                if (cell.getPosition().getX() == pos.getX() + p
                        && cell.getPosition().getY() == pos.getY()) {
                    isWall = cell.isWall();
                }
            }
            if (!isWall) {
                player.getPosition().setX(pos.getX() + p);
            }
        } else {
            boolean isWall = true;
            for (Cell cell : cellList) {
                if (cell.getPosition().getX() == pos.getX()
                        && cell.getPosition().getY() == pos.getY() + p) {
                    isWall = cell.isWall();
                }
            }
            if (!isWall) {
                player.getPosition().setY(pos.getY() + p);
            }
        }
    }
}
