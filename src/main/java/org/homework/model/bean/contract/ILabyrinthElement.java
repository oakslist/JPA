package org.homework.model.bean.contract;

import org.homework.model.bean.Position;

/**
 * Created by User1 on 29.11.2015.
 */
public interface ILabyrinthElement {
    /**
     * Get player's current position
     * @param position     new x and y position
     */
    void setPosition(Position position);

    /**
     * Get player's current position
     * @return Position
     */
    Position getPosition();

}
