package org.homework.model.bean;

import org.homework.model.bean.contract.ILabyrinthElement;

/**
 * Created by User1 on 29.11.2015.
 */
public class Cell implements ILabyrinthElement {

    private Position position;
    private boolean isWall;

    public Cell(Position position, boolean isWall) {
        this.position = position;
        this.isWall = isWall;
    }

    public void setPosition(Position position) {

    }
    public Position getPosition() {
        return this.position;
    }

    public boolean isWall() {
        return this.isWall;
    }

    public void setIsWall(boolean isWall) {
        this.isWall = isWall;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "position=" + position +
                ", isWall=" + isWall +
                '}';
    }
}
