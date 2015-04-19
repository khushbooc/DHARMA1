package model.gameMap;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GameMech
{
	//Constants
	public final static boolean orFLAT= true;
	public final static boolean orPOINT= false;
	//public static boolean ORIENT= orFLAT;  
	public static boolean XYVertex=true;	
 
	private static int BORDERS=50;	//default number of pixels for the border.
 
	private static int s=0;	// length of one side
	private static int t=0;	// short side of 30o triangle outside of each hex
	private static int r=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
	private static int h=0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.
 
	public static void setXYasVertex(boolean b) {
		XYVertex=b;
	}
	public static void setBorders(int b){
		BORDERS=b;
	}
 
	
	public static void setSide(int side) {
		s=side;
		t =  (int) (s / 2);			
		r =  (int) (s * 0.8660254037844);	
		h=2*r;
	}
	public static void setHeight(int height) {
		h = height;			
		r = h/2;			
		s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
		t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
	}
 

	public static Polygon hex (int x0, int y0) {
 
		int y = y0 + BORDERS;
		int x = x0 + BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true. 
				      // NO! Done below in cx= section
		if (s == 0  || h == 0) {
			System.out.println("ERROR: size of hex has not been set");
			return new Polygon();
		}
 
		int[] cx,cy;
 

		if (XYVertex) 
			cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};  //this is for the top left vertex being at x,y
		else
			cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};	//this is for the whole hexagon to be below and to the right of this point
 
		cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
		return new Polygon(cx,cy,6);
 
		/*
		   x=200;
		   poly = new Polygon();
		   poly.addPoint(x,y);
		   poly.addPoint(x+s,y);
		   poly.addPoint(x+s+t,y+r);
		   poly.addPoint(x+s,y+r+r);
		   poly.addPoint(x,y+r+r);
		   poly.addPoint(x-t,y+r);
		 */
	}
 
	public static void drawHex(int i, int j,Tile tile, Graphics2D g2) {
		int x = i * (s+t);
		int y = j * h + (i%2) * h/2;
		Polygon poly = hex(x,y);
		BufferedImage cell=tile.getTerrain().getImage();
		
		//g2.setColor(gameMap.COLOURCELL);
		g2.drawImage(cell,x+10,y+10,x+GameMap.HEXSIZE+20,y+GameMap.HEXSIZE+10,0,0,cell.getWidth(),cell.getHeight(),null);
		//g2.fillPolygon(GameMech.hex(x,y));
		//g2.fillPolygon(poly);
		//g2.setColor(gameMap.COLOURGRID);
		g2.drawPolygon(poly);
	}

	public static void fillHex(int i, int j,BufferedImage cell, Graphics2D g2) {
		char c='o';
		int x = i * (s+t);
		int y = j * h + (i%2) * h/2;
		//BufferedImage cell=tile.getTerrain().getImage();
		//if (i > 5 || j > 5) {
			g2.drawImage(cell,x+10,y+10,x+GameMap.HEXSIZE+20,y+GameMap.HEXSIZE+10,0,0,cell.getWidth(),cell.getHeight(),null);
			//g2.setColor(GameMap.COLOURONE);
			//g2.fillPolygon(hex(x,y));
			//g2.setColor(GameMap.COLOURONETXT);
			//c = (char)(-n);
			//g2.drawString(""+c, x+r+BORDERS, y+r+BORDERS+4); // handle XYVertex
			//g2.drawString(x+","+y, x+r+BORDERS, y+r+BORDERS+4);
		//}
		/*if (n > 0) {
			g2.setColor(GameMap.COLOURTWO);
			g2.fillPolygon(hex(x,y));
			g2.setColor(GameMap.COLOURTWOTXT);
			c = (char)n;
			g2.drawString(""+c, x+r+BORDERS, y+r+BORDERS+4); // handle XYVertex
			//g2.drawString(i+","+j, x+r+BORDERS, y+r+BORDERS+4);
			 
		}*/
	}
 

	public static Point pxtoHex(int mx, int my) {
		Point p = new Point(-1,-1);
 
		//correction for BORDERS and XYVertex
		mx -= BORDERS;
		my -= BORDERS;
		if (XYVertex) mx += t;
 
		int x = (int) (mx / (s+t)); //this gives a quick value for x. It works only on odd cols and doesn't handle the triangle sections. It assumes that the hexagon is a rectangle with width s+t (=1.5*s).
		int y = (int) ((my - (x%2)*r)/h); //this gives the row easily. It needs to be offset by h/2 (=r)if it is in an even column
 
	
		
		int dx = mx - x*(s+t);
		int dy = my - y*h;
 
		if (my - (x%2)*r < 0) return p; 
		//System.out.println("dx=" + dx + " dy=" + dy + "  > " + dx*r/t + " <");
		
		//even columns
		if (x%2==0) {
			if (dy > r) {	//bottom half of hexes
				if (dx * r /t < dy - r) {
					x--;
				}
			}
			if (dy < r) {	//top half of hexes
				if ((t - dx)*r/t > dy ) {
					x--;
					y--;
				}
			}
		} else {  // odd columns
			if (dy > h) {	//bottom half of hexes
				if (dx * r/t < dy - h) {
					x--;
					y++;
				}
			}
			if (dy < h) {	//top half of hexes
				//System.out.println("" + (t- dx)*r/t +  " " + (dy - r));
				if ((t - dx)*r/t > dy - r) {
					x--;
				}
			}
		}
		p.x=x;
		p.y=y;
		return p;
	}
}