package org.homework.application;

import org.homework.application.bean.SpriteAnimator;
import org.homework.application.bean.SpriteSheet;
import org.homework.model.bean.Cell;
import org.homework.model.bean.Labyrinth;
import org.homework.model.bean.Player;
import org.homework.model.bean.Position;
import org.homework.model.factories.LabyrinthFactory;
import org.homework.model.factories.PlayerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User1 on 29.11.2015.
 */
public class AppGamePanel extends JComponent implements ActionListener {

    private static final long serialVersionUID = 1L;

    private final static int APP_MAIN_MULTIPLE = 150;

    private Player playerBot = PlayerFactory.getPlayer("duckBot");
    private Player player = PlayerFactory.getPlayer("duckPlayer");
    private Labyrinth labyrinth = LabyrinthFactory.getLabyrinth();

    private Image wallImg;
    private Image pathImg;
    private BufferedImage playerImg;

    private SpriteAnimator animatorPlayer;

    private Position appWall;
    private Position appGround;

    private int step = 1;
    private int steps = labyrinth.getCellsPathList().size();

    private int appHeight;
    private int appWidth;

    public AppGamePanel() {
        Dimension size = getPreferredSize();
        appWidth = (labyrinth.getMaxPosition().getX() + 1) * APP_MAIN_MULTIPLE - 20;
        appHeight = (labyrinth.getMaxPosition().getY() + 1) * APP_MAIN_MULTIPLE - 20;
        size.width = appWidth;
        size.height = appHeight;
        setPreferredSize(size);
        try {
            pathImg = ImageIO.read(getClass().getResource("/images/ground2.png"));
            wallImg = ImageIO.read(getClass().getResource("/images/wall2.png"));
            playerImg = ImageIO.read(getClass().getResource("/images/Daffy_Duck.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        createFirstInitialization();
    }

    public void paintComponent(Graphics graphics) {
        // draw walls and the path
        for (Cell cell : labyrinth.getCellsList()) {
            if (cell.isWall()) {
                graphics.drawImage(wallImg, cell.getPosition().getX() * 150,
                        cell.getPosition().getY() * 150, null);
            } else {
                graphics.drawImage(pathImg, cell.getPosition().getX() * 150,
                        cell.getPosition().getY() * 150, null);
            }
        }
        // draw players
        animatorPlayer.update(System.currentTimeMillis());
        graphics.drawImage(animatorPlayer.sprite, playerBot.getPosition().getX() * 150 + 20,
                playerBot.getPosition().getY() * 150 + 50, null);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (step < steps) {
            playerBot.setPosition(labyrinth.getCellsPathList().get(step).getPosition());
            step++;
        } else {
        	 graphics.setColor(Color.BLACK);
             graphics.drawString("WINNER!!!", playerBot.getPosition().getX() * 150 + 7,
            		 playerBot.getPosition().getY() * 150 + 40);
        }
        graphics.setColor(Color.BLACK);
        graphics.drawString("push arrow", player.getPosition().getX() * 150 + 70,
                player.getPosition().getY() * 150 + 40);
        graphics.drawImage(animatorPlayer.sprite, player.getPosition().getX() * 150 + 85,
                player.getPosition().getY() * 150 + 50, null);

        // draw some more additional elements here
        // TODO
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        animatorPlayer.update(System.currentTimeMillis());
        repaint();
    }

    private void createFirstInitialization() {
        // create sprite for players
        SpriteSheet spritePlayer = new SpriteSheet(playerImg);
        List<BufferedImage> spritesPlayer = new ArrayList<BufferedImage>();

        spritesPlayer.add(spritePlayer.grabSprite(14, 134, 31, 53));
        spritesPlayer.add(spritePlayer.grabSprite(76, 130, 36, 59));
        spritesPlayer.add(spritePlayer.grabSprite(139, 135, 31, 53));
        spritesPlayer.add(spritePlayer.grabSprite(201, 130, 36, 59));

        animatorPlayer = new SpriteAnimator(spritesPlayer);
        animatorPlayer.setSpeed(200);
        animatorPlayer.start();
    }

}
