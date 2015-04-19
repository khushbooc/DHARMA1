package controller;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
    private KeyListenerSet keyListenerSet;

    public Controller(KeyListenerSet keys) {
        keyListenerSet = keys;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        //do nothing

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //forward the event to the set to let it handle it
        keyListenerSet.handleKeyPressedEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //do nothing
        //might need this to do something later
    }

    public void setKeyListenerSet(KeyListenerSet newKeySet) {
        keyListenerSet = newKeySet;
    }


    public void addKeyListenersToFrame(JFrame frame) {
        frame.addKeyListener(this);
    }
}
