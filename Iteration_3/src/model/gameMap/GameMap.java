package model.gameMap;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position.Bias;

import model.entity.Avatar;
import view.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
 
public class GameMap extends View
{
	
	private DrawingPanel panel;
	private Avatar avatar;
	private JFrame frame; 
	private int min_x=3;
	private int min_y=3;
	private int max_x=3;
	private int max_y=3;
	//private Terrain[][] terrain;
	
  public GameMap(Avatar avatar,JFrame frame) {
	  this.avatar=avatar;
	  this.frame=frame;
		initGame();
		createAndShowGUI();
	}
 
//	public static void main(String[] args)
//	{
//		SwingUtilities.invokeLater(new Runnable() {
//				public void run() {
//				new gameMap();
//				}
//				});
//	}
 
	final static Color COLOURBACK =  Color.WHITE;
	final static Color COLOURCELL =  Color.CYAN;	 
	final static Color COLOURGRID =  Color.BLACK;	 
	final static Color COLOURONE = new Color(255,255,255,200);
	final static Color COLOURONETXT = Color.BLUE;
	final static Color COLOURTWO = new Color(0,0,0,200);
	final static Color COLOURTWOTXT = new Color(255,100,255);
	final static int EMPTY = 0;
	final static int BSIZE = 30; //board size.
	final static int HEXSIZE = 80;	//hex size in pixels
	final static int BORDERS = 10;  
	//final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).
	public final static int WORLD_SIZE_X=1600;
	public final static int WORLD_SIZE_Y=700;
	public final static int VIEWPORT_SIZE_X=800;
	public final static int VIEWPORT_SIZE_Y=600;
	//int[][] board = new int[BSIZE][BSIZE];
	private BufferedImage stone;
	private BufferedImage grass;
	private BufferedImage mountain;
	private BufferedImage river;
	 Tile[][] map=new Tile[BSIZE][BSIZE];
 
	void initGame(){
		 try {
			    grass = ImageIO.read(new File("src/res/grass.png"));
			    mountain = ImageIO.read(new File("src/res/Geomorph.png"));
			} catch (IOException e) {
				System.out.println(e);
			}
		//terrain =new Terrain[BSIZE][BSIZE];
		 
		GameMech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.
 
		GameMech.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
		GameMech.setBorders(BORDERS);
		
		//frame = new JFrame("Hex Testing 4");
		
		//set up board here
		//board[3][3] =(int)'A' ;
		//board[4][3] = (int)'Q';
		//board[4][4] = -(int)'B';
	}
 
	public void createAndShowGUI()
	{
		for (int i=0;i<BSIZE;i++) {
			for (int j=0;j<BSIZE;j++) {
				//board[i][j]=EMPTY;
				Location loc=new Location(i,j);
				if(i>=min_x && j>=min_y){
						
						//terrain[i][j] = new Grass("Grass",grass);
						map[i][j]=new Tile(loc, new Grass("Grass",grass));
				}
				else{
					//terrain[i][j] = new Mountain("Mountain",mountain);
					map[i][j]=new Tile(loc,new Mountain("Mountain",mountain));
				}
			}
		}
		
		panel = new DrawingPanel();
		
		//JFrame.setDefaultLookAndFeelDecorated(true);
		
		
		//frame.getContentPane().setLayout(null);
		Container content = frame.getContentPane();
		content.add(panel);
		
		//panel.setLocation(100,100);
		panel.setPreferredSize(new Dimension(800,600));
		//panel.setLayout(null);
				
		// setup our canvas size and put it into the content of the frame
		//frame.setBounds(0,0,800,600);
		//panel.add(this);
		/*
		frame.pack();
		frame.setSize( VIEWPORT_SIZE_X, VIEWPORT_SIZE_Y);
		frame.setResizable(false);
		//frame.setLocationRelativeTo( null );
		frame.setVisible(true);
		
		frame.setFocusable(true);
        frame.setLayout(new FlowLayout());
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.repaint();
        */
	}
 
 
	@SuppressWarnings("serial")
	class DrawingPanel extends JPanel
	{
		public DrawingPanel()
		{	
			setBackground(COLOURBACK);
 
		
		}
 
		public void paintComponent(Graphics g)
		{
            Graphics2D g2 = (Graphics2D)g;
			//g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			super.paintComponent(g2);
			//draw grid

			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {
					GameMech.drawHex(i,j,map[i][j],g2);
				}
			}
			
			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {					
					//GameMech.fillHex(i,j,map[i][j],g2);
				}
			}
 
			GameMech.fillHex(3,3,avatar.getImage(),g2);
		}
 
	
	}
	public void update(Point step){
		setLocation(step);
		for (int i=0;i<BSIZE;i++) {
			for (int j=0;j<BSIZE;j++) {
				//board[i][j]=EMPTY;
				Location loc=new Location(i,j);
				if(i>=min_x  &&j >= min_y){
						
						//terrain[i][j] = new Grass("Grass",grass);
						map[i][j]=new Tile(loc, new Grass("Grass",grass));
				}
				else{
					//terrain[i][j] = new Mountain("Mountain",mountain);
					map[i][j]=new Tile(loc,new Mountain("Mountain",mountain));
				}
			}
		}
		panel.repaint();
		
	}
	public void setLocation(Point step){
		System.out.println("Location:"+min_x+","+min_y);
		min_x=min_x-(int)step.getX();
		min_y=min_y-(int)step.getY();
		if(min_x<-24)
			min_x=-24;
		if(min_y<-24)
			min_y=-24;
		if(min_x>3)
			min_x=3;
		if(min_y>3)
			min_y=3;
		
		
	}

}