package controller;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.Timer;

import view.View;
import model.gameMap.Game;
import model.gameMap.GameMap;
// All controllers to be created over here and this is the main controller class
public class ViewController {
	private MainMenuController mmc;
	private GameController gc;
	private CreateCharacterController ccc;
	private MapViewController  mvc;
	private GameMap map;
	//private JFrame mainFrame;
	
	 private View previous;
     private View current;
     private JFrame frame;
     private Map<String, View> views = new HashMap<String, View>();
	
	
	public ViewController(){
		
		this.display();
		frame = new JFrame();
        //instantiate the main menu controller + view
        mmc = new MainMenuController();
        views.put("Main", mmc.getView());
       
        //instantiate the character creator controller + view
        ccc = new CreateCharacterController();   
        views.put("Character", ccc.getView());
        current = views.get("Main");
        //set up the main frame
        frame.setFocusable(true);
        frame.setLayout(new FlowLayout());
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(current);
        frame.setVisible(true);
        frame.repaint();
        
        gc = new GameController();
        views.put("Game", ccc.getView());
		/*
		mainFrame=new JFrame("Hex Board");
		map=new GameMap(mainFrame);
		mainFrame.pack();
		mainFrame.setSize( GameMap.VIEWPORT_SIZE_X, GameMap.VIEWPORT_SIZE_Y);
		mainFrame.setResizable(false);
		//frame.setLocationRelativeTo( null );
		mainFrame.setVisible(true);
		
		mainFrame.setFocusable(true);
		mainFrame.setLayout(new FlowLayout());
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.repaint();
		mvc=new MapViewController(map,mainFrame);
		*/
		
	}
	public void changePanel(){
        previous = current;
        if(views.get(current.getNext()) == null && !current.nextStateEquals("New")){
            System.out.println("Illegal Path: " + current.getNext());
            current.setNext("Quit");
        }
        else{
            if(current.nextStateEquals("New")){
            	reLoad("New");
                current = views.get("Game");
            }
            else{
                current = views.get(current.getNext());
            }
            //current.reset();
            frame.remove(previous);
            frame.add(current);
            frame.revalidate();
            frame.repaint();
        }
        
}
	
	public void display(){
    	Timer timer = new Timer(20, new RunGameTimer());
		timer.start();
    }
/**
 * Reloads game variables and their associated views.
 */
public void reLoad(String command){
	// the game only needs to be instantiated once, or we will loose information
	Game game = null;
	if(command.equals("Load")){	
		
	}
	else if(command.equals("New")){
		game = new Game(ccc.getOccupation(), ccc.getName());
	}else{
		game = new Game();
	}
    //gc = new GameController(game);
   // views.put("Game");
	
    mvc= new MapViewController(game.getAvatar(),map,frame);
    views.put("Game", mvc.getView());
    //gc.stopReset();
    frame.revalidate();
    frame.repaint();
}
/**
 * Timer used to initiate changing views and reloading the game state.
 */
public class RunGameTimer implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if(current.nextStateEquals("Quit")){
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		if(current.getRedraw()){
			changePanel();
		}
		
	}
}

	

}
