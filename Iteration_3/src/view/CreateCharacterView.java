package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CreateCharacterView extends View {
	private JButton backGameButton;
	private JButton startsneakButton;
	private JButton startsmasherButton;
	private JButton startsummonerButton;
	private JLabel enterNameLabel;
	private JTextField enterNameField;
	private JLabel title;
	private JPanel backgroundPanel;
	// private final int STARTINGX=3;
	// private final int STARTINGY=3;

	public CreateCharacterView( ActionListener backAction, ActionListener sneakAction, ActionListener summonerAction, ActionListener smasherAction ){
		setPreferredSize(new Dimension(500,500));
		//canvas.setBorder(new LineBorder(Color.black, 5));
		setLayout(new BorderLayout());
		
		Font titleFont = new Font("serif", Font.PLAIN, 24);
		Font labelFont = new Font("serif", Font.PLAIN, 24);
		
		
		title = new JLabel("CHARACTER CREATION");
		title.setFont(titleFont.deriveFont(40f));
		
		backgroundPanel = new ImagePanel("src/res/main_menu.gif");
		
		backgroundPanel.setLayout(new GridBagLayout());//(FlowLayout.CENTER, 350, 5));
		GridBagConstraints c = new GridBagConstraints();
		
		ImageIcon summonerButton = new ImageIcon("src/res/sumlog.png");
		ImageIcon sneakButton = new ImageIcon("src/res/sneaklog.png");
		ImageIcon smasherButton = new ImageIcon("src/res/smasherlog.png");
		//smasherButton.
		
		backGameButton = new MainMenuButton("       <Back>", labelFont);
		
		//startsneakButton = new CharacterButton(sneakButton);
		//startsummonerButton = new CharacterButton(summonerButton);
		//startsmasherButton = new CharacterButton(smasherButton);
		
		startsneakButton = new CharacterButton("Sneak");
		startsummonerButton = new CharacterButton("Summoner");
		startsmasherButton = new CharacterButton("Smasher");
		
		JLabel summonerLabel = new JLabel("Summoner");
		summonerLabel.setForeground(Color.WHITE);
		Font labelFontRedux = labelFont.deriveFont(20f);
		summonerLabel.setFont(labelFontRedux);
		
		JLabel sneakLabel = new JLabel("Sneak");
		sneakLabel.setForeground(Color.WHITE);
		sneakLabel.setFont(labelFontRedux);
		
		JLabel smasherLabel = new JLabel("Smasher");
		smasherLabel.setForeground(Color.WHITE);
		smasherLabel.setFont(labelFontRedux);
		
		
		enterNameLabel = new JLabel("Character Name");
		enterNameLabel.setFont(labelFontRedux);
		enterNameLabel.setForeground(Color.WHITE);
		
		enterNameField = new JTextField("Khushboo");
		enterNameField.setHorizontalAlignment(JTextField.CENTER);
		enterNameField.setFont(labelFontRedux);
		enterNameField.setBackground(new Color(255,255,255,130));
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 30;
		c.gridwidth = 3;
		backgroundPanel.add(title, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		backgroundPanel.add(enterNameLabel, c);
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		backgroundPanel.add(backGameButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		backgroundPanel.add(enterNameField, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startsummonerButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startsneakButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		backgroundPanel.add(startsmasherButton, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(summonerLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(sneakLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		//c.ipady = -20;
		//backgroundPanel.add(smasherLabel, c);
		c.fill = GridBagConstraints.HORIZONTAL;

		
		//back.add(backGameButton);
		
		
		//canvas.add(main, BorderLayout.CENTER);
		
		add(backgroundPanel);
		
		backGameButton.addActionListener(backAction);
		startsneakButton.addActionListener(sneakAction);
		startsummonerButton.addActionListener(summonerAction);
		startsmasherButton.addActionListener(smasherAction);
	}
	
	public String avatarName(){
		return enterNameField.getText();
	}
}
