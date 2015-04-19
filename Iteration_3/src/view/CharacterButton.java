package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class CharacterButton extends JButton {
	public CharacterButton(String text) {
		super(text);
		customFeel();
	}
	
	public CharacterButton(ImageIcon i) {
		super(i);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	private void customFeel() {
		setBackground(new Color(59, 89, 182));
        setForeground(Color.WHITE);
        setFocusPainted(false);
	}

}
