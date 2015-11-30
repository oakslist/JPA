package org.homework.model.bean;

import org.homework.model.bean.contract.ILabyrinthElement;

/**
 * Created by User1 on 29.11.2015.
 */
public class Player implements ILabyrinthElement {

    private String name;
    private Position position;

    public Player(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
