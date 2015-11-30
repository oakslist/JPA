package org.homework.application.bean;

import java.awt.image.BufferedImage;

/**
 * Created by User1 on 30.11.2015.
 */
public class SpriteSheet {

    public BufferedImage spriteSheet;

    public SpriteSheet(BufferedImage spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public BufferedImage grabSprite(int x, int y, int width, int height) {
        BufferedImage sprite = spriteSheet.getSubimage(x,  y,  width, height);
        return sprite;
    }
}
