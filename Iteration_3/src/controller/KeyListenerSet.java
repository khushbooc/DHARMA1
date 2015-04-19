package controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyListenerSet {

    private ArrayList<DharmaKeyListener> keyListeners;

    public KeyListenerSet() {
        keyListeners = new ArrayList<DharmaKeyListener>();
    }

    public KeyListenerSet(ArrayList<DharmaKeyListener> previously_existing_key_listener_set) {
        this();
        keyListeners.addAll(previously_existing_key_listener_set);
    }

    public ArrayList<DharmaKeyListener> getKeyListeners() {
        return this.keyListeners;
    }

    public void addKeyListener(DharmaKeyListener listener) {
        keyListeners.add(listener);
    }

    public void removeKeyListener(DharmaKeyListener listener) {
        keyListeners.remove(listener);
    }

    public void handleKeyPressedEvent(KeyEvent e) {
        //iterate through the KeyListeners to see if this event matches any KeyListener
        for(DharmaKeyListener k : keyListeners) {
            k.onPress(e);
        }

    }

    public void onRelease(KeyEvent e) {
        //TBD if necessary.
    }
}
