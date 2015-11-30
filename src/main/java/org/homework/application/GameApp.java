package org.homework.application;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * Created by User1 on 29.11.2015.
 */
public class GameApp extends JFrame {

    private static final long serialVersionUID = 1L;

    private final static AppGamePanel PRESENTATION_AREA = new AppGamePanel();
    private final static int timerMillis = 50;
    private static Timer timer = new Timer(timerMillis, PRESENTATION_AREA);

    public GameApp(String title) {
        super(title);
        // set layout manager
        setLayout(new BorderLayout());
        // set swing component to JFrame
        super.setFocusableWindowState(true);
        PRESENTATION_AREA.addKeyListener(new KeyListener());
        PRESENTATION_AREA.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "pressed");
        PRESENTATION_AREA.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "pressed");

        super.add(PRESENTATION_AREA, BorderLayout.CENTER);

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
        timer.start();
    }
}


