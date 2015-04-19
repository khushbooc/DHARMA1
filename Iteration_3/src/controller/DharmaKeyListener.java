package controller;

import java.awt.event.KeyEvent;

import model.ability.Ability;

public class DharmaKeyListener {
    private Ability ability; //the ability associated with this KeyListener
    private int key_code; //the integer value of the key
    private boolean isEnabled;

    public DharmaKeyListener(Ability abile, int key_code) {
        this.key_code = key_code;
        this.ability = abile;
        this.isEnabled = true; //all key listeners are enabled by default
    }

    public DharmaKeyListener(Ability abile, char key_char) {
        this(abile, KeyEvent.getExtendedKeyCodeForChar(key_char));
    }

    public int getKeyCodeBinding() {
        return key_code;
    }

    public void onPress(KeyEvent e) {
        //call this method when this KeyListener's key was pressed.
        //the listener may forward the action to its ability, if it is currently enabled
        if(this.isEnabled && e.getKeyCode() == this.key_code) {
            System.out.println("(Debug) Key " + this.key_code + " was pressed, and its Listener is enabled");
            this.ability.use();
        }
        else if(e.getKeyCode() == this.key_code)
            System.out.println("(Debug) Key " + this.key_code + " was pressed, and its Listener is disabled :(");
    }

    public void onRelease(KeyEvent e) {
        //TBD if necessary.
    }
}
