package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.occupation.*;
import view.CreateCharacterView;
import view.View;


public class CreateCharacterController {
	
	private CreateCharacterView charCreation = new CreateCharacterView(new BackButtonListener(),new SneakSelectListener(),new SummonerSelectListener(),new SmasherSelectListener());
	private String name = "";
	private Occupation occ = (Occupation) new Summoner();
	
	public View getView(){
		return charCreation;
	}
	
	public String getName(){
		return name;
	}
	
	public Occupation getOccupation(){
		return occ;
	}
	
	public class BackButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			charCreation.setNext("Main");
			charCreation.setRedraw(true);
			
		}
	}
	
	public class SneakSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			occ = new Sneak();
			name = charCreation.avatarName();
			charCreation.setNext("New"); //Game View
			charCreation.setRedraw(true);
			
		}
	}
	
	public class SummonerSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			occ = new Summoner();
			name = charCreation.avatarName();
			charCreation.setNext("New"); //Game View
			charCreation.setRedraw(true);
			
		}
	}
	
	public class SmasherSelectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			occ = new Smasher();
			System.out.println("Smasher");
			name = charCreation.avatarName();
			charCreation.setNext("New"); //Game View
			//gameToCreate.getMap().updateEntityLocation(gameToCreate.getAvatar(), new Location(STARTINGX,STARTINGY));
			charCreation.setRedraw(true);
			
		}
	}
	

}
