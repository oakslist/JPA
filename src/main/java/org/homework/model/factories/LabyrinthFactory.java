package org.homework.model.factories;

import org.homework.model.bean.Labyrinth;

/**
 * Created by User1 on 29.11.2015.
 */
public class LabyrinthFactory {

    private static Labyrinth labyrinth;

    public LabyrinthFactory(String fileName) {
        if (labyrinth == null) {
            labyrinth = new Labyrinth(fileName);
        }
    }

    public static Labyrinth getLabyrinth() {
        if (labyrinth != null) {
            return labyrinth;
        }
        return null;
    }
}
