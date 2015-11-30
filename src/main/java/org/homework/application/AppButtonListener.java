package org.homework.application;

/**
 * Created by User1 on 30.11.2015.
 */
public class AppButtonListener {

    private boolean startButtonClicked;

    public AppButtonListener() {
        this.startButtonClicked = true;
    }

    public void startButtonlistener(boolean bool) {
        startButtonClicked = bool;
        synchronized (this) {
            try {
                while (!startButtonClicked) {
                    this.wait();
                }
                this.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
